package com.OcProject.PayMyBuddy.services;

import java.util.List;
import java.util.Optional;

import com.OcProject.PayMyBuddy.model.Contact;
import com.OcProject.PayMyBuddy.model.ContactId;
import com.OcProject.PayMyBuddy.services.ServiceInterface.IContactServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.repository.ContactRepository;

@Service
public class ContactService implements IContactServices {

	@Autowired
	private ContactRepository contactRepository;


	@Override
	public List<User> findAllContactsByUser(User user) {
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
