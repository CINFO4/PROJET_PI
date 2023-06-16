/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package com.esprit.tests;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class MainGUI extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
//      FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/CrudOffre.fxml"));
      FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/CrudDomaine.fxml"));
//      FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/CrudCandidature.fxml"));
        
      //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/InterfaceOffreUser.fxml"));
//      FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/InterfaceOffreEntreprise.fxml"));
      
      
      
      
      
      
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
