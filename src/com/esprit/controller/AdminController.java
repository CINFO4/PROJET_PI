/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.controller;

import com.esprit.entities.Administrateur;
import com.esprit.entities.Candidat;
import com.esprit.services.ServiceUser;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Anis
 */
public class AdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Administrateur> table;
    @FXML
    private TableColumn<Administrateur, String> nom;
    @FXML
    private TableColumn<Administrateur, String> prenom;
    @FXML
    private TableColumn<Administrateur, String> mail;
    @FXML
    private TableColumn<Administrateur, Integer> telephone;
    @FXML
    private TableColumn<Administrateur, String> description;
    @FXML
    private TableColumn<Administrateur, Void> supprimer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServiceUser su = new ServiceUser();
        //id.setCellValueFactory(new PropertyValueFactory<Candidat, Integer>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<Administrateur, String>("nom"));
        telephone.setCellValueFactory(new PropertyValueFactory<Administrateur, Integer>("numero_telephone"));
        prenom.setCellValueFactory(new PropertyValueFactory<Administrateur, String>("prenom"));

        mail.setCellValueFactory(new PropertyValueFactory<Administrateur, String>("mail"));
        description.setCellValueFactory(new PropertyValueFactory<Administrateur, String>("description"));
        ObservableList<Administrateur> lu = FXCollections.observableArrayList();
        try {
            lu.addAll(su.getalladmint());
        } catch (Exception e) {
            e.printStackTrace();
        }

        table.setItems(lu);
    }

}
