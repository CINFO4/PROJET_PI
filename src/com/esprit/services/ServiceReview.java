package com.esprit.services;

import com.esprit.entities.*;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceReview {

    private final Connection cnx = DataSource.getInstance().getCnx();

    public void ajouter(Review review) throws SQLException {
        String req = "INSERT INTO review(nbr_etoile, id_user, commentaire, id_entreprise) VALUES (?, ?, ?, ?);";
        PreparedStatement pst = cnx.prepareStatement(req);
        pst.setInt(1, review.getNbr_etoile());
        pst.setInt(2, review.getId_user());
        pst.setString(3, review.getCommentaire());
        pst.setInt(4, review.getId_entreprise());
        pst.executeUpdate();
        System.out.println("Review ajoutée !");
    }

    public void modifier(Review review) throws SQLException {
        String req = "UPDATE review SET nbr_etoile=?, commentaire=? WHERE id_review=?";
        PreparedStatement pst = cnx.prepareStatement(req);
        pst.setInt(1, review.getNbr_etoile());
        pst.setString(2, review.getCommentaire());
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
            list.add(new Review(rs.getInt("id_review"), rs.getInt("nbr_etoile"), rs.getInt("id_user"), rs.getString("commentaire"), rs.getInt("id_entreprise")));
        }

        return list;
    }

    public String getNomEntreprise(int id_entreprise) throws SQLException {
        String titre = null;

        String req = "SELECT NomEntreprise FROM user WHERE id = ?";
        PreparedStatement pst = cnx.prepareStatement(req);
        pst.setInt(1, id_entreprise);

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            titre = rs.getString("NomEntreprise");
        }

        return titre;
    }
}
