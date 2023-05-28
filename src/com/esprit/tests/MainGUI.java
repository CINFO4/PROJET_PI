package com.esprit.tests;

import com.esprit.gui.GererDocumentController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file
           FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/GererDocument.fxml"));
           AnchorPane root = loader.load();

            // Set up the controller
            GererDocumentController controller = loader.getController();
            // You can pass any necessary dependencies to the controller here

            // Set up the primary stage
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Your Application Title");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
