package com.artadvisory.model;

import java.util.ArrayList;
import java.util.List;

public class Expert extends User {
    private int licenseNumber;
    private String expertiseArea;
    // Each Expert can have multiple Availability entries
    private List<Availability> availabilityList = new ArrayList<>();

    // Possibly link back to the Institution if needed
    private Institution institution;

    // Constructors
    public Expert() {}
    public Expert(String emailAddress, String password) {
        super(emailAddress, password);
    }

    public Expert(int licenseNumber, String expertiseArea) {
        this.licenseNumber = licenseNumber;
        this.expertiseArea = expertiseArea;
    }

    public Expert(String email, String contactInfo, String name, String password, int licenseNumber, String expertiseArea) {
        this.emailAddress = email;
        this.phoneNumber = contactInfo;
        this.name = name;
        this.password = password;
        this.licenseNumber = licenseNumber;
        this.expertiseArea = expertiseArea;
    }

    public Expert(int expertID, String emailAddress, String phoneNumber, String name, String password, int licenseNumber, String expertiseArea, String availability) {
    }

    // Getters and Setters
    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getExpertiseArea() {
        return expertiseArea;
    }

    public void setExpertiseArea(String expertiseArea) {
        this.expertiseArea = expertiseArea;
    }

    public List<Availability> getAvailabilityList() {
        return availabilityList;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    // UML methods
    public void login() {
        // TODO implement
    }

    public void addAvailability(String weekDayAvailable, String startTime, String endTime) {
        Availability newAvail = new Availability(weekDayAvailable, startTime, endTime);
        availabilityList.add(newAvail);
    }

    public void addExpertise(String newArea) {
        // Possibly just set expertiseArea, or store multiple expertise areas
        this.expertiseArea = newArea;
    }

    public void getAuction() {
        // TODO implement retrieving auctions the expert is involved in
    }

    public void offerAvailability() {
        // TODO implement
    }

    public void modifyAvailability() {
        // TODO implement
    }
}

