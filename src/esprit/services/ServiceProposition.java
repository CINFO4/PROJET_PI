/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esprit.services;
import esprit.entities.proposition;
import esprit.utils.DataSource;
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
    
    public void ajouter(proposition p) {
        try {
            String req = "INSERT INTO proposition(id_proposition, description, etat) VALUES (?,?,?);";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, p.getdescription());
            pst.setString(1, p.getetat());
            pst.executeUpdate();
            System.out.println("Proposition ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void modifier(proposition p) {
        try {
            String req = "UPDATE proposition SET description=?, etat=? WHERE id_proposition=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(3, p.getid_proposition());
            pst.setString(1, p.getdescription());
            pst.setString(2, p.getetat());
            pst.executeUpdate();
            System.out.println("Proposition modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void supprimer(proposition p) {
        try {
            String req = "DELETE from proposition WHERE id_proposition=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getid_proposition());
            pst.executeUpdate();
            System.out.println("Proposition supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List<proposition> afficher() {
        List<proposition> list = new ArrayList<>();
        
        String req = "SELECT * FROM proposition";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new proposition(rs.getInt("id_proposition"), rs.getString("description"), rs.getString("etat")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return list;
    }
}
