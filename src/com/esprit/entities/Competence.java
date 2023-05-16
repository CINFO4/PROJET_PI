/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

/**
 *
 * @author 2023
 */
public class Competence {
    private int id_c;
    private String nom;
    private String description;
    private String niveau;
    
    public Competence(String nom,String description ,String niveau) {
        this.nom=nom;
        this.description=description;
        this.niveau=niveau;
   }
    
    public Competence(int id_c , String nom , String description , String niveau) {
        this.id_c=id_c;
        this.nom=nom;
        this.description=description;
        this.niveau=niveau;
   }


    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    @Override
    public String toString() {
        return "Competences{" + "id_c=" + id_c + ", nom=" + nom + ", description=" + description + ", niveau=" + niveau + '}';
    }
    
}
