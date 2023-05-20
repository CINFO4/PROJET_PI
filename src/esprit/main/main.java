/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package esprit.main;

import esprit.entities.Question;
import esprit.entities.proposition;
import esprit.services.ServiceProposition;
import esprit.services.ServiceQuestion;

/**
 *
 * @author Mayssen
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ServiceProposition p1 = new ServiceProposition();
        //p1.ajouter(new proposition("tunis","valid",1));
        p1.ajouter(new proposition("paris","nonvalid",1));
    }
    
}
