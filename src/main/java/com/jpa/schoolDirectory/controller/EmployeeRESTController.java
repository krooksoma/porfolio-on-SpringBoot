package com.jpa.schoolDirectory.controller;

import com.jpa.schoolDirectory.dao.EmployeeDAO;
import com.jpa.schoolDirectory.entitiy.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class EmployeeRESTController {

    private EmployeeDAO employeeDAO;

    public EmployeeRESTController(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

}
