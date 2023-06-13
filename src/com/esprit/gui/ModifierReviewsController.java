/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.Review;
import com.esprit.entities.ReviewOffre;
import com.esprit.services.ServiceReview;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mehdi
 */
public class ModifierReviewsController implements Initializable {
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
    private ListView lv1;
    
    @FXML
    private Button b1;
    
    @FXML
    private Button b2;
    
    @FXML
    private TextArea tf_commentaire;
    
    private final Color filledColor = Color.YELLOW;
    private final Color unfilledColor = Color.BLACK;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillViewOptions();
    }    
    
    private void fillViewOptions(){
        ServiceReview sr = new ServiceReview();
        List<Review> reviews = sr.afficher();
        
        List<ReviewOffre> reviewOffres = reviews.stream()
                .map(review->new ReviewOffre(review,sr.getNomEntreprise(review.getId_entreprise())))
                .collect(Collectors.toList());
        
        ObservableList<ReviewOffre> data = FXCollections.observableArrayList();
        data.addAll(reviewOffres);
        
        lv1.setItems(data);
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
    void selectViewOption(MouseEvent event) {
        SVGPath[] stars = new SVGPath[]{star1, star2, star3, star4, star5};
        for (SVGPath star : stars) {
            star.setFill(unfilledColor);
            star.setDisable(false);
        }
                
        ReviewOffre selectedOption = (ReviewOffre) lv1.getSelectionModel().getSelectedItem();

        tf_commentaire.setText(selectedOption.getReview().getCommentaire());
        
        for (int i = 0; i < selectedOption.getReview().getNbr_etoile(); i++) {
            SVGPath star = stars[i];
            star.setFill(filledColor);
        }
        
        b1.setDisable(false);
        b2.setDisable(false);
        
        tf_commentaire.setDisable(false);
    }
    
    @FXML
    private void modifier(ActionEvent event) throws IOException {
        ServiceReview sr = new ServiceReview();

        ReviewOffre selectedOption = (ReviewOffre) lv1.getSelectionModel().getSelectedItem();
        Review review = selectedOption.getReview();
        
        String commentaire = tf_commentaire.getText();
        
        review.setCommentaire(commentaire);
        review.setNbr_etoile(countStars());
        
        sr.modifier(review);
        JOptionPane.showMessageDialog(null, "Review modifiée !");
        
        System.out.println(sr.afficher());
        
        lv1.getSelectionModel().setSelectionMode(null);
        fillViewOptions();
        
        b1.setDisable(true);
        b2.setDisable(true);
        
        tf_commentaire.setText(null);
        tf_commentaire.setDisable(true);

        SVGPath[] stars = new SVGPath[]{star1, star2, star3, star4, star5};
        
        for (SVGPath star : stars) {
            star.setFill(unfilledColor);
            star.setDisable(true);
        }
    }
    
    @FXML
    private void supprimer(ActionEvent event) throws IOException {
        ServiceReview sr = new ServiceReview();

        ReviewOffre selectedOption = (ReviewOffre) lv1.getSelectionModel().getSelectedItem();
        Review review = selectedOption.getReview();
        sr.supprimer(review);
        
        JOptionPane.showMessageDialog(null, "Review supprimée !");
        
        System.out.println(sr.afficher());
        
        lv1.getSelectionModel().setSelectionMode(null);
        fillViewOptions();
        
        b1.setDisable(true);
        b2.setDisable(true);
        
        tf_commentaire.setText(null);
        tf_commentaire.setDisable(true);

        SVGPath[] stars = new SVGPath[]{star1, star2, star3, star4, star5};
        
        for (SVGPath star : stars) {
            star.setFill(unfilledColor);
            star.setDisable(true);
        }
    }
}
