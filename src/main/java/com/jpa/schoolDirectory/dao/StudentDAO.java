package com.jpa.schoolDirectory.dao;

import com.jpa.schoolDirectory.entitiy.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void updateStudentFirstName(Integer id, String info);

    void deleteStudent(Integer id);
}
