package com.OcProject.PayMyBuddy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.OcProject.PayMyBuddy.model.Contact;
import com.OcProject.PayMyBuddy.model.ContactId;
import com.OcProject.PayMyBuddy.model.User;

@Repository
public class ContactRepository implements CrudRepository<Contact, ContactId>{

	public List<User> findAllContactsByUser(User user){
		return null;
	}

	@Override
	public <S extends Contact> S save(S entity) {
		return null;
	}

	@Override
	public <S extends Contact> Iterable<S> saveAll(Iterable<S> entities) {
		return null;
	}

	@Override
	public Optional<Contact> findById(ContactId contactId) {
		return Optional.empty();
	}

	@Override
	public boolean existsById(ContactId contactId) {
		return false;
	}

	@Override
	public Iterable<Contact> findAll() {
		return null;
	}

	@Override
	public Iterable<Contact> findAllById(Iterable<ContactId> contactIds) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(ContactId contactId) {

	}

	@Override
	public void delete(Contact entity) {

	}

	@Override
	public void deleteAllById(Iterable<? extends ContactId> contactIds) {

	}

	@Override
	public void deleteAll(Iterable<? extends Contact> entities) {

	}

	@Override
	public void deleteAll() {

	}
}
