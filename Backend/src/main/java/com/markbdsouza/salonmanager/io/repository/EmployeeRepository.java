package com.markbdsouza.salonmanager.io.repository;

import com.markbdsouza.salonmanager.io.entity.EmployeesEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeesEntity, Long> {

}
