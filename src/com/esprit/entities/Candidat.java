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
    private List<Integer> ListeCompetences; 
    private String Github;
    private Experience experience;

    public Candidat(int id, String nom, String prenom, String mail, Integer numero_téléphone, String motdepasse, String description, Diplome education, String Github, Experience experience) {
        super(id, nom, prenom, mail, numero_téléphone, motdepasse, description);
        this.education = education;
        this.ListeCompetences = new ArrayList<>();
        this.Github= Github;
        this.experience=experience;
    }

    public Candidat( String nom, String prenom, String mail, Integer numero_téléphone, String motdepasse, String description,Diplome education, String Github, Experience experience) {
        super(nom, prenom, mail, numero_téléphone, motdepasse, description);
        this.education = education;
        this.ListeCompetences = new ArrayList<>();
        this.Github= Github;
        this.experience=experience;
    }

    public List<Integer> getListeCompetences() {
        return ListeCompetences;
    }

    public void setListeCompetences(List<Integer> ListeCompetences) {
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
        return "Candidat{" + super.toString() + "education=" + education + ", Github=" + Github + ", experience=" + experience + '}';
    }

   

    public String getGithub() {
        return Github;
    }

    public void setGithub(String Github) {
        this.Github = Github;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }
    

    

    

    

   
   
    
    
}
