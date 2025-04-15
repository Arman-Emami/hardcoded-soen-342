package com.artadvisory.model;

import com.artadvisory.interfaces.AdminActions;
import com.artadvisory.dao.*;

public class Admin extends User implements AdminActions {
    private int adminID;

    // Constructors
    public Admin() {}
    public Admin(int id) {
        this.adminID = id;
    }
    public Admin(String emailAddress, String password) {
        super(emailAddress, password);
    }
    public Admin(String emailAddress, String phoneNumber, String name, String password) {
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.password = password;
    }
    public Admin(int adminID, String emailAddress, String phoneNumber, String name, String password) {
        this.adminID = adminID;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.password = password;
    }

    // Getters and Setters
    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }


    @Override
    public void updateClientInfo(String email, String name, String phone) {
        ClientDAO dao = new ClientDAO();
        dao.updateClientInfo(email, name, phone);
    }

    @Override
    public void approveClient(int clientID) {
        ClientDAO dao = new ClientDAO();
        dao.updateAccountStatus(clientID, "Approved");
    }

    @Override
    public void rejectClient(int clientID) {
        ClientDAO dao = new ClientDAO();
        dao.updateAccountStatus(clientID, "Rejected");
    }

    @Override
    public void addObjectOfInterest(int auctionID, String title, String description,
                                    boolean isOwnedByInstitution, boolean canBeAuctioned, String objectType) {
        ObjectOfInterest obj = new ObjectOfInterest(auctionID, title, description, isOwnedByInstitution, canBeAuctioned, objectType);
        ObjectOfInterestDAO dao = new ObjectOfInterestDAO();
        dao.insertObject(obj);
    }

    @Override
    public void updateObjectOfInterest(int objectID, String title, String description,
                                       boolean isOwnedByInstitution, boolean canBeAuctioned, String objectType) {
        ObjectOfInterestDAO dao = new ObjectOfInterestDAO();
        dao.updateObject(objectID, title, description, isOwnedByInstitution, canBeAuctioned, objectType);
    }

    @Override
    public void addExpertAccount(String email, String password, String name, int licenseNumber, String contactInfo, String expertiseArea) {
        Expert expert = new Expert(email, contactInfo, name, password, licenseNumber, expertiseArea);
        ExpertDAO dao = new ExpertDAO();
        dao.insertExpert(expert);
    }

    @Override
    public void addExpertAvailability(int expertID, String weekDay, String startTime, String endTime, String availabilityType) {
        AvailabilityDAO dao = new AvailabilityDAO();
        dao.insertAvailability(expertID, weekDay, startTime, endTime, availabilityType);
    }

    @Override
    public void deleteUser(String userType, String email) {
        switch (userType.toLowerCase()) {
            case "client" -> new ClientDAO().deleteClientByEmail(email);
            case "expert" -> new ExpertDAO().deleteExpertByEmail(email);
            default -> System.out.println("❌ Unknown user type: " + userType);
        }
    }

    @Override
    public void updateExpertInfo(String email, String name, String phone) {
        ExpertDAO dao = new ExpertDAO();
        dao.updateExpertInfo(email, name, phone);
    }
}

