/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionduncentredesante.backend;

import gestionduncentredesante.database.Interfaces.CRUDInterface;
import gestionduncentredesante.database.ReturnCRUDInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import gestionduncentredesante.backend.help.Personne;
/**
 *
 * @author gino
 */
public class Medecin extends Personne{
    
    ReturnCRUDInterface retourne = new ReturnCRUDInterface();
    CRUDInterface crud = retourne.returnInterface();
    private String name_table = "medecin";
    private String poste;
    private CompteMedecin compte;
    private String[] values = {};
    
    /**
     * 
     */
    public Medecin(String poste, int id, String nom, String prenom, String date_Naissance, String sexe){
        
        super(id, nom, prenom, date_Naissance, sexe);
        this.poste = poste;
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
    public ArrayList getMedecin() throws SQLException{ 
        return crud.getAllTable(this.name_table);
    }
    
    /**
     * 
     */
    public void storeMedecin(String[] values) throws SQLException{
        crud.setTable(this.name_table, values);
    }
    
    
    /**
     * 
     */
    public void setCompte( int id_compte_medecin, String username, String pwd, boolean connect) throws SQLException{
        this.compte = new CompteMedecin(this.id, id_compte_medecin, username, pwd, connect);
    }
    
    
    /**
     * 
     */
    public CompteMedecin getCompte() throws SQLException{
        return this.compte;
    }
    
    
    /**
     * 
     */
    public void updateMedecin(String[] values, int id_relation) throws SQLException{
        crud.updateTableDependsToAnotherTable(this.name_table, "medecin", values, id_relation);
    }
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void deleteMedecin(int id) throws SQLException{
        compte.deleteCompte(id);
        crud.deleteTable(id, this.name_table);
    }
}

