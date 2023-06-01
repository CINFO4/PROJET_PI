/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.controller;

import com.esprit.entities.Domaine;
import com.esprit.services.ServiceDomaine;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CrudDomaineController implements Initializable {

    @FXML
    private TableView<Domaine> tableDomaine;
    
    @FXML
    private TableColumn<Domaine, String> domaineCol;
    @FXML
    private TextField TFnomDomaine;
    ServiceDomaine sd = new ServiceDomaine();
    @FXML
    private Button btnAjout;
    @FXML
    private Button btnSupp;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tableDomaine.setEditable(true);
        domaineCol.setCellFactory(TextFieldTableCell.forTableColumn());
        domaineCol.setOnEditCommit(this::OnEditDomaineName);
        Refreshtable();
    }    

    

    @FXML
    private void ajouterDomaine(ActionEvent event) {
        
        if(TFnomDomaine.getText().equals("")){
            JOptionPane.showMessageDialog(null, "donner le nom du domaine  !");
        }else{
            int result = JOptionPane.showConfirmDialog(null, "vouler vous ajouter un domaine ?","Confirmation",JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION){
                sd.ajouter(new Domaine(TFnomDomaine.getText()));
                JOptionPane.showMessageDialog(null, "Domaine Ajouter !");
                Refreshtable();
            }else{
                return ;
            }
        }
   
    }

    

    @FXML
    private void supprimerDomaine(ActionEvent event) {
        int index = tableDomaine.getSelectionModel().getSelectedIndex();
        
        if(index <= 0){
            JOptionPane.showMessageDialog(null, "selectionner un domaine  !");
        }else{
            int result = JOptionPane.showConfirmDialog(null, "vouler vous supprimer un domaine ?","Confirmation",JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION){
                int id = tableDomaine.getItems().get(index).getId_domaine();
                String nom = tableDomaine.getItems().get(index).getNom_domaine();
                sd.supprimer(new Domaine(id, nom));
                JOptionPane.showMessageDialog(null, "Domaine Supprimer !");
                Refreshtable();
            }else{
                return ;
            }
        }

    }
    
    public void Refreshtable(){
        ObservableList<Domaine> listDomaine = FXCollections.observableArrayList(sd.afficher());
        tableDomaine.setItems(listDomaine);
        domaineCol.setCellValueFactory(new PropertyValueFactory<>("nom_domaine"));
    }


    @FXML
    private void OnEditDomaineName(CellEditEvent event) {
        Domaine d = tableDomaine.getSelectionModel().getSelectedItem();
        int result = JOptionPane.showConfirmDialog(null, "vouler vous modifier un domaine ?","Confirmation",JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION){
                d.setNom_domaine(event.getNewValue().toString());
                sd.modifier(d);
            }else{
                d.setNom_domaine(event.getOldValue().toString());
                Refreshtable();
            }
        
        
        
    }
    
}
