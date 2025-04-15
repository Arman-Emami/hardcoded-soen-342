package com.artadvisory.dao;

import com.artadvisory.db.SQLiteConnector;
import com.artadvisory.model.Auction;

import java.sql.*;

public class AuctionDAO {

    public void displayAllAuctions() {
        String sql = "SELECT * FROM Auction";

        try (Connection conn = SQLiteConnector.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n📢 Upcoming Auctions:");
            boolean found = false;

            while (rs.next()) {
                found = true;
                int id = rs.getInt("auctionID");
                String name = rs.getString("name");
                String specialty = rs.getString("auctionSpecialty");
                String start = rs.getString("startDate");
                String end = rs.getString("endDate");
                boolean online = rs.getInt("isOnline") == 1;

                System.out.printf("ID: %d | %s | Specialty: %s | From %s to %s | Online: %b\n",
                        id, name, specialty, start, end, online);
            }

            if (!found) {
                System.out.println("⚠️ No auctions available.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Failed to fetch auctions: " + e.getMessage());
        }
    }

//    public void insertAuction(Auction auction) {
//        String sql = """
//        INSERT INTO Auction (
//            auctionHouseID, name, auctionSpecialty,
//            startWeekDay, endWeekDay, startDate, endDate,
//            startTime, endTime, auctionType, timeZone, isOnline
//        ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
//    """;
//
//        try (Connection conn = SQLiteConnector.connect();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            pstmt.setInt(1, auction.getAuctionHouseID());
//            pstmt.setString(2, auction.getName());
//            pstmt.setString(3, auction.getAuctionSpecialty());
//            pstmt.setString(4, auction.getStartWeekDay());
//            pstmt.setString(5, auction.getEndWeekDay());
//            pstmt.setString(6, auction.getStartDate());
//            pstmt.setString(7, auction.getEndDate());
//            pstmt.setString(8, auction.getStartTime());
//            pstmt.setString(9, auction.getEndTime());
//            pstmt.setString(10, auction.getAuctionType());
//            pstmt.setString(11, auction.getTimeZone());
//            pstmt.setInt(12, auction.isOnline() ? 1 : 0);
//
//            pstmt.executeUpdate();
//            System.out.println("✅ Auction created successfully.");
//
//        } catch (SQLException e) {
//            System.out.println("❌ Failed to create auction: " + e.getMessage());
//        }
//    }



}
