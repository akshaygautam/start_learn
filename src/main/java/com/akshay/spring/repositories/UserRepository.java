package com.akshay.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akshay.spring.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	 User findByEmail(String email);

}