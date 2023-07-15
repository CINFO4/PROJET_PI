/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.*;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anis
 */
public class ServiceCompetence {

    private Connection cnx = DataSource.GetInstance().getCnx();

    public void ajouter(Competence competence) {
        try {
            String req = "INSERT INTO competence(id_c, nom, description) VALUES (?, ?, ?);";
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
            String req = "UPDATE competence SET nom=?, description=? WHERE id_c=?";
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
            String req = "DELETE FROM competence WHERE id_c=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, competence.getId_c());
            pst.executeUpdate();
            System.out.println("Compétence supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int getCompetenceIdByName(String competenceName) {
        try {
            String req = "SELECT id_c FROM competence WHERE nom = ?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, competenceName);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt("id_c");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return 0;
    }

    public List<String> getCompetenceNamesByUserName(String userName) {
        List<String> competenceNames = new ArrayList<>();
        try {
            String req = "SELECT c.nom FROM competence c INNER JOIN profiles p ON c.id_c = p.id_competence INNER JOIN user u ON u.id_user = p.id_user WHERE u.nom = ?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, userName);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String competenceName = rs.getString("nom");
                competenceNames.add(competenceName);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return competenceNames;
    }

    public Profile.Niveau getNiveauByUserName(String userName) {
        Profile.Niveau niveau = null;
        try {

            String req = "SELECT DISTINCT niveau FROM profiles JOIN competence ON profiles.id_competence = competences.id_c JOIN user ON user.id_user = profiles.id_user WHERE user.nom =?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, userName);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String niveauString = rs.getString("niveau");
                niveau = Profile.Niveau.valueOf(niveauString);
            }
        } catch (SQLException ex) {
            // Handle or log the exception appropriately
            System.out.println(ex.getMessage());
        }
        return niveau;
    }

    public List<Competence> afficher() {
        List<Competence> list = new ArrayList<>();

        String req = "SELECT id_c, nom, description FROM competence";
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
    
    public String getNameCompetenceById(int id_c){
        String req = "SELECT nom FROM Competence WHERE  id_c = ? ";
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
