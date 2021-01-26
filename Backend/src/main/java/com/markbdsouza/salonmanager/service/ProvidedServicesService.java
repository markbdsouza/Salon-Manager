package com.markbdsouza.salonmanager.service;

import com.markbdsouza.salonmanager.shared.dto.CustomersServicesDTO;
import com.markbdsouza.salonmanager.shared.dto.ServiceRegisterationDTO;
import com.markbdsouza.salonmanager.shared.dto.ServicesDTO;

import java.util.List;

public interface ProvidedServicesService {
    List<ServicesDTO> getAllServices();
    CustomersServicesDTO  saveCustomerService(String customerId, String date, List<ServiceRegisterationDTO> serviceRegDTOList);
    CustomersServicesDTO  getCustomerServices(String customerId, String date);
    boolean delete(String customerId, String customerServiceId);
}
