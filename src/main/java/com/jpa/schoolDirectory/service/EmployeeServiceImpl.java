package com.jpa.schoolDirectory.service;

import com.jpa.schoolDirectory.dao.EmployeeDAO;
import com.jpa.schoolDirectory.entitiy.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeDAO.findEmployeeById(id);
    }

    @Override
    @Transactional
    public Employee saveEmployee(Employee theEmployee) {
        return employeeDAO.saveEmployee(theEmployee);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(long theId) {
        employeeDAO.deleteEmployeeById(theId);
    }
}
