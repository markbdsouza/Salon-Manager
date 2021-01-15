package com.markbdsouza.salonmanager.service.impl;

import com.markbdsouza.salonmanager.io.entity.CustomerEntity;
import com.markbdsouza.salonmanager.io.repository.CustomerRepository;
import com.markbdsouza.salonmanager.service.CustomerService;
import com.markbdsouza.salonmanager.shared.Constants;
import com.markbdsouza.salonmanager.shared.Utils;
import com.markbdsouza.salonmanager.shared.dto.CustomerDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    Utils utils;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customerDTO, customerEntity);
        customerEntity.setCustomerId(utils.generateCustomerId(Constants.CUSTOMER_ID_LENGTH));
        CustomerEntity savedEntity = customerRepository.save(customerEntity);
        CustomerDTO returnCustomer = new CustomerDTO();
        BeanUtils.copyProperties(savedEntity, returnCustomer);
        return returnCustomer;
    }

    @Override
    public CustomerDTO updateCustomer(String customerId, CustomerDTO customerDTO) {
        CustomerEntity originalCustomerEntity = customerRepository.findByCustomerId(customerId);
        originalCustomerEntity = copyCustomerDetailsForUpdate(customerDTO, originalCustomerEntity);
        if (originalCustomerEntity == null) throw new RuntimeException("Customer Id not found" + customerId);
        CustomerEntity savedEntity = customerRepository.save(originalCustomerEntity);
        CustomerDTO returnCustomer = new CustomerDTO();
        BeanUtils.copyProperties(savedEntity, returnCustomer);
        return returnCustomer;
    }

    @Override
    public CustomerDTO findCustomerByPhoneNumber(String phoneNumber) {
        CustomerEntity savedCustomerEntity = customerRepository.findByPhoneNumber(phoneNumber);
        if (savedCustomerEntity == null) throw new RuntimeException("Phone Number not found" + phoneNumber);
        CustomerDTO returnCustomer = new CustomerDTO();
        BeanUtils.copyProperties(savedCustomerEntity, returnCustomer);
        return returnCustomer;
    }

    @Override
    public CustomerDTO GetCustomerDetails(String customerId) {
        CustomerEntity savedCustomerEntity = customerRepository.findByCustomerId(customerId);
        if (savedCustomerEntity == null) throw new RuntimeException("Customer Id not found" + customerId);
        CustomerDTO returnCustomer = new CustomerDTO();
        BeanUtils.copyProperties(savedCustomerEntity, returnCustomer);
        return returnCustomer;
    }

    @Override
    public List<CustomerDTO> getCustomers() {
        List<CustomerEntity> customerEntityList = (List<CustomerEntity>) customerRepository.findAll();
        List<CustomerDTO> returnCustomerList = new ArrayList<>();
        CustomerDTO customerDto;
        for (CustomerEntity customerEntity : customerEntityList) {
            customerDto = new CustomerDTO();
            BeanUtils.copyProperties(customerEntity, customerDto);
            returnCustomerList.add(customerDto);
        }
        return returnCustomerList;
    }

    private CustomerEntity copyCustomerDetailsForUpdate(CustomerDTO customerDTO, CustomerEntity customerEntity) {
        customerEntity.setEmail(customerDTO.getEmail());
        customerEntity.setFirstName(customerDTO.getFirstName());
        customerEntity.setLastName(customerDTO.getLastName());
        customerEntity.setPhoneNumber(customerDTO.getPhoneNumber());
        return customerEntity;

    }
}
