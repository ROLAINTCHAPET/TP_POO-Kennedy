package com.example.stolen_objects;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class DatabaseManager {

    public DatabaseManager() {
    }

     public abstract Boolean CheckAccount(Integer Id);
    //Boolean CheckObjectPresence(int Id){};
    public List<Object> searchStolenObjects() {
        List<Object> stolenObjects = new ArrayList<>();
        String query = "SELECT * FROM objets WHERE statut = 'volé'";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_objets_voles", "MAES", "youngmister");
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Create a StolenObject for each row and add it to the list
                Object obj = new Object(00, "OO");
                obj.setCode(Integer.parseInt(rs.getString("code")));  // Adjust column names as needed
                obj.setName(rs.getString("nom"));
                obj.setPrice(Integer.parseInt(rs.getString("prix DECIMAL")));
                obj.setStatut(rs.getString("statut"));


                // Add to list
                stolenObjects.add(obj);
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }

        return stolenObjects;
    }
}
