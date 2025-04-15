package com.artadvisory.dao;

import com.artadvisory.db.SQLiteConnector;
import java.sql.*;
import java.util.Scanner;

public class ServiceRequestDAO {

    public void createRequest(int clientID) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Expert ID to request: ");
        int expertID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Request Type (e.g., Consultation, Valuation): ");
        String requestType = scanner.nextLine();

        String requestDate = java.time.LocalDate.now().toString();
        String requestTime = java.time.LocalTime.now().toString();

        String sql = """
        INSERT INTO ServiceRequest (clientID, expertID, requestType, requestDate, requestTime)
        VALUES (?, ?, ?, ?, ?);
    """;

        try (Connection conn = SQLiteConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, clientID);
            pstmt.setInt(2, expertID);
            pstmt.setString(3, requestType);
            pstmt.setString(4, requestDate);
            pstmt.setString(5, requestTime);

            pstmt.executeUpdate();
            System.out.println("✅ Service request submitted.");

        } catch (SQLException e) {
            System.out.println("❌ Failed to create service request: " + e.getMessage());
        }
    }

}
