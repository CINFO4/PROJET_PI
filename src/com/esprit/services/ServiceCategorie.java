/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.Categorie;
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
public class ServiceCategorie implements IServices<Categorie>{
    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Categorie c) {
        String req = "INSERT INTO categorie (nom_cat) VALUES (?)";
        try {
            
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, c.getNom_cat());
            pst.executeUpdate();
            System.out.println("ajout avec succes !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Categorie c) {
        String req = "UPDATE categorie SET nom_cat = ? WHERE id_cat = ?";
        try {
            
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, c.getNom_cat());
            pst.setInt(2, c.getId_cat());
            pst.executeUpdate();
            System.out.println("modifier avec succes !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Categorie c) {
        String req ="DELETE FROM categorie WHERE id_cat = ?";
        try{
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,c.getId_cat());
            pst.executeUpdate();
            System.out.println("supprimer avec succes !");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Categorie> afficher() {
        List<Categorie> list = new ArrayList<>();
        String req = "SELECT * FROM categorie";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                list.add(new Categorie(res.getInt("id_cat"), res.getString("nom_cat")));
            }
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list ;
    }
    
    
    
}
