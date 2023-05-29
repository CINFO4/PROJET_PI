/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.tests;

import com.esprit.entities.Commentaire;
import com.esprit.entities.Forum;
import com.esprit.entities.React;
import com.esprit.services.ServiceCommentaire;
import com.esprit.services.ServiceDomaine;
import com.esprit.services.ServiceForum;
import com.esprit.services.ServiceReact;

/**
 *
 * @author Rafik
 */
public class MainProg {
    
    public static void main(String[] args) {
//        ServiceForum sf = new ServiceForum();
//        System.out.println(sf.afficher());
//        Forum F = new Forum("AI","lorum epsum",1,1);
//        sf.ajouter(F);
//        System.out.println(sf.afficher());
//        F.setSujet("cloud");
//        F.setSujet("clodium");
//        sf.modifier(F);
//        System.out.println(sf.afficher());
//        sf.supprimer(F);
//        System.out.println(sf.afficher()); 
//        
//        ServiceCommentaire sc = new ServiceCommentaire();
//        System.out.println(sc.afficher());
//        Commentaire C = new Commentaire("AI",1,1);
//        sc.ajouter(C);
//        System.out.println(sc.afficher());
//        C.setContenu("Artificial intelligence is intelligence—perceiving");
//        sc.modifier(C);
//        System.out.println(sc.afficher());
//        sc.supprimer(C);
//        System.out.println(sc.afficher());
//        
//        ServiceReact sr = new ServiceReact();
//        System.out.println(sr.afficher());
//        React R = new React(true,1,1);
//        sr.ajouter(R);
//        System.out.println(sr.afficher());
//        R.setLiked(false);
//        sr.modifier(R);
//        System.out.println(sr.afficher());
//        sr.supprimer(R);
//        System.out.println(sr.afficher());
        
        ServiceDomaine sd = new ServiceDomaine();
        System.out.println(sd.listeDomaines().get(1));
    }
}
