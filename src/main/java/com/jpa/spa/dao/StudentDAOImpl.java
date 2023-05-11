package com.jpa.spa.dao;

import com.jpa.spa.entitiy.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    // Transaction handles db transactions. updates/modifications
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) throws NullPointerException{
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //create query. It does differ from MYSQL syntax. Check documentation
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student ORDER BY firstName", Student.class);

        //return query results

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student WHERE lastName=:theData", Student.class);

        theQuery.setParameter("theData", lastName);

        return theQuery.getResultList();
    }
}
