/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package com.esprit.tests;

import com.esprit.services.ServiceOffre;
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
 * @author ASUS
 */
public class MainGUI extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
//       FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/CrudOffre.fxml"));
//       FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/CrudDomaine.fxml"));
      FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/CrudCandidature.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
       primaryStage.setTitle("JOB World ");
        
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
