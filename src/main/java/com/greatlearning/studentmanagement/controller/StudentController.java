package com.greatlearning.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.studentmanagement.entity.Student;
import com.greatlearning.studentmanagement.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/add-begin")
	public String handleAddStudentBegin(Model model) {
		
		Student student= new Student();
		
		model.addAttribute("student", student);
		
		return "students-details";		
	}
	
	@RequestMapping("/update-begin")
	public String handleUpdateStudentBegin(
			@RequestParam("studentId") int studentId, Model model) {
		Student student = studentService.findById(studentId);
		model.addAttribute("student", student);
		
		return "students-details";
		
	}
	
	
	@PostMapping("/save")
	public String saveStudent(
			@RequestParam("studentId") int studentId,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("course") String course,
			@RequestParam("country") String country) {
		
		System.out.println(studentId);
		Student student = null;
		
		if(studentId != 0) {
			
			student = studentService.findById(studentId);
			
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setCourse(course);
			student.setCountry(country);
		}else
			student= new Student(firstName, lastName, course, country);
		studentService.save(student);
	
		return "redirect:/students/list";
	}
	
	@RequestMapping("/delete")
	public String delete(
			@RequestParam("studentId") int studentId) {
		studentService.deleteById(studentId);
		
		return "redirect:/students/list";
	}

}
