/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.esprit.main;

import com.esprit.entities.Question;
import com.esprit.entities.proposition;
import com.esprit.entities.Competence;
import com.esprit.services.ServiceProposition;
import com.esprit.services.ServiceQuestion;
import com.esprit.services.ServiceCompetence;

/**
 *
 * @author Mayssen
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ServiceQuestion p1 = new ServiceQuestion();
        //ServiceCompetence p2 = new ServiceCompetence();
        //p1.ajouter(new proposition("tunis","valid",1));
        System.out.println(p1.afficherQuestionView());
    }
    
}
