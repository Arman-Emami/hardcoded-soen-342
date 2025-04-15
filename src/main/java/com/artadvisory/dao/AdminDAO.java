package com.artadvisory.dao;

import com.artadvisory.db.SQLiteConnector;
import com.artadvisory.model.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    public Admin authenticateAdmin(String email, String password) {
        String sql = "SELECT * FROM Admin WHERE emailAddress = ? AND password = ?";

        try (Connection conn = SQLiteConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Admin(
                            rs.getInt("adminID"),
                            rs.getString("emailAddress"),
                            rs.getString("phoneNumber"),
                            rs.getString("name"),
                            rs.getString("password")
                    );
                } else {
                    System.out.println("⚠️ Login failed: invalid credentials.");
                    return null;
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ Login failed due to DB error: " + e.getMessage());
            return null;
        }
    }

    public void insertAdmin(Admin admin) {
        String sql = """
        INSERT INTO Admin (emailAddress, phoneNumber, name, password)
        VALUES (?, ?, ?, ?);
    """;

        try (Connection conn = SQLiteConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, admin.getEmailAddress());
            pstmt.setString(2, admin.getPhoneNumber());
            pstmt.setString(3, admin.getName());
            pstmt.setString(4, admin.getPassword());

            pstmt.executeUpdate();
            System.out.println("✅ Admin inserted successfully.");

        } catch (SQLException e) {
            System.out.println("❌ Failed to insert admin: " + e.getMessage());
        }
    }

}
