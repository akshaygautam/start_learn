package com.akshay.spring.serviceImpls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.spring.dtos.StudentDTO;
import com.akshay.spring.models.StudentModel;
import com.akshay.spring.repositories.StudentRepository;
import com.akshay.spring.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public List<StudentDTO> getAllStudents() {
		List <StudentModel> studentsModelList = studentRepository.findAll();
		List <StudentDTO> studentDTOList = new ArrayList();
		for(StudentModel student: studentsModelList) {
			studentDTOList.add(convertModelToDTO(student));
		}
		return studentDTOList;
	}


	@Override
	public StudentDTO getStudentBy(String rollNumber) {
		return convertModelToDTO(studentRepository.findByRollNumber(rollNumber));
	}

	@Override
	public StudentDTO saveStudent(StudentDTO studentDTO) {
		studentRepository.save(convertDTOToModel(studentDTO));
		return studentDTO;
	}

	@Override
	public void deleteStudentBy(String rollNumber) {
		StudentModel student = studentRepository.findByRollNumber(rollNumber);
		studentRepository.deleteById(student.getId());
	}


	private StudentDTO convertModelToDTO(StudentModel student) {
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setAddress(student.getAddress());
		studentDTO.setEmailId(student.getEmailId());
		studentDTO.setFathersName(student.getFathersName());
		studentDTO.setFirstName(student.getFirstName());
		studentDTO.setId(student.getId());
		studentDTO.setLastName(student.getLastName());
		studentDTO.setMothersName(student.getMothersName());
		studentDTO.setPhoneNumber(student.getPhoneNumber());
		studentDTO.setRollNumber(student.getRollNumber());
		studentDTO.setStandard(student.getStandard());
		return studentDTO;
	}
	
	private StudentModel convertDTOToModel(StudentDTO student) {
		StudentModel studentModel = new StudentModel();
		studentModel.setAddress(student.getAddress());
		studentModel.setEmailId(student.getEmailId());
		studentModel.setFathersName(student.getFathersName());
		studentModel.setFirstName(student.getFirstName());
		studentModel.setId(student.getId());
		studentModel.setLastName(student.getLastName());
		studentModel.setMothersName(student.getMothersName());
		studentModel.setPhoneNumber(student.getPhoneNumber());
		studentModel.setRollNumber(student.getRollNumber());
		studentModel.setStandard(student.getStandard());
		return studentModel;
	}
}
