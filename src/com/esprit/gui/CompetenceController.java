package com.esprit.gui;

// import statements

import com.esprit.entities.Competence;
import com.esprit.services.ServiceCompetence;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class CompetenceController implements Initializable {
    @FXML
    private TableView<Competence> competenceTable;
    @FXML
    private TableColumn<Competence, String> nameColumn;
    @FXML
    private TableColumn<Competence, String> descriptionColumn;
    @FXML
    private TextField nameField;
    @FXML
    private TextArea descriptionArea;
    @FXML
    private Button addButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;
    
    private ServiceCompetence serviceCompetence;
    private ObservableList<Competence> competenceList;

    // Controller methods
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        serviceCompetence = new ServiceCompetence();
        loadCompetences();
        setupTableListener();
        addButton.setOnAction(this::addButtonClicked);
        updateButton.setOnAction(this::updateButtonClicked);
        deleteButton.setOnAction(this::deleteButtonClicked);
    }
    
    private void loadCompetences() {
        competenceList = FXCollections.observableArrayList(serviceCompetence.afficher());
        competenceTable.setItems(competenceList);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
    }
    
    private void setupTableListener() {
        competenceTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                Competence selectedCompetence = competenceTable.getSelectionModel().getSelectedItem();
                nameField.setText(selectedCompetence.getNom());
                descriptionArea.setText(selectedCompetence.getDescription());
            } else {
                nameField.clear();
                descriptionArea.clear();
            }
        });
    }
    
    private void addButtonClicked(ActionEvent event) {
        String name = nameField.getText();
        String description = descriptionArea.getText();
        
        if (!name.isEmpty() && !description.isEmpty()) {
            Competence competence = new Competence(name, description);
            serviceCompetence.ajouter(competence);
            loadCompetences();
            clearFields();
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Please enter a name and description.");
        }
    }
    
    private void updateButtonClicked(ActionEvent event) {
        Competence selectedCompetence = competenceTable.getSelectionModel().getSelectedItem();
        
        if (selectedCompetence != null) {
            String name = nameField.getText();
            String description = descriptionArea.getText();
            
            if (!name.isEmpty() && !description.isEmpty()) {
                selectedCompetence.setNom(name);
                selectedCompetence.setDescription(description);
                serviceCompetence.modifier(selectedCompetence);
                loadCompetences();
                clearFields();
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Please enter a name and description.");
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "No competence selected.");
        }
    }
    
    private void deleteButtonClicked(ActionEvent event) {
        Competence selectedCompetence = competenceTable.getSelectionModel().getSelectedItem();
        
        if (selectedCompetence != null) {
            serviceCompetence.supprimer(selectedCompetence);
            loadCompetences();
            clearFields();
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "No competence selected.");
        }
    }
    
    private void clearFields() {
        nameField.clear();
        descriptionArea.clear();
    }
    
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
