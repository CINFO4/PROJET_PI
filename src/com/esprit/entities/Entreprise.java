/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

/**
 *
 * @author Anis
 */
public class Entreprise extends User {
    
    private String NomEntreprise;

    public Entreprise(String NomEntreprise, int id, String nom, String prenom, String adresse, int numero_téléphone, String motdepasse, String description, Role role) {
        super(id, nom, prenom, adresse, numero_téléphone, motdepasse, description, role);
        this.NomEntreprise = NomEntreprise;
    }

    public Entreprise(String NomEntreprise, String nom, String prenom, String adresse, int numero_téléphone, String motdepasse, String description, Role role) {
        super(nom, prenom, adresse, numero_téléphone, motdepasse, description, role);
        this.NomEntreprise = NomEntreprise;
    }

    public String getNomEntreprise() {
        return NomEntreprise;
    }

    public void setNomEntreprise(String NomEntreprise) {
        this.NomEntreprise = NomEntreprise;
    }

    
    
    
}
