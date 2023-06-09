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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * FXML Controller class
 *
 * @author Mayssen
 */
public class ListeQuizController implements Initializable {


    @FXML
    private TableView<Competence> infocompetence;
    @FXML
    private TableColumn<Competence, String> colcompetence;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceCompetence sc = new ServiceCompetence();
        
        AfficherCompetence();
        // TODO
    }   
    
    public void AfficherCompetence() {
    ServiceQuestion serviceQuestion = new ServiceQuestion();
    ServiceCompetence sc = new ServiceCompetence();
    ObservableList<Competence> competenceList = FXCollections.observableArrayList(sc.afficher()) ;
    infocompetence.setItems(competenceList);
    colcompetence.setCellValueFactory(new PropertyValueFactory<>("nom"));
    
}
}