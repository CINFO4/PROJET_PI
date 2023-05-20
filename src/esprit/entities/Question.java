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
    

    public Question(int id_question, String libelle) {
        this.id_question = id_question;
        this.libelle = libelle;
       
    }
    
  public int getid_question() {
        return id_question;
    }

    public void setid_question(int id_question) {
        this.id_question = id_question;
    }
   public String getlibelle() {
        return libelle;
    }

    public void setlibelle(String libelle) {
        this.libelle = libelle;
    }

   
}

   
