package com.markbdsouza.salonmanager.ui.controller;

import com.markbdsouza.salonmanager.service.ProvidedServicesService;
import com.markbdsouza.salonmanager.shared.dto.CustomersServicesDTO;
import com.markbdsouza.salonmanager.shared.dto.ServiceRegisterationDTO;
import com.markbdsouza.salonmanager.ui.model.request.CustomerServiceRegistrationRequestModel;
import com.markbdsouza.salonmanager.ui.model.response.CustomerServicesResponseModel;
import com.markbdsouza.salonmanager.ui.model.response.ServiceRegisterationModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("customerServices")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerServicesController {
    @Autowired
    ProvidedServicesService providedServicesService;

    @PostMapping(path = "/{customerId}/{Date}")
    public ResponseEntity<CustomerServicesResponseModel> saveCustomerServices(@PathVariable String customerId,
                                                                              @PathVariable String Date,
                                                                              @RequestBody CustomerServiceRegistrationRequestModel serviceRegModel) {
        ServiceRegisterationDTO serviceRegDTO = new ServiceRegisterationDTO();
        BeanUtils.copyProperties(serviceRegModel,serviceRegDTO);
        CustomersServicesDTO customersServicesDTO = providedServicesService.saveCustomerService(customerId, Date, serviceRegDTO);

        CustomerServicesResponseModel returnObject = createResponseObject(customersServicesDTO);
        return new ResponseEntity(returnObject, HttpStatus.CREATED);
    }




    private CustomerServicesResponseModel createResponseObject(CustomersServicesDTO customersServicesDTO){
        CustomerServicesResponseModel returnObject = new CustomerServicesResponseModel();
        List<ServiceRegisterationModel> serviceRegisterationModelList = new ArrayList<>();
        ServiceRegisterationModel serviceRegisterationModel;
        BeanUtils.copyProperties(customersServicesDTO, returnObject);
        for(ServiceRegisterationDTO serviceRegisterationDTO: customersServicesDTO.getServiceRegisterationDTOList()){
            serviceRegisterationModel=new ServiceRegisterationModel();
            BeanUtils.copyProperties(serviceRegisterationDTO, serviceRegisterationModel);
            serviceRegisterationModelList.add(serviceRegisterationModel);
        }
        returnObject.setServiceRegisterationModelList(serviceRegisterationModelList);
        return returnObject;
    }
}
