package com.OcProject.PayMyBuddy.model;

public class TransactionBean {

    private String mail1;
    private String mail2;
    private float amount;

    public TransactionBean(String mail1, String mail2, float amount) {
        this.mail1 = mail1;
        this.mail2 = mail2;
        this.amount = amount;
    }

    public TransactionBean() {
    }

    public String getMail1() {
        return mail1;
    }

    public void setMail1(String mail1) {
        this.mail1 = mail1;
    }

    public String getMail2() {
        return mail2;
    }

    public void setMail2(String mail2) {
        this.mail2 = mail2;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
