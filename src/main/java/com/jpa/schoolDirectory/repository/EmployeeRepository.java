package com.jpa.schoolDirectory.repository;

import com.jpa.schoolDirectory.entitiy.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
