package com.OcProject.PayMyBuddy.services;

import java.util.List;

import com.OcProject.PayMyBuddy.model.UserBean;
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



	public UserBean newUser(UserBean user) {
		User user1 = new User();
		user1.setFirstName(user.getFirstName());
		user1.setLastName(user.getLastName());
		user1.setMail(user.getEmail());
		user1.setBalance(0.0);
		user1.setPassword(getEncodedPassword(user.getPassword()));
		userRepo.save(user1);

		return user;
	}

	public boolean delete(String mail) {
		User user = findByMail(mail);
		userRepo.delete(user);
		return true;
	}
	
	public User findByMailAndPassword(String email, String password) {
		return userRepo.findByMailAndPassword(email, getEncodedPassword(password));
	}

	public User save(User user){
		return userRepo.save(user);
	}

    public void addMoney(String mail, Double amount) {
	User u = findByMail(mail);
	u.setBalance(u.getBalance()+amount);
	save(u);
    }

	public void pullOfMoney(String mail, Double montant) {
		User u = findByMail(mail);
		u.setBalance(u.getBalance()-montant);
		save(u);
	}
}


