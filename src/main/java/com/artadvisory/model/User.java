package com.artadvisory.model;

import java.util.Objects;

abstract class User {
    protected String emailAddress;
    protected String phoneNumber;
    protected String name;
    protected String password;

    // Constructors
    public User() {}

    public User(String emailAddress, String phoneNumber, String name, String password) {
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.password = password;
    }
    public User(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public boolean checkUsername(String s) {
        return (Objects.equals(s, this.getEmailAddress()));
    }
    public boolean checkPassword(String s) {
        return (Objects.equals(s, this.getPassword()));
    }

    // Getters and Setters
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
