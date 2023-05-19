/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.main;

import com.esprit.entities.*;
import com.esprit.services.ServiceUser;
import com.esprit.utils.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anis
 */
public class Mainprog {
    
    public static void main(String[] args) {
        ServiceUser sv = new ServiceUser();
        //sv.ajouter(new Candidat("ahmed", "othman", "ariana", 52421452, "aaaa", "vvvv", Diplome.Mastére, Role.Candidat));
        //sv.ajouter(new Entreprise("iplabel", "anis", "othman", "mohamed V", 71586248, "hyjkhiuh", "IT", Role.Entreprise));
        //System.out.println(sv.afficher());
        //sv.supprimer(new Candidat(2, "", "", "", 0, "", "", Diplome.Autre, Role.Admin));
        Candidat c = new Candidat("mohamed", "limam", "ariana", 25623757, "huygfry", "je suis", Diplome.Bacclauréat, Role.Candidat);
        List<Competence> l = new ArrayList<>();
        Competence com = new Competence(1,"java", "dev", "debutant");
        l.add(com);
        c.setListeCompetences(l);
        sv.ajouter(c);
        
        
    }
    
}
