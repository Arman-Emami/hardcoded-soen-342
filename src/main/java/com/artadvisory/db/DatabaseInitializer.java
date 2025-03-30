package com.artadvisory.db;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseInitializer {

    public static void createExpertTable() {
        String sql = """
        CREATE TABLE IF NOT EXISTS Expert (
            expertID INTEGER PRIMARY KEY AUTOINCREMENT,
            emailAddress TEXT NOT NULL UNIQUE,
            phoneNumber TEXT,
            name TEXT NOT NULL,
            password TEXT NOT NULL,
            licenseNumber TEXT,
            expertiseArea TEXT,
            availability TEXT
        );
    """;
        executeTableCreation(sql, "Expert");
    }

    public static void createClientTable() {
        String sql = """
        CREATE TABLE IF NOT EXISTS Client (
            clientID INTEGER PRIMARY KEY AUTOINCREMENT,
            emailAddress TEXT NOT NULL UNIQUE,
            phoneNumber TEXT,
            name TEXT NOT NULL,
            password TEXT NOT NULL,
            affiliation TEXT,
            intent TEXT,
            accountStatus TEXT DEFAULT "Pending"
        );
    """;
        executeTableCreation(sql, "Client");
    }

    public static void createAdminTable() {
        String sql = """
        CREATE TABLE IF NOT EXISTS Admin (
            adminID INTEGER PRIMARY KEY AUTOINCREMENT,
            emailAddress TEXT NOT NULL UNIQUE,
            phoneNumber TEXT,
            name TEXT NOT NULL,
            password TEXT NOT NULL,
        );
    """;
        executeTableCreation(sql, "Admin");
    }

    public static void createViewingTable() {
        String sql = """
        CREATE TABLE IF NOT EXISTS Viewing (
            viewingID INTEGER PRIMARY KEY AUTOINCREMENT,
            auctionID INTEGER NOT NULL,
            name TEXT NOT NULL,
            FOREIGN KEY (auctionID) REFERENCES Auction(auctionID)
        );
    """;
        executeTableCreation(sql, "Viewing");
    }

    public static void createAvailabilityTable() {
        String sql = """
        CREATE TABLE IF NOT EXISTS Availability (
            availabilityID INTEGER PRIMARY KEY AUTOINCREMENT,
            expertID INTEGER NOT NULL,
            weekDayAvailable TEXT NOT NULL,
            startTime TEXT NOT NULL,
            endTime TEXT NOT NULL,
            availabilityType TEXT,
            FOREIGN KEY (expertID) REFERENCES Expert(expertID)
        );
    """;
        executeTableCreation(sql, "Availability");
    }

    public static void createObjectOfInterestTable() {
        String sql = """
        CREATE TABLE IF NOT EXISTS ObjectOfInterest (
            objectOfInterestID INTEGER PRIMARY KEY AUTOINCREMENT,
            auctionID INTEGER,
            title TEXT NOT NULL,
            detailDescription TEXT,
            isOwnedByInstitution BOOLEAN NOT NULL,
            canBeAuctioned BOOLEAN NOT NULL,
            objectType TEXT,
            FOREIGN KEY (auctionID) REFERENCES Auction(auctionID)
        );
    """;
        executeTableCreation(sql, "ObjectOfInterest");
    }

    public static void createAuctionTable() {
        String sql = """
        CREATE TABLE IF NOT EXISTS Auction (
            auctionID INTEGER PRIMARY KEY AUTOINCREMENT,
            auctionHouseID INTEGER NOT NULL,
            name TEXT NOT NULL,
            auctionSpecialty TEXT,
            startWeekDay TEXT,
            endWeekDay TEXT,
            startDate TEXT,
            endDate TEXT,
            startTime TEXT,
            endTime TEXT,
            auctionType TEXT,
            timeZone TEXT,
            isOnline INTEGER NOT NULL CHECK (isOnline IN (0,1)),
            FOREIGN KEY (auctionHouseID) REFERENCES AuctionHouse(auctionHouseID)
        );
    """;
        executeTableCreation(sql, "Auction");
    }

    public static void createAuctionHouseTable() {
        String sql = """
        CREATE TABLE IF NOT EXISTS AuctionHouse (
            auctionHouseID INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT NOT NULL,
            city TEXT,
            address TEXT
        );
    """;
        executeTableCreation(sql, "AuctionHouse");
    }

    public static void createServiceRequestTable() {
        String sql = """
        CREATE TABLE IF NOT EXISTS ServiceRequest (
            serviceRequestID INTEGER PRIMARY KEY AUTOINCREMENT,
            clientID INTEGER NOT NULL,
            expertID INTEGER NOT NULL,
            requestType TEXT NOT NULL,
            requestDate TEXT NOT NULL,
            requestTime TEXT NOT NULL,
            FOREIGN KEY (clientID) REFERENCES Client(clientID),
            FOREIGN KEY (expertID) REFERENCES Expert(expertID)
        );
    """;
        executeTableCreation(sql, "ServiceRequest");
    }


    // Initialize all tables
    public static void initializeAllTables() {
        createClientTable();
        createExpertTable();
        createAdminTable();
        createAuctionHouseTable();
        createAuctionTable();
        createViewingTable();
        createAvailabilityTable();
        createObjectOfInterestTable();
        createServiceRequestTable();
        System.out.println("All tables created successfully.");
    }

    // Table Creation
    private static void executeTableCreation(String sql, String tableName) {
        try (Connection conn = SQLiteConnector.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("✅ Table '" + tableName + "' created or already exists.");
        } catch (SQLException e) {
            System.out.println("❌ Failed to create table '" + tableName + "': " + e.getMessage());
        }
    }

}
