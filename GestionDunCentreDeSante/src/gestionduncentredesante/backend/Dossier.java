/*
 * To change crud license header, choose License Headers in Project Properties.
 * To change crud template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionduncentredesante.backend;;

import gestionduncentredesante.database.Interfaces.CRUDInterface;
import gestionduncentredesante.database.ReturnCRUDInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import gestionduncentredesante.database.connexiondatabase.DataBaseConnect;

/**
 *
 * @author gino
 */
public class Dossier {
    
    ReturnCRUDInterface retourne = new ReturnCRUDInterface();
    CRUDInterface crud = retourne.returnInterface();
    private String name_table = "dossier";
    private String[] name_table_depend = {"consultation"};
    private int id_dossier;
    private String nom_dossier;
    private int patient_id;
    private String dossier_traite;
    private String[] values = {};
    private Consultation[] listeConsultations;
    
    /**
     * 
     */
    public Dossier(int id_dossier, String nom_dossier, int patient_id, String dossier_traite){
        
        this.id_dossier = id_dossier;
        this.nom_dossier = nom_dossier;
        this.patient_id = patient_id;
        this.dossier_traite = dossier_traite;
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
    public void setListeConsultations(){
        //
    }
    
    
    /**
     * 
     */
    public void storeListeConsultations(){
        //
    }
    
    
    /**
     * 
     */
    public void updateListeConsultations(){
        //
    }
    
    
    /**
     * 
     */
    public void deleteListeConsultations(){
        //
    }
    
    

    /**
     * 
     */
    public ArrayList getAllDossier() throws SQLException {
        return crud.getAllTable(name_table);
    }
    
        
    /**
     * 
     */
    public ArrayList getOneByIdDossier(int id) throws SQLException{
        return crud.getOneByIdTable(id, name_table);
    }
    
    
    /**
     * 
     */
    public void setDossier(String[] values)  throws SQLException{
        crud.setTable(name_table, values);
    }
    
    
    /**
     * @param  String, String, String, int
     * @return void
     * crud function delete a ligne in a table of our DB
     */
    public void updateDossier(String[] values, int id_row)  throws SQLException{
        crud.updateTable(name_table, values, id_row);
    }
    
    
    /**
     * @param  String
     * @return void
     * crud function delete a ligne in a table of our DB
     */
    public void deleteDossier(int id)  throws SQLException{
        crud.deleteTable(id, name_table);
        this.deleteTableWithDependencyDossier(id);
    }
    
    
    /**
     * @param  String
     * @return void
     * crud function delete a ligne in a table of our DB
     */
    public void deleteTableWithDependencyDossier(int id)  throws SQLException{
        crud.deleteTableWithDependency(id, name_table, "consultation");
    }
}
