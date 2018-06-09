package com.akshay.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.akshay.spring.models.StudentModel;

public interface StudentRepository extends JpaRepository<StudentModel, Long> {

	StudentModel findByRollNumber(String rollNumber);
}
