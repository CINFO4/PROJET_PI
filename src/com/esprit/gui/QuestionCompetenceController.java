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
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

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

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //setCompetence(selectedCompetence);
    }    
 private Competence selectedCompetence;

    public void setCompetence(Competence competence) {
        selectedCompetence = competence;
       int id = competence.getId_c();
        System.out.println(id);
        ServiceProposition sp = new ServiceProposition();
        ServiceQuestion sq = new ServiceQuestion();
        ServiceCompetence sc = new ServiceCompetence();
          lbCompetence.setText(sc.getNameCompetenceById(id));
        lbQ1.setText(sq.GetQuestionsByCompetences(id).get(0).getLibelle());
       lbQ2.setText(sq.GetQuestionsByCompetences(id).get(1).getLibelle());
        lbQ3.setText(sq.GetQuestionsByCompetences(id).get(2).getLibelle());
        lbQ4.setText(sq.GetQuestionsByCompetences(id).get(3).getLibelle());
         List prop = sp.afficherByIDquestion(sq.GetQuestionsByCompetences(id).get(0).getId_question());
         List prop1 = sp.afficherByIDquestion(sq.GetQuestionsByCompetences(id).get(1).getId_question()); 
         List prop2 = sp.afficherByIDquestion(sq.GetQuestionsByCompetences(id).get(2).getId_question()); 
         List prop3 = sp.afficherByIDquestion(sq.GetQuestionsByCompetences(id).get(3).getId_question());
         if (prop.size() >= 1) {
         proposition p11 = (proposition)prop.get(0);
        rdQ11.setText(p11.getDescription());
         }
    }

}
