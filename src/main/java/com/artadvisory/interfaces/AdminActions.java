package com.artadvisory.interfaces;

public interface AdminActions {

    void updateClientInfo(String email, String name, String phone);

    void approveClient(int clientID);

    void rejectClient(int clientID);

    void addObjectOfInterest(int auctionID, String title, String description,
                             boolean isOwnedByInstitution, boolean canBeAuctioned, String objectType);

    void updateObjectOfInterest(int objectID, String title, String description,
                                boolean isOwnedByInstitution, boolean canBeAuctioned, String objectType);

    void addExpertAccount(String email, String password, String name, String licenseNumber, String contactInfo, String expertiseArea);

    void addExpertAvailability(int expertID, String weekDay, String startTime, String endTime, String availabilityType);

    void deleteUser(String userType, String email); // e.g., "Client", "Expert"

    void updateExpertInfo(String email, String name, String phone);
}
