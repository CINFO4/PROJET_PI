/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

/**
 *
 * @author 2023
 */
public class Document {
     private int id_document;
    private String nom_document;
  
    
   public Document(String nom_document) {
        this.nom_document=nom_document;
   }
   
      public Document(int id_document , String nom_document) {
        this.id_document=id_document;
        this.nom_document=nom_document;
   }

    public int getId_document() {
        return id_document;
    }

    public void setId_document(int id_document) {
        this.id_document = id_document;
    }

    public String getNom_document() {
        return nom_document;
    }

    public void setNom_document(String nom_document) {
        this.nom_document = nom_document;
    }
   @Override
    public String toString() {
        return "GererDocument{" + "iddocument=" + id_document + ", nomdocument=" + nom_document + ", prenom=" +  '}';
    }
      
}

