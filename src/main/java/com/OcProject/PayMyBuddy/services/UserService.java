package com.OcProject.PayMyBuddy.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService  {

	private final Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private UserRepository userRepo;

	
	public Iterable<User> getUsers(){
		return userRepo.findAll();
	}

	public Optional<User> getUserById(Integer id) {
		return userRepo.findById(id);
	}

	public User newUser(User user){
		return userRepo.save(user);
	}

	public void delateUser (User user){
		userRepo.delete(user);
	}

}
