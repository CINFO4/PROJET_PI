package com.esprit.tests;

import com.esprit.entities.Document;
import com.esprit.gui.DetailsDocumentController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/DetailsDocument.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.setTitle("PIDEV");
        primaryStage.show();

        // Get the controller instance
        DetailsDocumentController controller = loader.getController();

        // Create a sample document
        Document document = new Document();
        document.setId_document(1);
        document.setTitre_document("Sample Document");
        document.setDescription_document("This is a sample document.");
        document.setType("Sample Type");
        document.setLien("https://example.com");
        document.setId_user(123);

        // Pass the document to the controller
        controller.setDocument(document);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
