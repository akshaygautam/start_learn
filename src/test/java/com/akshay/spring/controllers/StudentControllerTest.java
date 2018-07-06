package com.akshay.spring.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.akshay.spring.dtos.StudentDTO;
import com.akshay.spring.services.StudentService;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {
	@Mock 
	StudentService studentService;
	
	@Mock
	HttpServletRequest request;
	
	@InjectMocks
	StudentController studentController;
	
	private StudentDTO studentDTO;
	private StudentDTO deletedStudentDTO;
	private List<StudentDTO> studentDTOList;
	
	@Before
	public void setUp() {
		studentDTO = new StudentDTO();
		studentDTOList = new ArrayList<StudentDTO>();
		deletedStudentDTO = new StudentDTO();
		
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
		
	}
	
	@Test
	public void testGetAllStudents() {
		Mockito.when(studentService.getAllStudents()).thenReturn(studentDTOList);
		List<StudentDTO> studentDTOs = studentController.getAllStudents();
		
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
		Mockito.when(studentService.getStudentBy("123")).thenReturn(studentDTO);
		StudentDTO student = studentController.getStudentBy("123");
		assertTrue(null != student);
		assertEquals("123", student.getRollNumber());
	}
	
	@Test
	public void testSaveStudent() {
		Mockito.when(studentService.saveStudent(studentDTO)).thenReturn(studentDTO);
		StudentDTO student = studentController.saveStudent(studentDTO);
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
		assertFalse(student.getDeleted());
	}
	
	@Test
	public void testDeleteStudentBy() {
		Mockito.when(studentService.deleteStudentBy("123")).thenReturn(deletedStudentDTO);
		StudentDTO student = studentController.deleteStudentBy("123");
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
