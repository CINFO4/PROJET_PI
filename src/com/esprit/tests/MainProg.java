package com.esprit.tests;

import com.esprit.entities.Reclamation;
import com.esprit.entities.Review;
import com.esprit.services.ServiceReclamation;
import com.esprit.services.ServiceReview;

/**
 *
 * author molka
 */
public class MainProg {

    public static void main(String[] args) {
//        ServiceReview reviewService = new ServiceReview();
        ServiceReclamation reclamationService = new ServiceReclamation();

        // Adding a review
//        Review review1 = new Review(5, 1,"tttt");
//        reviewService.ajouter(review1);

        // Modifying a review
        //Review review2 = new Review(2, 1);
        //review2.setId_review(1);
        //reviewService.modifier(review2);

        // Deleting a review
//        Review review3 = new Review(3, 1);
//        review3.setId_review(2);
//        reviewService.supprimer(review3);

        // Displaying all reviews
//        System.out.println(reviewService.afficher());
//
  //   Adding a reclamation
     //Reclamation reclamation1 = new Reclamation(1,"molka",1);
       //reclamationService.ajouter(reclamation1);
//
//        // Modifying a reclamation
//        Reclamation reclamation2 = new Reclamation("Medium priority issue", 1);
//        reclamation2.setId_reclamation(1);
//        reclamationService.modifier(reclamation2);
//
//        // Deleting a reclamation
//        Reclamation reclamation3 = new Reclamation("Low priority issue", 1);
//        reclamation3.setId_reclamation(2);
//        reclamationService.supprimer(reclamation3);
//
//        // Displaying all reclamations
//        System.out.println(reclamationService.afficher());
    }
}
