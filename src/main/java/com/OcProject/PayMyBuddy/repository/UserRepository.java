package com.OcProject.PayMyBuddy.repository;

import com.OcProject.PayMyBuddy.services.UserService;
import org.apache.log4j.Logger;
import org.slf4j.ILoggerFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.OcProject.PayMyBuddy.model.User;

import java.util.Optional;



@Repository
public class UserRepository implements CrudRepository<User, Integer>{


	private final org.apache.log4j.Logger logger = Logger.getLogger(this.getClass());

	public User findByMail(String email){
		return null;
	}

	@Override
	public User save(User user){
		User existingUser = findByMail(user.getMail());
		if(existingUser != null) {
			logger.info("Mail deja existant");
			return null;
			//throw
		}

		//d'autres verifications
		return save(user);
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
