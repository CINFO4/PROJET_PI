/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.Domaine;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class ServiceDomaine {
        private Connection cnx = DataSource.getInstance().getCnx();
        public List<Domaine> listeDomaines() {
        List<Domaine> list = new ArrayList<>();
        
        String req = "SELECT * FROM domaine";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Domaine(rs.getInt("id_domaine"), rs.getString("nom_domaine")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return list;
    }  
}
