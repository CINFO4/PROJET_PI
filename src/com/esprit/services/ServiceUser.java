/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.utils.DataSource;
import java.sql.Connection;
import com.esprit.entities.*;
import com.mysql.cj.conf.PropertyKey;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
        

/**
 *
 * @author Anis
 */
public class ServiceUser {
    private Connection cnx = DataSource.GetInstance().getCnx();
    
    public void ajouter(User p) {
        if (p instanceof Candidat) {
            try{
             int id_user =0;   
            String req = "insert into user (nom,prenom,mail,numero_telephone,motdepasse,description,education,role, Github, experience) values (?,?,?,?,?,?,?,?,?,?);";
            String req1 = "insert into profil (id_user,id_competence) values (?,?);";
            String req2= "select last_insert_id() from user;";
            PreparedStatement pst = cnx.prepareStatement(req);
            PreparedStatement pst1 = cnx.prepareStatement(req1);
            PreparedStatement pst2 = cnx.prepareStatement(req2);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setString(3, p.getMail());
            pst.setInt(4, p.getNumero_téléphone());
            pst.setString(5, p.getMotdepasse());
            pst.setString(6, p.getDescription());
            pst.setString(7, ((Candidat) p).getEducation().name());
            pst.setString(8, p.getClass().toString());
            pst.setString(9, ((Candidat) p).getGithub());
            pst.setString(10, ((Candidat) p).getExperience().name());
            pst.executeUpdate();
            ResultSet rs = pst2.executeQuery();
            while (rs.next()){
                id_user = rs.getInt("last_insert_id()");
            }
            for (int id : ((Candidat) p).getListeCompetences()){
                 pst1.setInt(1,id_user );
                 pst1.setInt(2, id);
                 pst1.executeUpdate();
            }
            
            
            System.out.println("Candidat ajouté");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
    }
        else if(p  instanceof Entreprise){
            try{
            String req = "insert into user (nom,prenom,mail,numero_telephone,motdepasse,description,NomEntreprise,role,TailleEntreprise,SiteWeb,Linkedin,id_domaine) values (?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setString(3, p.getMail());
            pst.setInt(4, p.getNumero_téléphone());
            pst.setString(5, p.getMotdepasse());
            pst.setString(6, p.getDescription());
            pst.setString(7, ((Entreprise) p).getNomEntreprise());
            pst.setString(8, p.getClass().toString());
            pst.setString(9, ((Entreprise) p).getTailleEntreprise().name());
            pst.setString(10, ((Entreprise) p).getSiteWeb());
            pst.setString(11, ((Entreprise) p).getLinkedin());
            pst.setInt(12, ((Entreprise) p).getId_domaine());
            
            pst.executeUpdate();
            System.out.println("Entreprise ajoutée");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
        }
        else {
            try{
            String req = "insert into user (nom,prenom,mail,numero_telephone,motdepasse,description,role) values (?,?,?,?,?,?,?);";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setString(3, p.getMail());
            pst.setInt(4, p.getNumero_téléphone());
            pst.setString(5, p.getMotdepasse());
            pst.setString(6, p.getDescription());
            pst.setString(7, p.getClass().toString());
            
            pst.executeUpdate();
            System.out.println("Admin ajouté");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
        }
        }
    
    public void modifier(User p) {
        if (p instanceof Candidat){
            
         try {
            String req = "UPDATE User SET nom=?, prenom=?, mail=?, numero_telephone=?, motdepasse=?, description=?, education=?, github=?, experience=?   WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(9, p.getId());
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setString(3, p.getMail());
            pst.setInt(4, p.getNumero_téléphone());
            pst.setString(5, p.getMotdepasse());
            pst.setString(6, p.getDescription());
            pst.setString(7, ((Candidat) p).getEducation().name());
            pst.setString(8, ((Candidat) p).getGithub());
            pst.setString(9, ((Candidat) p).getExperience().name());
            pst.executeUpdate();
            System.out.println("Candidat modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
        else if (p instanceof Entreprise){
            try {
            String req = "UPDATE User SET nom=?, prenom=?, adresse=?, numero_telephone=?, motdepasse=?, description=?, NomEntreprise=?, role=?, TailleEntreprise=?, SiteWeb=?, Linkedin=?, id_domaine=?   WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(13, p.getId());
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setString(3, p.getMail());
            pst.setInt(4, p.getNumero_téléphone());
            pst.setString(5, p.getMotdepasse());
            pst.setString(6, p.getDescription());
            pst.setString(7, ((Entreprise) p).getNomEntreprise());
            pst.setString(8, p.getClass().toString());
            pst.setString(9, ((Entreprise) p).getTailleEntreprise().name());
            pst.setString(10, ((Entreprise) p).getSiteWeb());
            pst.setString(11, ((Entreprise) p).getLinkedin());
            pst.setInt(12, ((Entreprise) p).getId_domaine());
            
            pst.executeUpdate();
            System.out.println("Entreprise modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }
        else {
            try {
            String req = "UPDATE User SET nom=?, prenom=?, mail=?, numero_telephone=?, motdepasse=?, description=?,role=?   WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(8, p.getId());
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setString(3, p.getMail());
            pst.setInt(4, p.getNumero_téléphone());
            pst.setString(5, p.getMotdepasse());
            pst.setString(6, p.getDescription());
            pst.setString(7, p.getClass().toString());
            pst.executeUpdate();
            System.out.println("Admin modifiée !");
        }
            catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }
    }
    
    public void supprimer(User p) {
        try {
            String req = "DELETE from User WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getId());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        if (p instanceof Candidat){
            System.out.println("Candidat supprimée !");
        }
        else if (p instanceof Entreprise){
            System.out.println("Entreprise supprimée !");
        }
        else {
            System.out.println("Admin supprimée !");
        }
    }
    
    public List<User> afficher() {
        List<User> list = new ArrayList<>();
        
        String req = "SELECT * FROM user";
     
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String mail = rs.getString("mail");
                int numeroTelephone = rs.getInt("numero_telephone");
                String motdepasse = rs.getString("motdepasse");
                String description = rs.getString("description");
                String NomEntreprise= rs.getString("NomEntreprise");
                String role = rs.getString("role");               
                if (role.equals("class com.esprit.entities.Candidat")){
                    Diplome education = Diplome.valueOf(rs.getString("education"));
                    String Github = rs.getString("Github");
                    Experience experience = Experience.valueOf(rs.getString("experience"));
                    User candidat = new Candidat(id,nom, prenom, mail, numeroTelephone, motdepasse, description, education,Github, experience );
                    list.add(candidat);
                }
                else if (role.equals("class com.esprit.entities.Entreprise")){
                    Taille TailleEntreprise = Taille.valueOf(rs.getString("TailleEntreprise"));
                    String SiteWeb = rs.getString("SiteWeb");
                    String Linkedin = rs.getString("Linkedin");
                    int id_domaine = rs.getInt("id_domaine");
                    User entreprise = new Entreprise(id, nom, prenom, mail, numeroTelephone, motdepasse, description, NomEntreprise, TailleEntreprise, SiteWeb, Linkedin, id_domaine);
                    list.add(entreprise);
                }
                else{
                    User admin = new Administrateur(id,nom, prenom, mail, numeroTelephone, motdepasse, description);
                    list.add(admin);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return list;
    
    
    }
    

public class entreprisedomaine extends Entreprise{

        
        private String nom_domaine;

        public entreprisedomaine(int id, String nom, String prenom, String mail, int numero_téléphone, String motdepasse, String description, String NomEntreprise, Taille TailleEntreprise, String SiteWeb, String Linkedin, int id_domaine, String nom_domaine) {
            super(id, nom, prenom, mail, numero_téléphone, motdepasse, description, NomEntreprise, TailleEntreprise, SiteWeb, Linkedin, id_domaine);
            this.nom_domaine = nom_domaine;
        }
        
        public String getNom_domaine() {
            return nom_domaine;
        }

        public void setNom_domaine(String nom_domaine) {
            this.nom_domaine = nom_domaine;
        }

        @Override
        public String toString() {
            return "entreprisedomaine{" + super.toString() + "nom_domaine=" + nom_domaine + '}';
        }

       

    }
        public List<entreprisedomaine> afficherentreprise(){
        List<entreprisedomaine> list = new ArrayList<>();
        String req = "select id, nom, prenom, mail, numero_telephone, motdepasse, description, NomEntreprise, role, TailleEntreprise, SiteWeb, Linkedin, e.id_domaine, d.nom_domaine from User e join Domaine d on e.id_domaine=d.id_domaine;";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String mail = rs.getString("mail");
                int numeroTelephone = rs.getInt("numero_telephone");
                String motdepasse = rs.getString("motdepasse");
                String description = rs.getString("description");
                Taille TailleEntreprise = Taille.valueOf(rs.getString("TailleEntreprise"));
                String NomEntreprise= rs.getString("NomEntreprise");    
                String SiteWeb = rs.getString("SiteWeb");
                String Linkedin = rs.getString("Linkedin");
                int id_domaine = rs.getInt("id_domaine");
                String nom_domaine = rs.getString("nom_domaine");
                entreprisedomaine ed = new entreprisedomaine(id,nom,prenom, mail, numeroTelephone, motdepasse, description, NomEntreprise, TailleEntreprise, SiteWeb, Linkedin, id_domaine, nom_domaine);
                    list.add(ed);
            }
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
            
        }
        public ObservableList<User> getalluser() {
        ObservableList<User> list = FXCollections.observableArrayList();
        boolean entrepriseajoutee = false;
        String req = "SELECT * FROM user";
     
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String mail = rs.getString("mail");
                int numeroTelephone = rs.getInt("numero_telephone");
                String motdepasse = rs.getString("motdepasse");
                String description = rs.getString("description");
                String NomEntreprise= rs.getString("NomEntreprise");
                String role = rs.getString("role");               
                if (role.equals("class com.esprit.entities.Candidat")){
                    Diplome education = Diplome.valueOf(rs.getString("education"));
                    String Github = rs.getString("Github");
                    Experience experience = Experience.valueOf(rs.getString("experience"));
                    User candidat = new Candidat(id,nom, prenom, mail, numeroTelephone, motdepasse, description, education,Github, experience );
                    list.add(candidat);
                }
                else if (role.equals("class com.esprit.entities.Entreprise")){
                   
                    if (!entrepriseajoutee ){
                    list.addAll(afficherentreprise());
                    entrepriseajoutee  = true;
                }
                }
                else{
                    User admin = new Administrateur(id,nom, prenom, mail, numeroTelephone, motdepasse, description);
                    list.add(admin);
                }
            }
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return list;
    
    
    }
        
        public List<String> affichercompetence(int id) {
        List<String> list = new ArrayList<>();
        
        String req = "SELECT nom FROM profil where id=?";
     
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,id);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                list.add(res.getString("nom"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return list;
    
    
    }
        
    public int getuserid(String mail){
        int id=0;
        String req = "SELECT id from User where mail=?";
     
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1,mail);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                id = res.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
     
    }
   
    
    

