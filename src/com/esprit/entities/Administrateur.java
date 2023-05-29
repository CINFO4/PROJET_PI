/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

/**
 *
 * @author Anis
 */
public class Administrateur extends User {

    public Administrateur(int id, String nom, String prenom, String mail, int numero_téléphone, String motdepasse, String description) {
        super(id, nom, prenom, mail, numero_téléphone, motdepasse, description);
    }

    public Administrateur(String nom, String prenom, String mail, int numero_téléphone, String motdepasse, String description) {
        super(nom, prenom, mail, numero_téléphone, motdepasse, description);
    }

    
    
    
    
}
