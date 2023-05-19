package com.jpa.schoolDirectory.repository;

import com.jpa.schoolDirectory.entitiy.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//Adds custom path for the url instead of using custom REST path
//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
