package com.OcProject.PayMyBuddy.model;

public class User {
  private int userId;
  private String lastName;
  private String firstName;
  private String birthDate;


    public User(int userId, String lastName, String firstName, String birthDate) {
        this.userId = userId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
    }

    public User() {

    }

    public int getUserId() {
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
