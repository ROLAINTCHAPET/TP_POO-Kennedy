module com.example.stolen_objects {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires java.xml.crypto;


    opens com.example.stolen_objects to javafx.fxml;
    exports com.example.stolen_objects;
}