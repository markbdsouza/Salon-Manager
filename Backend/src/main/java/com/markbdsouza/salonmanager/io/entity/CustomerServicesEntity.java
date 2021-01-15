package com.markbdsouza.salonmanager.io.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_services")
public class CustomerServicesEntity {
    private static final long serialVersionUID = -2503907167963494127L;
    @Id
    @GeneratedValue()
    private long id;



}
