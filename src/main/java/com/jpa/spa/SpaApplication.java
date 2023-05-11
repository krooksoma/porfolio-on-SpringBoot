package com.jpa.spa;

import com.jpa.spa.dao.StudentDAO;
import com.jpa.spa.entitiy.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {

			// createStudent(studentDAO);
			// findStudent(studentDAO);
			// findAllStudents(studentDAO);
			// findByLastName(studentDAO);
			// updateStudentFirstName(studentDAO);
			deleteStudentById(studentDAO);
		};
	}

	private void deleteStudentById(StudentDAO studentDAO) {
		System.out.println("Deleting student with id: " + studentDAO.toString());
		studentDAO.deleteStudent(5);
	}

	private void updateStudentFirstName(StudentDAO studentDAO) {
		studentDAO.updateStudentFirstName(5, "Evelyn");
		Student student = studentDAO.findById(5);

		System.out.println("Saving new information for : " + student.toString());

	}

	private void findByLastName(StudentDAO studentDAO) {

		List<Student> studentList = studentDAO.findByLastName("Doe");

		for(Student x: studentList){
			System.out.println(x);
		}
	}

	private void findStudent(StudentDAO studentDAO) {

		Student student = studentDAO.findById(4);

		System.out.println(student.toString());
	}

	private void findAllStudents(StudentDAO studentDAO){
		List<Student> studentsList = studentDAO.findAll();
		for(Student x : studentsList){
			System.out.println(x);
		}

	}

	private void createStudent(StudentDAO studentDAO){
		// "Creating student object..."
		Student tempStudent = new Student("Abigail", "Doe", "baybay@luv2code.com");

		//Saving Student object
		studentDAO.save(tempStudent);

		System.out.println("Saved Student. Generated id: " + tempStudent.getId());

		System.out.println("New Student info: " + tempStudent.toString());
	}
}
