/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

/**
 *
 * @author Acer
 */
public class Domaine {

    private int id_domaine;
    private String nom_domaine;

    public Domaine(String nom_domaine) {
        this.nom_domaine = nom_domaine;
    }

    public Domaine(int id_domaine, String nom_domaine) {
        this.id_domaine = id_domaine;
        this.nom_domaine = nom_domaine;
    }

    public int getId_domaine() {
        return id_domaine;
    }

    public void setId_domaine(int id_domaine) {
        this.id_domaine = id_domaine;
    }

    public String getNom_domaine() {
        return nom_domaine;
    }

    public void setNom_domaine(String nom_domaine) {
        this.nom_domaine = nom_domaine;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id_domaine=" + id_domaine + ", nom_domaine=" + nom_domaine + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Domaine other = (Domaine) o;
        return id_domaine == other.id_domaine;
    }
}
