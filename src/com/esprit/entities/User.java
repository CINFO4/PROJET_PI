/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

import java.util.Objects;

/**
 *
 * @author Anis
 */
public class User {

    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private Integer numero_telephone;
    private String motdepasse;
    private String description;

    public User(int id, String nom, String prenom, String mail, Integer numero_telephone, String motdepasse, String description) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.numero_telephone = numero_telephone;
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
