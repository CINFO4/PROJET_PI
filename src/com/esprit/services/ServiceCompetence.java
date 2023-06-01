/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

/**
 *
 * author 2023
 */

import com.esprit.entities.Competence;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceCompetence {
    private final Connection cnx = DataSource.getInstance().getCnx();

    public void ajouter(Competence competence) {
        try {
            String req = "INSERT INTO competences(id_c, nom, description) VALUES (?, ?, ?);";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, competence.getId_c());
            pst.setString(2, competence.getNom());
            pst.setString(3, competence.getDescription());
            
            pst.executeUpdate();
            System.out.println("Compétence ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modifier(Competence competence) {
        try {
            String req = "UPDATE competences SET nom=?, description=? WHERE id_c=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, competence.getNom());
            pst.setString(2, competence.getDescription());
           
            pst.setInt(3, competence.getId_c());
            pst.executeUpdate();
            System.out.println("Compétence modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimer(Competence competence) {
        try {
            String req = "DELETE FROM competences WHERE id_c=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, competence.getId_c());
            pst.executeUpdate();
            System.out.println("Compétence supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Competence> afficher() {
    List<Competence> list = new ArrayList<>();

    String req = "SELECT id_c, nom, description FROM competences";
    try {
        PreparedStatement pst = cnx.prepareStatement(req);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            int id_c = rs.getInt("id_c");
            String nom = rs.getString("nom");
            String description = rs.getString("description");
            Competence competence = new Competence(id_c, nom, description);
            list.add(competence);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }

    return list;
}
    
    
    public String getNameCompetenceById(int id_c){
        String req = "SELECT nom FROM Competence WHERE  id_c= ? ";
        String  name = null ;
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,id_c);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                name = res.getString("nom");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return name ;
    }
    public List<String> affichercompetencebynom() {
    List<String> list = new ArrayList<>();

    String req = "SELECT nom FROM competence";
    try {
        PreparedStatement pst = cnx.prepareStatement(req);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            
            String nom = rs.getString("nom");
            
           
            list.add(nom);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }

    return list;
    
    }
    public int Getidcompetencebynom(String nom){
    int id = 0;
    String req = "SELECT id_c FROM competence c where c.nom like ?";
    try {
        PreparedStatement pst = cnx.prepareStatement(req);
        pst.setString(1, nom);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            
            id = rs.getInt("id_c");
            
                    
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }

    return id;
    }
    
        
  public List<String> GetCompetencesByNames() {
    List<String> list = new ArrayList<>();

    String req = "SELECT nom FROM competence";
    try {
        PreparedStatement pst = cnx.prepareStatement(req);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            
            String nom = rs.getString("nom");
            
           
            list.add(nom);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }

    return list;
    
    }
}
