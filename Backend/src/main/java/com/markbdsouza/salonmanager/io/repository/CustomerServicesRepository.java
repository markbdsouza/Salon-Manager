package com.markbdsouza.salonmanager.io.repository;

import com.markbdsouza.salonmanager.io.entity.CustomerEntity;
import com.markbdsouza.salonmanager.io.entity.CustomerServicesEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface CustomerServicesRepository extends CrudRepository<CustomerServicesEntity, Long> {
    List<CustomerServicesEntity> findByCustomerEntityAndServiceDate(CustomerEntity customerEntity, Date date);

    Long deleteByCustomerEntityAndCustomerServiceId(CustomerEntity customerEntity, String customerServiceId);
}
