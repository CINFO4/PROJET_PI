/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.Candidature;
import com.esprit.entities.Offre;
import com.esprit.services.ServiceCandidature;
import com.esprit.services.ServiceOffre;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjoutCandidatureController implements Initializable {

    @FXML
    private TextField tfId_user;
    @FXML
    private TextField tfId_offre;
    @FXML
    private TextField tfId_candidature;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterCandidature(ActionEvent event) throws IOException {
        ServiceCandidature sc = new ServiceCandidature();
        sc.ajouter(new Candidature(Integer.parseInt(tfId_user.getText()),Integer.parseInt(tfId_offre.getText()),Integer.parseInt(tfId_candidature.getText())));
        JOptionPane.showMessageDialog(null, "candidature ajouter !");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsCandidature.fxml"));
        Parent root = loader.load();
        tfId_candidature.getScene().setRoot(root);
        
        DetailsCandidatureController dcc = loader.getController();
        dcc.setLID_User(tfId_user.getText());
        dcc.setLID_Offre(tfId_offre.getText());
        dcc.setLID_Candidature(tfId_candidature.getText());
                
        
    }
    
}
