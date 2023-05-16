package com.jpa.schoolDirectory.service;

import com.jpa.schoolDirectory.entitiy.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findEmployeeById(Long id);

    Employee saveEmployee(Employee theEmployee);

    void deleteEmployeeById(long theId);

}
