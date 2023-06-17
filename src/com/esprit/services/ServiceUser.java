/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mehdi
 */
public class ServiceUser {

    private final Connection cnx = DataSource.getInstance().getCnx();

    public String getUserMail(int id) throws SQLException {
        String mail = null;
        String req = "SELECT mail FROM user where id = ?";

        PreparedStatement pst = cnx.prepareStatement(req);
        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            mail = rs.getString("mail");
        }

        return mail;
    }

    public String getNomEntreprise(int id_entreprise) throws SQLException {
        String titre = null;

        String req = "SELECT NomEntreprise FROM user WHERE id = ?";
        PreparedStatement pst = cnx.prepareStatement(req);
        pst.setInt(1, id_entreprise);

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            titre = rs.getString("NomEntreprise");
        }

        return titre;
    }

    public String getNomUser(int id_user) throws SQLException {
        String titre = null;

        String req = "SELECT prenom, nom FROM user WHERE id = ?";
        PreparedStatement pst = cnx.prepareStatement(req);
        pst.setInt(1, id_user);

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            String prenom = rs.getString("prenom");
            String nom = rs.getString("nom");

            titre = prenom + " " + nom;
        }

        return titre;
    }
}
