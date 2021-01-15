package com.markbdsouza.salonmanager.io.entity;

import javax.persistence.*;

@Entity
@Table(name="service_master")
public class ServiceMasterEntity {
    @Id
    @GeneratedValue()
    private String id;
    @Column(nullable = false)
    private String serviceTypeId;
    @Column(nullable = false)
    private String serviceType;
    @Column(nullable = false)
    private String name;
    private String description;
    private String summary;
    @Column(nullable = false)
    private double serviceCost;
    private double taxCost = 0.0;
    @Column(nullable = false)
    private int estimatedMinutes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(String serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public double getTaxCost() {
        return taxCost;
    }

    public void setTaxCost(double taxCost) {
        this.taxCost = taxCost;
    }

    public int getEstimatedMinutes() {
        return estimatedMinutes;
    }

    public void setEstimatedMinutes(int estimatedMinutes) {
        this.estimatedMinutes = estimatedMinutes;
    }
}
