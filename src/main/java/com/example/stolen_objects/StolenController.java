package com.example.stolen_objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.*;

public class StolenController extends DatabaseManager {
    @FXML
    private TextField code;

    @FXML
    private TextField nom_ar;

    @FXML
    private TextArea StolenTextArea;

    public Boolean CheckAccount(Integer Id){


        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_objets_voles", "MAES", "youngmister"); Statement stmt = conn.createStatement())

             {

            try (ResultSet rs = stmt.executeQuery("SELECT matricule FROM clients WHERE matricule = "+ Id.toString()+";" )) {
                if(rs !="NULL") {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }


    @FXML
    void OnRegisterStolen(ActionEvent event) {
        if (CheckAccount(Integer.parseInt(code.getText()))){
        System.out.println(" Cet Objet a été entregistré parmi les objets volés");
        StolenTextArea.setText("Cet Objet a été entregistré parmi les objets volés, " +
                "en voici les caracteristiques : \ncode : " +code.getText()+','+"\nnom_article:" + nom_ar.getText());

        }
        else{
            StolenTextArea.setText("Vous n'avez pas de compte, creez en un!!!");
        }
    }

}
