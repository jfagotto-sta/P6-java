package com.OcProject.PayMyBuddy.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "APPUSERS")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAppUser")
	private long userId;

	@Column(name = "lastName", length = 50, nullable = false)
	private String lastName;

	@Column(name = "firstName", length = 50, nullable = false)
	private String firstName;

	@Column(name = "mail", length = 100, nullable = false)
	private String mail;

	@Column(name = "password", length = 20, nullable = false)
	private String password;

	@Column(name = "balance", precision = 15, scale = 2, nullable = false)
	private double balance;

//	@ManyToMany(fetch = FetchType.EAGER)
//	private List<User> listOfFriends;

	public User() {

	}

	public User(int userId, String lastName, String firstName, String mail, String password, double balance) {
		super();
		this.userId = userId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.mail = mail;
		this.password = password;
		this.balance = balance;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, firstName, lastName, mail, password, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(mail, other.mail) && Objects.equals(password, other.password)
				&& userId == other.userId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", lastName=" + lastName + ", firstName=" + firstName + ", mail=" + mail
				+ ", password=" + password + ", balance=" + balance + "]";
	}

}
