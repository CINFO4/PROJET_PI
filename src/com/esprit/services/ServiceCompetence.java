/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

/**
 *
 * @author 2023
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
            String req = "INSERT INTO competences(id_c, nom, description, niveau) VALUES (?, ?, ?, ?);";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, competence.getId_c());
            pst.setString(2, competence.getNom());
            pst.setString(3, competence.getDescription());
            pst.setString(4, competence.getNiveau());
            pst.executeUpdate();
            System.out.println("Compétence ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modifier(Competence competence) {
        try {
            String req = "UPDATE competences SET nom=?, description=?, niveau=? WHERE id_c=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, competence.getNom());
            pst.setString(2, competence.getDescription());
            pst.setString(3, competence.getNiveau());
            pst.setInt(4, competence.getId_c());
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

        String req = "SELECT * FROM competences";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Competence(rs.getInt("id_c"), rs.getString("nom"), rs.getString("description"), rs.getString("niveau")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
}