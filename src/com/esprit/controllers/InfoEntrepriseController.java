/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.controllers;

import com.esprit.entities.MailException;
import com.esprit.services.ServiceUser;
import com.esprit.services.ServiceUser.Entreprisedomaine;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Anis
 */

public class InfoEntrepriseController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
     private Label nomentreprise;
     @FXML
     private Label telephone;
     @FXML
     private Label mail;
     @FXML
     private Label taille;
     @FXML
     private Label domaine;
     private Entreprisedomaine ed;
     private int id;

    public void setId(int id) {
        this.id = id;
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }  
    public void dataload(){
        ServiceUser su = new ServiceUser();
         try {
             ed = su.afficherunentreprise(45);
         } catch (MailException ex) {
             System.out.println(ex.getMessage());
         }
        nomentreprise.setText(ed.getNomEntreprise());
        telephone.setText(String.valueOf(ed.getNumero_telephone()));
        mail.setText(ed.getMail());
        taille.setText(String.valueOf(ed.getTailleEntreprise()));
        domaine.setText(String.valueOf(ed.getNom_domaine()));
    }
    
}
