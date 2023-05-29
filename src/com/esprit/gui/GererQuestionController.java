/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;
import com.esprit.entities.Question;
import com.esprit.entities.proposition;
import com.esprit.services.ServiceProposition;
import com.esprit.services.ServiceQuestion;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;


public class GererQuestionController implements Initializable {


    @FXML
    private TextField tfLibelle;
    @FXML
    private RadioButton rdActive;
    @FXML
    private ToggleGroup etat;
    @FXML
    private RadioButton rdDesactive;
    @FXML
    private TextField tfpro1;
    @FXML
    private TextField tfpro2;
    @FXML
    private TextField tfpro3;
    @FXML
    private TextField tfpro4;
    @FXML
    private RadioButton rdV1;
    @FXML
    private ToggleGroup etat1;
    @FXML
    private RadioButton rdV2;
    @FXML
    private ToggleGroup etat3;
    @FXML
    private RadioButton rdV3;
    @FXML
    private ToggleGroup etat4;
    @FXML
    private RadioButton rdV4;
    @FXML
    private ToggleGroup etat5;
    @FXML
    private RadioButton rdF1;
    @FXML
    private RadioButton rdF2;
    @FXML
    private RadioButton rdF3;
    @FXML
    private RadioButton rdF4;
    @FXML
    private TableView<Question> information;
    @FXML
    private TableColumn<Question, String> collibelle;
    @FXML
    private TableColumn<Question, String> coletat;
    @FXML
    private TableColumn<Question, Integer> colid_c;
   
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AfficherQuestion();
    }    
    
    
    public void AfficherQuestion() {
    ServiceQuestion serviceQuestion = new ServiceQuestion();
    ObservableList<Question> questionList = FXCollections.observableArrayList(serviceQuestion.afficher()) ;
    information.setItems(questionList);
    collibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
    coletat.setCellValueFactory(new PropertyValueFactory<>("etat_question"));
    colid_c.setCellValueFactory(new PropertyValueFactory<>("id_c"));
    }
    
    
    @FXML
    private void ajouterQuestion(ActionEvent event) {
        /** String libelle = tfLibelle.getText();

        // Créer une nouvelle instance de la classe Question
        Question question = new Question(0, libelle, valid, 1);

        // Ajouter les propositions à la question
        question.ajouterProposition(new Proposition(0, tfpro1.getText(), rdV1.isSelected(), question.getId_question()));
        question.ajouterProposition(new Proposition(0, tfpro2.getText(), rdV2.isSelected(), question.getId_question()));
        question.ajouterProposition(new Proposition(0, tfpro3.getText(), rdV3.isSelected(), question.getId_question()));
        question.ajouterProposition(new Proposition(0, tfpro4.getText(), rdV4.isSelected(), question.getId_question()));

        // Ajouter la question à la liste ou effectuer toute autre action souhaitée
        // listViewQuestions.getItems().add(question);

        // Effacer les champs de saisie après l'ajout
        tfLibelle.clear();
        tfpro1.clear();
        tfpro2.clear();
        tfpro3.clear();
        tfpro4.clear();
        */
    }

    @FXML
    private void modifierQuestion(ActionEvent event) {
    }

    @FXML
    private void supprimerQuestion(ActionEvent event) {
    }

   

}
