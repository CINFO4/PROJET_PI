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
public class OffreDetailsController implements Initializable {

    @FXML
    private Label LNomEntreprise;
    @FXML
    private Label LNomDomaine;
    @FXML
    private Label LDateExp;
    @FXML
    private Label LDatePub;
    @FXML
    private Label LDesc;
    @FXML
    private Label LTitle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setLNomEntreprise(String LNomEntreprise) {
        this.LNomEntreprise.setText(LNomEntreprise);
    }

    public void setLNomDomaine(String LNomDomaine) {
        this.LNomDomaine.setText(LNomDomaine);
    }

    public void setLDateExp(String LDateExp) {
        this.LDateExp.setText(LDateExp);
    }

    public void setLDatePub(String LDatePub) {
        this.LDatePub.setText(LDatePub);
    }

    public void setLDesc(String LDesc) {
        this.LDesc.setText(LDesc);
    }

    public void setLTitle(String LTitle) {
        this.LTitle.setText(LTitle);
    }
    
    
    
}
