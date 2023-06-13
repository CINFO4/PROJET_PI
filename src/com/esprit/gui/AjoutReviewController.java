package com.esprit.gui;

import com.esprit.entities.Review;
import com.esprit.services.ServiceReview;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javax.swing.JOptionPane;
import javafx.scene.paint.Color;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.shape.SVGPath;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class AjoutReviewController implements Initializable {
    @FXML
    private SVGPath star1;

    @FXML
    private SVGPath star2;

    @FXML
    private SVGPath star3;

    @FXML
    private SVGPath star4;

    @FXML
    private SVGPath star5;
    
    @FXML
    private Button b1;
    
    @FXML
    private TextArea tf_commentaire;
    
    private int user_id;
    
    private int entreprise_id;
    
    private final Color filledColor = Color.YELLOW;
    private final Color unfilledColor = Color.BLACK;
        
    
    public AjoutReviewController(int user_id, int entreprise_id) {
        this.user_id = user_id;
        this.entreprise_id = entreprise_id;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      
    }

    @FXML
    void selectStar(MouseEvent event) {
        SVGPath[] stars = new SVGPath[]{star1, star2, star3, star4, star5};
        SVGPath selectedStar = (SVGPath) event.getSource();

        for (SVGPath star : stars) {
            star.setFill(unfilledColor);
        }
        
        int i = -1;
        do{
            i++;
            stars[i].setFill(filledColor);
        }while(!selectedStar.equals(stars[i]));
        
        if(countStars()>0){
            b1.setDisable(false);
        }else{
            b1.setDisable(true);
        }
    }
    
    private int countStars(){
        int result = 0;
        for (SVGPath star : new SVGPath[]{star1, star2, star3, star4, star5}) {
            if (star.getFill().equals(filledColor)) {
                result++;
            }
        }
        
        return result;
    }
     
    @FXML
    private void ajouterReview(ActionEvent event) throws IOException {
        ServiceReview sr = new ServiceReview();
       
        String commentaire = tf_commentaire.getText();/*est utilisé pour convertir le texte en un entier (int).*/ 
        Review review = new Review(countStars(), user_id, commentaire, entreprise_id);
        sr.ajouter(review);
        JOptionPane.showMessageDialog(null, "Review ajoutée !");
        
        System.out.println(sr.afficher());
    }
}
