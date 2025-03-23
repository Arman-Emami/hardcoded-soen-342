package com.artadvisory.model;

public class Admin extends User{
    private int adminID;

    // Constructors
    public Admin() {}
    public Admin(int id) {
        this.adminID = id;
    }
    public Admin(String emailAddress, String password) {
        super(emailAddress, password);
    }

    // Getters and Setters
    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
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

