package com.markbdsouza.salonmanager.io.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="customer_services")
public class CustomerServicesEntity {
    private static final long serialVersionUID = -2503907167963494127L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String customerServiceId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false , cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customerEntity;
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "service_id", nullable = false)
    private ServicesEntity servicesEntity;
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "employee_id")
//    private EmployeesEntity employeesEntity;
    @Column
    private Date serviceDate = new Date();
    @Column
    private int quantity;
    @Column
    private boolean isComplete = false;
    @Column
    private boolean isCancelled = false;

//    public EmployeesEntity getEmployeesEntity() {
//        return employeesEntity;
//    }
//
//    public void setEmployeesEntity(EmployeesEntity employeesEntity) {
//        this.employeesEntity = employeesEntity;
//    }

    public String getCustomerServiceId() {
        return customerServiceId;
    }

    public void setCustomerServiceId(String customerServiceId) {
        this.customerServiceId = customerServiceId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    public ServicesEntity getServicesEntity() {
        return servicesEntity;
    }

    public void setServicesEntity(ServicesEntity servicesEntity) {
        this.servicesEntity = servicesEntity;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
}
