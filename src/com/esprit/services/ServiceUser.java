/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.utils.DataSource;
import java.sql.Connection;
import com.esprit.entities.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
        

/**
 *
 * @author Anis
 */
public class ServiceUser {
    private Connection cnx = DataSource.getInstance().getCnx();
    
    public void ajouter(User p) {
        if (p instanceof Candidat) {
            try{
                
            String req = "insert into user (nom,prenom,adresse,numero_téléphone,motdepasse,description,education,role) values (?,?,?,?,?,?,?,?);";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setString(3, p.getAdresse());
            pst.setInt(4, p.getNumero_téléphone());
            pst.setString(5, p.getMotdepasse());
            pst.setString(6, p.getDescription());
            pst.setObject(7, ((Candidat) p).getEducation()) ;
            pst.setObject(8, p.getRole());
            pst.executeUpdate();
            System.out.println("Candidat ajouté");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
    }
        else if(p  instanceof Entreprise){
            try{
            String req = "insert into user (nom,prenom,adresse,numero_téléphone,motdepasse,description,NomEntreprise,role) values (?,?,?,?,?,?,?,?);";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setString(3, p.getAdresse());
            pst.setInt(4, p.getNumero_téléphone());
            pst.setString(5, p.getMotdepasse());
            pst.setString(6, p.getDescription());
            pst.setString(7, ((Entreprise) p).getNomEntreprise());
            pst.setObject(8, p.getRole());
            
            pst.executeUpdate();
            System.out.println("Entreprise ajouté");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
        }
        else {
            try{
            String req = "insert into user (nom,prenom,adresse,numero_téléphone,motdepasse,description,role) values (?,?,?,?,?,?,?);";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setString(3, p.getAdresse());
            pst.setInt(4, p.getNumero_téléphone());
            pst.setString(5, p.getMotdepasse());
            pst.setString(6, p.getDescription());
            pst.setObject(7, p.getRole());
            
            pst.executeUpdate();
            System.out.println("Admin ajouté");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
        }
        }
    
    public void modifier(User p) {
        if (p instanceof Candidat){
            
         try {
            String req = "UPDATE User SET nom=?, prenom=?, adresse=?, numero_téléphone=?, motdepasse=?, description=?, education=?, role=?   WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(9, p.getId());
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setString(3, p.getAdresse());
            pst.setInt(4, p.getNumero_téléphone());
            pst.setString(5, p.getMotdepasse());
            pst.setString(6, p.getDescription());
            pst.setObject(7, ((Candidat) p).getEducation());
            pst.setObject(8, p.getRole());
            pst.executeUpdate();
            System.out.println("Candidat modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
        else if (p instanceof Entreprise){
            try {
            String req = "UPDATE User SET nom=?, prenom=?, adresse=?, numero_téléphone=?, motdepasse=?, description=?, NomEntreprise, role=?   WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(9, p.getId());
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setString(3, p.getAdresse());
            pst.setInt(4, p.getNumero_téléphone());
            pst.setString(5, p.getMotdepasse());
            pst.setString(6, p.getDescription());
            pst.setObject(7, ((Entreprise) p).getNomEntreprise());
            pst.setObject(8, p.getRole());
            pst.executeUpdate();
            System.out.println("Entreprise modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }
    }
    
    
}
