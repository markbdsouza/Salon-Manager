package com.markbdsouza.salonmanager.service.impl;

import com.markbdsouza.salonmanager.io.entity.EmployeesEntity;
import com.markbdsouza.salonmanager.io.repository.EmployeeRepository;
import com.markbdsouza.salonmanager.service.EmployeeService;
import com.markbdsouza.salonmanager.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public static int EMPLOYEE_ID_LENGTH = 10;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    Utils utils;

    @Override
    public void createEmployees() {
        List<EmployeesEntity> employeesEntityList = new ArrayList<>();
        employeeRepository.save(createEmployeeJonn());
        employeeRepository.save(createEmployeeMarie());
    }

    private EmployeesEntity createEmployeeJonn() {
        EmployeesEntity employeesEntity = new EmployeesEntity();
        employeesEntity.setFirstName("Jonn");
        employeesEntity.setLastName("Luiz");
        employeesEntity.setDetailedDescription("-------------------");
        employeesEntity.setEmail("JonnLuiz@gmail.com");
        employeesEntity.setPhoneNumber("8214-213-512");
        employeesEntity.setJoiningDate(new Date());
        employeesEntity.setYearsInIndustry(5);
        employeesEntity.setSummary("Hair Styling Expert");
        employeesEntity.setEmployeeId(utils.generateEmployeeId(EMPLOYEE_ID_LENGTH));
        return employeesEntity;
    }

    private EmployeesEntity createEmployeeMarie() {
        EmployeesEntity employeesEntity = new EmployeesEntity();
        employeesEntity.setFirstName("Marie");
        employeesEntity.setLastName("Luiz");
        employeesEntity.setDetailedDescription("-------------------");
        employeesEntity.setEmail("MarieLuiz@gmail.com");
        employeesEntity.setPhoneNumber("2151002132");
        employeesEntity.setJoiningDate(new Date());
        employeesEntity.setYearsInIndustry(8);
        employeesEntity.setSummary("Vast Experience in Hair Treatment");
        employeesEntity.setEmployeeId(utils.generateEmployeeId(EMPLOYEE_ID_LENGTH));
        return employeesEntity;
    }
    private EmployeesEntity createEmployeeSharon() {
        EmployeesEntity employeesEntity = new EmployeesEntity();
        employeesEntity.setFirstName("Sharon");
        employeesEntity.setLastName("Gomez");
        employeesEntity.setDetailedDescription("-------------------");
        employeesEntity.setEmail("Sharon@gmail.com");
        employeesEntity.setPhoneNumber("5196932-3123");
        employeesEntity.setJoiningDate(new Date());
        employeesEntity.setYearsInIndustry(12);
        employeesEntity.setSummary("Great in Hair and Makeup");
        employeesEntity.setEmployeeId(utils.generateEmployeeId(EMPLOYEE_ID_LENGTH));
        return employeesEntity;
    }
}
