/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.SousCategorie;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ServiceSousCategorie implements IServices<SousCategorie>{
    Connection cnx = DataSource.getInstance().getCnx();
    
    
    @Override
    public void ajouter(SousCategorie sc) {
        String req = "INSERT INTO souscategorie (nom_sous_cat) VALUES (?)";
        try {
            
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, sc.getNom_sous_cat());
            pst.executeUpdate();
            System.out.println("ajout avec succes !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(SousCategorie sc) {
         String req = "UPDATE souscategorie SET nom_sous_cat = ? WHERE id_sous_cat  = ?";
        try {
            
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, sc.getNom_sous_cat());
            pst.setInt(2, sc.getId_sous_cat());
            pst.executeUpdate();
            System.out.println("modifier avec succes !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(SousCategorie sc) {
        String req ="DELETE FROM souscategorie WHERE id_sous_cat = ?";
        try{
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,sc.getId_sous_cat());
            pst.executeUpdate();
            System.out.println("supprimer avec succes !");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<SousCategorie> afficher() {
        List<SousCategorie> list = new ArrayList<>();
        String req = "SELECT * FROM souscategorie";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                list.add(new SousCategorie(res.getInt(1), res.getString(2)));
            }
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list ;
    }
    
}
