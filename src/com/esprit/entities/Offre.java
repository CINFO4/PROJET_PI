/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class Offre {
    private int id_offre ; 
    private String titre;
    private String description;
    //Date date = Date.valueOf("2024-02-03");

    public Offre(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }

    public Offre(int id_offre, String titre, String description) {
        this.id_offre = id_offre;
        this.titre = titre;
        this.description = description;
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Offre{" + "id_offre=" + id_offre + ", titre=" + titre + ", description=" + description + '}';
    }
    
    
    
}
