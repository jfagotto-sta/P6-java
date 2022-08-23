package com.OcProject.PayMyBuddy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.OcProject.PayMyBuddy.model.User;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	@Transactional
	public User findByMail(String email);
	
	public User findByLastNameAndFirstName(String lastName, String firstName);

	public User findByMailAndPassword(String email, String password);

	@Query("SELECT U FROM User U WHERE LOWER(U.mail) LIKE LOWER(concat(?1, '%'))")
	List<User> findLikeMail(String mail);
	
}
