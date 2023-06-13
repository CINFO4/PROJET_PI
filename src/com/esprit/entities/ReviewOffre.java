/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

/**
 *
 * @author Mehdi
 */
public class ReviewOffre {
    
   private Review review;
   private String titre;

    public ReviewOffre(Review review, String titre) {
        this.review = review;
        this.titre = titre;
    }

    @Override
    public String toString() {
        return titre+"                                                      note: "+review.getNbr_etoile()+"/5";
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
