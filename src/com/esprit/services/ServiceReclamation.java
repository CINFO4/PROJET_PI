package com.esprit.services;

import com.esprit.entities.EtatReclamation;
import com.esprit.entities.Reclamation;
import com.esprit.utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceReclamation {

    private final Connection cnx;

    public ServiceReclamation() {
        cnx = DataSource.getInstance().getCnx();
    }

    public void ajouter(Reclamation reclamation) {
        try {
            String req = "INSERT INTO reclamation(reclamation, id_user, etat, id_offre) VALUES (?, ?, ?, ?);";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, reclamation.getReclamation());
            pst.setInt(2, reclamation.getId_user());
            pst.setString(3, reclamation.getEtat().name());
            pst.setInt(4, reclamation.getId_offre());
            pst.executeUpdate();
            System.out.println("Reclamation ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modifier(Reclamation reclamation) {
        try {
            String req = "UPDATE reclamation SET reclamation=?, etat=? WHERE id_reclamation=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, reclamation.getReclamation());
            pst.setString(2, reclamation.getEtat().name());
            pst.setInt(3, reclamation.getId_reclamation());
            pst.executeUpdate();
            System.out.println("Reclamation modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimer(int idReclamation) {
        try {
            String req = "DELETE FROM reclamation WHERE id_reclamation=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, idReclamation);
            pst.executeUpdate();
            System.out.println("Reclamation supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Reclamation> afficher() {
        List<Reclamation> list = new ArrayList<>();

        String req = "SELECT * FROM reclamation";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int idReclamation = rs.getInt("id_reclamation");
                String reclamation = rs.getString("reclamation");
                int idUser = rs.getInt("id_user");
                String etat = rs.getString("etat");
                int idOffre = rs.getInt("id_offre");


                Reclamation rec = new Reclamation(idReclamation, reclamation, idUser, EtatReclamation.valueOf(etat),idOffre);
                list.add(rec);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
    public String getTitreOffre(int id_offre) {
        String titre = null;
        
        String req = "SELECT titre FROM offre WHERE id_offre = ?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,id_offre);
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                titre = rs.getString("titre");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return titre;
    }
}
