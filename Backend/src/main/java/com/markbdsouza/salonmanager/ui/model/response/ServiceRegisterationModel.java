package com.markbdsouza.salonmanager.ui.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceRegisterationModel {
    private String customerServiceId;
    private String serviceTypeId;
    @JsonProperty
    private boolean isComplete;
    @JsonProperty
    private boolean isCancelled;
    private int quantity;

    public String getCustomerServiceId() {
        return customerServiceId;
    }

    public void setCustomerServiceId(String customerServiceId) {
        this.customerServiceId = customerServiceId;
    }

    public String getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(String serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
