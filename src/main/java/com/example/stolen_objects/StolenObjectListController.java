package com.example.stolen_objects;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.List;

import static javafx.application.Application.launch;


public class StolenObjectListController extends DatabaseManager{

    @FXML
    private TextArea stolenObjectsTextArea;
    public void printStolenObjects() {
        List<Object> objects = searchStolenObjects();
        StringBuilder displayText = new StringBuilder();

        if (objects.isEmpty()) {
            stolenObjectsTextArea.setText("Aucun objet volé trouvé dans la base de données.");
        } else {
            for (Object obj : objects) {
                displayText.append("Code: ").append(obj.getCode()).append("\n");
                displayText.append("Nom: ").append(obj.getName()).append("\n");
                displayText.append("prix DECIMAL: ").append(obj.getPrice()).append("\n");
                displayText.append("Staut: ").append(obj.getStatut()).append("\n");
                displayText.append("----------------------------------\n");
            }

            // Set the text to the TextArea
            stolenObjectsTextArea.setText(displayText.toString());
        }
    }

    public  Boolean CheckAccount(Integer Id){return false;}
}
