/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package com.esprit.tests;

import com.esprit.gui.AjoutReviewController;
import com.esprit.gui.ModifierReviewsController;
import com.esprit.gui.reclamation.AjoutReclamationController;
import com.esprit.services.Email;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.mail.MessagingException;

/**
 *
 * @author Mehdi
 */
public class MainGui extends Application {
    
  @Override
public void start(Stage primaryStage) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ModifierReviews.fxml"));
    //ModifierReviewsController reviewController = new ModifierReviewsController(); // Pass the userID here
    //loader.setController(reviewController);
    //AjoutReclamationController ajoutReclamationController = new AjoutReclamationController(1); // Pass the userID here
    //loader.setController(ajoutReclamationController);
    Parent root = loader.load();
    Scene scene = new Scene(root);
    scene.getStylesheets().add(getClass().getResource("../gui/style.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.setTitle("Ajouter Review");
    primaryStage.show();
}


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      try {
          Email.sendMail("mcehdich@gmail.com","subject","bzzzzzz");
      } catch (MessagingException ex) {
          Logger.getLogger(MainGui.class.getName()).log(Level.SEVERE, null, ex);
      }
        launch(args);
    }
    
}
