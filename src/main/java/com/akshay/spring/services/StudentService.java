package com.akshay.spring.services;

import java.util.List;

import com.akshay.spring.dtos.StudentDTO;

public interface StudentService {

	List<StudentDTO> getAllStudents();

	StudentDTO getStudentBy(String rollNumber);

	StudentDTO saveStudent(StudentDTO studentDTO);

	void deleteStudentBy(String rollNumber);

}
