package com.markbdsouza.salonmanager.shared.dto;

import java.util.Date;
import java.util.List;

public class CustomersServicesDTO {
    private String customerId;
    private Date date;
    private List<ServiceRegisterationDTO> serviceRegisterationDTOList;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ServiceRegisterationDTO> getServiceRegisterationDTOList() {
        return serviceRegisterationDTOList;
    }

    public void setServiceRegisterationDTOList(List<ServiceRegisterationDTO> serviceRegisterationDTOList) {
        this.serviceRegisterationDTOList = serviceRegisterationDTOList;
    }
}
