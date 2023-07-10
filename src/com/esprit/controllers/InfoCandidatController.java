/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.controllers;

import com.esprit.entities.Candidat;
import com.esprit.entities.MailException;
import com.esprit.services.ServiceUser;
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
public class InfoCandidatController implements Initializable {

    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label diplome;
    @FXML
    private Label telephone;
    @FXML
    private Label mail;
    @FXML
    private Label experience;
    private Candidat c;
    private int id;

    public void setId(int id) {
        this.id = id;
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServiceUser su = new ServiceUser();
        try {
            c=su.afficherunCandidat(id);
        } catch (MailException ex) {
            System.out.println(ex.getMessage());
        }
        nom.setText(c.getNom());
        prenom.setText(c.getPrenom());
        telephone.setText(String.valueOf(c.getNumero_telephone()));
        mail.setText(c.getMail());
        diplome.setText(String.valueOf(c.getEducation()));
        experience.setText(String.valueOf(c.getExperience()));
        
    } 
    
    
}
