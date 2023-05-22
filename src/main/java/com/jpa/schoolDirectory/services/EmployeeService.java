package com.jpa.schoolDirectory.services;

import com.jpa.schoolDirectory.entitiy.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee saveEmployee(Employee theEmployee);

    Employee findEmployeeById(int id);

    void deleteById(int id);
}
