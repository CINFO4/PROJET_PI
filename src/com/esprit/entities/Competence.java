/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

/**
 *
 * @author Anis
 */
public class Competence {
    
    private int id_competence;
    private String nom_competence;
    private String description;
    private String niveau;

    public Competence(int id_competence, String nom_competence, String description, String niveau) {
        this.id_competence = id_competence;
        this.nom_competence = nom_competence;
        this.description = description;
        this.niveau = niveau;
    }

    public Competence(String nom_competence, String description, String niveau) {
        this.nom_competence = nom_competence;
        this.description = description;
        this.niveau = niveau;
    }

    public int getId_competence() {
        return id_competence;
    }

    public void setId_competence(int id_competence) {
        this.id_competence = id_competence;
    }

    public String getNom_competence() {
        return nom_competence;
    }

    public void setNom_competence(String nom_competence) {
        this.nom_competence = nom_competence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
    
    
}
