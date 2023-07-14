/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * FXML Controller class
 *
 * @author Anis
 */
public class GestionUtilisateurController implements Initializable {

    @FXML
    private Button candidat;
    @FXML
    private Button entreprise;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void espaceentreprise(ActionEvent a) throws IOException {
        System.out.println("cc");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Entreprise.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) entreprise.getScene().getWindow(); // Récupère la fenêtre actuelle
        stage.setScene(scene); // Définit la nouvelle scène sur la fenêtre
        stage.show();
    }

    @FXML
    public void espacecandidat(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Candidat.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) candidat.getScene().getWindow(); // Récupère la fenêtre actuelle
        stage.setScene(scene); // Définit la nouvelle scène sur la fenêtre
        stage.show();
    }

}
