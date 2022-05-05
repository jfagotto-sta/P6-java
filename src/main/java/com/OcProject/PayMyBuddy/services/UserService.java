package com.OcProject.PayMyBuddy.services;

import com.OcProject.PayMyBuddy.services.ServiceInterface.IUserServices;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService implements IUserServices {

	private final Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private UserRepository userRepo;

	
	public User getUserByMail(String mail) {
		return userRepo.findByMail(mail);
	}

	@Override
	public User save(User user) {
		return userRepo.save(user);
	}

	@Override
	public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
		return null;
	}

	@Override
	public Optional<User> findById(Integer integer) {
		return Optional.empty();
	}

	@Override
	public boolean existsById(Integer integer) {
		return false;
	}

	@Override
	public Iterable<User> findAll() {
		return null;
	}

	@Override
	public Iterable<User> findAllById(Iterable<Integer> integers) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(Integer integer) {

	}

	@Override
	public void delete(User entity) {

	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> integers) {

	}

	@Override
	public void deleteAll(Iterable<? extends User> entities) {

	}

	@Override
	public void deleteAll() {

	}
}
