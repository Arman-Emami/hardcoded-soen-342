package com.artadvisory.model;

import java.util.ArrayList;
import java.util.List;

public class AuctionHouse {
    private String name;
    private String city;
    private String address;

    // An auction house can host multiple Auctions and Viewings
    private List<Auction> auctions = new ArrayList<>();
    private List<Viewing> viewings = new ArrayList<>();

    // Constructors
    public AuctionHouse() {}

    public AuctionHouse(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Auction> getAuctions() {
        return auctions;
    }

    public List<Viewing> getViewings() {
        return viewings;
    }

    // UML methods
    public void organizeAuction(String auctionName,
                                String expertise,
                                String city,
                                String startDateTime,
                                String endDateTime,
                                boolean isOnline) {
        // TODO implement creating and scheduling an Auction
    }

    public void organizeViewing(String auctionName) {
        // TODO implement
    }
}
