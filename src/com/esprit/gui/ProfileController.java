package com.esprit.gui;

import com.esprit.entities.Profile;
import com.esprit.services.ServiceProfile;
import com.esprit.services.ServiceCompetence;
import com.esprit.utils.DataSource;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {

    @FXML
    private ComboBox<String> userNameComboBox;

    @FXML
    private Label competenceLabel;

    @FXML
    private Label niveauLabel;

    private final ServiceProfile serviceProfile;
    private final ServiceCompetence serviceCompetence;

    public ProfileController() {
        serviceProfile = new ServiceProfile();
        serviceCompetence = new ServiceCompetence();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Populate the user name combo box
        populateUserNameComboBox();

        // Listen for changes in the selected user name
        userNameComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Fetch competence names and niveau for the selected user name
                List<String> competenceNames = serviceCompetence.getCompetenceNamesByUserName(newValue);
                Profile.Niveau niveau = serviceCompetence.getNiveauByUserName(newValue);

                // Update the displayed labels
                competenceLabel.setText(String.join(", ", competenceNames));
                niveauLabel.setText(niveau.toString());
            } else {
                // Clear the displayed labels
                competenceLabel.setText("");
                niveauLabel.setText("");
            }
        });
    }

    private void populateUserNameComboBox() {
        try {
            // Fetch user names from the database and populate the combo box
            Connection cnx = DataSource.getInstance().getCnx();
            String req = "SELECT nom FROM user";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            List<String> userNames = new ArrayList<>();
            while (rs.next()) {
                String userName = rs.getString("nom");
                userNames.add(userName);
            }

            userNameComboBox.setItems(FXCollections.observableArrayList(userNames));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void addProfile() {
        // Get the selected user name
        String userName = userNameComboBox.getValue();

        // Fetch the competence names and niveau for the selected user name
        List<String> competenceNames = serviceCompetence.getCompetenceNamesByUserName(userName);
        Profile.Niveau niveau = serviceCompetence.getNiveauByUserName(userName);

        // Update the displayed labels
        competenceLabel.setText(String.join(", ", competenceNames));
        niveauLabel.setText(niveau.toString());
    }
}
