module com.example.ecommerceak {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.ecommerceak to javafx.fxml;
    exports com.example.ecommerceak;
}