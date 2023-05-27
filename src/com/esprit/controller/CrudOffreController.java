/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.controller;

import com.esprit.entities.Offre;
import com.esprit.services.ServiceDomaine;
import com.esprit.services.ServiceOffre;
import com.esprit.services.ServiceOffre.OffreView;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CrudOffreController implements Initializable {

    @FXML
    private TextField txtTitre;

    @FXML
    private DatePicker datePicker;
    @FXML
    private TextArea txtDescription;

    @FXML
    private Button btnAdd;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TableView<OffreView> tableOffre;
    @FXML
    private TableColumn<OffreView, String> titreCol;
    @FXML
    private TableColumn<OffreView, String> descCol;
    @FXML
    private TableColumn<OffreView,Date > datePubCol;
    @FXML
    private TableColumn<OffreView, Date> dateExpCol;
    @FXML
    private ChoiceBox<String> ChoiseBoxDomaine;
    @FXML
    private TableColumn<OffreView, String> NomDomaineCol;
    @FXML
    private Button btnAff;
    @FXML
    private TableColumn<OffreView, String> NomEntCol;
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table();
        ServiceDomaine sd = new ServiceDomaine();
        ChoiseBoxDomaine.getItems().addAll(sd.getDomainesName());
    }    

    @FXML
    private void selectDate(ActionEvent event) {
    }

    @FXML
    private void add(ActionEvent event) {
        ServiceOffre sf = new ServiceOffre();
        ServiceDomaine sd = new ServiceDomaine();
        sf.ajouter(new Offre(txtTitre.getText(), txtDescription.getText(),sd.getIdDomaineByName(ChoiseBoxDomaine.getValue()),2, Date.valueOf(datePicker.getValue())));
        JOptionPane.showMessageDialog(null, "offre ajouter !");
        table();
    }
    
    
    Integer index;
        
    
    
    @FXML
    private void update(ActionEvent event) throws IOException {
        
        index = tableOffre.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            JOptionPane.showMessageDialog(null,"il faut selectionner une ligne !");
        }else{
            ServiceDomaine sd = new ServiceDomaine();
            FXMLLoader loader =new FXMLLoader(getClass().getResource("../gui/UpdateOffre.fxml"));
            Parent root = loader.load();
            UpdateOffreController uoc = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
            
            uoc.setTxtDescription(descCol.getCellData(index));
            uoc.setTxtTitre(titreCol.getCellData(index));
            uoc.setChoiseBoxDomaine();
            uoc.setComboBoxDomaine();
            uoc.setDatePickerPub(Date.valueOf(datePubCol.getCellData(index).toString()));
            uoc.setDatePickerExp(Date.valueOf(dateExpCol.getCellData(index).toString()));
            uoc.setOffreController(this);
            uoc.setStage(stage);
            
           
        }
       
    }
    

    @FXML
    private void delete(ActionEvent event) {
        int index;
        index = tableOffre.getSelectionModel().getSelectedIndex();
        int id = Integer.parseInt(String.valueOf(tableOffre.getItems().get(index).getId_offre()));
        ServiceOffre sf = new ServiceOffre();
        sf.supprimerParId(id);
        JOptionPane.showMessageDialog(null, "offre supprimer !");
        table();
    }
    
    public void table(){
        
         ServiceOffre sf = new ServiceOffre();
        
        ObservableList<OffreView> listOffres = observableArrayList(sf.afficherOffres());
        System.out.println(listOffres);
        
        NomEntCol.setCellValueFactory(new PropertyValueFactory<OffreView,String>("nomEntreprise"));
        titreCol.setCellValueFactory(new PropertyValueFactory<OffreView,String>("titre"));
        descCol.setCellValueFactory(new PropertyValueFactory<OffreView,String>("description"));
        NomDomaineCol.setCellValueFactory(new PropertyValueFactory<OffreView,String>("nomDomaine"));
        datePubCol.setCellValueFactory(new PropertyValueFactory<OffreView,Date>("date_pub"));
        dateExpCol.setCellValueFactory(new PropertyValueFactory<OffreView,Date>("date_Exp"));
        tableOffre.setItems(listOffres);
    }

    @FXML
    private void AfficherOffre(ActionEvent event) throws IOException {
//        index = tableOffre.getSelectionModel().getSelectedIndex();
//        if (index <= -1) {
//            JOptionPane.showMessageDialog(null,"il faut selectionner une ligne !");
//        }else{
//            ServiceDomaine sd = new ServiceDomaine();
//            
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("OffreDetails.fxml"));
//            Parent root = loader.load();
//            Scene scene = new Scene(root);
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            
//            OffreDetailsController odc = loader.getController();
//            odc.setLNomEntreprise(idCol.getCellData(index).toString());
//            odc.setLDesc(descCol.getCellData(index).toString());
//            odc.setLTitle(titreCol.getCellData(index).toString());
//            odc.setLNomDomaine(sd.getNameDomaineById(NomDomaineCol.getCellData(index)));
//            odc.setLDatePub(datePubCol.getCellData(index).toString());
//            odc.setLDateExp(dateExpCol.getCellData(index).toString());
//            
//            
//            
//            
//            stage.show();
//           
//        }
        
    }
    
    

    
    
}
