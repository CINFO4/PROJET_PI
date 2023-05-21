/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.Offre;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ServiceOffre implements IServices<Offre>{
    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Offre f) {
         String req ="INSERT INTO offre(titre,description,id_domaine,date_expiration) VALUES (?,?,?,?)";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            
            pst.setString(1, f.getTitre());
            pst.setString(2, f.getDescription());
            pst.setInt(3,f.getId_domaine());
            pst.setDate(4, f.getDate_Expiration());
            pst.executeUpdate();
            System.out.println("ajouter avec Succes !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Offre f) {
        String req ="UPDATE offre SET titre = ? , description = ? , id_domaine = ? , date_offre = ? , date_expiration = ? WHERE id_offre = ? ";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            
            pst.setString(1, f.getTitre());
            pst.setString(2, f.getDescription());
            pst.setInt(3, f.getId_domaine());
            pst.setDate(4, f.getDate_offre());
            pst.setDate(5, f.getDate_Expiration());
            pst.setInt(6, f.getId_offre());
            
            pst.executeUpdate();
            System.out.println("modifier avec Succes !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Offre f) {
        String req ="DELETE FROM offre WHERE id_offre = ?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, f.getId_offre());
            pst.executeUpdate();
            System.out.println("Supprimer avec Succes !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Offre> afficher() {
        List<Offre> list = new ArrayList<>();
        String req ="SELECT * FROM offre";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            
            while(res.next()){
                list.add(new Offre(res.getInt("id_offre"),res.getString("titre"), res.getString("description"),res.getInt("id_domaine"),res.getDate("date_offre"),res.getDate("date_expiration")));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list ;

    }
}
