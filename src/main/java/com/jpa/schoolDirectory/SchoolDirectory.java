package com.jpa.schoolDirectory;

import com.jpa.schoolDirectory.dao.EmployeeDAO;
import com.jpa.schoolDirectory.entitiy.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SchoolDirectory {

	public static void main(String[] args) {
		SpringApplication.run(SchoolDirectory.class, args);
	}

}
