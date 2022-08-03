package com.OcProject.PayMyBuddy.model;

import org.springframework.context.annotation.Primary;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Access(AccessType.FIELD)
@Entity
@Table(name = "appusers", uniqueConstraints = @UniqueConstraint(name = "mail unique",columnNames = "mail"))
public class User  implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@Column(name = "mail", length = 255, nullable = false)
	private String mail;

	@Column(name = "lastname", length = 50, nullable = false)
	private String lastName;

	@Column(name = "firstname", length = 50, nullable = false)
	private String firstName;

	@Column(name = "password", length = 50, nullable = false)
	private String password;

	@Column(name = "balance", precision = 15, scale = 2, nullable = false)
	private Double balance;



//	@ManyToMany(fetch = FetchType.EAGER)
//	private List<Contact> listOfFriends;


	public User() {
	}

	public User(String lastName, String firstName, String mail, String password, double balance) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.mail = mail;
		this.password = password;
		this.balance = balance;
	}

	public User(String mail, String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.mail = mail;
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

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

//	public List<Contact> getListOfFriends() {
//		return listOfFriends;
//	}
//
//	public void setListOfFriends(List<Contact> listOfFriends) {
//		this.listOfFriends = listOfFriends;
//	}
}
