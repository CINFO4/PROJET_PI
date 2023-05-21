/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.controller;

import com.esprit.entities.Domaine;
import com.esprit.services.ServiceDomaine;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjoutDomaineController implements Initializable {

    @FXML
    private TextField tfNomDomaine;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterDomaine(ActionEvent event) {
        ServiceDomaine sd = new ServiceDomaine();
        sd.ajouter(new Domaine(tfNomDomaine.getText()));
        JOptionPane.showMessageDialog(null,"Domaine Ajouter !");
    }
    
}
