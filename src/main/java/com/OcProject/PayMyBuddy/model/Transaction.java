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
@Table(name = "transactions")
public class Transaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTransaction")
	private Long idTransaction;

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

	public Transaction(Long idTransaction, long amount, Date dateOfTransaction, User sender, User recipient,
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

	public Long getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(Long idTransaction) {
		this.idTransaction = idTransaction;
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
