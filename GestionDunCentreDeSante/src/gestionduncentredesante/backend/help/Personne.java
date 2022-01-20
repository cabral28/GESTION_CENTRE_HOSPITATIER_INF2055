/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionduncentredesante.backend.help;

/**
 *
 * @author gino
 */
public class Personne {
    protected int id;
    protected String nom;
    protected String prenom;
    protected String date_Naissance;
    protected String sexe;

    public Personne(int id, String nom, String prenom, String date_Naissance, String sexe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date_Naissance = date_Naissance;
        this.sexe = sexe;
    }
    
    
}
