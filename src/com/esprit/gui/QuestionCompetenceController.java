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
import com.esprit.gui.ListeQuizController;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Mayssen
 */
public class QuestionCompetenceController implements Initializable {

    @FXML
    private Label lbCompetence;
    @FXML
    private Label lbQ1;
    @FXML
    private RadioButton rdQ11;
    @FXML
    private RadioButton rdQ12;
    @FXML
    private RadioButton rdQ13;
    @FXML
    private RadioButton rdQ14;
    @FXML
    private Label lbQ2;
    @FXML
    private RadioButton rdQ21;
    @FXML
    private RadioButton rdQ22;
    @FXML
    private RadioButton rdQ23;
    @FXML
    private RadioButton rdQ24;
    @FXML
    private Label lbQ3;
    @FXML
    private RadioButton rdQ31;
    @FXML
    private RadioButton rdQ32;
    @FXML
    private RadioButton rdQ33;
    @FXML
    private RadioButton rdQ34;
    @FXML
    private Label lbQ4;
    @FXML
    private RadioButton rdQ41;
    @FXML
    private RadioButton rdQ42;
    @FXML
    private RadioButton rdQ43;
    @FXML
    private RadioButton rdQ44;
    @FXML
    private Button btValider;
    @FXML
    private ToggleGroup Q1;
    @FXML
    private ToggleGroup Q2;
    @FXML
    private ToggleGroup Q3;
    @FXML
    private ToggleGroup Q4;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //setCompetence(selectedCompetence);
    }    
 private Competence selectedCompetence;

    public void setCompetence(Competence competence) {
        selectedCompetence = competence;
       int id = competence.getId_c();
       
        ServiceProposition sp = new ServiceProposition();
        ServiceQuestion sq = new ServiceQuestion();
        ServiceCompetence sc = new ServiceCompetence();
        
        ObservableList<Question> questions = FXCollections.observableArrayList(sq.GetQuestionsByCompetences(id));

        
        if (questions.size() > 4) {
            
            Collections.shuffle(questions);
         
            questions = FXCollections.observableArrayList(questions.subList(0, 4));
        }
        
          lbCompetence.setText(sc.getNameCompetenceById(id));
       lbQ1.setText(questions.get(0).getLibelle());
        lbQ2.setText(questions.get(1).getLibelle());
        lbQ3.setText(questions.get(2).getLibelle());
        lbQ4.setText(questions.get(3).getLibelle());
         List<proposition> prop1 = sp.afficherByIDquestion(sq.GetidQuestionbynom(lbQ1.getText()));
         List<proposition> prop2 = sp.afficherByIDquestion(sq.GetidQuestionbynom(lbQ2.getText()));
        List<proposition> prop3 = sp.afficherByIDquestion(sq.GetidQuestionbynom(lbQ3.getText()));
       List<proposition> prop4 = sp.afficherByIDquestion(sq.GetidQuestionbynom(lbQ4.getText()));
         if (prop1.size() >= 1) {
         proposition p11 = prop1.get(0);
        rdQ11.setText(p11.getDescription());
       
         }
         
         if (prop1.size() >= 2) {
         proposition p12 = prop1.get(1);
        rdQ12.setText(p12.getDescription());
         }
         
         if (prop1.size() >= 3) {
         proposition p13= prop1.get(2);
        rdQ13.setText(p13.getDescription());
         }
         
         if (prop1.size() >= 4) {
         proposition p14 = prop1.get(3);
        rdQ14.setText(p14.getDescription());
         }
         
         
         if (prop2.size() >= 1) {
         proposition p21 = prop2.get(0);
        rdQ21.setText(p21.getDescription());
        
         }
         
         if (prop2.size() >= 2) {
         proposition p22 = prop2.get(1);
        rdQ22.setText(p22.getDescription());
         }
         
         if (prop2.size() >= 3) {
         proposition p23= prop2.get(2);
        rdQ23.setText(p23.getDescription());
         }
         
         if (prop2.size() >= 4) {
         proposition p24 = prop2.get(3);
        rdQ24.setText(p24.getDescription());
         }
         
         
         if (prop3.size() >= 1) {
         proposition p31 = prop3.get(0);
        rdQ31.setText(p31.getDescription());
       
         }
         
         if (prop3.size() >= 2) {
         proposition p32 = prop3.get(1);
        rdQ32.setText(p32.getDescription());
         }
         
         if (prop3.size() >= 3) {
         proposition p33= prop3.get(2);
        rdQ33.setText(p33.getDescription());
         }
         
         if (prop3.size() >= 4) {
         proposition p34 = prop1.get(3);
        rdQ34.setText(p34.getDescription());
         }
         
         
         if (prop4.size() >= 1) {
         proposition p41 = prop4.get(0);
        rdQ41.setText(p41.getDescription());
       
         }
         
         if (prop4.size() >= 2) {
         proposition p42 = prop4.get(1);
        rdQ42.setText(p42.getDescription());
         }
         
         if (prop4.size() >= 3) {
         proposition p43= prop4.get(2);
        rdQ43.setText(p43.getDescription());
         }
         
         if (prop4.size() >= 4) {
         proposition p44 = prop4.get(3);
        rdQ44.setText(p44.getDescription());
         }
    }

}
