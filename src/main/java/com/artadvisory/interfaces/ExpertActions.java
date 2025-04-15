package com.artadvisory.interfaces;

public interface ExpertActions {
    void addAvailability(String weekDay, String startTime, String endTime);

    void removeAvailability(int availabilityID);

    void modifyAvailability(int availabilityID, String newWeekDay, String newStartTime, String newEndTime);

    void addExpertise(String expertiseArea);

    void getAuction();

    void offerAvailability();
}
