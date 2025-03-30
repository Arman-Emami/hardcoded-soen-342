package com.artadvisory;

import com.artadvisory.db.DatabaseInitializer;
import com.artadvisory.dao.*;
import com.artadvisory.model.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        DatabaseInitializer.createClientTable();

        ClientDAO clientDAO = new ClientDAO();

        Client c = new Client("example09@mail.com", "123-456-7890", "John Doe", "pass123",
                "Private Collector", "Interested in Islamic Art");
        clientDAO.insertClient(c);

        List<Client> clients = clientDAO.getAllClients();
        for (Client client : clients) {
            System.out.println(client);
        }

//        Scanner keyIn = new Scanner(System.in);
//
//        Admin admin = new Admin("admin@gmail.com", "admin");
//        Expert expert = new Expert("expert@gmail.com", "expert");
//        Clients client = new Clients("client@gmail.com", "client");
//
//        boolean continuation = true;
//
//        while (continuation){
//            System.out.println("Welcome to the system! Please select your role to continue.");
//            System.out.println("1. Admin");
//            System.out.println("2. Expert");
//            System.out.println("3. Client");
//            int selectedRole = keyIn.nextInt();
//
//            System.out.println("Enter your username: ");
//            String enteredUsername = keyIn.next();
//
//            System.out.println("Enter your password: ");
//            String enteredPassword = keyIn.next();
//
//            switch(selectedRole) {
//                case(1): {
//                    if (!(admin.checkUsername(enteredUsername) &&
//                            admin.checkPassword(enteredPassword))) {
//                        System.out.println("Invalid username or password entered," +
//                                "exiting system.");
//                        System.exit(0);
//                    }
//                    //rest of the code
//                    System.out.println("Select an option:");
//                    System.out.println("1. Add object of interest.");
//                    int adminSelectedAction = keyIn.nextInt();
//                    if (adminSelectedAction == 1){
//                        System.out.println("Enter the title of the object:");
//                        String objectTitle = keyIn.next();
//
//                        System.out.println("Enter the description of the object:");
//                        String objectDescription = keyIn.next();
//
//                        System.out.println("Is the object owned by the institution?");
//                        boolean isOwned = keyIn.nextBoolean();
//
//                        System.out.println("Can the object be auctioned?");
//                        boolean isAuctioned = keyIn.nextBoolean();
//
//                        System.out.println("Enter the type of the object:");
//                        String objectType = keyIn.next();
//
//                        ObjectOfInterest o1 = new ObjectOfInterest(objectTitle, objectDescription, isOwned, isAuctioned, objectType);
//                        System.out.println("Object successfully added.");
//                    }
//                    System.out.println("Wish to continue?");
//                    String doContinue = keyIn.next();
//                    if (doContinue.equals("yes")){
//                        System.out.println("Continuing");
//                    }
//                    else {
//                        continuation = false;
//                    }
//                    break;
//                }
//                case(2): {
//                    if (!(expert.checkUsername(enteredUsername) &&
//                            expert.checkPassword(enteredPassword))) {
//                        System.out.println("Invalid username or password entered," +
//                                "exiting system.");
//                        System.exit(0);
//                    }
//                    //rest of the code
//                    System.out.println("Select an option:");
//                    System.out.println("1.View objects of interests.");
//                    int expertSelectedOption = keyIn.nextInt();
//                    if (expertSelectedOption == 1){
//                        System.out.println("List of ObjectOfInterest instances:");
//                        for (ObjectOfInterest obj : ObjectOfInterest.getListOfObjects()) {
//                            obj.displayInfo();
//                            System.out.println("-------------------");
//                        }
//                    }
//                    System.out.println("Wish to continue?");
//                    String doContinue = keyIn.next();
//                    if (doContinue.equals("yes")){
//                        System.out.println("Continuing");
//                    }
//                    else {
//                        continuation = false;
//                    }
//                    break;
//                }
//                case(3): {
//                    if (!(client.checkUsername(enteredUsername) &&
//                            client.checkPassword(enteredPassword))) {
//                        System.out.println("Invalid username or password entered," +
//                                "exiting system.");
//                        System.exit(0);
//                    }
//                    //rest of the code
//                    System.out.println("Select an option:");
//                    System.out.println("1.View objects of interests.");
//                    int expertSelectedOption = keyIn.nextInt();
//                    if (expertSelectedOption == 1){
//                        System.out.println("List of ObjectOfInterest instances:");
//                        for (ObjectOfInterest obj : ObjectOfInterest.getListOfObjects()) {
//                            obj.displayInfo();
//                            System.out.println("-------------------");
//                        }
//                    }
//                    System.out.println("Wish to continue?");
//                    String doContinue = keyIn.next();
//                    if (doContinue.equals("yes")){
//                        System.out.println("Continuing");
//                    }
//                    else {
//                        continuation = false;
//                    }
//                    break;
//                }
//            }
//        }

    }
}