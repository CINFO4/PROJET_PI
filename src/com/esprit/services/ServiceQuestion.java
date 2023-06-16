/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;
import com.esprit.entities.Competence;
import com.esprit.entities.Question;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;

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
            String req = "UPDATE Question SET libelle=?, etat_question=?, id_c=? WHERE id_question=?";
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
            String req = "DELETE from Question WHERE id_question=?";
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

    public List<QuestionView> GetQuestionsByCompetences(ObservableList<String> selectedCompetences) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public class QuestionView {
        
    private int id_question;
    private String libelle;
    private String etat_question;
    private int id_c;
    private String nomc;

        public int getId_question() {
            return id_question;
        }

        public void setId_question(int id_question) {
            this.id_question = id_question;
        }

        public String getLibelle() {
            return libelle;
        }

        public void setLibelle(String libelle) {
            this.libelle = libelle;
        }

        public String getEtat_question() {
            return etat_question;
        }

        public void setEtat_question(String etat_question) {
            this.etat_question = etat_question;
        }

        public int getId_c() {
            return id_c;
        }

        public void setId_c(int id_c) {
            this.id_c = id_c;
        }

        public String getNomc() {
            return nomc;
        }

        public void setNomc(String nomc) {
            this.nomc = nomc;
        }

        public QuestionView(int id_question, String libelle, String etat_question, int id_c, String nomc) {
            this.id_question = id_question;
            this.libelle = libelle;
            this.etat_question = etat_question;
            this.id_c = id_c;
            this.nomc = nomc;
        }

        @Override
        public String toString() {
            return "QuestionView{" + "id_question=" + id_question + ", libelle=" + libelle + ", etat_question=" + etat_question + ", id_c=" + id_c + ", nomc=" + nomc + '}';
        }
    
    
    }
    
    public List<QuestionView> afficherQuestionView() {
        List<QuestionView> list = new ArrayList<>();
        
        String req = "SELECT id_question, libelle,etat_question,id_c,(select c.nom from Competence c where c.id_c=q.id_c) as nomc FROM Question q";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new QuestionView(rs.getInt("id_question"), rs.getString("libelle"), rs.getString("etat_question"), rs.getInt("id_c"), rs.getString("nomc")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return list;
    }
    
    
    
    public List<QuestionView> afficherQuestionViewByCom(String comp) {
        List<QuestionView> list = new ArrayList<>();
        
        String req = "SELECT id_question, libelle, etat_question, id_c, (SELECT c.nom FROM Competence c WHERE c.id_c = q.id_c) AS nomc FROM Question q WHERE (SELECT c.nom FROM Competence c WHERE c.id_c = q.id_c) = ?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, comp);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new QuestionView(rs.getInt("id_question"), rs.getString("libelle"), rs.getString("etat_question"), rs.getInt("id_c"), rs.getString("nomc")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return list;
    }
    
    
    
    public int GetidQuestionbynom(String libelle){
    int id = 0;
    String req = "SELECT id_question FROM Question q where q.libelle like ?";
    try {
        PreparedStatement pst = cnx.prepareStatement(req);
        pst.setString(1, libelle);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            
            id = rs.getInt("id_question");
         
                    
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }

    return id;
    }
     
    
       
       public List<Question> GetQuestionsByCompetences(int id_c){
           List<Question> relatedQuestions = new ArrayList<>();
    String req = "SELECT libelle, etat_question, id_c FROM Question q where q.id_c = ?";
    try {
        PreparedStatement pst = cnx.prepareStatement(req);
        pst.setInt(1, id_c);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            
           String libelle = rs.getString("libelle");
            String etat_question = rs.getString("etat_question");
            Question question = new Question(libelle,id_c);
            relatedQuestions.add(question);
         
                    
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }

    return relatedQuestions;
    }
       
       
       
       public boolean questionExists(String libelle) {
    
   
 String req = "SELECT COUNT(*) FROM question WHERE libelle = ?";
    try {
        
       PreparedStatement pst = cnx.prepareStatement(req);
        pst.setString(1, libelle);
        ResultSet rs = pst.executeQuery();

       if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0;
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    } finally {
       
    }

    return false; 
}

}
