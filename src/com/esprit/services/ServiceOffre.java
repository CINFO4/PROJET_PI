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
public class ServiceOffre {
    
    private final Connection cnx = DataSource.getInstance().getCnx();

    
    public String getTitreOffre(int id_offre) throws SQLException {
        String titre = null;

        String req = "SELECT titre FROM offre WHERE id_offre = ?";
        PreparedStatement pst = cnx.prepareStatement(req);
        pst.setInt(1, id_offre);

        ResultSet rs = pst.executeQuery();
        while(rs.next()) {
            titre = rs.getString("titre");
        }

        return titre;
    }
}
