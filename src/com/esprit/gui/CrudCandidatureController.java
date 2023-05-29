/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.Candidature;
import com.esprit.entities.Domaine;
import com.esprit.entities.EtatCandidature;
import com.esprit.services.ServiceCandidature;
import com.esprit.services.ServiceCandidature.CandidatureDetails;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import static javafx.scene.input.KeyCode.S;
import javafx.util.Callback;
import javafx.util.converter.DefaultStringConverter;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CrudCandidatureController implements Initializable {

    @FXML
    private TableView<CandidatureDetails> tableCandidature;
    @FXML
    private TableColumn<CandidatureDetails, String> dateCol;
    @FXML
    private TableColumn<CandidatureDetails, String> nomCol;
    @FXML
    private TableColumn<CandidatureDetails, String> prenomCol;
    @FXML
    private TableColumn<CandidatureDetails, String> entrepriseCol;
    @FXML
    private TableColumn<CandidatureDetails, String> posteCol;
    @FXML
    private TableColumn<CandidatureDetails, String>domaineCol;
    @FXML
    private TableColumn<CandidatureDetails, EtatCandidature> etatCol;
    ServiceCandidature sc = new ServiceCandidature();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        tableCandidature.setEditable(true);
        nomCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nomCol.setOnEditCommit(this::EditNom);
//        
//        dateCol.setCellFactory(TextFieldTableCell.forTableColumn());
//        dateCol.setOnEditCommit(this::editDate);
//        
//        etatCol.setCellFactory(TextFieldTableCell.forTableColumn(etatCol));
//        dateCol.setOnEditCommit(this::);
        refreshTable();
        
       
    }    
    
    
    public void refreshTable(){
        ObservableList<CandidatureDetails> listCandidature = (ObservableList<CandidatureDetails>) FXCollections.observableArrayList(sc.candidatureDetails());
        tableCandidature.setItems(listCandidature);
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date_condidature"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom_user"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom_user"));
        entrepriseCol.setCellValueFactory(new PropertyValueFactory<>("nom_entreprise"));
        posteCol.setCellValueFactory(new PropertyValueFactory<>("titreoffre"));
        domaineCol.setCellValueFactory(new PropertyValueFactory<>("nom_domaine"));
        etatCol.setCellValueFactory(new PropertyValueFactory<>("etat"));
        tableCandidature.setEditable(true);
       
    }

//    private void onEditChange(TableColumn.CellEditEvent<CandidatureDetails, String> eventCandidature) {
//        CandidatureDetails candidature  = tableCandidature.getSelectionModel().getSelectedItem();
//        candidature.setNom_user(eventCandidature.getNewValue());
//    }

    @FXML
    private void editDate(CellEditEvent event) {
        
    }

    private void EditNom(CellEditEvent event) {
          CandidatureDetails candidature = tableCandidature.getSelectionModel().getSelectedItem();
        candidature.setNom_user(event.getNewValue().toString());
        
    }

    @FXML
    private void editEtat(CellEditEvent even) {
          CandidatureDetails candidature = tableCandidature.getSelectionModel().getSelectedItem();
        
    }

    @FXML
    private void supprimerCandidature(ActionEvent event) {
        int index = tableCandidature.getSelectionModel().getSelectedIndex();
        int id_user = tableCandidature.getItems().get(index).getId_user();
        int id_can = tableCandidature.getItems().get(index).getId_candidature();
        int id_offre = tableCandidature.getItems().get(index).getId_offre();
        Date date_condidature = tableCandidature.getItems().get(index).getDate_condidature();
        EtatCandidature etat =tableCandidature.getItems().get(index).getEtat();
        if(index <= -1){
            JOptionPane.showMessageDialog(null, "selectionner une candidature  !");
        }else{
            int result = JOptionPane.showConfirmDialog(null, "vouler vous supprimer cet Candidature ?","Confirmation",JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION){
                sc.supprimer(new Candidature(id_user, id_offre,  id_can, date_condidature, etat));
                refreshTable();
              
            }else{
                return ;
            }
        }
    }

    @FXML
    private void refuser(ActionEvent event) {
        int index = tableCandidature.getSelectionModel().getSelectedIndex();
        if(index <0){
            JOptionPane.showMessageDialog(null, "selectionner une candidature  !");
        }else{
            int id_user = tableCandidature.getItems().get(index).getId_user();
            int id_can = tableCandidature.getItems().get(index).getId_candidature();
            int id_offre = tableCandidature.getItems().get(index).getId_offre();
            Date date_condidature = tableCandidature.getItems().get(index).getDate_condidature();
            
            int result = JOptionPane.showConfirmDialog(null, "vouler vous Accepter ce candidat ?","Confirmation",JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION){
            sc.modifier(new Candidature(id_user, id_offre, id_can, date_condidature, EtatCandidature.Refuser));
              JOptionPane.showMessageDialog(null, "Candidat refuser  !");
              refreshTable();
            }else{
                return ;
            }
        }
        
    }

    @FXML
    private void accpeter(ActionEvent event) {      
        int index = tableCandidature.getSelectionModel().getSelectedIndex();
        if(index < 0){
            JOptionPane.showMessageDialog(null, "selectionner une candidature  !");
        }else{
            
            int id_user = tableCandidature.getItems().get(index).getId_user();
            int id_can = tableCandidature.getItems().get(index).getId_candidature();
            int id_offre = tableCandidature.getItems().get(index).getId_offre();
            Date date_condidature = tableCandidature.getItems().get(index).getDate_condidature();
            int result = JOptionPane.showConfirmDialog(null, "vouler vous refuser ce candidat ?","Confirmation",JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION){
               sc.modifier(new Candidature(id_user, id_offre, id_can, date_condidature, EtatCandidature.Accepter));
              JOptionPane.showMessageDialog(null, "Candidat Accepter  !");
              refreshTable();
            }else{
                return ;
            }
        }
    }

  
    
 
    
    
}
