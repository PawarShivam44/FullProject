package com.demo.service;

import java.util.List;

import com.demo.model.Student;

public interface StudentService {

	List<Student> getallstudent();
	Student savestudent(Student student);
	Student getstudentbyid(int id);
	Student updatestudent(Student student );
	void deletestudbyid(int id);
}
