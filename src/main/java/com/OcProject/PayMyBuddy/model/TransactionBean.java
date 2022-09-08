package com.OcProject.PayMyBuddy.model;

public class TransactionBean {

    private String sender;
    private String recipient;
    private float amount;
    private double fees;

    public TransactionBean(String mail1, String mail2, float amount) {
        this.sender = mail1;
        this.recipient = mail2;
        this.amount = amount;
    }

    public TransactionBean() {
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public float getAmount() {
        return amount;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
