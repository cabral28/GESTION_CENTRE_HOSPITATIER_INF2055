/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionduncentredesante.backend;;

import gestionduncentredesante.backend.help.Personne;
import gestionduncentredesante.database.Interfaces.CRUDInterface;
import gestionduncentredesante.database.ReturnCRUDInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author gino
 */
public class Patient extends Personne{
    
    ReturnCRUDInterface retourne = new ReturnCRUDInterface();
    CRUDInterface crud = retourne.returnInterface();
    private String name_table = "patient";
    private String[] name_table_depend = {"dossier"};
    private Dossier dos;
    private String nom_pere;
    private String nom_mere;
    private int compte_medecin_id;
    private String[] values = {};
    
    
    
    /**
     * 
     */
    public Patient(String nom_pere, String nom_mere, int compte_medecin_id, int id, String nom, String prenom, String date_Naissance, String sexe){
        
        super(id, nom, prenom, date_Naissance, sexe);
        this.nom_pere = nom_pere;
        this.nom_mere = nom_mere;
        this.compte_medecin_id = compte_medecin_id;
    }
    
    /**
     * 
     */
    public String[] getValues(){
        return this.values;
    }
    
    
    /**
     * 
     */
    public void setValues(String[] vals) { 
        this.values = vals;
    }
    
    /**
     * 
     */
    public void setId(int id) throws SQLException{
        this.id = id;
    }
    
    
    /**
     * 
     */
    public int getId() throws SQLException{
        return this.id;
    }
    

    /**
     * 
     */
    public void storePatient(String[] values) throws SQLException { 
        crud.setTable(this.name_table, values);
    }
    
    /**
     * 
     */
    public void setDossier(int id_dossier, String nom_dossier, String dossier_traite) throws SQLException { 
        this.dos = new Dossier( id_dossier, nom_dossier, this.id, dossier_traite);
    }
    
    
    /**
     * 
     */
    public Dossier getDossier() throws SQLException { 
        return this.dos;
    }
    
    
    /**
     * 
     */
    public ArrayList getPatientCompteMedecin(int id_relation) throws SQLException{ 
        return crud.getTableDependToAnotherTable(id_relation, this.name_table, "compte_medecin");
    }
    
    
    /**
     * 
     */
    public void updatePatient(String[] values, int id_relation) throws SQLException{
        crud.updateTable(this.name_table, values, this.id);
    }
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void deletePatient(int id_table)  throws SQLException{
        crud.deleteTableDependsToAnotherTable(id_table, this.name_table, "compte_medecin");
        this.dos.deleteDossier(id_table, this.dos.getId());
    }
}


