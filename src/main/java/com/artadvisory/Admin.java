package com.artadvisory;

public class Admin extends User{
    private int id;

    // Constructors
    public Admin() {}
    public Admin(int id) {
        this.id = id;
    }
    public Admin(String emailAddress, String password) {
        super(emailAddress, password);
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Methods per UML
    public void updateClientInfo() {
        // TODO implement
    }

    public void addObjectOfInterest() {
        // TODO implement
    }

    public void updateObjectOfInterest() {
        // TODO implement
    }

    public void addExpertAccount(String name, int licenseNumber, String contactInfo, String expertiseArea) {
        // TODO implement
    }

    public void deleteUser() {
        // TODO implement
    }

    public void approveClient() {
        // TODO implement
    }

    public void updateUser() {
        // TODO implement
    }

    public void addExpertAvailability() {
        // TODO implement
    }
}

