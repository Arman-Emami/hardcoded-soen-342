package com.artadvisory.model;

public class Client extends User {
    private int clientID;
    private String affiliation;
    private String intent;
    private String accountStatus;

    // A client can have multiple service requests or attend multiple auctions, etc.
    //private List<ServiceRequest> serviceRequests = new ArrayList<>();
    //private List<Auction> attendedAuctions = new ArrayList<>();

    // Constructors
    public Client() {
        super();
    }
    public Client(String emailAddress, String password) {
        super(emailAddress, password);
    }

    // Without account status specified (Default = pending by database)
    public Client(String emailAddress, String phoneNumber, String name, String password,
                  String affiliation, String intent) {
        super(emailAddress, phoneNumber, name, password);
        this.affiliation = affiliation;
        this.intent = intent;
    }

    public Client(int clientID, String emailAddress, String phoneNumber, String name, String password,
                  String affiliation, String intent, String accountStatus) {
        super(emailAddress, phoneNumber, name, password);
        this.clientID = clientID;
        this.affiliation = affiliation;
        this.intent = intent;
        this.accountStatus = accountStatus;
    }

    // Getters and Setters
    public int getClientID() {
        return clientID;
    }
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

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

    public String getAccountStatus() {
        return accountStatus;
    }
    public void setAccountStatus(String intent) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return ("🙎Client ID: " + this.clientID + '\t'
                + "📧Email: " + this.emailAddress + '\t'
                + "Name: " + this.name + '\t'
                + "Account Status: " + this.accountStatus + '\t'
                + "Phone Number: " + this.phoneNumber + '\t'
                + "Password: " + this.password + '\t'
                + "Affiliation: " + this.affiliation + '\t'
                + "Intent: " + this.intent + '\t'
        );
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
