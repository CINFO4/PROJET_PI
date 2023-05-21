/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.controller;

import com.esprit.entities.Offre;
import com.esprit.services.ServiceOffre;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjoutOffreController implements Initializable {

    @FXML
    private TextField tfTitre;
    @FXML
    private TextField tfIdDomaine;
    @FXML
    private TextArea taDescription;
    @FXML
    private TextField tfDateExp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterOffre(ActionEvent event) {
        ServiceOffre sf = new ServiceOffre();
        sf.ajouter(new Offre(tfTitre.getText(), taDescription.getText(), Integer.parseInt(tfIdDomaine.getText()),Date.valueOf(tfDateExp.getText())));
        JOptionPane.showMessageDialog(null, "offre ajouter !");
        
        
    }
    
}
