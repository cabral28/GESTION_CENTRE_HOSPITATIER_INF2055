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
    public Patient(int id_patient, String nom_pere, String nom_mere, int compte_medecin_id, int id, String nom, String prenom, String date_Naissance, String sexe){
        
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
    public ArrayList getAllPatient() throws SQLException {
        return crud.getAllTable(name_table);
    }
    
        
    /**
     * 
     */
    public ArrayList getOneByIdPatient(int id) throws SQLException{
        return crud.getOneByIdTable(id, name_table);
    }
    
    
    /**
     * 
     */
    public ArrayList getAllPatientDependency(int id) throws SQLException{
        return crud.getAllTableDependency(id, name_table, "dossier");
    }
    
    
    /**
     * 
     */
    public void setPatient(String[] values)  throws SQLException{
        crud.setTable(name_table, values);
    }
    
    
    /**
     * @param  String, String, String, int
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void updatePatient(String[] values, int id_row)  throws SQLException{
        crud.updateTable(name_table, values, id_row);
    }
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void deletePatient(int id)  throws SQLException{
        crud.deleteTable(id, name_table);
        this.deleteTableWithDependencyPatient(id);
    }
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void deleteTableWithDependencyPatient(int id)  throws SQLException{
        crud.deleteTableWithDependency(id, name_table, "dossier");
    }
}


