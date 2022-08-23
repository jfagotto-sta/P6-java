package com.OcProject.PayMyBuddy.services;

import java.util.List;
import java.util.Optional;

import com.OcProject.PayMyBuddy.model.UserBean;
import com.OcProject.PayMyBuddy.utils.PasswordHashing;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.repository.UserRepository;

import static com.OcProject.PayMyBuddy.utils.PasswordHashing.getEncodedPassword;

@Service
public class UserService {

	private final Logger logger = Logger.getLogger(this.getClass());

	public UserService() {
	}

	@Autowired
	private UserRepository userRepo;

	public User findByMail(String email) {
		return userRepo.findByMail(email);
	}

	public List<User> findByLikableMail(String email) {
		return userRepo.findLikeMail(email);
	}

	public User findByLastNameAndFirstName(String lastName, String firstName) {
		return userRepo.findByLastNameAndFirstName(lastName, firstName);
	}

	public Iterable<User> getUsers() {
		return userRepo.findAll();
	}

	public Optional<User> getUserById(Integer id) {
		return userRepo.findById(id);
	}

	public void newUser(UserBean user) {
		User user1 = new User();
		user1.setFirstName(user.getFirstName());
		user1.setLastName(user.getLastName());
		user1.setMail(user.getEmail());
		user1.setBalance(0.0);
		user1.setPassword(getEncodedPassword(user.getPassword()));
		userRepo.save(user1);

	}

	public void deleteById(Integer id) {
		userRepo.deleteById(id);
	}
	
	public User findByMailAndPassword(String email, String password) {
		return userRepo.findByMailAndPassword(email, getEncodedPassword(password));
	}

}


