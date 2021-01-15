package com.markbdsouza.salonmanager.ui.controller;

import com.markbdsouza.salonmanager.service.CustomerService;
import com.markbdsouza.salonmanager.shared.dto.CustomerDTO;
import com.markbdsouza.salonmanager.ui.model.request.CustomerRequestModel;
import com.markbdsouza.salonmanager.ui.model.response.CustomerResponseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("customers")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @GetMapping(path = "/{id}")
    public ResponseEntity<CustomerResponseModel> GetCustomerDetails(@PathVariable String id) {
        CustomerDTO savedCustomerDTO = customerService.GetCustomerDetails(id);
        // copy details to returnObject
        CustomerResponseModel customerResponseModel = new CustomerResponseModel();
        BeanUtils.copyProperties(savedCustomerDTO, customerResponseModel);
        return new ResponseEntity(customerResponseModel, HttpStatus.OK);
    }

    @GetMapping(path = "/phoneNumber/{phoneNumber}")
    public ResponseEntity<CustomerResponseModel> FindCustomerByPhoneNumber(@PathVariable String phoneNumber) {
        CustomerDTO savedCustomerDTO = customerService.findCustomerByPhoneNumber(phoneNumber);
        // copy details to returnObject
        CustomerResponseModel customerResponseModel = new CustomerResponseModel();
        BeanUtils.copyProperties(savedCustomerDTO, customerResponseModel);
        return new ResponseEntity(customerResponseModel, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CustomerResponseModel>> GetCustomers() {

        List<CustomerDTO> savedCustomerDTOList = customerService.getCustomers();
        // copy details to returnObject
        List<CustomerResponseModel> customerResponseModelList = new ArrayList<>();
        CustomerResponseModel userRest;
        for (CustomerDTO customerDTO : savedCustomerDTOList) {
            userRest = new CustomerResponseModel();
            BeanUtils.copyProperties(customerDTO, userRest);
            customerResponseModelList.add(userRest);
        }
        return new ResponseEntity<>(customerResponseModelList, HttpStatus.OK);

    }


    @PostMapping
    public ResponseEntity<CustomerResponseModel> createCustomer(@RequestBody CustomerRequestModel customer) {
        CustomerDTO receivedCustomerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, receivedCustomerDTO);
        //call service
        CustomerDTO savedCustomerDTO = customerService.saveCustomer(receivedCustomerDTO);
        // copy details to returnObject
        CustomerResponseModel customerResponseModel = new CustomerResponseModel();
        BeanUtils.copyProperties(savedCustomerDTO, customerResponseModel);
        return new ResponseEntity(customerResponseModel, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CustomerResponseModel> updateCustomer(@PathVariable String id, @RequestBody CustomerRequestModel customer) {
        CustomerDTO receivedCustomerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, receivedCustomerDTO);
        receivedCustomerDTO.setCustomerId(id);
        //call service
        CustomerDTO savedCustomerDTO = customerService.updateCustomer(id, receivedCustomerDTO);
        // copy details to returnObject
        CustomerResponseModel customerResponseModel = new CustomerResponseModel();
        BeanUtils.copyProperties(savedCustomerDTO, customerResponseModel);
        return new ResponseEntity(customerResponseModel, HttpStatus.CREATED);
    }
}
