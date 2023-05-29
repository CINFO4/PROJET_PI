/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.tests;

import com.esprit.entities.*;
import com.esprit.services.*;
import com.esprit.utils.DataSource;
import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class MainProg {
    public static void main(String[] args) {
        
        ServiceOffre sf = new ServiceOffre();
//        sf.ajouter(new Offre("administrateur base de donne ", "les technologie : mysql,mongoDB ",2,Date.valueOf("2023-05-30")));
//        sf.modifier(new Offre(16, "Developpeur back-end", "les technologie : node js ,express js ",2,Date.valueOf("2022-05-22"),Date.valueOf("2022-06-22")));
//        sf.supprimer(new Offre(17, "", "",1,null,null));
//        System.out.println(sf.afficher());
//        System.out.println(sf.afficherOffres());

    
        ServiceDomaine sd = new ServiceDomaine();
//        sd.ajouter(new Domaine("informatiue"));
//        sd.modifier(new Domaine(3, "mecanique"));
//        sd.supprimer(new Domaine(4, ""));
//        System.out.println(sd.afficher());

       
        ServiceCandidature sc = new ServiceCandidature();
//        sc.ajouter(new Candidature(1, 15));
//        sc.modifier(new Candidature(1, 15, 4,Date.valueOf("2000-8-8"),EtatCandidature.Refuser));
//        sc.supprimer(new Candidature(1, 5, 4, null, ""));
//        System.out.println(sc.afficher());
            System.out.println(sc.candidatureDetails());
          
        

       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       

         
    }
}
