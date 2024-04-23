package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.model.Student;
import com.demo.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService service;

	public StudentController(StudentService service) {
		super();
		this.service = service;
	}
	@GetMapping("/students")
	public String liststudent(Model model) {
		model.addAttribute("students", service.getallstudent());
		return "students";
	}
	@GetMapping("/students/new")
	public String createstudentform(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String savestudent(@ModelAttribute("student") Student student) {
	service.savestudent(student);
	return "redirect:/students";
	}
	@GetMapping("/students/edit/{id}")
	public String editstudentform(@PathVariable int id, Model model) {
		model.addAttribute("student",service.getstudentbyid(id));
		return"edit_student";
}
	@PostMapping("/students/{id}")
	public String updatestudent(@PathVariable int id,  
			@ModelAttribute("student") Student student, Model model) {
		Student existstudent = service.getstudentbyid(id);
		existstudent.setId(id);
		existstudent.setFirstname(student.getFirstname());
		existstudent.setLastname(student.getLastname());
		existstudent.setEmail(student.getEmail());
		
		service.updatestudent(existstudent);
		return"redirect:/students";
	}

	@GetMapping("/students/delete/{id}")
	public  String deletestudent(@PathVariable int id) {
		service.deletestudbyid(id);
		return"redirect:/students";
	}
	
}
