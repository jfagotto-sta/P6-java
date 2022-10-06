package com.OcProject.PayMyBuddy.model;

import org.springframework.data.jpa.repository.Temporal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Access(AccessType.FIELD)
@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTransaction")
	private int idTransaction;

	@Column(name = "amount", precision = 15, scale = 2, nullable = false)
	private float amount;


	@Column(name = "dateTransaction", nullable = false)
	//@Temporal(TemporalType.DATE)
	private Date dateOfTransaction;

	@ManyToOne
	@JoinColumn(name = "idSender")
	private User sender;

	@ManyToOne
	@JoinColumn(name = "idRecipient")
	private User recipient;

	@Column(name = "fees", precision = 12, scale = 2)
	private double fees;

	public Transaction(int idTransaction, float amount, Date dateOfTransaction, User sender, User recipient,
			double fees) {
		this.idTransaction = idTransaction;
		this.amount = amount;
		this.dateOfTransaction = dateOfTransaction;
		this.sender = sender;
		this.recipient = recipient;
		this.fees = fees;
	}

	public Transaction() {
	}

	public int getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(int idTransaction) {
		this.idTransaction = idTransaction;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getRecipient() {
		return recipient;
	}

	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

}
