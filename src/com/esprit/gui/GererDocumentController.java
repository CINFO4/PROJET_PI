package com.esprit.gui;

import com.esprit.entities.Document;
import com.esprit.services.ServiceGererDocument;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.beans.property.ReadOnlyObjectWrapper;

import java.net.URL;
import java.util.ResourceBundle;

public class GererDocumentController implements Initializable {

    @FXML
    private TextField txtTitre;

    @FXML
    private ChoiceBox<String> choiceType;

    @FXML
    private TextField txtLien;

    @FXML
    private TextField txtDescription;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClear;

    @FXML
    private TableView<Document> tableDocument;

    @FXML
    private TableColumn<Document, String> titreCol;

    @FXML
    private TableColumn<Document, String> typeCol;

    @FXML
    private TableColumn<Document, String> lienCol;

    @FXML
    private TableColumn<Document, String> descCol;

    @FXML
    private Button btnDelete;

    private ServiceGererDocument service;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize your choice box with values
        ObservableList<String> typeOptions = FXCollections.observableArrayList(
                "Type 1", "Type 2", "Type 3");
        choiceType.setItems(typeOptions);

        // Initialize your table columns
     titreCol.setCellValueFactory(data -> new ReadOnlyObjectWrapper<>(data.getValue().getTitre_document()));
typeCol.setCellValueFactory(data -> new ReadOnlyObjectWrapper<>(data.getValue().getType()));
lienCol.setCellValueFactory(data -> new ReadOnlyObjectWrapper<>(data.getValue().getLien()));
descCol.setCellValueFactory(data -> new ReadOnlyObjectWrapper<>(data.getValue().getDescription_document()));


        // Initialize your service
        service = new ServiceGererDocument();

        // Load documents into the table
        loadDocuments();
    }

    @FXML
    void handleAdd(ActionEvent event) {
        String titre = txtTitre.getText();
        String type = choiceType.getValue();
        String lien = txtLien.getText();
        String description = txtDescription.getText();

        Document document = new Document();
        document.setTitre_document(titre);
        document.setType(type);
        document.setLien(lien);
        document.setDescription_document(description);

        // Call your service to add the document
        service.ajouter(document);

        // Clear input fields and reload the documents
        clearFields();
        loadDocuments();
    }

    @FXML
    void handleClear(ActionEvent event) {
        clearFields();
    }

    @FXML
    void handleDelete(ActionEvent event) {
        Document selectedDocument = tableDocument.getSelectionModel().getSelectedItem();
        if (selectedDocument != null) {
            // Call your service to delete the selected document
            service.supprimer(selectedDocument);

            // Reload the documents
            loadDocuments();
        }
    }

    private void loadDocuments() {
        // Call your service to retrieve the documents
        ObservableList<Document> documents = FXCollections.observableArrayList(service.afficher());

        // Load the documents into the table
        tableDocument.setItems(documents);
    }

    private void clearFields() {
        txtTitre.clear();
        choiceType.getSelectionModel().clearSelection();
        txtLien.clear();
        txtDescription.clear();
    }
}
