/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Anis
 */
public abstract class User {

    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private Integer numero_telephone;
    private String motdepasse;
    private String description;
    
    public boolean emailvalidator(String mail){
       String email_pattern = "^[A-Za-z0-9+_.-]+@^[A-Za-z0-9+_.-]+\\.[A-Za-z]+";
        Pattern pattern = Pattern.compile(email_pattern);
        Matcher matcher = pattern.matcher(mail);
        return matcher.matches();
    }

    public User(int id, String nom, String prenom, String mail, Integer numero_telephone, String motdepasse, String description) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        if(emailvalidator(mail)){
        this.mail = mail;
        }
        else{
            System.out.println("mail invalide");
        }
        int nbr = String.valueOf(numero_telephone).length();
        if(nbr==8){
        this.numero_telephone = numero_telephone;
        }
        else{
            System.out.println("le numero de téléphone doit contenir 8 chiffres");
        }
        this.motdepasse = motdepasse;
        this.description = description;

    }

    public User(String nom, String prenom, String mail, Integer numero_telephone, String motdepasse, String description) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.numero_telephone = numero_telephone;
        this.motdepasse = motdepasse;
        this.description = description;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getNumero_telephone() {
        return numero_telephone;
    }

    public void setNumero_telephone(Integer numero_telephone) {
        this.numero_telephone = numero_telephone;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", numero_telephone=" + numero_telephone + ", motdepasse=" + motdepasse + ", description=" + description + '}';
    }

}
