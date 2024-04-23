package com.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Student;
import com.demo.repository.StudentRepository;
import com.demo.service.StudentService;
@Service
public class Serviceimpl implements StudentService{
	@Autowired
	private StudentRepository studentRepository;
	public Serviceimpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	@Override
	public List<Student> getallstudent() {
		return studentRepository.findAll();
	}
	@Override
	public Student savestudent(Student student) {
		return studentRepository.save(student);
	}
	@Override
	public Student getstudentbyid(int id) {

	return studentRepository.findById(id).get();
	}
	@Override
	public Student updatestudent(Student student) {
		
		return studentRepository.save(student);
	}
	@Override
	public void deletestudbyid(int id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}
	
	
	
	
	
	
}
