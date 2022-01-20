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
    private int id_dossier;
    private String nom_dossier;
    private int patient_id;
    private String dossier_traite;
    private String[] values = {};
    private Consultation consultation;
    
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
    public void setValues(String[] vals) { 
        this.values = vals;
    }
    
    /**
     * 
     */
    public void setId(int id) throws SQLException{
        this.id_dossier = id;
    }
    
    
    /**
     * 
     */
    public int getId() throws SQLException{
        return this.id_dossier;
    }
    
    /**
     * 
     */
    public void setId() throws SQLException{
        this.id_dossier = crud.getLastIdTable(this.name_table) + 1;
    }
    
    
    
    /**
     * 
     */
    public void setConsultation(int id_consultation, String nom_cons, int traite_cons){ 
        this.consultation = new Consultation( id_consultation, nom_cons, this.id_dossier, traite_cons);
    }
    
    
    /**
     * 
     */
    public Consultation getConsultation() { 
        return this.consultation;
    }
    
    
    /**
     * 
     */
    public ArrayList getDossierPatient(int id_relation) throws SQLException{ 
        return crud.getTableDependToAnotherTable(id_relation, this.name_table, "patient");
    }
    
    /**
     * 
     */
    public void storeDossier(String[] values) throws SQLException{
        crud.setTable(this.name_table, values);
    }
    
    
    /**
     * 
     */
    public void updateDossier(String[] values, int id_relation) throws SQLException{
        crud.updateTableDependsToAnotherTable(this.name_table, "patient", values, id_relation);
    }
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void deleteDossier(int id_relation, int id_table)  throws SQLException{
        crud.deleteTableDependsToAnotherTable(id_relation, this.name_table, "patient");
        this.consultation.deleteConsultation(id_relation, this.consultation.getId());
    }
}
