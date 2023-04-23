package com.example.ecommerceak;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class E_Commerce extends Application {
    UserInterface userInterface = new UserInterface();

    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(userInterface.createContent());
        stage.setTitle("Deal Hive");
        Image icon =new Image("C:\\Java Projects Acciojob\\E-CommerceAK\\src\\main\\icon.jpeg");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}