package com.OcProject.PayMyBuddy.model;

public class Bank {

    private int bankID;
    private String bankName;

    public Bank(int bankID, String bankName) {
        this.bankID = bankID;
        this.bankName = bankName;
    }

    public Bank() {
    }

    public int getBankID() {
        return bankID;
    }

    public void setBankID(int bankID) {
        this.bankID = bankID;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
