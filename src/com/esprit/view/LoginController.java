/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.view;

import com.esprit.services.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private Label motdepasseoublie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    public void sign(Event e) throws IOException {
    ServiceUser su = new ServiceUser();
    String loginText = login.getText();
    String passwordText = motdepasse.getText();
    if (su.login(loginText, passwordText)) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Candidat.fxml"));
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

    
}
