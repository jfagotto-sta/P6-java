package com.OcProject.PayMyBuddy.model;

import java.io.Serializable;
import java.util.Objects;

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

	public ContactId(String user1, String user2) {
		super();
		this.user1 = user1;
		this.user2 = user2;
	}

	public ContactId() {
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

	@Override
	public int hashCode() {
		return Objects.hash(user1, user2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactId other = (ContactId) obj;
		return Objects.equals(user1, other.user1) && Objects.equals(user2, other.user2);
	}

}
