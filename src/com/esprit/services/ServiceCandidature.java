/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.Candidature;
import com.esprit.entities.EtatCandidature;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ServiceCandidature implements IServices<Candidature>{
    private Connection cnx = DataSource.getInstance().getCnx();
    @Override
    public void ajouter(Candidature c) {
        try {
            String req = "INSERT INTO candidature"
                    + " (id_user,id_offre,id_candidature)"
                    + " VALUES (?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,c.getId_user());
            pst.setInt(2,c.getId_offre());
            pst.setInt(3, c.getId_candidature());
         
            
            pst.executeUpdate();
            System.out.println("ajout avec success !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Candidature c) {
        try {
            String req = "UPDATE candidature SET date_candidature = ?  , etat = ? "
                    + "WHERE id_user= ? and id_offre = ? and id_candidature =?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setDate(1, c.getDate_condidature());
            pst.setString(2, c.getEtat().toString());
            pst.setInt(3, c.getId_user());
            pst.setInt(4, c.getId_offre());
            pst.setInt(5, c.getId_candidature());
            
            
            pst.executeUpdate();
            System.out.println("modifier avec success !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Candidature c) {
        try {
            String req = "DELETE FROM candidature WHERE "
                    + "id_user= ? and id_offre = ? and id_candidature =?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, c.getId_user());
            pst.setInt(2, c.getId_offre());
            pst.setInt(3, c.getId_candidature());
            pst.executeUpdate();
            System.out.println("supprimer avec success !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }
    }

    @Override
    public List<Candidature> afficher() {
        List<Candidature> list = new ArrayList<>();
        try {  
            String req = "SELECT * FROM candidature";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            
            while (res.next()) {
                list.add(new Candidature(res.getInt("id_user"),res.getInt("id_offre") , res.getInt("id_candidature"),res.getDate("date_candidature"), EtatCandidature.valueOf(res.getString("etat"))));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
}
