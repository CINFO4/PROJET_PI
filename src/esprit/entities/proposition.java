/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esprit.entities;

/**
 *
 * @author Taieb
 */
public class proposition {
    private int id_proposition;
    private String description;
    private String etat;

    public proposition(int id_proposition, String description, String etat) {
        this.id_proposition = id_proposition;
        this.description = description;
        this.etat = etat;
    }
    
  public int getid_proposition() {
        return id_proposition;
    }

    public void setid_proposition(int id_proposition) {
        this.id_proposition = id_proposition;
    }
   public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }
    
    
    public String getetat() {
        return etat;
    }

    public void setetat(String etat) {
        this.etat = etat;
    }
   
}

