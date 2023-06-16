package com.esprit.review;

import com.esprit.entities.Review;
import com.esprit.services.ServiceReview;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
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

    private void fillViewOptions() {
        ServiceReview sr = new ServiceReview();
        try {
            List<Review> reviews = sr.afficher();

            for (Review rev : reviews) {
                String output = sr.getNomEntreprise(rev.getId_entreprise()) + "      " + rev.getNbr_etoile() + "/5";

                rev.setOutput(output);
            }

            ObservableList<Review> data = FXCollections.observableArrayList();
            data.addAll(reviews);

            lv1.setItems(data);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erreur lors de l'affichage des reviews !");
        }
    }

    @FXML
    void selectStar(MouseEvent event) {
        SVGPath[] stars = new SVGPath[]{star1, star2, star3, star4, star5};
        SVGPath selectedStar = (SVGPath) event.getSource();

        for (SVGPath star : stars) {
            star.setFill(unfilledColor);
        }

        int i = -1;
        do {
            i++;
            stars[i].setFill(filledColor);
        } while (!selectedStar.equals(stars[i]));
    }

    private int countStars() {
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

        Review selectedOption = (Review) lv1.getSelectionModel().getSelectedItem();

        tf_commentaire.setText(selectedOption.getCommentaire());

        for (int i = 0; i < selectedOption.getNbr_etoile(); i++) {
            SVGPath star = stars[i];
            star.setFill(filledColor);
        }

        b1.setDisable(false);
        b2.setDisable(false);

        tf_commentaire.setDisable(false);
    }

    @FXML
    private void modifier(ActionEvent event) {
        ServiceReview sr = new ServiceReview();

        Review selectedOption = (Review) lv1.getSelectionModel().getSelectedItem();

        String commentaire = tf_commentaire.getText();

        selectedOption.setCommentaire(commentaire);
        selectedOption.setNbr_etoile(countStars());

        try {
            sr.modifier(selectedOption);
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
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la modification de la review !");
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
        ServiceReview sr = new ServiceReview();

        Review selectedOption = (Review) lv1.getSelectionModel().getSelectedItem();
        
        try {
            sr.supprimer(selectedOption);

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
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la suppression de la review !");
        }
    }
}
