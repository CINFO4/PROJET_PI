package com.esprit.gui.reclamation;

import com.esprit.entities.EtatReclamation;
import com.esprit.entities.Reclamation;
import com.esprit.entities.ReclamationOffre;
import com.esprit.entities.Review;
import com.esprit.entities.ReviewOffre;
import com.esprit.services.ServiceReclamation;
import com.esprit.services.ServiceReview;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

public class AjoutReclamationController implements Initializable {

    @FXML
    private TextArea tf_reclamation;
    
    @FXML
    private Text rclname;
     
    @FXML
    private Text recid;
    
    @FXML
    private Text rclstat;
     
    @FXML
    private Text recstat;
     
    @FXML
    private ListView lv1;
    
    @FXML
    private Button b1;
    
    private int id_user;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillViewOptions();
    }    

    public AjoutReclamationController(int id_user) {
        this.id_user = id_user;
    }
      
    private void fillViewOptions(){
        ServiceReclamation sr = new ServiceReclamation();
        List<Reclamation> reclamations = sr.afficher();
        
        List<ReclamationOffre> reviewOffres = reclamations.stream()
                .map(reclamation->new ReclamationOffre(reclamation,sr.getTitreOffre(reclamation.getId_offre())))
                .collect(Collectors.toList());
        
        ObservableList<ReclamationOffre> data = FXCollections.observableArrayList();
        data.addAll(reviewOffres);
        
        lv1.setItems(data);
    }
    
     @FXML
    void selectViewOption(MouseEvent event) {
        ReclamationOffre selectedOption = (ReclamationOffre) lv1.getSelectionModel().getSelectedItem();

        tf_reclamation.setText(selectedOption.getReclamation().getReclamation());
        tf_reclamation.setDisable(true);
        
        b1.setText("Retour");
        b1.setOnAction(e-> clearButton());
        
        rclname.setText(String.valueOf(selectedOption.getReclamation().getId_reclamation()));
        rclstat.setText(String.valueOf(selectedOption.getReclamation().getEtat()));

        recid.setVisible(true);
        recstat.setVisible(true);
    }
    
    @FXML
    private void ajouterReclamation(ActionEvent event) throws IOException {
        ServiceReclamation sr = new ServiceReclamation();
       
        String message = tf_reclamation.getText();/*est utilisé pour convertir le texte en un entier (int).*/ 
        Reclamation reclamation = new Reclamation(0, message, 1, EtatReclamation.En_cours, 5);
        sr.ajouter(reclamation);
        JOptionPane.showMessageDialog(null, "Reclamation ajoutée !");
        
        lv1.getSelectionModel().setSelectionMode(null);
        tf_reclamation.setText("");

        fillViewOptions();
    }

    private void clearButton() {
        b1.setText("Envoyer");
        b1.setOnAction(e-> {
            try {
                ajouterReclamation(e);
            } catch (IOException ex) {
                Logger.getLogger(AjoutReclamationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        lv1.getSelectionModel().setSelectionMode(null);
        
        tf_reclamation.setText("");
        tf_reclamation.setDisable(false);
        
        rclname.setText(null);
        recid.setVisible(false);
        
        rclstat.setText(null);
        recstat.setVisible(false);
    }
} 
