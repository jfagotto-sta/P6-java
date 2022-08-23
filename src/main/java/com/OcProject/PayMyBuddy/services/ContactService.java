package com.OcProject.PayMyBuddy.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.OcProject.PayMyBuddy.model.ContactBean;
import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OcProject.PayMyBuddy.model.Contact;
import com.OcProject.PayMyBuddy.model.ContactId;
import com.OcProject.PayMyBuddy.repository.ContactRepository;

@Service
public class ContactService  {

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private UserRepository userRepo;

	public SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");


	public Iterable<Contact> getContacts() {
		return contactRepository.findAll();
	}

	public Optional<Contact> getContactByPrimaryKey(ContactId contactId) {
		return contactRepository.findById(contactId);
	}

	public Contact addContact(String mail1, String mail2) throws Exception {
		//verifier que les deux mails existent bien dans le systeme
//		User userDemandeur = userRepo.findByMail(mail1);
//		User userAjoutee = userRepo.findByMail(mail2);

//		if(userDemandeur == null || userAjoutee == null) {
//			System.out.println("Erreur pour trouver les users depuis leurs mails");
//			return null;
//		}

		if(contactExistAlready(mail1,mail2)) {
			throw new Exception("Contact exist already");
		}

		ContactId contactId = new ContactId();
		contactId.setUser1(mail1);
		contactId.setUser2(mail2);
		Contact contact = new Contact();
		contact.setContactId(contactId);
		contact.setDate(new Date());
		return contactRepository.save(contact);
	}

	public boolean contactExistAlready(String mail1, String mail2) {
		Contact c = contactRepository.findContactsFromMails(mail1, mail2);
		return c != null;
	}

	public void deleteContact (Contact user){
		contactRepository.delete(user);
	}

	public boolean deleteById(ContactId id){
		contactRepository.deleteById(id);
		return true;
	}


	
	public List<Contact> findByLastNameAndFirstName(String lastName, String firstName) {
		//return contactRepository.findByLastNameAndFirstName(lastName, firstName);
		return null;
	}

	public Optional<Contact> getById(ContactId id) {
		return contactRepository.findById(id);
	}

	public List<ContactBean> findFriends(String mail){

		List<Contact> contacts = contactRepository.findContactsAttachedToThisMail(mail);
		List<ContactBean> contactsBean = new ArrayList<>();
		for (Contact c : contacts) {
			ContactBean cb = new ContactBean();
			cb.setFriendsSince(sdf.format(c.getDate()));
			String mailOfMyFriend = c.getContactId().getUser1();
			if(mailOfMyFriend.equals(mail)) {
				mailOfMyFriend = c.getContactId().getUser2();
			}
			User user = userRepo.findByMail(mailOfMyFriend);
			cb.setFirstName(user.getFirstName());
			cb.setLastName(user.getLastName());
			cb.setMail(user.getMail());
			contactsBean.add(cb);
		}
		return contactsBean;
	}



}
