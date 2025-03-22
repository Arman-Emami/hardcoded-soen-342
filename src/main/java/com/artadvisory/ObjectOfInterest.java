package com.artadvisory;

import java.util.*;
public class ObjectOfInterest {
    private String title;
    private String detailDescription;
    private boolean isOwnedByInstitution;
    private boolean canBeAuctioned;
    private String objectType;
    private static List<ObjectOfInterest> listOfObjects = new ArrayList<>();

    // Constructors
    public ObjectOfInterest() {}

    public ObjectOfInterest(String title, String detailDescription, boolean isOwnedByInstitution,
                            boolean canBeAuctioned, String objectType) {
        this.title = title;
        this.detailDescription = detailDescription;
        this.isOwnedByInstitution = isOwnedByInstitution;
        this.canBeAuctioned = canBeAuctioned;
        this.objectType = objectType;
        listOfObjects.add(this);

    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public boolean isOwnedByInstitution() {
        return isOwnedByInstitution;
    }

    public void setOwnedByInstitution(boolean ownedByInstitution) {
        isOwnedByInstitution = ownedByInstitution;
    }

    public boolean isCanBeAuctioned() {
        return canBeAuctioned;
    }

    public void setCanBeAuctioned(boolean canBeAuctioned) {
        this.canBeAuctioned = canBeAuctioned;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public static List<ObjectOfInterest> getListOfObjects() {
        return listOfObjects;
    }

    // UML method
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Description: " + detailDescription);
        System.out.println("Owned by Institution: " + isOwnedByInstitution);
        System.out.println("Can be Auctioned: " + canBeAuctioned);
        System.out.println("Object Type: " + objectType);
    }
}
