package com.markbdsouza.salonmanager.service;

import com.markbdsouza.salonmanager.shared.dto.CustomerDTO;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    CustomerDTO findCustomerByPhoneNumber(String phoneNumber);

}
