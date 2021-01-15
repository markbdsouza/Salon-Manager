package com.markbdsouza.salonmanager.service;

import com.markbdsouza.salonmanager.shared.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(String customerId, CustomerDTO customerDTO);
    CustomerDTO findCustomerByPhoneNumber(String phoneNumber);
    CustomerDTO GetCustomerDetails(String customerId);

    List<CustomerDTO> getCustomers();
}
