/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.Domaine;
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
            String req = "INSERT INTO forum(sujet, contenu, id_user, id_domaine) VALUES (?,?,?,?);";
            PreparedStatement pst = cnx.prepareStatement(req);           
            pst.setString(1, F.getSujet());
            pst.setString(2, F.getContenu());
            pst.setInt(3, F.getId_user());
            pst.setInt(4, F.getId_domaine());
            pst.executeUpdate();
            System.out.println("Forum ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void modifier(Forum F) {
        try {
            String req = "UPDATE forum SET sujet=?, contenu=?,id_domaine=? WHERE id_forum=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, F.getSujet());
            pst.setString(2, F.getContenu());
            pst.setInt(3, F.getId_domaine());
            pst.setInt(4, F.getId_forum());
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
                list.add(new Forum(rs.getInt("id_forum"), rs.getString("sujet"),rs.getString("contenu"), rs.getInt("id_user"),rs.getInt("id_domaine")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return list;
    }
    
    public List<Domaine> getDomaines() {
        List<Domaine> domainNames = new ArrayList<>();

        String query = "SELECT * FROM domaine";
        try (PreparedStatement pst = cnx.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Domaine domaine = new Domaine(rs.getInt("id_domaine"),rs.getString("nom_domaine"));
                domainNames.add(domaine);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return domainNames;
    }

    public Domaine getDomainById(int id_domaine) {
        String query = "SELECT * FROM domaine WHERE id_domaine = ?";
        try {
            PreparedStatement pst = cnx.prepareStatement(query);
            pst.setInt(1, id_domaine);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id_domaine");
                String nom_domaine = rs.getString("nom_domaine");
                return new Domaine(id, nom_domaine);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null; // Domaine not found
    }
}
