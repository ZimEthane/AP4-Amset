/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author m.sage
 */
public class User {

    // Attribut
    private int id_user;
    private String prenom_user;
    private String nom_user;
    private String identifiant_user;
    private String mot_de_passe_user;
    private String adresse_mail_user;

    // Construteur User
    public User(String prenom_user, String nom_user, String identifiant_user, String mot_de_passe_user, String adresse_mail_user) {
        this.prenom_user = prenom_user;
        this.nom_user = nom_user;
        this.identifiant_user = identifiant_user;
        this.mot_de_passe_user = mot_de_passe_user;
        this.adresse_mail_user = adresse_mail_user;
    }

    public User(int id_user, String prenom_user, String nom_user, String identifiant_user, String mot_de_passe_user, String adresse_mail_user) {
        this.id_user = id_user;
        this.prenom_user = prenom_user;
        this.nom_user = nom_user;
        this.identifiant_user = identifiant_user;
        this.mot_de_passe_user = mot_de_passe_user;
        this.adresse_mail_user = adresse_mail_user;
    }

    // Methode
    // Get
    public int getId() {
        return id_user;
    }

    public String getPrenom() {
        return prenom_user;
    }

    public String getNom() {
        return nom_user;
    }

    public String getIdentifiant() {
        return identifiant_user;
    }

    public String getPassword() {
        return mot_de_passe_user;
    }

    public String getEmail() {
        return adresse_mail_user;
    }

    // Set
    public void setId(int id_user) {
        this.id_user = id_user;
    }

    public void setNom(String nom_user) {
        this.nom_user = nom_user;
    }

    public void setPrenom(String prenom_user) {
        this.prenom_user = prenom_user;
    }

    public void setInitial(String mot_de_passe_user) {
        this.mot_de_passe_user = mot_de_passe_user;
    }

    public void setEmail(String adresse_mail_user) {
        this.adresse_mail_user = adresse_mail_user;
    }

    // toString
    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", prenom_user=" + prenom_user + ", nom_user=" + nom_user + ", identifiant_user=" + identifiant_user + ", mot_de_passe_user=" + mot_de_passe_user + ", adresse_mail_user=" + adresse_mail_user + '}';
    }

}
