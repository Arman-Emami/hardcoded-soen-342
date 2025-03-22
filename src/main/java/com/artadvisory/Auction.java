package com.artadvisory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Auction {
    private String name;
    private String expertise;
    private Date startDateTime;
    private Date endDateTime;
    private String startTime; // or use a more precise type
    private String endTime;   // or use a more precise type
    private String auctionType;
    private boolean isOnline;

    // An Auction can contain many ObjectsOfInterest
    private List<ObjectOfInterest> objects = new ArrayList<>();

    // Constructors
    public Auction() {}

    public Auction(String name, String expertise, Date startDateTime, Date endDateTime,
                   String startTime, String endTime, String auctionType, boolean isOnline) {
        this.name = name;
        this.expertise = expertise;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.auctionType = auctionType;
        this.isOnline = isOnline;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAuctionType() {
        return auctionType;
    }

    public void setAuctionType(String auctionType) {
        this.auctionType = auctionType;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public List<ObjectOfInterest> getObjects() {
        return objects;
    }

    // You can add methods to add/remove objects
    public void addObjectOfInterest(ObjectOfInterest obj) {
        objects.add(obj);
    }
}
