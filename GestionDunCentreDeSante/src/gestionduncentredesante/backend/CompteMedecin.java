/*
 * To change CRUD license header, choose License Headers in Project Properties.
 * To change CRUD template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionduncentredesante.backend;

import gestionduncentredesante.backend.help.Compte;
import gestionduncentredesante.database.Interfaces.CRUDInterface;
import gestionduncentredesante.database.ReturnCRUDInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import gestionduncentredesante.database.connexiondatabase.DataBaseConnect;
import java.util.Date;

/**
 *
 * @author gino
 */
public class CompteMedecin extends Compte{
    
    
    ReturnCRUDInterface retourne = new ReturnCRUDInterface();
    CRUDInterface crud = retourne.returnInterface();
    private String name_table = "compte_medecin";
    private Patient patient;
    private String[] values = {};
    
    
    
    /**
     * 
     */
    public CompteMedecin(int medecin_id, int id_compte_medecin, String username, String pwd, boolean connect) {    
        super(id_compte_medecin, username, pwd, connect);
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
    public String[] setValues( String[] str){
        return this.values = str;
    }
    
    
    
    /**
     * 
     */
    public void setId(int id){
        this.id_compte = id;
    }
    
    
    /**
     * 
     */
    public int getId(){
        return this.id_compte;
    }
    

    /**
     * 
     */
    public ArrayList getCompteMedecin(int id_relation) throws SQLException{ 
        return crud.getTableDependToAnotherTable(id_relation, this.name_table, "medecin");
    }
    
    /**
     * 
     */
    public void storeCompte(String[] values) throws SQLException{
        crud.setTable(this.name_table, values);
    }
    
    
    /**
     * 
     */
    public void setPatient(String nom_pere, String nom_mere, int id, String nom, String prenom, String date_Naissance, String sexe){
        this.patient = new Patient( nom_pere, nom_mere, this.id_compte, id, nom, prenom, date_Naissance, sexe);
    }
    
    
    /**
     * 
     */
    public Patient getPatient(){
        return this.patient;
    }
    
    
    /**
     * 
     */
    public void updateCompte(String[] values, int id_relation) throws SQLException{
        crud.updateTableDependsToAnotherTable(this.name_table, "medecin", values, id_relation);
    }
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void deleteCompte(int id_medecin) throws SQLException{
        crud.deleteTableDependsToAnotherTable(id_medecin, name_table, "medecin");
    }
}
