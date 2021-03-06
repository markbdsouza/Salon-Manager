package com.markbdsouza.salonmanager.io.repository;

import com.markbdsouza.salonmanager.io.entity.EmployeesEntity;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeesEntity, Long> {

}
