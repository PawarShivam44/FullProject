package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.model.Student;
import com.demo.repository.StudentRepository;

@SpringBootApplication
public class FullProjectMyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FullProjectMyApplication.class, args);
	}

	@Autowired
	private StudentRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		//Student s = new Student(101,"Shivam","Pawar", "Shivam@gmail.com");
		//repository.save(s);
		
		//Student s1 = new Student(102,"Shubham","Pawar", "Shubham@gmail.com");
		//repository.save(s1);
	}

	
}
