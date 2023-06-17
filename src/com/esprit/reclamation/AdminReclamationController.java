package com.esprit.reclamation;

import com.esprit.entities.Email;
import com.esprit.entities.EtatReclamation;
import com.esprit.entities.Reclamation;
import com.esprit.services.ServiceOffre;
import com.esprit.services.ServiceReclamation;
import com.esprit.services.ServiceUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;

public class AdminReclamationController implements Initializable {

    @FXML
    private ListView<Reclamation> lv1;

    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private TextArea tf_commentaire;

    private ServiceReclamation sr;
    
    private ServiceUser su;
    
    private ServiceOffre so;

    public AdminReclamationController() {
        sr = new ServiceReclamation();
        su = new ServiceUser();
        so = new ServiceOffre();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sr = new ServiceReclamation();
        su = new ServiceUser();
        afficherReclamations();
    }

    private void afficherReclamations() {
        try {
            List<Reclamation> reclamations = sr.getReclamationEnCours();

            for (Reclamation rec : reclamations) {
                String output = so.getTitreOffre(rec.getId_offre()) + " " +
                        su.getNomUser(rec.getId_user());

                rec.setOutput(output);
            }

            ObservableList<Reclamation> data = FXCollections.observableArrayList();
            data.addAll(reclamations);

            lv1.setItems(data);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    void selectViewOption(MouseEvent event) {
        Reclamation selectedOption = (Reclamation) lv1.getSelectionModel().getSelectedItem();

        tf_commentaire.setText(selectedOption.getReclamation());

        b1.setDisable(false);
        b2.setDisable(false);

        tf_commentaire.setDisable(false);
    }

    @FXML
    private void valider(ActionEvent event) {
        Reclamation selectedReclamation = lv1.getSelectionModel().getSelectedItem();
        if (selectedReclamation != null) {
            selectedReclamation.setEtat(EtatReclamation.Approuvee);
            try {
                sr.modifier(selectedReclamation);
                
                JOptionPane.showMessageDialog(null, "Envoie du mail en cours ");

                int id = selectedReclamation.getId_reclamation();
                String mail = su.getUserMail(selectedReclamation.getId_user());

                Email.sendMail(mail, "Reclamation [Ref: " + id+"]", Email.envoiValidMessage(su.getNomUser(selectedReclamation.getId_user()), id));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erreur lors de la validation! ");

            } catch (MessagingException ex) {
                JOptionPane.showMessageDialog(null, "Erreur lors de l'envoie du mail!");
            }

            afficherReclamations();

            tf_commentaire.setText("");
            tf_commentaire.setDisable(true);
            b2.setDisable(true);
            b1.setDisable(true);
        }
    }

    @FXML
    private void rejeter(ActionEvent event) {
        Reclamation selectedReclamation = lv1.getSelectionModel().getSelectedItem();
        if (selectedReclamation != null) {
            selectedReclamation.setEtat(EtatReclamation.Rejetee);
            try {
                sr.modifier(selectedReclamation);

                JOptionPane.showMessageDialog(null, "Envoie du mail en cours ");
                int id = selectedReclamation.getId_reclamation();
                
                String mail = su.getUserMail(selectedReclamation.getId_user());

                Email.sendMail(mail, "Reclamation [Ref: " + id+"]", Email.envoiRejectMessage(su.getNomUser(selectedReclamation.getId_user()), id));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erreur lors de la validation! ");

            } catch (MessagingException ex) {
                JOptionPane.showMessageDialog(null, "Erreur lors de l'envoie du mail!");
            }

            afficherReclamations();

            tf_commentaire.setText("");
            tf_commentaire.setDisable(true);
            b2.setDisable(true);
            b1.setDisable(true);
        }
    }
}
