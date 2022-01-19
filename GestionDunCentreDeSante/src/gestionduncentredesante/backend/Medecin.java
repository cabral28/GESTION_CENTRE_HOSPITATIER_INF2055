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
    private String[] name_table_relation = {"compte_medecin"};
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
    public int getId(){
        return this.id;
    }
        
    /**
     * 
     */
    public ArrayList getOneByIdMedecin(int id) throws SQLException{
        return crud.getOneByIdTable(id, name_table);
    }
    
    
    /**
     * 
     */
    public void setAdmin(String[] values) throws SQLException { 
        crud.setTable(this.name_table, values);
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
    public void setCompte(int medecin_id, int id_compte_medecin, String username, String pwd, boolean connect) throws SQLException{ 
        this.compte = new CompteMedecin(medecin_id, id_compte_medecin, username, pwd, connect);
    }
    
    
    /**
     * 
     */
    public ArrayList getAllCompte() throws SQLException{ 
        return crud.getAllTable(this.name_table_depend[0]);
    }
    
    /**
     * 
     */
    public void storeCompte() throws SQLException{ 
        crud.setTable(this.name_table_depend[0], this.medecin.getValues());
    }
    
    
    /**
     * 
     */
    public void updateCompte() throws SQLException{ 
        crud.updateTable(this.name_table_depend[0], this.medecin.getValues(), this.medecin.getId());
    }
    
    
    /**
     * 
     */
    public void storeAdmin() throws SQLException{ 
        crud.setTable(this.name_table, this.values);
    }
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void deleteTableWithDependencyMedecin(int id)  throws SQLException{
        crud.deleteTableWithDependency(id, name_table, "compte_medecin");
    }
}

