package com.jpa.schoolDirectory.controller;

import com.jpa.schoolDirectory.entitiy.Student;
import com.jpa.schoolDirectory.utils.StudentErrorResponse;
import com.jpa.schoolDirectory.utils.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private List<Student> theStudentList;

    @PostConstruct
    public void loadData(){

        theStudentList = new ArrayList<>();

        theStudentList.add(new Student(1, "Timothy", "Jones", "tim@mail.com"));
        theStudentList.add(new Student(2, "Amy", "Closer", "amy@mail.com"));
        theStudentList.add(new Student(3, "Danny", "Closer", "Dany@mail.com"));
        theStudentList.add(new Student(4, "Emmanuel", "Jhones", "Emjon@mail.com"));
    }

    @GetMapping("/studentsList")
    public List<Student> getStudentsList(){return theStudentList;}

    //define endpoint for "/student/{studentid}
    @GetMapping("/student/{studentId}")
    public Student getStudentByID(@PathVariable int studentId){


        //check student id against list
        if((studentId >= theStudentList.size()) || (studentId < 0)){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudentList.get(studentId);
    }

//
//    //add another generic Exception Handler
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException (Exception exc){
//
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        //400 response instead of 404(NOT_FOUND)
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setMessage(exc.getMessage());
//        error.setTimestamp(new Date(System.currentTimeMillis()));
//
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }

}
