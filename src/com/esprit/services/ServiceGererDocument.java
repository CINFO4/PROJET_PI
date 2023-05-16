/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.Document;
import com.esprit.utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceGererDocument {
    private final Connection cnx = DataSource.getInstance().getCnx();

    public void ajouter(Document document) {
        try {
            String req = "INSERT INTO document( nom_document) VALUES (?);";
            PreparedStatement pst = cnx.prepareStatement(req);
             pst.setString(1, document.getNom_document());
            pst.executeUpdate();
            System.out.println("Document ajouté !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modifier(Document document) {
        try {
            String req = "UPDATE document SET nom_document=? WHERE id_document=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, document.getNom_document());
            pst.setInt(2, document.getId_document());
            pst.executeUpdate();
            System.out.println("Document modifié !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimer(Document document) {
        try {
            String req = "DELETE FROM document WHERE id_document=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, document.getId_document());
            pst.executeUpdate();
            System.out.println("Document supprimé !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Document> afficher() {
        List<Document> list = new ArrayList<>();

        String req = "SELECT * FROM document";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Document(rs.getInt("id_document"), rs.getString("nom_document")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
}

