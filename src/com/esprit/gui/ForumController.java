package com.esprit.gui;

import com.esprit.entities.Domaine;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.esprit.entities.Forum;
import com.esprit.services.ServiceForum;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

public class ForumController {

    @FXML
    private ListView<Forum> forumListView;

    @FXML
    private TextField sujetTextField;

    @FXML
    private TextArea contenuTextArea;

    @FXML
    private ChoiceBox<Domaine> domaineChoiceBox; // Added

    private ServiceForum serviceForum;

    private Forum selectedForum;

    public ForumController() {
        serviceForum = new ServiceForum();
    }

    @FXML
    public void initialize() {
        loadForums();
        loadDomainNames(); // Added

        forumListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        selectedForum = newValue;
                        displayForumDetails(newValue);
                    }
                }
        );
    }

    @FXML
    private void createForum(ActionEvent event) throws IOException {
        String sujet = sujetTextField.getText();
        String contenu = contenuTextArea.getText();
        Domaine selectedDomaine = domaineChoiceBox.getValue(); // Added

        if (sujet.isEmpty() || contenu.isEmpty() || selectedDomaine == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attention");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs !");
            alert.showAndWait();
            return;
        }

        Forum forum = new Forum(sujet, contenu, 1, selectedDomaine.getId_domaine());
        serviceForum.ajouter(forum);

        loadForums();
        clearFields();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succès");
        alert.setHeaderText(null);
        alert.setContentText("Forum créé avec succès !");
        alert.showAndWait();
    }

    @FXML
    private void deleteForum(ActionEvent event) throws IOException {
        Forum selectedForum = forumListView.getSelectionModel().getSelectedItem();

        if (selectedForum != null) {
            serviceForum.supprimer(selectedForum);

            loadForums();
            clearFields();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès");
            alert.setHeaderText(null);
            alert.setContentText("Forum supprimé avec succès !");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attention");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner un forum !");
            alert.showAndWait();
        }
    }

    @FXML
    private void modifyForum(ActionEvent event) throws IOException {
        if (selectedForum != null) {
            String sujet = sujetTextField.getText();
            String contenu = contenuTextArea.getText();
            Domaine selectedDomaine = domaineChoiceBox.getValue();

            if (sujet.isEmpty() || contenu.isEmpty() || selectedDomaine == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Attention");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez remplir tous les champs !");
                alert.showAndWait();
                return;
            }

            selectedForum.setSujet(sujet);
            selectedForum.setContenu(contenu);
            selectedForum.setId_domaine(selectedDomaine.getId_domaine());

            serviceForum.modifier(selectedForum);

            loadForums();
            clearFields();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès");
            alert.setHeaderText(null);
            alert.setContentText("Forum modifié avec succès !");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attention");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner un forum !");
            alert.showAndWait();
        }
    }

    private void loadForums() {
        forumListView.getItems().clear();
        forumListView.getItems().addAll(serviceForum.afficher());
    }

    private void loadDomainNames() {
        domaineChoiceBox.setItems(FXCollections.observableArrayList(serviceForum.getDomaines()));
    }

    private void displayForumDetails(Forum forum) {
        sujetTextField.setText(forum.getSujet());
        contenuTextArea.setText(forum.getContenu());
        domaineChoiceBox.setValue(serviceForum.getDomainById(forum.getId_domaine()));
    }

    private void clearFields() {
        sujetTextField.clear();
        contenuTextArea.clear();
        domaineChoiceBox.getSelectionModel().clearSelection();
    }
}
