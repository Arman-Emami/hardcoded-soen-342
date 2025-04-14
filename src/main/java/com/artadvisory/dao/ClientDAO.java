package com.artadvisory.dao;

import com.artadvisory.db.SQLiteConnector;
import com.artadvisory.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ClientDAO {

    // SignUp of new Client
    public void insertClient(Client client) {
        String insertSql = """
        INSERT INTO Client (emailAddress, phoneNumber, name, password, affiliation, intent)
        VALUES (?, ?, ?, ?, ?, ?);
    """;

        try (Connection conn = SQLiteConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(insertSql)) {

            pstmt.setString(1, client.getEmailAddress());
            pstmt.setString(2, client.getPhoneNumber());
            pstmt.setString(3, client.getName());
            pstmt.setString(4, client.getPassword());
            pstmt.setString(5, client.getAffiliation());
            pstmt.setString(6, client.getIntent());
            System.out.println("✅ Client created!");

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("❌ Failed to insert client: " + e.getMessage());
        }
    }

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM Client";

        try (Connection conn = SQLiteConnector.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Client client = new Client(
                        rs.getInt("clientID"),
                        rs.getString("emailAddress"),
                        rs.getString("phoneNumber"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("affiliation"),
                        rs.getString("intent"),
                        rs.getString("accountStatus")
                );
                clients.add(client);
            }

        } catch (SQLException e) {
            System.out.println("❌ Failed to fetch clients: " + e.getMessage());
        }

        return clients;
    }

    public List<Client> getAllPendingClients() {
        List<Client> pendingClients = new ArrayList<>();
        String sql = "SELECT * FROM Client WHERE accountStatus = 'Pending'";

        try (Connection conn = SQLiteConnector.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Client client = new Client(
                        rs.getInt("clientID"),
                        rs.getString("emailAddress"),
                        rs.getString("phoneNumber"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("affiliation"),
                        rs.getString("intent"),
                        rs.getString("accountStatus")
                );
                pendingClients.add(client);
            }

        } catch (SQLException e) {
            System.out.println("❌ Failed to fetch clients: " + e.getMessage());
        }

        return pendingClients;
    }

    public Integer getClientIDByEmail(String email) {
        String sql = "SELECT clientID FROM Client WHERE emailAddress = ?";

        try (Connection conn = SQLiteConnector.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("clientID");
                } else {
                    System.out.println("⚠️ No client found with email: " + email);
                    return null;
                }
            }
        } catch (SQLException e) {
            System.out.println("❌ Failed to fetch client ID: " + e.getMessage());
            return null;
        }
    }

    public Client authenticateClient(String email, String password) {
        String sql = "SELECT * FROM Client WHERE emailAddress = ? AND password = ?";

        try (Connection conn = SQLiteConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Client(
                            rs.getInt("clientID"),
                            rs.getString("emailAddress"),
                            rs.getString("phoneNumber"),
                            rs.getString("name"),
                            rs.getString("password"),
                            rs.getString("affiliation"),
                            rs.getString("intent"),
                            rs.getString("accountStatus")
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

    public void updateClientInfo(String email, String name, String phone) {
        String sql = "UPDATE Client SET name = ?, phoneNumber = ? WHERE emailAddress = ?";
        try (Connection conn = SQLiteConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.setString(3, email);
            pstmt.executeUpdate();
            System.out.println("✅ Client info updated!");

        } catch (SQLException e) {
            System.out.println("❌ Failed to update client info: " + e.getMessage());
        }
    }

    public void updateAccountStatus(int clientID, String newStatus) {
        String sql = "UPDATE Client SET accountStatus = ? WHERE clientID = ?";
        try (Connection conn = SQLiteConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newStatus);
            pstmt.setInt(2, clientID);
            pstmt.executeUpdate();
            System.out.println("✅ Client Account Status updated!");

        } catch (SQLException e) {
            System.out.println("❌ Failed to update account status: " + e.getMessage());
        }
    }

    public void deleteClientByEmail(String email) {
        String sql = "DELETE FROM Client WHERE emailAddress = ?";
        try (Connection conn = SQLiteConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            pstmt.executeUpdate();
            System.out.println("✅ Client deleted!");

        } catch (SQLException e) {
            System.out.println("❌ Failed to delete client: " + e.getMessage());
        }
    }

}
