/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class Offre {
    private int id_offre ; 
    private String titre;
    private String description;
    private int id_domaine;
//    Date date_offres = Date.valueOf("2024-02-03");
    Date date_offre ;// Date.valueOf(LocalDate.now());

    public Offre(String titre, String description, int id_domaine) {
        this.titre = titre;
        this.description = description;
        this.id_domaine = id_domaine;
        this.date_offre = Date.valueOf(LocalDate.now());
    }

    public Offre(int id_offre, String titre, String description, int id_domaine, Date date_offre) {
        this.id_offre = id_offre;
        this.titre = titre;
        this.description = description;
        this.id_domaine = id_domaine;
        this.date_offre = date_offre;
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

    public int getId_domaine() {
        return id_domaine;
    }

    public void setId_domaine(int id_domaine) {
        this.id_domaine = id_domaine;
    }

    public Date getDate_offre() {
        return date_offre;
    }

    public void setDate_offre(Date date_offre) {
        this.date_offre = date_offre;
    }

    @Override
    public String toString() {
        return "Offre{" + "id_offre=" + id_offre + ", titre=" + titre + ", description=" + description + ", id_domaine=" + id_domaine + ", date_offre=" + date_offre + "} \n ";
    }
    
    

    
}
