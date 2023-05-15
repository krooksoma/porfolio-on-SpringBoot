package com.jpa.schoolDirectory.dao;


import com.jpa.schoolDirectory.entitiy.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
