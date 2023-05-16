/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.Candidat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.sql.DataSource;
import com.esprit.utils.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Anis
 */
public class ServiceCandidat implements IService<Candidat>{

        private Connection cnx = DataSource.GetInstance().GetCnx();
        
    @Override
    public void ajouter(Candidat p) {
        try{
            String req = "insert into user (nom,prenom,adresse,numero_téléphone,motdepasse,description,education) values (?,?,?,?,?,?,?);";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setString(3, p.getAdresse());
            pst.setInt(4, p.getNumero_téléphone());
            pst.setString(5, p.getMotdepasse());
            pst.setString(6, p.getDescription());
            pst.setObject(7, p.getEducation());
            pst.executeUpdate();
            System.out.println("Candidat ajouté");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
    }
       

    @Override
    public void modifier(Candidat p) {
        try{
            String req = "update user set nom=?,prenom=?,adresse=?,numero_téléphone=?,motdepasse=?,description=?, education=? where id=?;";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setString(3, p.getAdresse());
            pst.setInt(4, p.getNumero_téléphone());
            pst.setString(5, p.getMotdepasse());
            pst.setString(6, p.getDescription());
            pst.setObject(7, p.getEducation());
            pst.setInt(8, p.getId());
            pst.executeUpdate();
            System.out.println("Candidat modifié");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
      
    }

    @Override
    public void supprimer(Candidat p) {
         try{
            String req = "delete from user where id=?;";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getId());
            pst.executeUpdate();
            System.out.println("Candidat supprimé");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
       
    }

    @Override
    public List<Candidat> afficher() {
        List<Candidat> list = new ArrayList<>();
        
        String req = "SELECT * FROM user";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            ResultSet rs = st.executeQuery(req);
            while(rs.next()) {
                list.add(new Candidat(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"),rs.getInt("numero_téléphone"),rs.getString("motdepasse"),rs.getString("description"),rs.getObject("education")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return list;
    }
        
    }
    
    
    

