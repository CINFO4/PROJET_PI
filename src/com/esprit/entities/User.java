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
public class  User {
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private int numero_téléphone;
    private String motdepasse;
    private String description;
    private Role role;

    public User(int id, String nom, String prenom, String adresse, int numero_téléphone, String motdepasse, String description, Role role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numero_téléphone = numero_téléphone;
        this.motdepasse = motdepasse;
        this.description = description;
        this.role = role;
    }

    public User(String nom, String prenom, String adresse, int numero_téléphone, String motdepasse, String description, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numero_téléphone = numero_téléphone;
        this.motdepasse = motdepasse;
        this.description = description;
        this.role = role;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNumero_téléphone() {
        return numero_téléphone;
    }

    public void setNumero_téléphone(int numero_téléphone) {
        this.numero_téléphone = numero_téléphone;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.role);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return this.role == other.role;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", numero_t\u00e9l\u00e9phone=" + numero_téléphone + ", motdepasse=" + motdepasse + ", description=" + description + ", role=" + role + '}';
    }

    
    
    
    

    
    
}
