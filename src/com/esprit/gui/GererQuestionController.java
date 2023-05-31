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
//import java.awt.Insets;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
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
        information.setOnMouseClicked(event -> {
        if (event.getClickCount() == 2) {
            modifierQuestion();
        }
    });
}
        
     
    
    
    public void AfficherQuestion() {
    ServiceQuestion serviceQuestion = new ServiceQuestion();
    ServiceProposition serviceProposition = new ServiceProposition();
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
    private void modifierQuestion() {
        
     QuestionView selectedQuestion = information.getSelectionModel().getSelectedItem();
    if (selectedQuestion != null) {
        // Afficher une boîte de dialogue pour modifier la question
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Modifier la question");
        dialog.setHeaderText(null);

        // Créer les champs de saisie pour les nouveaux valeurs de la question
        TextField tfLibelle = new TextField(selectedQuestion.getLibelle());
        RadioButton rdActive = new RadioButton("Active");
        RadioButton rdDesactive = new RadioButton("Desactive");
        ToggleGroup etat = new ToggleGroup();
        rdActive.setToggleGroup(etat);
        rdDesactive.setToggleGroup(etat);

        // Pré-sélectionner l'état de la question
        if (selectedQuestion.getEtat_question().equals("Active")) {
            rdActive.setSelected(true);
        } else if (selectedQuestion.getEtat_question().equals("Desactive")) {
            rdDesactive.setSelected(true);
        }

        // Créer le bouton de confirmation
        ButtonType btnModifier = new ButtonType("Modifier", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(btnModifier, ButtonType.CANCEL);

        // Ajouter les champs de saisie à la boîte de dialogue
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        // Utiliser javafx.geometry.Insets
        gridPane.setPadding(new Insets(20, 150, 10, 10));
        gridPane.add(new Label("Libelle:"), 0, 0);
        gridPane.add(tfLibelle, 1, 0);
        gridPane.add(new Label("Etat:"), 0, 1);
        gridPane.add(rdActive, 1, 1);
        gridPane.add(rdDesactive, 2, 1);
        dialog.getDialogPane().setContent(gridPane);

        // Activer le bouton de confirmation uniquement si le libellé est saisi
        Node btnModifierNode = dialog.getDialogPane().lookupButton(btnModifier);
        btnModifierNode.setDisable(true);
        tfLibelle.textProperty().addListener((observable, oldValue, newValue) -> {
            btnModifierNode.setDisable(newValue.trim().isEmpty());
        });

        // Récupérer les nouveaux valeurs de la question et les appliquer
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == btnModifier) {
                String libelle = tfLibelle.getText().trim();
                String etatQuestion = rdActive.isSelected() ? "Active" : "Desactive";
                Question modifiedQuestion = new Question(
                selectedQuestion.getId_question(),
                libelle,
                etatQuestion,
                selectedQuestion.getId_c()
        );

      return dialogButton;
            }
            return null;
       });

        // Afficher la boîte de dialogue et mettre à jour la question si les modifications sont confirmées
       Optional<ButtonType> result = dialog.showAndWait();
         result.ifPresent(dialogButton -> {
            if (dialogButton == btnModifier) {
            ServiceQuestion serviceQuestion = new ServiceQuestion();
            QuestionView modifiedQuestion = information.getSelectionModel().getSelectedItem();
                 if (modifiedQuestion != null) {
                      Question q = new Question(
                         modifiedQuestion.getId_question(),
                         modifiedQuestion.getLibelle(),
                         modifiedQuestion.getEtat_question(),
                         modifiedQuestion.getId_c()
                        );
        serviceQuestion.modifier(q);
            refresh();
                 }
             }
    });
              
                 } }              
   
          
    @FXML
    private void supprimerQuestion(ActionEvent event) {
        
         QuestionView selectedQuestion = information.getSelectionModel().getSelectedItem();
    if (selectedQuestion != null) {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppression");
        alert.setHeaderText("Supprimer la question et ses propositions ?");
        alert.setContentText("Êtes-vous sûr de vouloir supprimer cette question et toutes ses propositions ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
        ServiceQuestion serviceQuestion = new ServiceQuestion();
        ServiceProposition serviceProposition = new ServiceProposition();
        Question q = new Question(selectedQuestion.getId_question(), selectedQuestion.getLibelle(), selectedQuestion.getEtat_question(), selectedQuestion.getId_c());
        serviceProposition.supprimer(selectedQuestion.getId_question());
        serviceQuestion.supprimer(q);
        refresh();
    }
        
    }
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
