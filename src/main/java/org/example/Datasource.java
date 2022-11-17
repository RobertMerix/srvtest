package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Datasource {
    String USERNAME = "roberto";
    String PASSWORD = "password";
    public static final String CONNECTION_STRING = "jdbc:postgresql://database/gps_db";

    public static final String TABLE_ROUTES = "routes";
    public static final String COLUMN_IMEI = "imei";

    public static final String INSERT_ROUTES = "INSERT INTO " + TABLE_ROUTES +
            " (" + COLUMN_IMEI + ") VALUES(?)";

    private Connection conn;

    private PreparedStatement insertIntoRoutes;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
            insertIntoRoutes = conn.prepareStatement(INSERT_ROUTES);

            return true;
        } catch(SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
//            if(conn != null) {
//                conn.close();
//            }

            if(insertIntoRoutes !=  null) {
                insertIntoRoutes.close();
            }

        } catch(SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }


    public void insertPosition(String value) {


        try {
            conn.setAutoCommit(false);

            insertIntoRoutes.setString(1, value);
            int affectedRows = insertIntoRoutes.executeUpdate();
            if(affectedRows == 1) {
                conn.commit();
            } else {
                throw new SQLException("The song insert failed");
            }

        } catch(SQLException e) {
            System.out.println("Insert song exception: " + e.getMessage());
            try {
                System.out.println("Performing rollback");
                conn.rollback();
            } catch(SQLException e2) {
                System.out.println("Oh boy! Things are really bad! " + e2.getMessage());
            }
        }
        /*
                finally {
            try {
                System.out.println("Resetting default commit behavior");
                conn.setAutoCommit(true);
            } catch(SQLException e) {
                System.out.println("Couldn't reset auto-commit! " + e.getMessage());
            }
        }
         */
    }
}
