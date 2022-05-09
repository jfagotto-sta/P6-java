package com.OcProject.PayMyBuddy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.OcProject.PayMyBuddy.model.User;



@Repository
public interface UserRepository extends CrudRepository<User, Integer>{


	public User findByMail(String email);
	
	public List<User> findByLastNameAndFirstName(String lastName, String firstName);
//
//	@Override
//	public User save(User user){
//		User existingUser = findByMail(user.getMail());
//		if(existingUser != null) {
//			logger.info("Mail deja existant");
//			return null;
//			//throw
//		}
//
//		//d'autres verifications
//		return save(user);
//	}
//

}
