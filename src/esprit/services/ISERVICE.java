/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package esprit.services;

import java.util.List;

/**
 *
 * @author Taieb
 * @param <T>
 */
public interface ISERVICE<T> {
      public void ajouter(T q);
    public void modifier(T q);
    public void supprimer(T q);
    public List<T> afficher();

}
