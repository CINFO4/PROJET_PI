package com.esprit.tests;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainProfile extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/profile.fxml"));
        
       
        Parent root = loader.load();

        // Set up the primary stage
        primaryStage.setTitle("Profile Management");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}