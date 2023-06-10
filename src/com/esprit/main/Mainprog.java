/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.main;

import com.esprit.entities.*;
import com.esprit.services.*;
import com.esprit.utils.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anis
 */
public class Mainprog {

    public static void main(String[] args) throws MailException {
        //ServiceUser sv = new ServiceUser();
        //sv.ajouter(new Candidat("ahmed", "othman", "ariana", 52421452, "aaaa", "vvvv", Diplome.Mastére, Role.Candidat));
        //sv.ajouter(new Entreprise("iplabel", "anis", "othman", "mohamed V", 71586248, "hyjkhiuh", "IT", Role.Entreprise));
        //System.out.println(sv.afficher());
        //sv.supprimer(new Candidat(2, "", "", "", 0, "", "", Diplome.Autre, Role.Admin));
//        Candidat c = new Candidat("Talel", "lili", "ariana", 25623757, "huygfry", "je suis", Diplome.Bacclauréat);
//        List<Competence> l = new ArrayList<>();
//        Competence com = new Competence(1,"java", "dev", "debutant");
//        l.add(com);
//        c.setListeCompetences(l);
//        sv.ajouter(c);
        //ServiceDomaine sd = new ServiceDomaine();
        //sd.ajouter(new Domaine("Ecommerce"));
        //System.out.println(sd.getDomainesName());
//        ServiceCompetence sc = new ServiceCompetence();
//        sc.ajouter(new Competence("Reseau", "Définit les projets d'évolution du réseau"));
        ServiceUser sv = new ServiceUser();
        //sv.ajouter(new Candidat("hazem", "landolsi", "hazem@gmail.com", 25412542, "admin", "azert", Diplome.Bacclauréat, "git", Experience.Confirme));
        // System.out.println(sv.getallcandidat());
        // sv.ajouter(new Entreprise("anis", "othman", "anis@ip-label.com", 25623767, "azerty", "it entreprise", "sofrecom", Taille.PLUS_DE_50_EMPLOYES, "sofrecom.com", "linkdin.fr",1));
        //sv.ajouter(new Entreprise("khh", "klhh", "jghjig", 54654, "jgh", "ljkhg", "jhjh", Taille.DE_1_A_10_EMPLOYES, "khoh", "lkhh", 1));
        //sv.ajouter(new Candidat("helmi", "amdouni", "hmd@ip.fr", 45216584, "admin", "un jeune etudiant", Diplome.Ingénierie, "helmi.github", Experience.Confirme));
        //System.out.println(sv.login("anis@ip-label.com", "azerty"));
        //System.out.println(CodeGenerator.generateCode());

        // code api : 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
        //sv.modifiermotdepasse("goalooot", "2562")
        try {
            //sv.ajouter(new Candidat("isam", "laabidi", "lamine@gmail.com", 25623768, "Motface@2026?", "admin", Diplome.Autre, "git", Experience.Confirme));
            System.out.println(sv.afficherCandidat());
            //sv.ajouter(new Entreprise("mounir", "chamem", "mounir@gmail.com",25142258,"anis25623@libel", "admin", "focus", Taille.DE_1_A_10_EMPLOYES, "foxus.com", "focus.linkedin", 1));
        } catch (MailException e) {
            System.out.println(e.getMessage());
        }
        
    }

}
