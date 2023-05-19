/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anis
 */
public class Candidat extends User {
    private Diplome education;
    private List<Competence> ListeCompetences; 

    public Candidat(int id, String nom, String prenom, String adresse, int numero_téléphone, String motdepasse, String description, Diplome education, Role role) {
        super(id, nom, prenom, adresse, numero_téléphone, motdepasse, description, role);
        this.education = education;
        this.ListeCompetences = new ArrayList<>();
    }

    public Candidat( String nom, String prenom, String adresse, int numero_téléphone, String motdepasse, String description,Diplome education, Role role) {
        super(nom, prenom, adresse, numero_téléphone, motdepasse, description, role);
        this.education = education;
        this.ListeCompetences = new ArrayList<>();
    }

    public List<Competence> getListeCompetences() {
        return ListeCompetences;
    }

    public void setListeCompetences(List<Competence> ListeCompetences) {
        this.ListeCompetences = ListeCompetences;
    }
    

    

    

    public Diplome getEducation() {
        return education;
    }

    public void setEducation(Diplome education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Candidat{" + super.toString() + "education=" + education + '}';
    }
    

    

    

    

   
   
    
    
}
