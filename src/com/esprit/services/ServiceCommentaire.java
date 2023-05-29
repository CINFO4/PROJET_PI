/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.Commentaire;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class ServiceCommentaire implements IService<Commentaire>{
    private Connection cnx = DataSource.getInstance().getCnx();
    
    public void ajouter(Commentaire C) {
        try {
            String req = "INSERT INTO commentaire(contenu, id_forum, id_user) VALUES (?,?,?);";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, C.getContenu());
            pst.setInt(2, C.getId_forum());
            pst.setInt(3, C.getId_user());
            pst.executeUpdate();
            System.out.println("Commentaire ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void modifier(Commentaire C) {
        try {
            String req = "UPDATE commentaire SET contenu=? WHERE id_commentaire=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, C.getContenu());
            pst.setInt(2, C.getId_commentaire());
            pst.executeUpdate();
            System.out.println("Commentaire modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void supprimer(Commentaire C) {
        try {
            String req = "DELETE from commentaire WHERE id_commentaire=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, C.getId_commentaire());
            pst.executeUpdate();
            System.out.println("Commentaire supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List<Commentaire> afficher() {
        List<Commentaire> list = new ArrayList<>();
        
        String req = "SELECT * FROM commentaire";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Commentaire(rs.getInt("id_commentaire"), rs.getString("contenu"), rs.getInt("id_forum"), rs.getInt("id_user")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return list;
    }  
}
