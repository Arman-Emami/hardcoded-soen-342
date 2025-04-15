package com.artadvisory;

import com.artadvisory.model.Client;

import java.util.Scanner;

public class UserDashboard {

    public static void show(Client client) {
        if (!client.getAccountStatus().equalsIgnoreCase("Approved")) {
            System.out.println("⚠️ Your account is pending approval. Please wait for an admin to verify your account.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n🎟️ Client Dashboard - Welcome " + client.getName());
            System.out.println("[1] Search Auctions");
            System.out.println("[2] Search Objects of Interest");
            System.out.println("[3] Request a Service");
            System.out.println("[4] Buy an Object of Interest");
            System.out.println("[0] Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> client.searchAuctions();
                case 2 -> client.searchObjects();
                case 3 -> client.requestService();
                case 4 -> client.buyObjectOfInterest();
                case 0 -> {
                    running = false;
                    System.out.println("👋 Logging out...");
                }
                default -> System.out.println("❌ Invalid choice.");
            }
        }
    }
}
