package com.esprit.gui;

import com.esprit.entities.Document;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailsDocumentController implements Initializable {

    @FXML
    private Label lbTitle;
    @FXML
    private Label lbDescription;
    @FXML
    private Label lbType;
    @FXML
    private Label lbLink;
    @FXML
    private Label lbUserId;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setDocument(Document document) {
        lbTitle.setText(document.getTitre_document());
        lbDescription.setText(document.getDescription_document());
        lbType.setText(document.getType());
        lbLink.setText(document.getLien());
        lbUserId.setText(String.valueOf(document.getId_user()));
    }
}
