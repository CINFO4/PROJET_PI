/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.Forum;
import com.esprit.services.ServiceForum;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class AjoutforumController implements Initializable {

    @FXML
    private TextField txtSujet;
    @FXML
    private TextArea txtContenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterForum(ActionEvent event) throws IOException {
        ServiceForum sp = new ServiceForum();
        sp.ajouter(new Forum(txtSujet.getText(), txtContenu.getText(), 1, 1));
        JOptionPane.showMessageDialog(null, "Forum ajoutée !");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsForum.fxml"));
        Parent root = loader.load();
        txtSujet.getScene().setRoot(root);
        
        DetailsforumController dfc = loader.getController();
        dfc.setLbSujet(txtSujet.getText());
        dfc.setLbContenu(txtContenu.getText());
    }
    
}
