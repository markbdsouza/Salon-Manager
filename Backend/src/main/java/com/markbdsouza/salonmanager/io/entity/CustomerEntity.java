package com.markbdsouza.salonmanager.io.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="customers")
public class CustomerEntity  extends Auditable<String>  {
    private static final long serialVersionUID = 5609254628708546255L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String customerId;
    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 15)
    private String phoneNumber;

    @OneToMany(mappedBy = "customerEntity", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<CustomerServicesEntity> customerServices;

    public Set<CustomerServicesEntity> getCustomerServices() {
        return customerServices;
    }

    public void setCustomerServices(Set<CustomerServicesEntity> customerServices) {
        this.customerServices = customerServices;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
