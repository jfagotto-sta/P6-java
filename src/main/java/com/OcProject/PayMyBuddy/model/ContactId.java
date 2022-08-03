package com.OcProject.PayMyBuddy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContactId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "user1")
	private String user1;

	@Column(name = "user2")
	private String user2;

	public ContactId() {
	}

	public ContactId(String mail1, String mail2) {
		this.user1 = mail1;
		this.user2 = mail2;
	}

	public String getUser1() {
		return user1;
	}

	public void setUser1(String user1) {
		this.user1 = user1;
	}

	public String getUser2() {
		return user2;
	}

	public void setUser2(String user2) {
		this.user2 = user2;
	}
}
