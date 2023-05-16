/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.esprit.services;

import java.util.List;

/**
 *
 * @author 2023
 * @param <T>
 */
public interface IService<T> {
 
    public void ajouter(T a);
    public void modifier(T b);
    public void supprimer(T c);
    public List<T> afficher();
    
    
}   

