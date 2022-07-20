package com.OcProject.PayMyBuddy.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.OcProject.PayMyBuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OcProject.PayMyBuddy.model.Contact;
import com.OcProject.PayMyBuddy.model.ContactId;
import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.repository.ContactRepository;

@Service
public class ContactService  {

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private UserRepository userRepo;


	public Iterable<Contact> getContacts() {
		return contactRepository.findAll();
	}

	public Optional<Contact> getContactByPrimaryKey(ContactId contactId) {
		return contactRepository.findById(contactId);
	}

	public Contact addContact(String mail1, String mail2){
		//verifier que les deux mails existent bien dans le systeme
//		User userDemandeur = userRepo.findByMail(mail1);
//		User userAjoutee = userRepo.findByMail(mail2);

//		if(userDemandeur == null || userAjoutee == null) {
//			System.out.println("Erreur pour trouver les users depuis leurs mails");
//			return null;
//		}
		ContactId contactId = new ContactId();
		contactId.setUser1(mail1);
		contactId.setUser2(mail2);
		Contact contact = new Contact();
		contact.setContactId(contactId);
		contact.setDate(new Date());
		return contactRepository.save(contact);
	}

	public void deleteContact (Contact user){
		contactRepository.delete(user);
	}

	public void deleteById(ContactId id){
		contactRepository.deleteById(id);
	}

//	public Iterable<Contact> getById(ContactId id){
//		return contactRepository.findById(id);
//	}
	
	public List<Contact> findByLastNameAndFirstName(String lastName, String firstName) {
		//return contactRepository.findByLastNameAndFirstName(lastName, firstName);
		return null;
	}

}
