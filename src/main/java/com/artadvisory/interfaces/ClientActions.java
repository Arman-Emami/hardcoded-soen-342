package com.artadvisory.interfaces;

public interface ClientActions {

        void signUp(String emailAddress, String phoneNumber, String name, String password, String affiliation, String intent);

        void login();

        void searchObjects();

        void searchAuctions();

        void requestService();

        void buyObjectOfInterest();
}
