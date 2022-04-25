package com.OcProject.PayMyBuddy.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTIONS")
public class Transaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTransaction")
	private long transactionID;

	@Column(name = "amount", precision = 15, scale = 2, nullable = false)
	private long amount;

	@Column(name = "date", nullable = false)
	private Date dateOfTransaction;

	@ManyToOne
	@JoinColumn(name = "idSender")
	private User sender;

	@ManyToOne
	@JoinColumn(name = "idRecipient")
	private User recipient;

	@Column(name = "fees", precision = 12, scale = 2)
	private double fees;

	public Transaction(long transactionID, long amount, Date dateOfTransaction, User sender, User recipient,
			double fees) {
		this.transactionID = transactionID;
		this.amount = amount;
		this.dateOfTransaction = dateOfTransaction;
		this.sender = sender;
		this.recipient = recipient;
		this.fees = fees;
	}

	public long getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
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
