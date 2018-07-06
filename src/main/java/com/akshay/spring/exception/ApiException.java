package com.akshay.spring.exception;

import org.hibernate.service.spi.ServiceException;

public class ApiException extends ServiceException {

	public ApiException(String message, Throwable root) {
		super(message, root);
	}
	
	public ApiException(String message) {
		super(message);
	}

}
