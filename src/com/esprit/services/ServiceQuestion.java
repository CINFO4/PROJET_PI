/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;
import com.esprit.entities.Question;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abdel
 */
public class ServiceQuestion {
    
    private final Connection cnx = DataSource.getInstance().getCnx();
    
    public void ajouter(Question q) {
        try {
            String req = "INSERT INTO Question(libelle, etat_question, id_c) VALUES (?,?,?);";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, q.getLibelle());
            pst.setString(2, q.getEtat_question());
             pst.setInt(3, q.getId_c());
            pst.executeUpdate();
            System.out.println("Question ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void modifier(Question q) {
        try {
            String req = "UPDATE Question SET libelle=?, etat_question=?, id_c=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(4, q.getId_question());
            pst.setString(1, q.getLibelle());
            pst.setString(2, q.getEtat_question());
            pst.setInt(3, q.getId_c());
            pst.executeUpdate();
            System.out.println("Question modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void supprimer(Question q) {
        try {
            String req = "DELETE from Question WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, q.getId_question());
            pst.executeUpdate();
            System.out.println("Question supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List<Question> afficher() {
        List<Question> list = new ArrayList<>();
        
        String req = "SELECT * FROM Question";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Question(rs.getInt("id_question"), rs.getString("libelle"), rs.getString("etat_question"), rs.getInt("id_c")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return list;
    }
}
