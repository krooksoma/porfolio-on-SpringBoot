package com.jpa.schoolDirectory.controller;

import com.jpa.schoolDirectory.dao.EmployeeDAO;
import com.jpa.schoolDirectory.entitiy.Employee;
import com.jpa.schoolDirectory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRESTController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //just in case they pass ID in Json .. set id to 0
        //force save new item
        theEmployee.setId(0L);

        Employee dbEmployee = employeeService.saveEmployee(theEmployee);

        return dbEmployee;
    }

    @PostMapping("/employee")
    public void deleteEmployee(@RequestBody Long id){

        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/employee/{id}")
    public Employee findEmployeedById(Long id){
        Employee theEmployee = employeeService.findEmployeeById(id);

        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - " + id);
        }

        return theEmployee;
    }

}
