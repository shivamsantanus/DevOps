package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.User;
import com.ecommerce.respository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	public User saveWithProduct(User user) {
		return userRepo.save(user);
	}

	public List<User> allUsers() {
		return userRepo.findAll();
	}
	
	
	public Optional<User> getById(long id) {
		Optional<User> user = userRepo.findById(id);
		return user;
	}
	public Optional<User> getUserByName(String name) {
		Optional<User> user = userRepo.findUserByName(name);
		return user;
	}

	
	

}

