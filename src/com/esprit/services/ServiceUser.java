/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.utils.DataSource;
import java.sql.Connection;
import com.esprit.entities.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
        

/**
 *
 * @author Anis
 */
public class ServiceUser {
    private Connection cnx = DataSource.GetInstance().getCnx();
    
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
            pst.setString(7, ((Candidat) p).getEducation().toString());
            pst.setString(8, p.getRole().name());
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
            pst.setString(8, p.getRole().name());
            
            pst.executeUpdate();
            System.out.println("Entreprise ajoutée");
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
            pst.setString(7, p.getRole().name());
            
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
            pst.setString(7, ((Candidat) p).getEducation().toString());
            pst.setString(8, p.getRole().name());
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
            pst.setString(7, ((Entreprise) p).getNomEntreprise());
            pst.setString(8, p.getRole().name());
            pst.executeUpdate();
            System.out.println("Entreprise modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }
        else {
            try {
            String req = "UPDATE User SET nom=?, prenom=?, adresse=?, numero_téléphone=?, motdepasse=?, description=?,role=?   WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(8, p.getId());
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setString(3, p.getAdresse());
            pst.setInt(4, p.getNumero_téléphone());
            pst.setString(5, p.getMotdepasse());
            pst.setString(6, p.getDescription());
            pst.setString(7, p.getRole().name());
            pst.executeUpdate();
            System.out.println("Admin modifiée !");
        }
            catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }
    }
    
    public void supprimer(User p) {
        try {
            String req = "DELETE from User WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getId());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        if (p instanceof Candidat){
            System.out.println("Candidat supprimée !");
        }
        else if (p instanceof Entreprise){
            System.out.println("Entreprise supprimée !");
        }
        else {
            System.out.println("Admin supprimée !");
        }
    }
    
    public List<User> afficher() {
        List<User> list = new ArrayList<>();
        
        String req = "SELECT * FROM user";
     
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String adresse = rs.getString("adresse");
                int numeroTelephone = rs.getInt("numero_téléphone");
                String motdepasse = rs.getString("motdepasse");
                String description = rs.getString("description");
                //Diplome education = Diplome.Autre;
                //if (rs.getString("education")!= null)
                    
                String NomEntreprise= rs.getString("NomEntreprise");
                Role role = Role.valueOf(rs.getString("role"));
                if (role.name().equals("Candidat")){
                    Diplome education = Diplome.valueOf(rs.getString("education"));
                    User candidat = new Candidat(id,nom, prenom, adresse, numeroTelephone, motdepasse, description, education, role);
                    list.add(candidat);
                }
                else if (role.name().equals("Entreprise")){
                    User entreprise = new Entreprise(NomEntreprise,id, nom, prenom, adresse, numeroTelephone, motdepasse, description, role);
                    list.add(entreprise);
                }
                else{
                    User admin = new Administrateur(id,nom, prenom, adresse, numeroTelephone, motdepasse, description, role);
                    list.add(admin);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return list;
    
    
    }
    }
