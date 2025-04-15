package com.artadvisory;

import com.artadvisory.model.Expert;

import java.util.Scanner;

public class ExpertDashboard {

    public static void show(Expert expert) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n🧠 Expert Dashboard - Welcome " + expert.getName());
            System.out.println("[1] Add Availability");
            System.out.println("[2] Remove Availability");
            System.out.println("[3] Modify Availability");
            System.out.println("[4] View My Availability");
            System.out.println("[5] Update Expertise");
            System.out.println("[6] View Auctions (Placeholder)");
            System.out.println("[0] Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("\n📅 Add Availability");

                    System.out.print("Week Day (e.g., Monday): ");
                    String day = scanner.nextLine();

                    System.out.print("Start Time (HH:MM): ");
                    String start = scanner.nextLine();

                    System.out.print("End Time (HH:MM): ");
                    String end = scanner.nextLine();

                    expert.addAvailability(day, start, end);
                }

                case 2 -> {
                    System.out.println("\n🗑️ Remove Availability");

                    System.out.print("Enter Availability ID to delete: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    expert.removeAvailability(id);
                }

                case 3 -> {
                    System.out.println("\n✏️ Modify Availability");

                    System.out.print("Enter Availability ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("New Week Day: ");
                    String day = scanner.nextLine();

                    System.out.print("New Start Time: ");
                    String start = scanner.nextLine();

                    System.out.print("New End Time: ");
                    String end = scanner.nextLine();

                    expert.modifyAvailability(id, day, start, end);
                }

                case 4 -> {
                    expert.offerAvailability();
                }

                case 5 -> {
                    System.out.println("\n🧑‍🎨 Update Expertise");

                    System.out.print("New Expertise Area (e.g., Paintings, Jewelry): ");
                    String area = scanner.nextLine();

                    expert.addExpertise(area);
                }

                case 6 -> {
                    expert.getAuction();
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
