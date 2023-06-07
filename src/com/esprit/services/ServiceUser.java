/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.User;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class ServiceUser {
     private final Connection cnx = DataSource.getInstance().getCnx();

    public User getUserByID(int id) {
        User u = null;
        String req = "SELECT * FROM user Where id = ?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                u=new User(res.getInt("id"), res.getString("nom"), res.getString("nom"), res.getString("mail"), res.getInt("num_tel"),res.getString("mot_de_passe") , res.getString("description"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return u;
    }
}
