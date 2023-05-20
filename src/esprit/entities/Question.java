/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package esprit.entities;

/**
 *
 * @author Taieb
 */
public class Question {
    private int id_question;
    private String libelle;
    private int id_c;

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public Question(String libelle, int id_c) {
        this.libelle = libelle;
        this.id_c = id_c;
    }

    public Question(int id_question, String libelle, int id_c) {
        this.id_question = id_question;
        this.libelle = libelle;
        this.id_c = id_c;
    }

    @Override
    public String toString() {
        return "Question{" + "id_question=" + id_question + ", libelle=" + libelle + ", id_c=" + id_c + '}';
    }
    
    

    
 
   
}

   
