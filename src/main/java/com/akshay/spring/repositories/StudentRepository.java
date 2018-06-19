package com.akshay.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akshay.spring.models.StudentModel;
@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {

	StudentModel findByRollNumber(String rollNumber);
}
