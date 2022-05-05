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
	private User user1;

	@Column(name = "user2")
	private User user2;

	public ContactId(User user1, User user2) {
		super();
		this.user1 = user1;
		this.user2 = user2;
	}

	public ContactId() {
	}

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return user2;
	}

	public void setUser2(User user2) {
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
