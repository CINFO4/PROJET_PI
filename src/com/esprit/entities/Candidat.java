/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

/**
 *
 * @author Anis
 */
public class Candidat extends User {
    private Diplome education;

    public Candidat(Diplome education, int id, String nom, String prenom, String adresse, int numero_téléphone, String motdepasse, String description) {
        super(id, nom, prenom, adresse, numero_téléphone, motdepasse, description);
        this.education = education;
    }

    public Candidat(Diplome education, String nom, String prenom, String adresse, int numero_téléphone, String motdepasse, String description) {
        super(nom, prenom, adresse, numero_téléphone, motdepasse, description);
        this.education = education;
    }

    public Candidat(int aInt, String string, String string0, String string1, int aInt0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Diplome getEducation() {
        return education;
    }

    public void setEducation(Diplome education) {
        this.education = education;
    }

   
   
    
    
}
