/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.controller;

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
public class DetailsOffreController implements Initializable {

    @FXML
    private Label LbDescription;
    @FXML
    private Label LbIdDomaine;
    @FXML
    private Label LbDateExp;
    @FXML
    private Label LbTitre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setLbDescription(String description){
        LbDescription.setText(description);
    }
    
    public void setLbIdDomaine(String idDomaine){
        LbIdDomaine.setText(idDomaine);
    }
    
    public void setLbDateExp(String date_exp){
        LbDateExp.setText(date_exp);
    }
    
    public void setLbTitre(String titre){
        LbTitre.setText(titre);
    }
    
}
