/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.controller;

import java.net.URL;
import java.util.ResourceBundle;
import com.esprit.entities.*;
import com.esprit.services.*;
import java.io.IOException;
import java.util.List;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Anis
 */
public class AjoutEntrepriseController implements Initializable {
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfNomEntreprise;
    @FXML
    private TextField tfnumero;
    @FXML
    private TextField tfPassword;
    @FXML
    private TextField tfPassword2;
    @FXML
    private TextField tfSIteWeb;
    @FXML
    private TextField tfLinkedin;
    @FXML
    private TextArea taDescription;
    @FXML
    private TextField tfAdresse;
    
     
    @FXML
    private ComboBox<Taille> cbTailleEntreprise;
    @FXML
    private ComboBox<String> cbSecteurActivite;
   
    private Refresh refreshEvent;
   
    public void setRefreshEvent(Refresh refreshListener) {
    this.refreshEvent = refreshListener;
}
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        Taille[] t = Taille.values();
//        String[] t2 = new String[t.length];
//        for(int i=0; i<t.length;i++){
//            t2[i]=t[i].toString().replace('_', ' ');
//        }
        ServiceDomaine sd = new ServiceDomaine();
        cbSecteurActivite.setItems(FXCollections.observableArrayList(sd.getDomainesName()));
        cbTailleEntreprise.setItems(FXCollections.observableArrayList(Taille.values()));
        
        // TODO
    }  
    public void triggerRefreshEvent() {
        if (refreshEvent != null) {
            refreshEvent.onRefresh();
        }
     }
    
    public boolean validateFields() {
        if (tfNom.getText().isEmpty() || tfPrenom.getText().isEmpty() || tfNomEntreprise.getText().isEmpty() || tfnumero.getText().isEmpty() || tfPassword.getText().isEmpty() || tfPassword2.getText().isEmpty() || tfSIteWeb.getText().isEmpty() || tfLinkedin.getText().isEmpty() || taDescription.getText().isEmpty() || tfAdresse.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Champs obligatoires");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs obligatoires.");
            alert.showAndWait();
            return false;
        }
        return true;
    }
     @FXML
    public void ajouterEntreprise(ActionEvent event) throws IOException {
        if(!validateFields()){
            return;
        }
        if(tfPassword.getText().equals(tfPassword2.getText())){
        ServiceUser sp = new ServiceUser();
        ServiceDomaine sd = new ServiceDomaine();
        sp.ajouter(new Entreprise(tfNom.getText(), tfPrenom.getText(), tfAdresse.getText(), Integer.parseInt(tfnumero.getText()), tfPassword.getText(), taDescription.getText(),tfNomEntreprise.getText(),cbTailleEntreprise.getValue(),tfSIteWeb.getText(),tfLinkedin.getText(),sd.getIdDomaineByName(cbSecteurActivite.getValue())));
        JOptionPane.showMessageDialog(null, "Entreprise ajoutée !");
        triggerRefreshEvent();
        }
        else {
            JOptionPane.showMessageDialog(null, "Mot de passe erronée");
        }
        
     
    }
    

    
     

    
}
