/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;
import com.esprit.entities.Proposition;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abdel
 */
public class ServiceProposition {
    
    private final Connection cnx = DataSource.getInstance().getCnx();
    
    public void ajouter(Proposition p) {
        try {
            String req = "INSERT INTO Proposition(description, etat, id_question) VALUES (?,?,?);";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, p.getDescription());
            pst.setString(2, p.getEtat());
            pst.setInt(3, p.getId_question());
            pst.executeUpdate();
            System.out.println("Proposition ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void modifier(Proposition p) {
        try {
            String req = "UPDATE Proposition SET description=?, etat=?, id_question=? WHERE id_proposition=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(4, p.getId_proposition());
            pst.setString(1, p.getDescription());
            pst.setString(2, p.getEtat());
            pst.setInt(3, p.getId_question());
            pst.executeUpdate();
            System.out.println("Proposition modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void supprimer(int id_question) {
        try {
            String req = "DELETE from Proposition WHERE id_question=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, id_question);
            pst.executeUpdate();
            } 
            catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List<Proposition> afficher() {
        List<Proposition> list = new ArrayList<>();
        
        String req = "SELECT * FROM Proposition";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Proposition(rs.getInt("id_proposition"), rs.getString("description"), rs.getString("etat"), rs.getInt("id_question")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return list;
    }
    
    public List<Proposition> afficherByIDquestion(int id) {
        List<Proposition> list = new ArrayList<>();
        
        String req = "SELECT * FROM Proposition where id_question = ?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Proposition(rs.getInt("id_proposition"), rs.getString("description"), rs.getString("etat"), rs.getInt("id_question")));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
               
        return list;
    }
    
    
    public String BonnereponseByIDquestion(int id) {
       String BonneReponse = "";
        
        String req = "SELECT * FROM Proposition where id_question = ? and etat = ? ";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, id);
            pst.setString(2, "vrai");
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
             BonneReponse = rs.getString("description");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
               
        return BonneReponse;
    }
}
