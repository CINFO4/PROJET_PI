/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package com.esprit.view;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Anis
 */
public class Mainprog extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
       //FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AjoutCandidat.fxml"));
     //FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AjoutEntreprise.fxml"));
      //FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/User.fxml"));
      //FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Candidat.fxml"));
      FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Entreprise.fxml"));
      //FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Login.fxml"));
      //FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/motdepasse.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        
        primaryStage.setTitle("FindJob");
        
        primaryStage.show();
        
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
