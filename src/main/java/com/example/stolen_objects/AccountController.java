package com.example.stolen_objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.awt.*;
import java.sql.*;

import static java.lang.constant.ConstantDescs.NULL;

public class AccountController {

    @FXML
    private TextField adresse;

    @FXML
    private TextField matricule;

    @FXML
    private TextField nom;

    @FXML
    private TextField tel;

    @FXML
    void OnRegister(ActionEvent event) {
        // Vérifier que les champs ne sont pas vides
        if (matricule.getText() != null && !matricule.getText().isEmpty() &&
                nom.getText() != null && !nom.getText().isEmpty() &&
                adresse.getText() != null && !adresse.getText().isEmpty() &&
                tel.getText() != null && !tel.getText().isEmpty()) {

            // Établir la connexion à la base de données
            Connection conn = null;
            PreparedStatement pstmt = null;

            try {
                // Établir la connexion à la base de données
                // Remplacez les informations de connexion selon votre configuration
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_objets_voles", "MAES", "youngmister");

                // Préparer la requête SQL d'insertion
                String sql = "INSERT INTO Clients (nom, adresse, telephone) VALUES (?, ?, ?)";
                pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                // Définir les paramètres
                pstmt.setString(1, nom.getText());
                pstmt.setString(2, adresse.getText());
                pstmt.setString(3, tel.getText());

                // Exécuter la requête
                int affectedRows = pstmt.executeUpdate();

                if (affectedRows > 0) {
                    // Récupérer le matricule auto-généré
                    ResultSet generatedKeys = pstmt.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);

                        // Afficher le message de confirmation dans la zone de texte
                        /*notetetArea.setText("Client enregistré avec succès !\n" +
                                "Nom: " + nom.getText() + "\n" +
                                "Adresse: " + adresse.getText() + "\n" +
                                "Téléphone: " + tel.getText() + "\n" +
                                "Matricule attribué: " + generatedId);*/

                        // Afficher le matricule attribué dans le champ matricule
                        matricule.setText(String.valueOf(generatedId));

                        // Vider les champs après enregistrement
                        clearFields();
                    }
                } else {
                    //notetetArea.setText("Erreur: Aucune ligne insérée dans la base de données.");
                }

            } catch (SQLException e) {
                // Gérer les exceptions SQL
                //notetetArea.setText("Erreur de base de données: " + e.getMessage());
                e.printStackTrace();
            } finally {
                // Fermer les ressources
                try {
                    if (pstmt != null) pstmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            // Afficher un message d'erreur si certains champs sont vides
            //notetetArea.setText("Erreur: Veuillez remplir tous les champs obligatoires.");
        }
    }

    // Méthode auxiliaire pour vider les champs après enregistrement
    private void clearFields() {
        nom.setText("");
        adresse.setText("");
        tel.setText("");
        // On ne vide pas le champ matricule car il contient le matricule attribué
    }
}
