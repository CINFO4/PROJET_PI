/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.Forum;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafik
 */
public class ServiceForum implements IService<Forum>{
    
    private Connection cnx = DataSource.getInstance().getCnx();
    
    public void ajouter(Forum F) {
        try {
            String req = "INSERT INTO forum(id_forum, nom_forum, id_user) VALUES (?,?,?);";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, F.getId_forum());            
            pst.setString(2, F.getNom_forum());
            pst.setInt(3, F.getId_user());
            pst.executeUpdate();
            System.out.println("Forum ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void modifier(Forum F) {
        try {
            String req = "UPDATE forum SET nom_forum=? WHERE id_forum=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, F.getNom_forum());
            pst.setInt(2, F.getId_forum());
            pst.executeUpdate();
            System.out.println("Forum modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void supprimer(Forum F) {
        try {
            String req = "DELETE from forum WHERE id_forum=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, F.getId_forum());
            pst.executeUpdate();
            System.out.println("Forum supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List<Forum> afficher() {
        List<Forum> list = new ArrayList<>();
        
        String req = "SELECT * FROM forum";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Forum(rs.getInt("id_forum"), rs.getString("nom_forum"), rs.getInt("id_user")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return list;
    }

}
