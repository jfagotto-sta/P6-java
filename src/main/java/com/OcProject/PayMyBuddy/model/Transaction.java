package com.OcProject.PayMyBuddy.model;

public class Transaction {

    private int transactionID;
    private int amount;
    private String dateOfTransaction;
    private String senderID;
    private String recipientID;
    private String senderIBAN;
    private String recipientIBAN;
    private int commissionAmount;

    public Transaction(int transactionID, int amount, String dateOfTransaction, String senderID, String recipientID, String senderIBAN, String recipientIBAN, int commissionAmount) {
        this.transactionID = transactionID;
        this.amount = amount;
        this.dateOfTransaction = dateOfTransaction;
        this.senderID = senderID;
        this.recipientID = recipientID;
        this.senderIBAN = senderIBAN;
        this.recipientIBAN = recipientIBAN;
        this.commissionAmount = commissionAmount;
    }

    public Transaction() {

    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(String dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public String getRecipientID() {
        return recipientID;
    }

    public void setRecipientID(String recipientID) {
        this.recipientID = recipientID;
    }

    public String getSenderIBAN() {
        return senderIBAN;
    }

    public void setSenderIBAN(String senderIBAN) {
        this.senderIBAN = senderIBAN;
    }

    public String getRecipientIBAN() {
        return recipientIBAN;
    }

    public void setRecipientIBAN(String recipientIBAN) {
        this.recipientIBAN = recipientIBAN;
    }

    public int getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(int commissionAmount) {
        this.commissionAmount = commissionAmount;
    }
}
