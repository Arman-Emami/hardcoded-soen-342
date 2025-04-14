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

}
