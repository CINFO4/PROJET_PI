/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.controller;

import com.esprit.services.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Anis
 */
public class LoginController implements Initializable {

    @FXML
    private TextField login;
    @FXML
    private TextField motdepasse;
    @FXML
    private Button sidentitfier;
    @FXML
    private Button sinscrire;
    @FXML
    private Button motdepasseoublie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    public void sign(Event e) throws IOException {
        if (!validateFields()) {
        return;
    }
    ServiceUser su = new ServiceUser();
    String loginText = login.getText();
    String passwordText = motdepasse.getText();
    if (su.login(loginText, passwordText)) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Candidat.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) login.getScene().getWindow(); // Récupère la fenêtre actuelle
            stage.setScene(scene); // Définit la nouvelle scène sur la fenêtre
            stage.show(); // Affiche la nouvelle scène
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } else {
        JOptionPane.showMessageDialog(null, "Login ou mot de passe erroné !","Erreur", JOptionPane.ERROR_MESSAGE);
    }
}
    
    public void oublier(Event e){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/motdepasse.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) login.getScene().getWindow(); // Récupère la fenêtre actuelle
            stage.setScene(scene); // Définit la nouvelle scène sur la fenêtre
            stage.show(); // Affiche la nouvelle scène
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public boolean validateFields() {
    if (login.getText().isEmpty() || motdepasse.getText().isEmpty()) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Champs obligatoires");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs obligatoires.");
        alert.showAndWait();
        return false;
    }
    return true;
}
    
    public void inscription(ActionEvent e) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/EspaceInscription.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) login.getScene().getWindow(); // Récupère la fenêtre actuelle
            stage.setScene(scene); // Définit la nouvelle scène sur la fenêtre
            stage.show();
   }

    
}
