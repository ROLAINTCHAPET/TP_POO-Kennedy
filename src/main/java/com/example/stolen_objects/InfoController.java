package com.example.stolen_objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class InfoController {
    @FXML
    private TextField code;

    @FXML
    private TextArea mytextArea;

    @FXML
    private TextField nbr;

    @FXML
    private TextField nom_ar;
    @FXML
    void OnShowConfirmation(ActionEvent event) {
        Object article = new Object(Integer.parseInt(code.getText()), nom_ar.getText());
        mytextArea.setText("Hello, this is the confirmation box");
        System.out.println("code de l'article : "+article.getCode());


    }

}
