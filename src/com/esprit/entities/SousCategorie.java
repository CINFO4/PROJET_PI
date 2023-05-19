/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

/**
 *
 * @author ASUS
 */
public class SousCategorie {
    private int id_sous_cat;
    private String nom_sous_cat ;

    
    
    public SousCategorie(String nom_sous_cat) {
        this.nom_sous_cat = nom_sous_cat;
    }

    public SousCategorie(int id_sous_cat, String nom_sous_cat) {
        this.id_sous_cat = id_sous_cat;
        this.nom_sous_cat = nom_sous_cat;
    }

    public int getId_sous_cat() {
        return id_sous_cat;
    }

    public void setId_sous_cat(int id_sous_cat) {
        this.id_sous_cat = id_sous_cat;
    }

    public String getNom_sous_cat() {
        return nom_sous_cat;
    }

    public void setNom_sous_cat(String nom_sous_cat) {
        this.nom_sous_cat = nom_sous_cat;
    }

    @Override
    public String toString() {
        return "SousCategorie{" + "id_sous_cat=" + id_sous_cat + ", nom_sous_cat=" + nom_sous_cat + '}';
    }
    
    
    
    
}
