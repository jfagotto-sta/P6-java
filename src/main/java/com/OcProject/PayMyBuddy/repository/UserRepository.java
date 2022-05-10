package com.OcProject.PayMyBuddy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.OcProject.PayMyBuddy.model.User;



@Repository
public interface UserRepository extends CrudRepository<User, Integer>{


	public User findByMail(String email);
	
	public List<User> findByLastNameAndFirstName(String lastName, String firstName);

}
