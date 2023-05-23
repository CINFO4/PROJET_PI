/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DetailsCandidatureController implements Initializable {

    @FXML
    private Label LID_User;
    @FXML
    private Label LID_Offre;
    @FXML
    private Label LID_Candidature;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setLID_User(String id) {
        LID_User.setText(id);
    }
    public void setLID_Offre(String id) {
        LID_Offre.setText(id);
    }
    public void setLID_Candidature(String id) {
        LID_Candidature.setText(id);
    }
    
}
