package com.artadvisory.model;

public class Clients extends User {
    private String affiliation;
    private String intent;

    // A client can have multiple service requests or attend multiple auctions, etc.
    //private List<ServiceRequest> serviceRequests = new ArrayList<>();
    //private List<Auction> attendedAuctions = new ArrayList<>();

    // Constructors
    public Clients() {
        super();
    }
    public Clients(String emailAddress, String password) {
        super(emailAddress, password);
    }

    public Clients(String emailAddress, String phoneNumber, String name, String password,
                   String affiliation, String intent) {
        super(emailAddress, phoneNumber, name, password);
        this.affiliation = affiliation;
        this.intent = intent;
    }

    // Getters and Setters
    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    //public List<ServiceRequest> getServiceRequests() {
    //    return serviceRequests;
    //}

    //public List<Auction> getAttendedAuctions() {
    //    return attendedAuctions;
    //}

    // UML methods
    public void signUp(String emailAddress, String password, String affiliation, String phoneNumber, String intent) {
        // TODO implement sign up logic
    }

    public void search() {
        // TODO implement search
    }

    public void requestService() {
        // TODO implement
    }

    public void buyObjectOfInterest() {
        // TODO implement
    }
}
