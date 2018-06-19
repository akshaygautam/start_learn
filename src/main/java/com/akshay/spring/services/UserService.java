package com.akshay.spring.services;

import com.akshay.spring.models.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
