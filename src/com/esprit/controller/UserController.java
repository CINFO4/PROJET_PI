/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.controller;

import com.esprit.entities.*;
import com.esprit.entities.Experience;
import com.esprit.entities.Taille;
import com.esprit.main.Mainprog;
import com.esprit.services.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Anis
 */


public class UserController implements Initializable, Refresh {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableColumn<User, String> nom;
    @FXML
    private TableColumn<User, String> prenom;
    @FXML
    private TableColumn<User, Taille> taille;
    @FXML
    private TableColumn<User, String> secteur;
    @FXML
    private TableColumn<User, String> nomentreprise;
    @FXML
    private TableColumn<User, String> linkedin;
    @FXML
    private TableColumn<User, String> github;
    @FXML
    private TableColumn<User, String> siteweb;
    @FXML
    private TableColumn<User, String> role;
    @FXML
    private TableColumn<User, Diplome> education;
    @FXML
    private TableColumn<User, Experience> experience;
    @FXML
    private TableColumn<User, String> description;
    @FXML
    private TableColumn<User, String> adresse;
    @FXML
    private TableColumn<User, Integer> telephone;
    @FXML
    private TableColumn<User, String> motdepasse;
    @FXML
    private ComboBox<String> adduser;
    @FXML
    private Button add;
    @FXML
    private TableView<User> table;
    ServiceUser su = new ServiceUser();
    String [] l = new String[]{"Entreprise","Candidat","Admin"};
    ObservableList<String> lt = FXCollections.observableArrayList(l);
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //adduser.setItems(FXCollections.observableArrayList(l))
        adduser.getItems().addAll(lt);
        nom.setCellValueFactory(new PropertyValueFactory<User, String>("nom"));
        nomentreprise.setCellValueFactory(new PropertyValueFactory<User, String>("NomEntreprise"));
        prenom.setCellValueFactory(new PropertyValueFactory<User, String>("prenom"));
        telephone.setCellValueFactory(new PropertyValueFactory<User, Integer>("numero_telephone"));
        motdepasse.setCellValueFactory(new PropertyValueFactory<User, String>("motdepasse"));
        github.setCellValueFactory(new PropertyValueFactory<User, String>("Github"));
        linkedin.setCellValueFactory(new PropertyValueFactory<User, String>("Linkedin"));
        siteweb.setCellValueFactory(new PropertyValueFactory<User, String>("SiteWeb"));
        taille.setCellValueFactory(new PropertyValueFactory<User, Taille>("TailleEntreprise"));
        adresse.setCellValueFactory(new PropertyValueFactory<User, String>("mail"));
        description.setCellValueFactory(new PropertyValueFactory<User, String>("description"));
        education.setCellValueFactory(new PropertyValueFactory<User, Diplome>("education"));
        experience.setCellValueFactory(new PropertyValueFactory<User, Experience>("experience"));
        secteur.setCellValueFactory(new PropertyValueFactory<User, String>("nom_domaine"));
        role.setCellValueFactory(new PropertyValueFactory<User, String>("role"));
        ObservableList<User> lu = FXCollections.observableArrayList(su.getalluser());
        table.setItems(lu);
        
        
    }    
    
   @FXML
   
private void onComboBoxSelectionChanged(ActionEvent event) {
    String selectedPage = adduser.getValue();

    try {
        if (selectedPage.equals("Entreprise")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AjoutEntreprise.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            AjoutEntrepriseController controller = loader.getController();
            controller.setRefreshEvent(this);
            
        } else if (selectedPage.equals("Candidat")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AjoutCandidat.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            AjoutCandidatController controller = loader.getController();
           
        } else if (selectedPage.equals("Admin")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AjoutAdmin.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            AjoutAdminController controller = loader.getController();
            // Faites quelque chose avec le contrôleur AjoutAdminController
        }
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}
@FXML
public void onRefresh(){
        nom.setCellValueFactory(new PropertyValueFactory<User, String>("nom"));
        nomentreprise.setCellValueFactory(new PropertyValueFactory<User, String>("NomEntreprise"));
        prenom.setCellValueFactory(new PropertyValueFactory<User, String>("prenom"));
        telephone.setCellValueFactory(new PropertyValueFactory<User, Integer>("numero_telephone"));
        motdepasse.setCellValueFactory(new PropertyValueFactory<User, String>("motdepasse"));
        github.setCellValueFactory(new PropertyValueFactory<User, String>("Github"));
        linkedin.setCellValueFactory(new PropertyValueFactory<User, String>("Linkedin"));
        siteweb.setCellValueFactory(new PropertyValueFactory<User, String>("SiteWeb"));
        taille.setCellValueFactory(new PropertyValueFactory<User, Taille>("TailleEntreprise"));
        adresse.setCellValueFactory(new PropertyValueFactory<User, String>("mail"));
        description.setCellValueFactory(new PropertyValueFactory<User, String>("description"));
        education.setCellValueFactory(new PropertyValueFactory<User, Diplome>("education"));
        experience.setCellValueFactory(new PropertyValueFactory<User, Experience>("experience"));
        secteur.setCellValueFactory(new PropertyValueFactory<User, String>("nom_domaine"));
        role.setCellValueFactory(new PropertyValueFactory<User, String>("role"));
        ObservableList<User> lu = FXCollections.observableArrayList(su.getalluser());
        table.setItems(lu);
}

//public void onComboBoxSelectionChanged(ActionEvent event) throws IOException {
//    
//    String selectedPage = adduser.getValue();
//
//    if (selectedPage.equals("Entreprise")) {
//        
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AjoutEntreprise.fxml"));
//            Parent root = loader.load();
//            
//            
//            Scene scene = add.getScene();
//            scene.setRoot(root);
//
//            AjoutEntrepriseController dpc = loader.getController();
//            
//        
//    }
//    else if(selectedPage.equals("Candidat")){
//         FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AjoutCandidat.fxml"));
//            Parent root = loader.load();
//            
//            
//            Scene scene = adduser.getScene();
//            scene.setRoot(root);
//
//            AjoutCandidatController dpc = loader.getController();
//    }
//    else {
//         FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AjoutAdmin.fxml"));
//            Parent root = loader.load();
//            
//            
//            Scene scene = adduser.getScene();
//            scene.setRoot(root);
//
//            AjoutAdminController dpc = loader.getController();
//    }
//}

    
    
    
}
