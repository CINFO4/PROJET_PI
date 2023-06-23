package com.esprit.services;

import com.esprit.entities.*;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceReview {

    private final Connection cnx = DataSource.getInstance().getCnx();
  public void ajouter(Review review) throws SQLException {
    String req = "INSERT INTO review(nbr_etoile, id_user, commentaire, id_entreprise) VALUES (?, ?, ?, ?);";
    PreparedStatement pst = cnx.prepareStatement(req);
    pst.setInt(1, review.getNbr_etoile());
    pst.setInt(2, review.getId_user());
    String originalCommentaire = review.getCommentaire();
    if (containsBadWords(originalCommentaire)) {
        System.out.println("Cannot add the review. It contains bad words. Please provide another review.");
        return;
    }
    String sanitizedCommentaire = replaceBadWords(originalCommentaire); // Sanitize the commentaire
    pst.setString(3, sanitizedCommentaire);
    pst.setInt(4, review.getId_entreprise());
    pst.executeUpdate();
    System.out.println("Review ajoutée !");
}

    private boolean containsBadWords(String input) {
        List<String> badWords = Arrays.asList("molka", "mehdi", "weldi"); // Replace with your own list of bad words

        for (String word : badWords) {
            if (input.toLowerCase().contains(word.toLowerCase())) {
                return true; // Input contains a bad word
            }
        }

        return false; // Input does not contain any bad words
    }


    public void modifier(Review review) throws SQLException {
        String req = "UPDATE review SET nbr_etoile=?, commentaire=? WHERE id_review=?";
        PreparedStatement pst = cnx.prepareStatement(req);
        pst.setInt(1, review.getNbr_etoile());

        String sanitizedCommentaire = replaceBadWords(review.getCommentaire()); 
        pst.setString(2, sanitizedCommentaire);

        pst.setInt(3, review.getId_review());
        pst.executeUpdate();
        System.out.println("Review modifiée !");
    }


    public void supprimer(Review review) throws SQLException {
        String req = "DELETE from review WHERE id_review=?";
        PreparedStatement pst = cnx.prepareStatement(req);
        pst.setInt(1, review.getId_review());
        pst.executeUpdate();
        System.out.println("Review supprimée !");
    }

    public List<Review> afficher() throws SQLException {
        List<Review> list = new ArrayList<>();

        String req = "SELECT * FROM review";
        PreparedStatement pst = cnx.prepareStatement(req);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            int idReview = rs.getInt("id_review");
            int nbrEtoile = rs.getInt("nbr_etoile");
            int idUser = rs.getInt("id_user");
            String commentaire = rs.getString("commentaire");
            int idEntreprise = rs.getInt("id_entreprise");

            // Replace bad words in the commentaire field
            commentaire = replaceBadWords(commentaire);

            list.add(new Review(idReview, nbrEtoile, idUser, commentaire, idEntreprise));
        }

        return list;
    }

    public String replaceBadWords(String input) {
        List<String> wordsToReplace = new ArrayList<>();
        wordsToReplace.add("hello");
        wordsToReplace.add("focus");
        wordsToReplace.add("bye");

        for (String word : wordsToReplace) {
            String stars = "";
            for (int i = 0; i < word.length(); i++) {
                stars += "*";
            }
            input = input.replaceAll("\\b" + word + "\\b", stars);
        }

        return input;
    }

}


