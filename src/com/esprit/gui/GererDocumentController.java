package com.esprit.gui;

import com.esprit.entities.Document;
import com.esprit.services.ServiceGererDocument;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.paint.Color;

public class GererDocumentController implements Initializable {

    @FXML
    private TextField txtTitre;

    @FXML
    private TextField txtUserId;

    @FXML
    private ChoiceBox<String> choiceType;

    @FXML
    private TextField txtLien;

    @FXML
    private TableView<Document> tblDocuments;

    @FXML
    private TableColumn<Document, String> colTitre;

    @FXML
    private TableColumn<Document, String> colUserId;

    @FXML
    private TableColumn<Document, String> colType;

    @FXML
    private TableColumn<Document, String> colLien;

    @FXML
    private Button btnSupprimer;

    private ObservableList<Document> documentsList;
    private ServiceGererDocument serviceGererDocument;
    @FXML
    private Color linearGradientEnd;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnModifier;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadChoiceBox();
        refresh();

        tblDocuments.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                Document selectedDocument = tblDocuments.getSelectionModel().getSelectedItem();
                txtTitre.setText(selectedDocument.getTitre_document());
                txtUserId.setText(String.valueOf(selectedDocument.getId_user()));
                choiceType.getSelectionModel().select(selectedDocument.getType());
                txtLien.setText(selectedDocument.getLien());
            }
        });
    }

    @FXML
    void ajouter(ActionEvent event) {
        String titre = txtTitre.getText();
        String description = "";
        String type = choiceType.getValue();
        String lien = txtLien.getText();
        int userId = Integer.parseInt(txtUserId.getText());

//        if (titre.isEmpty() || type.isEmpty() || lien.isEmpty()) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("Warning");
//            alert.setHeaderText(null);
//            alert.setContentText("Please fill in all the fields");
//            alert.showAndWait();
//            return;
//        }

       // Create a new Document instance
Document document = new Document();
document.setTitre_document(titre);
document.setDescription_document(description);
document.setType(type);
document.setLien(lien);
document.setId_user(userId);
ServiceGererDocument sd= new ServiceGererDocument();

sd.ajouter(document);
refresh();
    }
    
  
    
    

    @FXML
    void modifier(ActionEvent event) {
        Document selectedDocument = tblDocuments.getSelectionModel().getSelectedItem();
        if (selectedDocument != null) {
            String titre = txtTitre.getText();
            String description = "";
            String type = choiceType.getValue();
            String lien = txtLien.getText();
            int userId = Integer.parseInt(txtUserId.getText());

            if (titre.isEmpty() || type.isEmpty() || lien.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please fill in all the fields");
                alert.showAndWait();
                return;
            }

            selectedDocument.setTitre_document(titre);
            selectedDocument.setDescription_document(description);
            selectedDocument.setType(type);
            selectedDocument.setLien(lien);
            selectedDocument.setId_user(userId);

            serviceGererDocument.modifier(selectedDocument);
            tblDocuments.refresh();
            clearFields();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please select a document to edit");
            alert.showAndWait();
        }
    }

    @FXML
    void supprimer(ActionEvent event) {
        Document selectedDocument = tblDocuments.getSelectionModel().getSelectedItem();
        if (selectedDocument != null) {
            serviceGererDocument.supprimer(selectedDocument);
            documentsList.remove(selectedDocument);
            clearFields();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please select a document to delete");
            alert.showAndWait();
        }
    }

    private void loadChoiceBox() {
        ObservableList<String> types = FXCollections.observableArrayList("Type 1", "Type 2", "Type 3");
        choiceType.setItems(types);
    }

    private void clearFields() {
        txtTitre.clear();
        txtUserId.clear();
        choiceType.getSelectionModel().clearSelection();
        txtLien.clear();
    }
    
    public void refresh(){
        
       serviceGererDocument = new ServiceGererDocument();
       
        colTitre.setCellValueFactory(new PropertyValueFactory<>("titre_document"));
        colUserId.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colLien.setCellValueFactory(new PropertyValueFactory<>("lien"));

        documentsList = FXCollections.observableArrayList(serviceGererDocument.afficher());
        tblDocuments.setItems(documentsList);
    }
}
