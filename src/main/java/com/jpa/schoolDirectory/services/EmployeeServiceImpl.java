package com.jpa.schoolDirectory.services;

import com.jpa.schoolDirectory.entitiy.Employee;
import com.jpa.schoolDirectory.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public Employee findEmployeeById(int id) {
        Optional<Employee> theEmployee = employeeRepository.findById(id);

        Employee returnEmployee = null;

        if(theEmployee.isPresent()){
            returnEmployee = theEmployee.get();
        }
        else{
            throw new RuntimeException("Did not find employee id: " + id);
        }

        return returnEmployee;
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
