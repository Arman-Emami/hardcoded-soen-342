package com.artadvisory.model;

import java.util.ArrayList;
import java.util.List;

public class Institution {
    private String name;
    private String address;

    // According to the diagram, an Institution can have many Experts
    private List<Expert> experts = new ArrayList<>();

    // Constructors
    public Institution() {}

    public Institution(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Expert> getExperts() {
        return experts;
    }

    // UML method
    public void buyObjectOfInterest(String objectName, double price,
                                    String city, String startDateTime,
                                    String endDateTime, String auctionType) {
        // TODO implement buying logic
    }
}
