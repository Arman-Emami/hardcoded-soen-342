package com.artadvisory.dao;

import com.artadvisory.db.SQLiteConnector;
import com.artadvisory.model.Availability;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvailabilityDAO {

    public void insertAvailability(int expertID, String weekDay, String startTime, String endTime, String availabilityType) {
        String sql = """
        INSERT INTO Availability (expertID, weekDayAvailable, startTime, endTime, availabilityType)
        VALUES (?, ?, ?, ?, ?);
    """;
        try (Connection conn = SQLiteConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, expertID);
            pstmt.setString(2, weekDay);
            pstmt.setString(3, startTime);
            pstmt.setString(4, endTime);
            pstmt.setString(5, availabilityType);
            pstmt.executeUpdate();
            System.out.println("✅ Availability added!");

        } catch (SQLException e) {
            System.out.println("❌ Failed to insert availability: " + e.getMessage());
        }
    }

    public void deleteAvailability(int availabilityID) {
        String sql = "DELETE FROM Availability WHERE availabilityID = ?";

        try (Connection conn = SQLiteConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, availabilityID);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("🗑️ Availability entry deleted successfully.");
            } else {
                System.out.println("⚠️ No availability found with that ID.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Failed to delete availability: " + e.getMessage());
        }
    }

    public void updateAvailability(int availabilityID, String newWeekDay, String newStartTime, String newEndTime) {
        String sql = """
        UPDATE Availability
        SET weekDayAvailable = ?, startTime = ?, endTime = ?
        WHERE availabilityID = ?;
    """;

        try (Connection conn = SQLiteConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newWeekDay);
            pstmt.setString(2, newStartTime);
            pstmt.setString(3, newEndTime);
            pstmt.setInt(4, availabilityID);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Availability updated.");
            } else {
                System.out.println("⚠️ No availability found with that ID.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Failed to update availability: " + e.getMessage());
        }
    }

    public void printExpertAvailability(int expertID) {
        String sql = "SELECT * FROM Availability WHERE expertID = ?";

        try (Connection conn = SQLiteConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, expertID);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("\n📅 Your Availability:");
            boolean found = false;

            while (rs.next()) {
                found = true;
                int id = rs.getInt("availabilityID");
                String day = rs.getString("weekDayAvailable");
                String start = rs.getString("startTime");
                String end = rs.getString("endTime");
                String type = rs.getString("availabilityType");

                System.out.printf("ID: %d | %s | %s - %s | Type: %s\n", id, day, start, end, type);
            }

            if (!found) {
                System.out.println("⚠️ You have no availability set.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Failed to retrieve availability: " + e.getMessage());
        }
    }


}
