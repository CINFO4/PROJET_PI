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
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.util.Callback;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;


public class GererQuestionController implements Initializable {


    @FXML
    private TextField tfLibelle;
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
    private ListView<String> listcompetence;
    @FXML
    private ComboBox<String> filterbox;
    @FXML
    private ToggleGroup etat2;
    @FXML
    private TableColumn<QuestionView, Void> colSupprimer;
   
   
   
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    

 @Override
public void initialize(URL url, ResourceBundle rb) {
    ServiceCompetence sc = new ServiceCompetence();
    filterbox.getItems().add("All");
    filterbox.getItems().addAll(FXCollections.observableArrayList(sc.affichercompetencebynom()));
    filterbox.setOnAction(this::filterQuestions);
    AfficherQuestion();

    information.setOnMouseClicked(event -> {

    if (event.getClickCount() == 2) {
            Details(event);
        }
    });
 initializeTableCellFactory();
    refresh();
}
    
          
         private void initializeTableCellFactory() {
    colSupprimer.setCellFactory(column -> {
    return new TableCell<QuestionView, Void>() {
        private final Button deleteButton = new Button();

        {
            deleteButton.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.TRASH));
            Tooltip tooltip = new Tooltip("Supprimer"); 
            Tooltip.install(deleteButton, tooltip);
            deleteButton.setOnAction(event -> {
                
                QuestionView question = getTableView().getItems().get(getIndex());
                supprimerQuestion(event);
            });
        }

        @Override
        protected void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setGraphic(null);
            } else {
                setGraphic(deleteButton);
            }
        }
    };
});

         }
                    
    private void filterQuestions(ActionEvent event) {
       ServiceQuestion serviceQuestion = new ServiceQuestion();
    String selectedCompetence = filterbox.getValue();
    
    if (selectedCompetence.equals("All")) {
        AfficherQuestion();
    } else {
        
        List<QuestionView> filteredQuestions = serviceQuestion.afficherQuestionViewByCom(selectedCompetence);
        ObservableList<QuestionView> questionList = FXCollections.observableArrayList(filteredQuestions);
        information.setItems(questionList);
    }
}
    
    public void AfficherQuestion() {
    ServiceQuestion serviceQuestion = new ServiceQuestion();
    ServiceProposition serviceProposition = new ServiceProposition();
    ServiceCompetence sc = new ServiceCompetence();
    listcompetence.setItems(FXCollections.observableArrayList(sc.affichercompetencebynom()));
    listcompetence.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    ObservableList<QuestionView> questionList = FXCollections.observableArrayList(serviceQuestion.afficherQuestionView()) ;
    ObservableList<proposition> propositionList = FXCollections.observableArrayList(serviceProposition.afficher()) ;
    information.setItems(questionList);
    collibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
    coletat.setCellValueFactory(new PropertyValueFactory<>("etat_question"));
    colnomc.setCellValueFactory(new PropertyValueFactory<>("nomc"));
  
    

    }
    
    
    
    @FXML
    private void ajouterQuestion(ActionEvent event) {
        ServiceQuestion sq = new ServiceQuestion();
        ServiceProposition sp = new ServiceProposition();
        String etatProposition1 ="vrai";
        String etatProposition2 ="vrai";
        String etatProposition3 ="vrai";
        String etatProposition4 ="vrai";
        if (tfLibelle.getText().isEmpty() || listcompetence.getSelectionModel().isEmpty() || tfpro1.getText().isEmpty() || tfpro2.getText().isEmpty() || tfpro3.getText().isEmpty() || tfpro4.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs requis !");
        return;
    }

    
    if (!rdV1.isSelected() && !rdV2.isSelected() && !rdV3.isSelected() && !rdV4.isSelected()) {
        JOptionPane.showMessageDialog(null, "Veuillez sélectionner au moins une proposition vraie !");
        return;
    }
    if (sq.questionExists(tfLibelle.getText())) {
    JOptionPane.showMessageDialog(null, "Le libellé de la question existe déjà !");
    return;
    }    
    
    if (rdV1.isSelected()) {
        etatProposition1 = "vrai";
    } else if (rdF1.isSelected()) {
        etatProposition1 = "faux";
    } else {
        return;
    }
    
    
    if (rdV2.isSelected()) {
        etatProposition2 = "vrai";
    } else if (rdF2.isSelected()) {
        etatProposition2 = "faux";
    } else {
        return;
    }
    
     
    if (rdV3.isSelected()) {
        etatProposition3 = "vrai";
    } else if (rdF3.isSelected()) {
        etatProposition3 = "faux";
    } else {
        return;
    }
    
     
    if (rdV4.isSelected()) {
        etatProposition4 = "vrai";
    } else if (rdF4.isSelected()) {
        etatProposition4 = "faux";
    } else {
        return;
    }
         
        int index = listcompetence.getSelectionModel().getSelectedIndex();
        String n = listcompetence.getItems().get(index).toString();
        ServiceCompetence sc = new ServiceCompetence();
        Question q = new Question(tfLibelle.getText(),sc.Getidcompetencebynom(n));
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
        rdV1.setSelected(false);
        rdV2.setSelected(false);
        rdV3.setSelected(false);
        rdV4.setSelected(false);
        rdF1.setSelected(false);
        rdF2.setSelected(false);
        rdF3.setSelected(false);
        rdF4.setSelected(false);
        refresh();
    }

    @FXML
    private void modifierQuestion() {
        ServiceProposition sp = new ServiceProposition();
        ServiceCompetence sc = new ServiceCompetence();
        ServiceQuestion sq = new ServiceQuestion();
        
        QuestionView selectedQuestion = information.getSelectionModel().getSelectedItem();
        int index = information.getSelectionModel().getSelectedIndex();
        String newLibelle = tfLibelle.getText();

        String newProposition1 = tfpro1.getText();
        String newProposition2 = tfpro2.getText();
        String newProposition3 = tfpro3.getText();
        String newProposition4 = tfpro4.getText();
        String newEtatProposition1;
        String newEtatProposition2;
        String newEtatProposition3;
        String newEtatProposition4;
        if (rdV1.isSelected()) {
    newEtatProposition1 = "vrai";
        } else if (rdF1.isSelected()) {
    newEtatProposition1 = "faux";
        } else {
    
    return;
        }
        if (rdV2.isSelected()) {
    newEtatProposition2 = "vrai";
        } else if (rdF2.isSelected()) {
    newEtatProposition2 = "faux";
        } else {
    
    return;
        }
       if (rdV3.isSelected()) {
    newEtatProposition3 = "vrai";
        } else if (rdF3.isSelected()) {
    newEtatProposition3 = "faux";
        } else {
    
    return;
        }
       
       if (rdV4.isSelected()) {
    newEtatProposition4 = "vrai";
        } else if (rdF4.isSelected()) {
    newEtatProposition4 = "faux";
        } else {
    
    return;
        }
      String n = listcompetence.getSelectionModel().getSelectedItem().toString(); 
      Question q = new Question(selectedQuestion.getId_question(), newLibelle, "Active", sc.Getidcompetencebynom(n));  
        sq.modifier(q);
      List prop = sp.afficherByIDquestion(information.getItems().get(index).getId_question());
      proposition p0 = (proposition) prop.get(0);
      proposition p1 = (proposition) prop.get(1);
      proposition p2 = (proposition) prop.get(2);
      proposition p3 = (proposition) prop.get(3);
      sp.modifier(new proposition(p0.getId_proposition(), newProposition1, newEtatProposition1, selectedQuestion.getId_question()));
      sp.modifier(new proposition(p1.getId_proposition(), newProposition2, newEtatProposition2, selectedQuestion.getId_question()));
      sp.modifier(new proposition(p2.getId_proposition(), newProposition3, newEtatProposition3, selectedQuestion.getId_question()));
      sp.modifier(new proposition(p3.getId_proposition(), newProposition4, newEtatProposition4, selectedQuestion.getId_question()));
     JOptionPane.showMessageDialog(null, "Question Modifiée !");
        tfLibelle.clear();
        tfpro1.clear();
        tfpro2.clear();
        tfpro3.clear();
        tfpro4.clear();
        rdV1.setSelected(false);
        rdV2.setSelected(false);
        rdV3.setSelected(false);
        rdV4.setSelected(false);
        rdF1.setSelected(false);
        rdF2.setSelected(false);
        rdF3.setSelected(false);
        rdF4.setSelected(false);
        refresh();
    }
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
         JOptionPane.showMessageDialog(null, "Question Supprimée !");
        refresh();
        tfLibelle.clear();
        tfpro1.clear();
        tfpro2.clear();
        tfpro3.clear();
        tfpro4.clear();
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

    

   

    private void Details(MouseEvent event) {
        
          QuestionView selectedQuestion = information.getSelectionModel().getSelectedItem();
        ServiceProposition sp = new ServiceProposition();
        ServiceCompetence sc = new ServiceCompetence();
        int index = information.getSelectionModel().getSelectedIndex();
        tfLibelle.setText(information.getItems().get(index).getLibelle());
        int id = information.getItems().get(index).getId_c();
        listcompetence.getSelectionModel().clearSelection();
        listcompetence.getSelectionModel().select(sc.getNameCompetenceById(id));
        
      List prop = sp.afficherByIDquestion(information.getItems().get(index).getId_question());
      
        if (prop.size() >= 1) {
        proposition p = (proposition)prop.get(0);
        tfpro1.setText(p.getDescription());
        if (p.getEtat().equals("vrai")){
        rdV1.setSelected(true);
        }
        else {
        rdF1.setSelected(true);
        }
    }
    
    if (prop.size() >= 2) {
        proposition p = (proposition) prop.get(1);
        tfpro2.setText(p.getDescription());
        if (p.getEtat().equals("vrai")){
        rdV2.setSelected(true);
        }
        else {
        rdF2.setSelected(true);
        }
    }
    
    if (prop.size() >= 3) {
        proposition p = (proposition)prop.get(2);
        tfpro3.setText(p.getDescription());
        if (p.getEtat().equals("vrai")){
        rdV3.setSelected(true);
        }
        else {
        rdF3.setSelected(true);
        }
    }
    
    if (prop.size() >= 4) {
        proposition p = (proposition)prop.get(3);
        tfpro4.setText(p.getDescription());
        if (p.getEtat().equals("vrai")){
        rdV4.setSelected(true);
        }
        else {
        rdF4.setSelected(true);
        }
    }

    }


   
}
