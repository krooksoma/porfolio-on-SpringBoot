package com.jpa.schoolDirectory.repository;

import com.jpa.schoolDirectory.entitiy.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//Adds custom path for the url instead of using custom REST path
@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
