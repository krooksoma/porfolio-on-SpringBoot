package com.jpa.schoolDirectory.dao;

import com.jpa.schoolDirectory.entitiy.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeJPADAOImpl implements EmployeeDAO{

    //define field for entitymanager
    private EntityManager entityManager;

    //set up constructon injection
    @Autowired
    public EmployeeJPADAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        //create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);

        //execute query
        List<Employee> employees = theQuery.getResultList();
        //return query
        return employees;
    }

    @Override
    public Employee findEmployeeById(Long id) {
        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    //Transactional annotation goes in the service layer
    @Override
    public Employee saveEmployee(Employee theEmployee) {
        //.merge method will save if entity does not exist or update if it does exist
        Employee dbEmployee = entityManager.merge(theEmployee);

        return dbEmployee;
    }

    //Transactional goes in the service layer
    @Override
    public void deleteEmployeeById(long theId) {
        Employee employee = entityManager.find(Employee.class, theId);

        entityManager.remove(employee);

    }
}
