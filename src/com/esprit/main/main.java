/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.esprit.main;

import com.esprit.entities.Question;
import com.esprit.entities.proposition;
import com.esprit.services.ServiceProposition;
import com.esprit.services.ServiceQuestion;

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
        //p1.ajouter(new proposition("tunis","valid",1));
        System.out.println(p1.afficher());;
    }
    
}
