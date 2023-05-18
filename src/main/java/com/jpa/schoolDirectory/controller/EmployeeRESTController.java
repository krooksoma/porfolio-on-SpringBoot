package com.jpa.schoolDirectory.controller;


import com.jpa.schoolDirectory.entitiy.Employee;
import com.jpa.schoolDirectory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRESTController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //just in case they pass ID in Json .. set id to 0
        //force save new item
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.saveEmployee(theEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable int id){
        Employee theEmployee = employeeService.findEmployeeById(id);


        employeeService.deleteById(theEmployee.getId());
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.saveEmployee(theEmployee);

        return dbEmployee;
    }

    @GetMapping("/employee/{id}")
    public Employee findEmployeedById(@PathVariable int id){
        Employee theEmployee = employeeService.findEmployeeById(id);

        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - " + id);
        }

        return theEmployee;
    }

}
