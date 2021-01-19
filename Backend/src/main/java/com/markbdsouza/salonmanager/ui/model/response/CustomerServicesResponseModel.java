package com.markbdsouza.salonmanager.ui.model.response;

import java.util.Date;
import java.util.List;

public class CustomerServicesResponseModel {
    private String customerId;
    private Date date;
    private List<ServiceRegisterationModel> serviceRegisterationModelList;

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

    public List<ServiceRegisterationModel> getServiceRegisterationModelList() {
        return serviceRegisterationModelList;
    }

    public void setServiceRegisterationModelList(List<ServiceRegisterationModel> serviceRegisterationModelList) {
        this.serviceRegisterationModelList = serviceRegisterationModelList;
    }
}
