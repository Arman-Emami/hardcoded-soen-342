package com.artadvisory.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Auction {
    private int auctionID;
    private String name;
    private String auctionSpeciality;
    private String weekday;
    public String date;
    private String startTime; // or use a more precise type
    private String endTime;   // or use a more precise type
    private String auctionType;
    private String timezone;

    public Auction(int auctionID, String name, String auctionSpeciality, String weekday, String date, String startTime, String endTime, String auctionType, String timezone, boolean isOnline) {
        this.auctionID = auctionID;
        this.name = name;
        this.auctionSpeciality = auctionSpeciality;
        this.weekday = weekday;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.auctionType = auctionType;
        this.timezone = timezone;
        this.isOnline = isOnline;
    }

    public int getAuctionID() {
        return auctionID;
    }

    public void setAuctionID(int auctionID) {
        this.auctionID = auctionID;
    }

    private boolean isOnline;

    // An Auction can contain many ObjectsOfInterest
    private List<ObjectOfInterest> objects = new ArrayList<>();

    // Constructors
    public Auction() {}

    public Auction(String name, String auctionSpeciality, String weekday, String date,
                   String startTime, String endTime, String auctionType, String timezone, boolean isOnline) {
        this.name = name;
        this.auctionSpeciality = auctionSpeciality;
        this.weekday = weekday;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.auctionType = auctionType;
        this.timezone = timezone;
        this.isOnline = isOnline;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getauctionSpeciality() {
        return auctionSpeciality;
    }

    public void setauctionSpeciality(String auctionSpeciality) {
        this.auctionSpeciality = auctionSpeciality;
    }


    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
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
