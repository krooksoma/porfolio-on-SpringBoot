package com.jpa.schoolDirectory.dao;


import com.jpa.schoolDirectory.entitiy.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findEmployeeById(Long id);

    Employee saveEmployee(Employee theEmployee);

    void deleteEmployeeById(long theId);
}
