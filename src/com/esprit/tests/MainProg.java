/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.tests;

import com.esprit.entities.Competence;
import com.esprit.entities.Document;
import com.esprit.services.ServiceGererDocument;
import com.esprit.services.ServiceCompetence;
import com.esprit.utils.DataSource;

/**
 * MainProg class for testing entities and services.
 */
public class MainProg {
    
    public static void main(String[] args) {
        
      ServiceGererDocument sd = new ServiceGererDocument();
      // sd.ajouter(new Document(2,"Document 6"));
       //sd.modifier(new Document(2,"Document99"));
   //  sd.supprimer(new Document(1,""));
     
        System.out.println(sd.afficher());

        
        ServiceCompetence sc = new ServiceCompetence();
//        sc.ajouter(new Competence(1, "Competence 1", "Description 1", "Niveau 1"));
//        System.out.println(sc.afficher());

        DataSource d=DataSource.getInstance();
        DataSource d1=DataSource.getInstance();
    }
}


