package com.artadvisory;

import com.artadvisory.db.DatabaseInitializer;
import com.artadvisory.dao.*;
import com.artadvisory.model.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DatabaseInitializer.initializeAllTables();
                Scanner scanner = new Scanner(System.in);
                Object loggedUser = null;

                while (loggedUser == null) {
                    System.out.println("\nWelcome to the Art Advisory System 🎨");
                    System.out.println("[1] Login");
                    System.out.println("[2] Sign Up (Client Only)");
                    System.out.println("[0] Exit");
                    System.out.print("Select an option: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1 -> {
                            System.out.println("\nLogin as:");
                            System.out.println("[1] Client");
                            System.out.println("[2] Expert");
                            System.out.println("[3] Admin");
                            System.out.print("Select user type: ");
                            int role = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Email: ");
                            String email = scanner.nextLine();
                            System.out.print("Password: ");
                            String password = scanner.nextLine();

                            switch (role) {
                                case 1 -> {
                                    Client client = new ClientDAO().authenticateClient(email, password);
                                    if (client != null) {
                                        loggedUser = client;
                                        System.out.println("✅ Client login successful. Welcome, " + client.getName());
                                    } else {
                                        System.out.println("❌ Invalid credentials.");
                                    }
                                }
                                case 2 -> {
                                    Expert expert = new ExpertDAO().authenticateExpert(email, password);
                                    if (expert != null) {
                                        loggedUser = expert;
                                        System.out.println("✅ Expert login successful. Welcome, " + expert.getName());
                                    } else {
                                        System.out.println("❌ Invalid credentials.");
                                    }
                                }
                                case 3 -> {
                                    Admin admin = new AdminDAO().authenticateAdmin(email, password);
                                    if (admin != null) {
                                        loggedUser = admin;
                                        System.out.println("✅ Admin login successful. Welcome, " + admin.getName());
                                    } else {
                                        System.out.println("❌ Invalid credentials.");
                                    }
                                }
                                default -> System.out.println("❌ Invalid user type.");
                            }
                        }

                        case 2 -> {
                            System.out.println("\n📝 Client Sign Up");
                            System.out.print("Email: ");
                            String email = scanner.nextLine();
                            System.out.print("Phone Number: ");
                            String phone = scanner.nextLine();
                            System.out.print("Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Password: ");
                            String password = scanner.nextLine();
                            System.out.print("Affiliation: ");
                            String affiliation = scanner.nextLine();
                            System.out.print("Intent (e.g., Buyer, Seller): ");
                            String intent = scanner.nextLine();

                            Client newClient = new Client();
                            newClient.signUp(email, phone, name, password, affiliation, intent);
                            System.out.println("✅ Client signed up! Please log in.");
                        }

                        case 0 -> {
                            System.out.println("👋 Exiting program. Goodbye!");
                            System.exit(0);
                        }

                        default -> System.out.println("❌ Invalid choice.");
                    }
                }

        if (loggedUser instanceof Client client)
            UserDashboard.show(client);
         else if (loggedUser instanceof Admin admin)
            AdminDashboard.show(admin);
         else if (loggedUser instanceof Expert expert)
            ExpertDashboard.show(expert);
        else
            System.exit(0);
            }
        }

//public static void main(String[] args) {
//        Admin admin1 = new Admin("admin@gmail.com","4384384343", "John", "admin123");
//        AdminDAO adminDAO = new AdminDAO();
//        adminDAO.insertAdmin(admin1);
//    }
//}