package com.markbdsouza.salonmanager.io.entity;

import javax.persistence.*;

@Entity
@Table(name="customer_services")
public class CustomerServicesEntity {
    private static final long serialVersionUID = -2503907167963494127L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



}
