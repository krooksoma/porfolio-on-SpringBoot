package com.jpa.schoolDirectory.service;

import com.jpa.schoolDirectory.entitiy.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findEmployeeById(int id);

    Employee saveEmployee(Employee theEmployee);

    void deleteById(int theId);

}
