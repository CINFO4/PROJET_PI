/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

/**
 *
 * @author Rafik
 */
public class Forum {
    
    private int id_forum;
    private String nom_forum;
    private int id_user;

    public Forum(String nom_forum, int id_user) {
        this.nom_forum = nom_forum;
        this.id_user = id_user;
    }

    public Forum(int id_forum, String nom_forum, int id_user) {
        this.id_forum = id_forum;
        this.nom_forum = nom_forum;
        this.id_user = id_user;
    }

    public int getId_forum() {
        return id_forum;
    }

    public void setId_forum(int id_forum) {
        this.id_forum = id_forum;
    }

    public String getNom_forum() {
        return nom_forum;
    }

    public void setNom_forum(String nom_forum) {
        this.nom_forum = nom_forum;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Forum{" + "id_forum=" + id_forum + ", nom_forum=" + nom_forum + ", id_user=" + id_user + '}';
    }
    
    
}
