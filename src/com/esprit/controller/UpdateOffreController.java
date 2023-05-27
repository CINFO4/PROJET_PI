/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.controller;

import com.esprit.controller.CrudOffreController;
import com.esprit.entities.Offre;
import com.esprit.services.ServiceDomaine;
import com.esprit.services.ServiceOffre;
import com.sun.java.swing.plaf.windows.resources.windows;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class UpdateOffreController implements Initializable {

    @FXML
    private TextField txtTitre;
    @FXML
    private DatePicker datePickerExp;
    @FXML
    private TextArea txtDescription;
    @FXML
    private DatePicker datePickerPub;
    private TextField txtId;
    @FXML
    private ChoiceBox<String> ChoiseBoxDomaine;
    private Stage stage;
    ServiceDomaine sd = new ServiceDomaine();
    private CrudOffreController offreController;
    @FXML
    private ComboBox<String> ddddddd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void selectDate(ActionEvent event) {
    }

    @FXML
    private void updateOffre(ActionEvent event) {

        if (ChoiseBoxDomaine.getValue() == null) {
            JOptionPane.showMessageDialog(null, "selectionner un Domaine ! ");
        } else {
            ServiceOffre sf = new ServiceOffre();
            sf.modifier(new Offre(Integer.parseInt(txtId.getText()), txtTitre.getText(), txtDescription.getText(), sd.getIdDomaineByName(ChoiseBoxDomaine.getValue()), Date.valueOf(datePickerPub.getValue()), Date.valueOf(datePickerExp.getValue())));
            JOptionPane.showMessageDialog(null, "offre modifier ! ");
        }
        offreController.table();
        

    }

    public void setTxtTitre(String txtTitre) {
        this.txtTitre.setText(txtTitre);
    }

    public void setChoiseBoxDomaine() {
        this.ChoiseBoxDomaine.getItems().addAll(sd.getDomainesName());
    }
    public void setComboBoxDomaine() {
        this.ddddddd.getItems().addAll(sd.getDomainesName());
    }
    

    public void setDatePickerExp(Date date) {
        this.datePickerExp.setValue(date.toLocalDate());
    }

    public void setTxtDescription(String txtDescription) {
        this.txtDescription.setText(txtDescription);;
    }

    public void setDatePickerPub(Date date) {
        this.datePickerPub.setValue(date.toLocalDate());
    }

    public void setTxtId(String txtId) {
        this.txtId.setText(txtId);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    void setOffreController(CrudOffreController offreController) {
        this.offreController = offreController;
    }

}
