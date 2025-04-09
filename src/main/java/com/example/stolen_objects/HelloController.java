package com.example.stolen_objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import javax.xml.crypto.Data;
import java.io.IOException;

public class HelloController extends DatabaseManager {
    public void OnClickOpen_buy_page(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("info.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("Entrer les infos");
        stage.setScene(scene);
        stage.show();
    }

    public void OnSignalStolen(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Stolen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Objets Volé");
        stage.setScene(scene);
        stage.show();

    }

    public void OnCreateUserAccount(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("account.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("Creer un compte");
        stage.setScene(scene);
        stage.show();
        //User Client = new User();
    }

    @FXML
    void OnVerifyStolenObjects(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("StolenObjectlist.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("Liste des Objets volés");
        stage.setScene(scene);
        stage.show();

    }
    public Boolean CheckAccount(Integer Id){return false;}
}
