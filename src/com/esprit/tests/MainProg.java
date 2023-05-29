/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.tests;

import com.esprit.entities.Competence;
import com.esprit.entities.Document;
import com.esprit.services.ServiceGererDocument;
import com.esprit.services.ServiceCompetence;
import com.esprit.services.ServiceProfile;
import com.esprit.utils.DataSource;

/**
 
 */
public class MainProg {
    
    public static void main(String[] args) {
        
        ServiceGererDocument sd = new ServiceGererDocument();
        sd.ajouter(new Document( "Document 6", "aaa", "bbb", "ccc", 1));
       // sd.modifier(new Document(2, "Document990", "vva", "qqss", "ddaziz", 1));
       // sd.supprimer(new Document(2, "", "", "", "", 1));
       // System.out.println(sd.afficher());

        
        ServiceCompetence sc = new ServiceCompetence();
        //sc.ajouter(new Competence(1, "Competence 1", "Description 1"));
        System.out.println(sc.afficher());
        
        //ServiceProfile sp = new ServiceProfile();
        //sp.ajouter(new Profile(1, 1, "Niveau 1"));
        //System.out.println(sp.afficher());

        DataSource d = DataSource.getInstance();
        DataSource d1 = DataSource.getInstance();
    }
}
