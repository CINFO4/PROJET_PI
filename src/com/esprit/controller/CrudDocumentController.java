/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author 2023
 */
public class CrudDocumentController implements Initializable {


    @FXML
    @FXML
    @FXML
    private TextField txtTitre;
    @FXML
    @FXML
    @FXML
    private ChoiceBox<?> choiceType;
    @FXML
    @FXML
    @FXML
    private TextField txtLien;
    @FXML
    @FXML
    @FXML
    private TextArea txtDescription;
    @FXML
    @FXML
    @FXML
    private Button btnAdd;
    @FXML
    @FXML
    @FXML
    private TableView<?> tableDocument;
    @FXML
    @FXML
    @FXML
    private TableColumn<?, ?> titreCol;
    @FXML
    @FXML
    @FXML
    private TableColumn<?, ?> descCol;
    @FXML
    @FXML
    @FXML
    private TableColumn<?, ?> typeCol;
    @FXML
    @FXML
    @FXML
    private TableColumn<?, ?> lienCol;
    @FXML
    @FXML
    @FXML
    private Button btnUpdate;
    @FXML
    @FXML
    @FXML
    private Button btnDelete;
    @FXML
    @FXML
    @FXML
    private Button btnAff;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    @FXML
    private void addDocument(ActionEvent event) {
    }

    @FXML
    @FXML
    private void updateDocument(ActionEvent event) {
    }

    @FXML
    @FXML
    private void deleteDocument(ActionEvent event) {
    }

    @FXML
    @FXML
    private void AfficherDocument(ActionEvent event) {
    }

}
