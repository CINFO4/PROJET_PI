/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;
import com.esprit.entities.Question;
import com.esprit.entities.proposition;
import com.esprit.entities.Competence;
import com.esprit.services.ServiceProposition;
import com.esprit.services.ServiceQuestion;
import com.esprit.services.ServiceCompetence;
import com.esprit.services.ServiceQuestion.QuestionView;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;


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
    private TableView<QuestionView> information;
    @FXML
    private TableColumn<QuestionView, String> collibelle;
    @FXML
    private TableColumn<QuestionView, String> coletat;
    @FXML
    private TableColumn<QuestionView, String> colnomc;
    @FXML
    private Button btAjouter;
    @FXML
    private Button btModifier;
    @FXML
    private Button btSupprimer;
    @FXML
    private ListView<String> listcompetence;
    
   
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AfficherQuestion();
        refresh();
        
    }    
    
    
    public void AfficherQuestion() {
    ServiceQuestion serviceQuestion = new ServiceQuestion();
    ServiceCompetence sc = new ServiceCompetence();
    listcompetence.setItems(FXCollections.observableArrayList(sc.affichercompetencebynom()));
    listcompetence.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    ObservableList<QuestionView> questionList = FXCollections.observableArrayList(serviceQuestion.afficherQuestionView()) ;
    information.setItems(questionList);
    collibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
    coletat.setCellValueFactory(new PropertyValueFactory<>("etat_question"));
    colnomc.setCellValueFactory(new PropertyValueFactory<>("nomc"));
    }
    
    
    @FXML
    private void ajouterQuestion(ActionEvent event) {
        ServiceQuestion sq = new ServiceQuestion();
        ServiceProposition sp = new ServiceProposition();
        
        String etatProposition1;
    if (rdV1.isSelected()) {
        etatProposition1 = "vrai";
    } else if (rdF1.isSelected()) {
        etatProposition1 = "faux";
    } else {
        return;
    }
    
     String etatProposition2;
    if (rdV2.isSelected()) {
        etatProposition2 = "vrai";
    } else if (rdF2.isSelected()) {
        etatProposition2 = "faux";
    } else {
        return;
    }
    
     String etatProposition3;
    if (rdV3.isSelected()) {
        etatProposition3 = "vrai";
    } else if (rdF3.isSelected()) {
        etatProposition3 = "faux";
    } else {
        return;
    }
    
     String etatProposition4;
    if (rdV4.isSelected()) {
        etatProposition4 = "vrai";
    } else if (rdF1.isSelected()) {
        etatProposition4 = "faux";
    } else {
        return;
    }
    
      String etatQuestion;
    if (rdActive.isSelected()) {
        etatQuestion = "Active";
    } else if (rdDesactive.isSelected()) {
        etatQuestion = "Desactive";
    } else {
        return;
    }
    
        int index = listcompetence.getSelectionModel().getSelectedIndex();
        String n = listcompetence.getItems().get(index).toString();
        ServiceCompetence sc = new ServiceCompetence();
        Question q = new Question(tfLibelle.getText(), etatQuestion,sc.Getidcompetencebynom(n));
        sq.ajouter(q);
        
        int id_q = sq.GetidQuestionbynom(q.getLibelle());
        sp.ajouter(new proposition(tfpro1.getText(), etatProposition1,id_q));
        sp.ajouter(new proposition(tfpro2.getText(), etatProposition2,id_q));
        sp.ajouter(new proposition(tfpro3.getText(), etatProposition3,id_q));
        sp.ajouter(new proposition(tfpro4.getText(), etatProposition4,id_q));
        JOptionPane.showMessageDialog(null, "Question Ajoutée !");
        tfLibelle.clear();
        tfpro1.clear();
        tfpro2.clear();
        tfpro3.clear();
        tfpro4.clear();
        refresh();
    }

    @FXML
    private void modifierQuestion(ActionEvent event) {
    }

    @FXML
    private void supprimerQuestion(ActionEvent event) {
    }

   public void refresh(){
    ServiceQuestion serviceQuestion = new ServiceQuestion();
               
    collibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
    coletat.setCellValueFactory(new PropertyValueFactory<>("etat_question"));
    colnomc.setCellValueFactory(new PropertyValueFactory<>("nomc"));
    ObservableList<QuestionView> questionList = FXCollections.observableArrayList(serviceQuestion.afficherQuestionView()) ;
    information.setItems(questionList);
   }

}
