package com.OcProject.PayMyBuddy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OcProject.PayMyBuddy.model.Contact;
import com.OcProject.PayMyBuddy.model.ContactId;
import com.OcProject.PayMyBuddy.repository.ContactRepository;

@Service
public class ContactService  {

	@Autowired
	private ContactRepository contactRepository;



	public Iterable<Contact> getContacts() {
		return contactRepository.findAll();
	}

	public Optional<Contact> getContactByPrimaryKey(ContactId contactId) {
		return contactRepository.findById(contactId);
	}

	public Contact addContact(Contact user){
		return contactRepository.save(user);
	}

	public void deleteContact (Contact user){
		contactRepository.delete(user);
	}

}
