package com.akshay.spring.aspects;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AuditLogging {

	@Around("execution(* com.akshay.spring.controllers.StudentController.saveStudent(..))")
	public void saveStudentAuditLog() {
		System.out.println("Saving student");
	}
}
