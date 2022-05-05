package com.OcProject.PayMyBuddy.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contacts")
public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ContactId contactId;

	@Column(name = "dateAction")
	private Date date;

	public Contact(ContactId contactId, Date date) {
		super();
		this.contactId = contactId;
		this.date = date;
	}

	public Contact() {
	}

	public ContactId getContactId() {
		return contactId;
	}

	public void setContactId(ContactId contactId) {
		this.contactId = contactId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contactId, date);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(contactId, other.contactId) && Objects.equals(date, other.date);
	}

}
