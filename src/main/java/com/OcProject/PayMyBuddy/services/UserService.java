package com.OcProject.PayMyBuddy.services;

import java.util.List;
import java.util.Optional;

import com.OcProject.PayMyBuddy.utils.PasswordHashing;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.repository.UserRepository;

@Service
public class UserService {

	private final Logger logger = Logger.getLogger(this.getClass());


	@Autowired
	private UserRepository userRepo;

	public User findByMail(String email) {
		return userRepo.findByMail(email);
	}

	public List<User> findByLikableMail(String email) {
		return userRepo.findLikeMail(email);
	}

	public List<User> findByLastNameAndFirstName(String lastName, String firstName) {
		return userRepo.findByLastNameAndFirstName(lastName, firstName);
	}

	public Iterable<User> getUsers() {
		return userRepo.findAll();
	}

	public Optional<User> getUserById(Integer id) {
		return userRepo.findById(id);
	}

	public User newUser(User user) {
		user.setPassword(PasswordHashing.getEncodedPassword(user.getPassword()));
		System.out.println(user.getPassword());
		return userRepo.save(user);

	}

	public void deleteById(Integer id) {
		userRepo.deleteById(id);
	}
	
	public User findByMailAndPassword(String email, String password) {
		return userRepo.findByMailAndPassword(email, PasswordHashing.getEncodedPassword(password));
	}



//	public User getUserWithCorrectMailAndPAssword(String mail, String Password) {
//
//		//if (user.getMail())
//	}

//	public void addAFriendToFriendList(User user1, User user2) {
//		ContactId contactId = new ContactId(user1, user2);
//		Contact contact = new Contact();
//		contact.setContactId(contactId);
//		contact.setDate(Calendar.getInstance().getTime());
//		user1.getListOfFriends().add(contact);
//		user2.getListOfFriends().add(contact);
//	}
//
//	public void deleteAUserFromFriendList (User user1, User user2){
//		user1.getListOfFriends().remove(user2);
//		user2.getListOfFriends().remove(user1);
//	}


}


