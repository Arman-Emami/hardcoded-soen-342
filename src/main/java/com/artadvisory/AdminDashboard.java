package com.artadvisory;

import com.artadvisory.model.*;
import com.artadvisory.dao.*;

import java.util.List;
import java.util.Scanner;

public class AdminDashboard {

    public static void show(Admin admin) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n🛠️ Admin Dashboard");
            System.out.println("[1] Approve Clients");
            System.out.println("[2] Add Object of Interest");
            System.out.println("[3] Update Expert Info");
            System.out.println("[4] Create Expert Account");
            System.out.println("[5] Delete User");
            System.out.println("[6] Update Object of Interest");
            System.out.println("[0] Logout");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    ClientDAO clientDAO = new ClientDAO();
                    List<Client> pendingClients = clientDAO.getAllPendingClients();

                    if (pendingClients.isEmpty()) {
                        System.out.println("✅ No pending clients at the moment.");
                        break;
                    }

                    System.out.println("\n📋 Pending Clients:");
                    for (Client c : pendingClients) {
                        System.out.println("ID: " + c.getClientID() +
                                " | Name: " + c.getName() +
                                " | Email: " + c.getEmailAddress() +
                                " | Status: " + c.getAccountStatus());
                    }

                    System.out.print("\nEnter the ID of the client to approve (or 0 to cancel): ");
                    int clientID = scanner.nextInt();
                    scanner.nextLine();

                    if (clientID != 0) {
                        admin.approveClient(clientID);
                        System.out.println("✅ Client with ID " + clientID + " has been approved.");
                    } else {
                        System.out.println("❌ Operation cancelled.");
                    }
                }
                case 2 -> {
                    System.out.println("\n➕ Add Object of Interest");

                    System.out.print("Auction ID (must already exist): ");
                    int auctionID = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Detailed Description: ");
                    String description = scanner.nextLine();

                    System.out.print("Owned by Institution? (true/false): ");
                    boolean isOwned = scanner.nextBoolean();

                    System.out.print("Can Be Auctioned? (true/false): ");
                    boolean canBeAuctioned = scanner.nextBoolean();
                    scanner.nextLine(); // consume newline

                    System.out.print("Object Type (e.g., Painting, Sculpture): ");
                    String objectType = scanner.nextLine();

                    admin.addObjectOfInterest(auctionID, title, description, isOwned, canBeAuctioned, objectType);
                }
                case 3 -> {
                    System.out.println("\n✏️ Update Expert Info");

                    System.out.print("Enter Expert's Email: ");
                    String email = scanner.nextLine();

                    System.out.print("New Name: ");
                    String name = scanner.nextLine();

                    System.out.print("New Phone Number: ");
                    String phone = scanner.nextLine();

                    admin.updateExpertInfo(email, name, phone);
                    System.out.println("✅ Expert info updated successfully.");
                }
                case 4 -> {
                    System.out.println("\n👨‍🏫 Create Expert Account");

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Password: ");
                    String password = scanner.nextLine();

                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("License Number: ");
                    int licenseNumber = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Phone Number: ");
                    String phone = scanner.nextLine();

                    System.out.print("Expertise Area: ");
                    String expertiseArea = scanner.nextLine();

                    admin.addExpertAccount(email, password, name, licenseNumber, phone, expertiseArea);
                }
                case 5 -> {
                    System.out.println("\n🗑️ Delete User");

                    System.out.print("Enter user type (Client / Expert): ");
                    String userType = scanner.nextLine();

                    System.out.print("Enter email of the user to delete: ");
                    String email = scanner.nextLine();

                    admin.deleteUser(userType, email);
                }
                case 6 -> {
                    System.out.println("\n✏️ Update Object of Interest");

                    System.out.print("Enter Object ID to update: ");
                    int objectID = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    System.out.print("New Title: ");
                    String title = scanner.nextLine();

                    System.out.print("New Detailed Description: ");
                    String description = scanner.nextLine();

                    System.out.print("Owned by Institution? (true/false): ");
                    boolean isOwned = scanner.nextBoolean();

                    System.out.print("Can Be Auctioned? (true/false): ");
                    boolean canBeAuctioned = scanner.nextBoolean();
                    scanner.nextLine();

                    System.out.print("New Object Type: ");
                    String objectType = scanner.nextLine();

                    admin.updateObjectOfInterest(objectID, title, description, isOwned, canBeAuctioned, objectType);
                    System.out.println("✅ Object of Interest updated.");
                }

                case 0 -> {
                    running = false;
                    System.out.println("👋 Logging out...");
                }
                default -> System.out.println("❌ Invalid option.");
            }
        }
    }
}
