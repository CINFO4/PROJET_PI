/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.controller;

import com.esprit.entities.Candidat;
import com.esprit.entities.Diplome;
import com.esprit.entities.Experience;
import com.esprit.entities.Taille;
import com.esprit.entities.User;
import com.esprit.services.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Anis
 */
public class CandidatController implements Initializable, Refresh {

    @FXML
    private TextField txtSearch;
    @FXML
    private Button add;
    @FXML
    private TableColumn<Candidat, String> nom;
    @FXML
    private TableColumn<Candidat, String> prenom;
    @FXML
    private TableColumn<Candidat, String>mail;
    @FXML
    private TableColumn<Candidat, Integer> tele;
    @FXML
    private TableColumn<Candidat, String> description;
    @FXML
    private TableColumn<Candidat, String> education;
    @FXML
    private TableColumn<Candidat, String> experience;
    @FXML
    private TableColumn<Candidat, String> github;
    @FXML
    private TableView<Candidat> table;
    
    ServiceUser su = new ServiceUser();
   
           

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nom.setCellValueFactory(new PropertyValueFactory<Candidat,String>("nom"));
      
        prenom.setCellValueFactory(new PropertyValueFactory<Candidat,String>("prenom"));
        tele.setCellValueFactory(new PropertyValueFactory<Candidat, Integer>("numero_telephone"));
       
        github.setCellValueFactory(new PropertyValueFactory<Candidat,String>("Github"));
        
        
        mail.setCellValueFactory(new PropertyValueFactory<Candidat,String>("mail"));
        description.setCellValueFactory(new PropertyValueFactory<Candidat,String>("description"));
        education.setCellValueFactory(new PropertyValueFactory<Candidat,String>("education"));
        experience.setCellValueFactory(new PropertyValueFactory<Candidat,String>("experience"));
        ObservableList<Candidat> lu = FXCollections.observableArrayList(su.getallcandidat());
        table.setItems(lu);
        table.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
            Candidat selectedUser = table.getSelectionModel().getSelectedItem();
            if (selectedUser != null) {
                try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ModifierCandidat.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            ModifierCandidatController controller = loader.getController();
            controller.initData(selectedUser);}
                catch(Exception e){
                    e.getMessage();
                }
            }   
            }
});
    }    
    @FXML
    public void AjouterCandidat(ActionEvent event) throws IOException {
    

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AjoutCandidat.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            AjoutCandidatController controller = loader.getController();
            controller.setRefreshEvent(this);
      
}

    public void onRefresh(){
        nom.setCellValueFactory(new PropertyValueFactory<Candidat,String>("nom"));
      
        prenom.setCellValueFactory(new PropertyValueFactory<Candidat,String>("prenom"));
        tele.setCellValueFactory(new PropertyValueFactory<Candidat, Integer>("numero_telephone"));
       
        github.setCellValueFactory(new PropertyValueFactory<Candidat,String>("Github"));
        
        
        mail.setCellValueFactory(new PropertyValueFactory<Candidat,String>("mail"));
        description.setCellValueFactory(new PropertyValueFactory<Candidat,String>("description"));
        education.setCellValueFactory(new PropertyValueFactory<Candidat,String>("education"));
        experience.setCellValueFactory(new PropertyValueFactory<Candidat,String>("experience"));
        ObservableList<Candidat> lu = FXCollections.observableArrayList(su.getallcandidat());
        table.setItems(lu);
}
    
    
}
