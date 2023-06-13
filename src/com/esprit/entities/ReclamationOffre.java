/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

/**
 *
 * @author Mehdi
 */
public class ReclamationOffre {
    
    private Reclamation reclamation;
    private String titre;

    public ReclamationOffre(Reclamation reclamation, String titre) {
        this.reclamation = reclamation;
        this.titre = titre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    @Override
    public String toString() {
        return titre+"                                         "+reclamation.getEtat();
    }

    public Reclamation getReclamation() {
        return reclamation;
    }

    public void setReclamation(Reclamation reclamation) {
        this.reclamation = reclamation;
    }
}
