package com.artadvisory.dao;

import com.artadvisory.db.SQLiteConnector;
import com.artadvisory.model.Expert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpertDAO {

    public void insertExpert(Expert expert) {
        String sql = """
        INSERT INTO Expert (emailAddress, phoneNumber, name, password, licenseNumber, expertiseArea)
        VALUES (?, ?, ?, ?, ?, ?);
    """;
        try (Connection conn = SQLiteConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, expert.getEmailAddress());
            pstmt.setString(2, expert.getPhoneNumber());
            pstmt.setString(3, expert.getName());
            pstmt.setString(4, expert.getPassword());
            pstmt.setString(5, expert.getLicenseNumber());
            pstmt.setString(6, expert.getExpertiseArea());
            pstmt.executeUpdate();
            System.out.println("✅ Expert added!");

        } catch (SQLException e) {
            System.out.println("❌ Failed to insert expert: " + e.getMessage());
        }
    }

    public void updateExpertInfo(String email, String name, String phone) {
        String sql = "UPDATE Expert SET name = ?, phoneNumber = ? WHERE emailAddress = ?";
        try (Connection conn = SQLiteConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.setString(3, email);
            pstmt.executeUpdate();
            System.out.println("✅ Expert info updated");

        } catch (SQLException e) {
            System.out.println("❌ Failed to update expert info: " + e.getMessage());
        }
    }

    public void deleteExpertByEmail(String email) {
        String sql = "DELETE FROM Expert WHERE emailAddress = ?";
        try (Connection conn = SQLiteConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            pstmt.executeUpdate();
            System.out.println("✅ Expert deleted");

        } catch (SQLException e) {
            System.out.println("❌ Failed to delete expert: " + e.getMessage());
        }
    }

}
