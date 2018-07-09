package com.akshay.spring.serviceImpls;


import static org.mockito.Matchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.akshay.spring.dtos.StudentDTO;
import com.akshay.spring.models.StudentModel;
import com.akshay.spring.repositories.StudentRepository;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImpTest {

	@Mock
	StudentRepository studentRepository;

	@InjectMocks
	StudentServiceImpl studentService;

	public StudentDTO studentDTO;
	public StudentDTO deletedStudentDTO;
	
	public List<StudentDTO> studentDTOList;

	public StudentModel studentModel;
	public List<StudentModel> studentModelList;
	public StudentModel deletedstudentModel;
	public StudentModel  studentModelDeleted ;

	@Before
	public void setUp() {
		//this is to  initialise all the mock  object are requested to create
		MockitoAnnotations.initMocks(this);
	
		
		
		studentDTO = new StudentDTO();
		studentDTOList = new ArrayList<StudentDTO>();
		deletedStudentDTO = new StudentDTO();

		studentModel = new StudentModel();
		studentModelList = new ArrayList<StudentModel>();
		deletedstudentModel = new StudentModel();
		studentModelDeleted = new StudentModel();
		studentDTO.setAddress("Delhi");
		studentDTO.setEmailId("email@gmail.com");
		studentDTO.setFathersName("Father");
		studentDTO.setFirstName("FirstName");
		studentDTO.setId(1L);
		studentDTO.setLastName("LastName");
		studentDTO.setMothersName("Mother");
		studentDTO.setPhoneNumber("9873871307");
		studentDTO.setRollNumber("123");
		studentDTO.setStandard("XII");
		studentDTO.setDeleted(false);

		studentDTOList.add(studentDTO);

		deletedStudentDTO.setAddress("Delhi");
		deletedStudentDTO.setEmailId("email@gmail.com");
		deletedStudentDTO.setFathersName("Father");
		deletedStudentDTO.setFirstName("FirstName");
		deletedStudentDTO.setId(1L);
		deletedStudentDTO.setLastName("LastName");
		deletedStudentDTO.setMothersName("Mother");
		deletedStudentDTO.setPhoneNumber("9873871307");
		deletedStudentDTO.setRollNumber("123");
		deletedStudentDTO.setStandard("XII");
		deletedStudentDTO.setDeleted(true);

		studentModel.setAddress("Delhi");
		studentModel.setEmailId("email@gmail.com");
		studentModel.setFathersName("Father");
		studentModel.setFirstName("FirstName");
		studentModel.setId(1L);
		studentModel.setLastName("LastName");
		studentModel.setMothersName("Mother");
		studentModel.setPhoneNumber("9873871307");
		studentModel.setRollNumber("123");
		studentModel.setStandard("XII");
		studentModel.setDeleted(false);
		
		
		studentModelDeleted.setAddress("Delhi");
		studentModelDeleted.setEmailId("email@gmail.com");
		studentModelDeleted.setFathersName("Father");
		studentModelDeleted.setFirstName("FirstName");
		studentModelDeleted.setId(1L);
		studentModelDeleted.setLastName("LastName");
		studentModelDeleted.setMothersName("Mother");
		studentModelDeleted.setPhoneNumber("9873871307");
		studentModelDeleted.setRollNumber("123");
		studentModelDeleted.setStandard("XII");
		studentModelDeleted.setDeleted(true);

		studentModelList.add(studentModel);

		deletedstudentModel.setAddress("Delhi");
		deletedstudentModel.setEmailId("email@gmail.com");
		deletedstudentModel.setFathersName("Father");
		deletedstudentModel.setFirstName("FirstName");
		deletedstudentModel.setId(1L);
		deletedstudentModel.setLastName("LastName");
		deletedstudentModel.setMothersName("Mother");
		deletedstudentModel.setPhoneNumber("9873871307");
		deletedstudentModel.setRollNumber("123");
		deletedstudentModel.setStandard("XII");
		deletedstudentModel.setDeleted(true);
	}

	@Test
	public void testGetAllStudents() {
		Mockito.when(studentRepository.findAll()).thenReturn(studentModelList);
		List<StudentDTO> studentDTOs = studentService.getAllStudents();

		assertTrue(!studentDTOs.isEmpty());
		assertEquals("Delhi", studentDTOs.get(0).getAddress());
		assertEquals("email@gmail.com", studentDTOs.get(0).getEmailId());
		assertEquals("Father", studentDTOs.get(0).getFathersName());
		assertEquals("FirstName", studentDTOs.get(0).getFirstName());
		assertEquals(1L, studentDTOs.get(0).getId().longValue());
		assertEquals("LastName", studentDTOs.get(0).getLastName());
		assertEquals("Mother", studentDTOs.get(0).getMothersName());
		assertEquals("9873871307", studentDTOs.get(0).getPhoneNumber());
		assertEquals("123", studentDTOs.get(0).getRollNumber());
		assertEquals("XII", studentDTOs.get(0).getStandard());
		assertFalse(studentDTOs.get(0).getDeleted());
	}

	@Test
	public void testGetStudentBy() {
		Mockito.when(studentRepository.findByRollNumber("123")).thenReturn(studentModel);
		StudentDTO student = studentService.getStudentBy("123");
		assertTrue(null != student);
		assertEquals("123", student.getRollNumber());
	}

	@Test
	public void testSaveStudent() {
		 Mockito.when(studentRepository.save(any(StudentModel.class))).thenReturn(studentModel);
		StudentDTO student = studentService.saveStudent(studentDTO);
		// Mockito.verify(repository, Mockito.times(1)).save(Mockito.eq(studentModel));

		assertNotNull(student);
		assertEquals("Delhi", student.getAddress());
		assertEquals("email@gmail.com", student.getEmailId());
		assertEquals("Father", student.getFathersName());
		assertEquals("FirstName", student.getFirstName());
		assertEquals(1L, student.getId().longValue());
		assertEquals("LastName", student.getLastName());
		assertEquals("Mother", student.getMothersName());
		assertEquals("9873871307", student.getPhoneNumber());
		assertEquals("123", student.getRollNumber());
		assertEquals("XII", student.getStandard());
		assertFalse(student.getDeleted());
	}

	@Test
	public void testDeleteStudentBy() {
		Mockito.when(studentRepository.findByRollNumber("123")).thenReturn(studentModel);
		Mockito.when(studentRepository.save(any(StudentModel.class))).thenReturn(deletedstudentModel);
		StudentDTO student = studentService.deleteStudentBy("123");
		assertTrue(null != student);
		assertEquals("Delhi", student.getAddress());
		assertEquals("email@gmail.com", student.getEmailId());
		assertEquals("Father", student.getFathersName());
		assertEquals("FirstName", student.getFirstName());
		assertEquals(1L, student.getId().longValue());
		assertEquals("LastName", student.getLastName());
		assertEquals("Mother", student.getMothersName());
		assertEquals("9873871307", student.getPhoneNumber());
		assertEquals("123", student.getRollNumber());
		assertEquals("XII", student.getStandard());
		assertTrue(student.getDeleted());
	}
}
