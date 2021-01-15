package com.markbdsouza.salonmanager.io.repository;

import com.markbdsouza.salonmanager.io.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
    CustomerEntity findByCustomerId(String customerId);
    CustomerEntity findByPhoneNumber(String phoneNumber);
}
