package com.artadvisory;

import com.artadvisory.model.Client;

import java.util.Scanner;

public class UserDashboard {

    public static void show(Client client) {
        if (!client.getAccountStatus().equalsIgnoreCase("Approved")) {
            System.out.println("⚠️ Your account is pending approval. Please wait for an admin to verify it.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n👤 Client Dashboard");
            System.out.println("[1] Search Auctions");
            System.out.println("[2] Search Objects of Interest");
            System.out.println("[3] Request a Service");
            System.out.println("[4] Buy an Object");
            System.out.println("[0] Logout");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> System.out.println("🔍 Searching auctions...");
                case 2 -> System.out.println("🔍 Searching objects of interest...");
                case 3 -> System.out.println("📄 Requesting service...");
                case 4 -> System.out.println("💳 Buying object...");
                case 0 -> {
                    running = false;
                    System.out.println("👋 Logging out...");
                }
                default -> System.out.println("❌ Invalid option.");
            }
        }
    }
}
