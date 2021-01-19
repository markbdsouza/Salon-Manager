package com.markbdsouza.salonmanager.io.repository;

import com.markbdsouza.salonmanager.io.entity.ServicesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends CrudRepository<ServicesEntity, Long> {
    ServicesEntity findByServiceTypeId(String serviceTypeId);
}
