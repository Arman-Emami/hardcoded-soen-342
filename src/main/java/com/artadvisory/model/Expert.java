package com.artadvisory.model;

import com.artadvisory.dao.AvailabilityDAO;
import com.artadvisory.dao.ExpertDAO;
import com.artadvisory.interfaces.ExpertActions;

import java.util.ArrayList;
import java.util.List;

public class Expert extends User implements ExpertActions {
    private int expertID;
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



    @Override
    public void addAvailability(String weekDay, String startTime, String endTime) {
        new AvailabilityDAO().insertAvailability(expertID, weekDay, startTime, endTime, "Regular");
    }

    @Override
    public void removeAvailability(int availabilityID) {
        new AvailabilityDAO().deleteAvailability(availabilityID);
    }

    @Override
    public void modifyAvailability(int availabilityID, String newWeekDay, String newStartTime, String newEndTime) {
        new AvailabilityDAO().updateAvailability(availabilityID, newWeekDay, newStartTime, newEndTime);
    }

    @Override
    public void addExpertise(String newExpertise) {
        this.expertiseArea = newExpertise;
        new ExpertDAO().updateExpertise(this.expertID, newExpertise);
    }

    @Override
    public void offerAvailability() {
        new AvailabilityDAO().printExpertAvailability(expertID);
    }

    @Override
    public void getAuction() {
        System.out.println("🔍 This feature (getAuction) is not yet implemented.");
    }
}

