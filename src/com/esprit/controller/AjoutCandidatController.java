/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.controller;

import com.esprit.entities.*;
import com.esprit.services.ServiceCompetence;
import com.esprit.services.ServiceUser;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Anis
 */
public class AjoutCandidatController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfadresse;
    @FXML
    private TextField tfmotdepasse;
    @FXML
    private TextField tfmotdepasse2;
    @FXML
    private TextField tftelephone;
    @FXML
    private TextField tfgithub;
    @FXML
    private TextArea tadescription;
    @FXML
    private ComboBox<Experience> cbexperience;
    @FXML
    private ComboBox<Diplome> cbdiplome;
    @FXML
     private ListView<String> listcompetence; 
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServiceCompetence sc = new ServiceCompetence();
        cbdiplome.setItems(FXCollections.observableArrayList(Diplome.values()));
        cbexperience.setItems(FXCollections.observableArrayList(Experience.values()));
        listcompetence.setItems(FXCollections.observableArrayList(sc.affichercompetencebynom()));
        listcompetence.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }    
    
}
