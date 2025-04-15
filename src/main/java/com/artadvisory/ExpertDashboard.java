package com.artadvisory;

import com.artadvisory.model.Expert;

import java.util.Scanner;

public class ExpertDashboard {

    public static void show(Expert expert) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n🧠 Expert Dashboard");
            System.out.println("[1] View Service Requests");
            System.out.println("[2] Update Availability");
            System.out.println("[0] Logout");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> System.out.println("📋 Viewing service requests...");
                case 2 -> System.out.println("📅 Updating availability...");
                case 0 -> {
                    running = false;
                    System.out.println("👋 Logging out...");
                }
                default -> System.out.println("❌ Invalid option.");
            }
        }
    }
}
