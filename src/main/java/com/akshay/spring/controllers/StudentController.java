package com.akshay.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.spring.dtos.StudentDTO;
import com.akshay.spring.services.StudentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/getAllStudents")
	public List<StudentDTO> getAllStudents() {
		System.out.println("Get all");
		return studentService.getAllStudents();
	}
	
	@GetMapping("/getStudentByRollNumber")
	public StudentDTO getStudentBy(@RequestParam(name="rollNumber") String rollNumber) {
		return studentService.getStudentBy(rollNumber);
	}
	
	@PostMapping("/saveStudent")
	public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO) {
		System.out.println("Save student");
		System.out.println(studentDTO);
		return studentService.saveStudent(studentDTO);
	}
	@PostMapping("/deleteStudentByRollNumber")
	public void deleteStudentBy(@RequestParam(name="rollNumber")String rollNumber) {
		System.out.println("delete student\t"+rollNumber);
		studentService.deleteStudentBy(rollNumber);
	}
	
}
