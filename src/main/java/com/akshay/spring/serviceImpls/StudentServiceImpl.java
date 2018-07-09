package com.akshay.spring.serviceImpls;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.spring.dtos.StudentDTO;
import com.akshay.spring.exception.ApiException;
import com.akshay.spring.models.StudentModel;
import com.akshay.spring.repositories.StudentRepository;
import com.akshay.spring.services.StudentService;
import com.akshay.spring.utils.StringUtils;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	private ModelMapper mapper = new ModelMapper();
	private static Logger LOGGER = Logger.getLogger(StudentServiceImpl.class.getName());

	@Override
	public List<StudentDTO> getAllStudents() {
		try {
			List<StudentModel> studentsModelList = studentRepository.findAllByDeleted(false);
			List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();
			for (StudentModel student : studentsModelList) {
				studentDTOList.add(convertModelToDTO(student));
			}
			return studentDTOList;
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error while fetching students\n" + e);
			throw new ApiException("Error while fetching students", e);
		}
	}

	@Override
	public StudentDTO getStudentBy(String rollNumber) {
		try {
			return convertModelToDTO(studentRepository.findByRollNumber(rollNumber));
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error while fetching student: " + rollNumber + "\n" + e);
			throw new ApiException("Error while fetching student with rollnumber: " + rollNumber, e);
		}
	}

	@Override
	public StudentDTO saveStudent(StudentDTO studentDTO) {
		validateStudent(studentDTO);
		try {
			StudentModel studentModel = convertDTOToModel(studentDTO);
			StudentModel savedStudent =null;
			if(null != studentModel) {
				savedStudent = studentRepository.save(studentModel);
			}
			LOGGER.log(Level.SEVERE, "savedStudent student\n" + savedStudent);
			return convertModelToDTO(savedStudent);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error while saving student\n" + e);
			throw new ApiException("Error while saving student", e);
		}
	}

	@Override
	public StudentDTO deleteStudentBy(String rollNumber) {
		try {
			StudentModel student = studentRepository.findByRollNumber(rollNumber);
			student.setDeleted(true);
			return saveStudent(convertModelToDTO(student));
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error while Deleting student: " + rollNumber + "\n" + e);
			throw new ApiException("Error while Deleting student with rollnumber: " + rollNumber, e);
		}
	}

	private StudentDTO convertModelToDTO(StudentModel student) {
		StudentDTO studentDTO = new StudentDTO();
		mapper.map(student, studentDTO);
		return studentDTO;
	}

	private StudentModel convertDTOToModel(StudentDTO student) {
		StudentModel studentModel = new StudentModel();
		mapper.map(student, studentModel);
		return studentModel;
	}

	private void validateStudent(StudentDTO studentDTO) {
		if (null == studentDTO || StringUtils.isBlank(studentDTO.getAddress())
				|| StringUtils.isEmpty(studentDTO.getAddress()) 	|| StringUtils.isBlank(studentDTO.getEmailId())
				|| StringUtils.isEmpty(studentDTO.getEmailId()) 	|| StringUtils.isBlank(studentDTO.getFathersName())
				|| StringUtils.isEmpty(studentDTO.getFathersName()) || StringUtils.isBlank(studentDTO.getFirstName())
				|| StringUtils.isEmpty(studentDTO.getFirstName()) 	|| StringUtils.isBlank(studentDTO.getLastName())
				|| StringUtils.isEmpty(studentDTO.getLastName()) 	|| StringUtils.isBlank(studentDTO.getMothersName())
				|| StringUtils.isEmpty(studentDTO.getMothersName()) || StringUtils.isBlank(studentDTO.getPhoneNumber())
				|| StringUtils.isEmpty(studentDTO.getPhoneNumber()) || StringUtils.isBlank(studentDTO.getRollNumber())
				|| StringUtils.isEmpty(studentDTO.getRollNumber()) 	|| StringUtils.isBlank(studentDTO.getStandard())
				|| StringUtils.isEmpty(studentDTO.getStandard()))
			throw new ApiException("Student detalis not valid");
		else
			chekcUniqenessOfStudent(studentDTO);
	}

	private void chekcUniqenessOfStudent(StudentDTO studentDTO) {
		if (null == studentDTO.getId() && null != studentRepository.findByRollNumber(studentDTO.getRollNumber())) {
			LOGGER.log(Level.SEVERE, "Student already exist with rollnumber: " + studentDTO.getRollNumber());
			throw new ApiException("Student already exist with rollnumber: " + studentDTO.getRollNumber());
		} else if (null == studentDTO.getId()) {
			studentDTO.setDeleted(false);
		}
	}
}
