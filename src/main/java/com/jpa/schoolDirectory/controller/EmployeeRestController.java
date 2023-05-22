package com.jpa.schoolDirectory.controller;


import com.jpa.schoolDirectory.entitiy.Employee;
import com.jpa.schoolDirectory.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //setting id to zero to force save
        theEmployee.setId(0);

        Employee newEmployee = employeeService.saveEmployee(theEmployee);

        return newEmployee;
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable int id){
        Employee theEmployeed = employeeService.findEmployeeById(id);

        employeeService.deleteById(theEmployeed.getId());
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee newEmployeeInfo = employeeService.saveEmployee(theEmployee);

        return newEmployeeInfo;
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
