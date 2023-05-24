package com.esprit.gui;

import com.esprit.entities.Document;
import com.esprit.services.ServiceGererDocument;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class AjouterDocumentController implements Initializable {

    @FXML
    private TextField tfTitle;
    @FXML
    private TextArea taDescription;
    @FXML
    private TextField tfType;
    @FXML
    private TextField tfLink;
    @FXML
    private TextField tfUserId;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ajouterDocument(ActionEvent event) throws IOException {
        ServiceGererDocument service = new ServiceGererDocument();
        Document document = new Document(tfTitle.getText(), taDescription.getText(), tfType.getText(), tfLink.getText(), tfUserId.getText());
        service.ajouter(document);
        
        JOptionPane.showMessageDialog(null, "Document ajouté !");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsDocument.fxml"));
        Parent root = loader.load();
        tfTitle.getScene().setRoot(root);
        
        DetailsDocumentController ddc = loader.getController();
        ddc.setDocument(document);
    }
}
