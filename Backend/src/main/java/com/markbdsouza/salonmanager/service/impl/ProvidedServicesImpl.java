package com.markbdsouza.salonmanager.service.impl;

import com.markbdsouza.salonmanager.io.entity.CustomerEntity;
import com.markbdsouza.salonmanager.io.entity.CustomerServicesEntity;
import com.markbdsouza.salonmanager.io.entity.ServicesEntity;
import com.markbdsouza.salonmanager.io.repository.CustomerRepository;
import com.markbdsouza.salonmanager.io.repository.CustomerServicesRepository;
import com.markbdsouza.salonmanager.io.repository.ServicesRepository;
import com.markbdsouza.salonmanager.service.ProvidedServicesService;
import com.markbdsouza.salonmanager.shared.Utils;
import com.markbdsouza.salonmanager.shared.dto.CustomersServicesDTO;
import com.markbdsouza.salonmanager.shared.dto.ServiceRegisterationDTO;
import com.markbdsouza.salonmanager.shared.dto.ServicesDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class ProvidedServicesImpl implements ProvidedServicesService {

    private static final int LENGTH_OF_SERVICE_ID = 5;
    @Autowired
    ServicesRepository servicesRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    Utils utils;
    @Autowired
    CustomerServicesRepository customerServicesRepository;

    @Override
    public CustomersServicesDTO getCustomerServices(String customerId, String date) {
        Date serviceDate;
        try {
            serviceDate = new SimpleDateFormat("yyyy-MM-DD", Locale.ENGLISH).parse(String.valueOf(date));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        CustomerEntity customerEntity = findCustomerEntity(customerId);
        List<CustomerServicesEntity> customerServicesSavedEntityList
                = customerServicesRepository.findByCustomerEntityAndServiceDate(customerEntity, serviceDate);
        return createReturnRegisterationDTOList(customerServicesSavedEntityList);
    }


    @Override
    public List<ServicesDTO> getAllServices() {
        List<ServicesEntity> servicesEntities = (List<ServicesEntity>) servicesRepository.findAll();
        List<ServicesDTO> returnServiceList = new ArrayList<>();
        ServicesDTO servicesDTO;
        for (ServicesEntity servicesEntity : servicesEntities) {
            servicesDTO = new ServicesDTO();
            BeanUtils.copyProperties(servicesEntity, servicesDTO);
            returnServiceList.add(servicesDTO);
        }
        return returnServiceList;
    }

    @Override
    public CustomersServicesDTO saveCustomerService(String customerId, String date, List<ServiceRegisterationDTO> serviceRegDTOList) {
        List<CustomerServicesEntity> customerServicesEntityList = new ArrayList<>();
        CustomerServicesEntity customerServicesEntity;
        ServicesEntity servicesEntity;
        CustomerEntity customerEntity;
        for (ServiceRegisterationDTO serviceRegDTO : serviceRegDTOList) {
            customerServicesEntity = new CustomerServicesEntity();
            customerEntity = findCustomerEntity(customerId);
            if (customerEntity != null) {
                customerServicesEntity.setCustomerEntity(customerEntity);
            } else return null;
            servicesEntity = findByServiceTypeId(serviceRegDTO.getServiceTypeId());
            if (servicesEntity != null) {
                customerServicesEntity.setServicesEntity(servicesEntity);
            } else return null;
            customerServicesEntity.setQuantity(serviceRegDTO.getQuantity());
            customerServicesEntity.setComplete(serviceRegDTO.isComplete());
            customerServicesEntity.setCancelled(serviceRegDTO.isCancelled());
            try {
                customerServicesEntity.setServiceDate(new SimpleDateFormat("yyyy-MM-DD", Locale.ENGLISH).parse(String.valueOf(date)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            customerServicesEntity.setCustomerServiceId(utils.generateCustomerServiceId(LENGTH_OF_SERVICE_ID));
            customerServicesEntityList.add(customerServicesEntity);
        }

        List<CustomerServicesEntity> customerServicesSavedEntityList = (List<CustomerServicesEntity>) customerServicesRepository.saveAll(customerServicesEntityList);
        CustomersServicesDTO returnDTO = createReturnRegisterationDTOList(customerServicesSavedEntityList);
        return returnDTO;

    }

    private CustomersServicesDTO createReturnRegisterationDTOList(List<CustomerServicesEntity> customerServicesSavedEntityList) {
        CustomersServicesDTO customersServicesDTO = new CustomersServicesDTO();
        customersServicesDTO.setCustomerId(customerServicesSavedEntityList.get(0).getCustomerEntity().getCustomerId());
        customersServicesDTO.setDate(customerServicesSavedEntityList.get(0).getServiceDate());
        ServiceRegisterationDTO serviceRegisterationDTO;
        List<ServiceRegisterationDTO> serviceRegisterationDTOList = new ArrayList<>();
        List<CustomersServicesDTO> customersServicesDTOList = new ArrayList<>();
        for (CustomerServicesEntity customerServicesEntity : customerServicesSavedEntityList) {
            serviceRegisterationDTO = new ServiceRegisterationDTO();
            BeanUtils.copyProperties(customerServicesEntity, serviceRegisterationDTO);
            serviceRegisterationDTO.setServiceTypeId(customerServicesEntity.getServicesEntity().getServiceTypeId());
            serviceRegisterationDTOList.add(serviceRegisterationDTO);
        }
        customersServicesDTO.setServiceRegisterationDTOList(serviceRegisterationDTOList);
        return customersServicesDTO;
    }

    private CustomersServicesDTO createReturnRegisterationDTO(CustomerServicesEntity customerServicesSavedEntity) {
        CustomersServicesDTO customersServicesDTO = new CustomersServicesDTO();
        customersServicesDTO.setCustomerId(customerServicesSavedEntity.getCustomerEntity().getCustomerId());
        customersServicesDTO.setDate(customerServicesSavedEntity.getServiceDate());
        ServiceRegisterationDTO serviceRegisterationDTO = new ServiceRegisterationDTO();
        BeanUtils.copyProperties(customerServicesSavedEntity, serviceRegisterationDTO);
        serviceRegisterationDTO.setServiceTypeId(customerServicesSavedEntity.getServicesEntity().getServiceTypeId());
        List<ServiceRegisterationDTO> serviceRegisterationDTOList = new ArrayList<>();
        serviceRegisterationDTOList.add(serviceRegisterationDTO);
        customersServicesDTO.setServiceRegisterationDTOList(serviceRegisterationDTOList);
        return customersServicesDTO;
    }

    private CustomerEntity findCustomerEntity(String customerId) {
        return customerRepository.findByCustomerId(customerId);
    }

    private ServicesEntity findByServiceTypeId(String serviceTypeId) {
        return servicesRepository.findByServiceTypeId(serviceTypeId);
    }

    private void createSomeServices() {
        CustomerServicesEntity customerServicesEntity = new CustomerServicesEntity();
        customerServicesEntity.setCustomerEntity(customerRepository.findByPhoneNumber("123123"));
        customerServicesEntity.setServicesEntity(servicesRepository.findByServiceTypeId("HR412"));
        customerServicesEntity.setComplete(false);
        customerServicesEntity.setQuantity(1);

        CustomerServicesEntity customerServicesEntity2 = new CustomerServicesEntity();
        BeanUtils.copyProperties(customerServicesEntity, customerServicesEntity2);
        customerServicesEntity2.setServicesEntity(servicesRepository.findByServiceTypeId("HS01"));

        CustomerServicesEntity customerServicesEntity3 = new CustomerServicesEntity();
        BeanUtils.copyProperties(customerServicesEntity, customerServicesEntity3);
        customerServicesEntity3.setServicesEntity(servicesRepository.findByServiceTypeId("HS03"));

        customerServicesRepository.save(customerServicesEntity);
        customerServicesRepository.save(customerServicesEntity2);
        customerServicesRepository.save(customerServicesEntity3);

    }
}
