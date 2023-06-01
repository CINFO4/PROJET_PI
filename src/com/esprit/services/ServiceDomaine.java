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
public class ServiceDomaine {
    
    private Connection cnx = DataSource.GetInstance().getCnx();
    
    public void ajouter(Domaine d) {
        try {
            String req ="INSERT INTO domaine (nom_domaine) VALUES(?)";
            
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1,d.getNom_domaine());
            pst.executeUpdate();
            System.out.println("ajouter avec Succes !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
     public List<String> getDomainesName() {
        List<String> list = new ArrayList<>();
        String req = "SELECT * FROM domaine ";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            
            while(res.next()){
                 list.add(res.getString("nom_domaine"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
        
        
    }
     public int getIdDomaineByName(String name){
        String req = "SELECT id_domaine FROM domaine WHERE nom_domaine = ? ";
        int id = 0;
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1,name);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                id = res.getInt("id_domaine");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id ;
    }
     public String getDomainenameByid(int id){
        String req = "SELECT nom_domaine FROM domaine WHERE id_domaine = ? ";
       String nom="";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,id);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                nom = res.getString("nom_domaine");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nom ;
    }
}
