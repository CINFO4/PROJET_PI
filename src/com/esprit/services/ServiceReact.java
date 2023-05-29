/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.React;
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
public class ServiceReact implements IService<React>{
    private Connection cnx = DataSource.getInstance().getCnx();
    
    public void ajouter(React R) {
        try {
            String req = "INSERT INTO react(liked, id_commentaire, id_user) VALUES (?,?,?);";
            PreparedStatement pst = cnx.prepareStatement(req);          
            pst.setBoolean(1, R.isLiked());
            pst.setInt(2, R.getId_Commentaire());
            pst.setInt(3, R.getId_user());           
            pst.executeUpdate();
            System.out.println("react ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
        public void modifier(React R) {
        try {
            String req = "UPDATE react SET liked=? WHERE id_react=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setBoolean(1, R.isLiked());
            pst.setInt(2, R.getId_react());
            pst.executeUpdate();
            System.out.println("React modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
        public void supprimer(React R) {
        try {
            String req = "DELETE from react WHERE id_react=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, R.getId_react());
            pst.executeUpdate();
            System.out.println("react supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
        public List<React> afficher() {
        List<React> list = new ArrayList<>();
        
        String req = "SELECT * FROM react";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new React(rs.getInt("id_react"), rs.getBoolean("liked"), rs.getInt("id_commentaire"),rs.getInt("id_user")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return list;
    }
    
}
