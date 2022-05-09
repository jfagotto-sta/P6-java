package com.OcProject.PayMyBuddy.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;


@Access(AccessType.FIELD)
@Entity
@Table(name = "APPUSERS", uniqueConstraints = @UniqueConstraint(name = "mail unique",columnNames = "mail"))
public class User  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAppUser")
	private int userId;

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
//	private List<Contact> listOfFriends;


	public User() {
	}

	public User(int userId, String lastName, String firstName, String mail, String password, double balance) {
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
}
