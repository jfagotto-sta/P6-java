package com.OcProject.PayMyBuddy.model;

import java.util.Date;

public class ContactBean {

    private String firstName;
    private String lastName;
    private String Mail;
    private String friendsSince;



    public ContactBean() {
    }

    public ContactBean(String firstName, String lastName, String mail, String friendsSince) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Mail = mail;
        this.friendsSince = friendsSince;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getFriendsSince() {
        return friendsSince;
    }

    public void setFriendsSince(String friendsSince) {
        this.friendsSince = friendsSince;
    }
}
