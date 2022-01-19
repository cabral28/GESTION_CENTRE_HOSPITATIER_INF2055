/*
 * To change crud license header, choose License Headers in Project Properties.
 * To change crud template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionduncentredesante.backend;

import gestionduncentredesante.database.crud.CRUD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import gestionduncentredesante.database.connexiondatabase.DataBaseConnect;

/**
 *
 * @author gino
 */
public class Consultation{
    
    private String name_table = "consultation";
    CRUD crud = new CRUD();
    private int id_consultation;
    private String[] name_table_depend = {"soin", "ordonnance", "examen"};
    private String nom_cons;
    private int dossier_id;
    private int traite_cons;
    private Soin soin;
    private Examen examen;
    private Ordonnance ordonnance;
    private String[] values = {}; 
    
    /**
     * 
     */
    public Consultation(int id_consultation, String nom_cons, int dossier_id, int traite_cons){
        this.id_consultation = id_consultation;
        this.nom_cons = nom_cons;
        this.dossier_id = dossier_id;
        this.traite_cons = traite_cons;
        //
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
    public void setSoin() {
        //
    }
    
    
    /**
     * 
     */
    public void setExamen(){
        //
    }
    
    
    /**
     * 
     */
    public void setOrdonnance(){
        //
    }
    
    
    /**
     * 
     */
    public void storeOrdonnance(){
        //
    }
    
    
    /**
     * 
     */
    public void storeSoin(){
        //
    }
    
    
    /**
     * 
     */
    public void storeExamen(){
        //
    }
    
    
    /**
     * 
     */
    public void deleteOrdonnance(){
        //
    }
    
    
    /**
     * 
     */
    public void deleteSoin(){
        //
    }
    
    
    /**
     * 
     */
    public void deleteExamen(){
        //
    }
    
    
    /**
     * 
     */
    public void updateExamen(){
        //
    }
    
    
    /**
     * 
     */
    public void updateOrdonnance(){
        //
    }
    
    
    /**
     * 
     */
    public void updateSoin(){
        //
    }
    

    /**
     * 
     */
    public ArrayList getAllConsultation() throws SQLException {
        return crud.getAllTable(name_table);
    }
    
        
    /**
     * 
     */
    public ArrayList getOneByIdConsultation(int id) throws SQLException{
        return crud.getOneByIdTable(id, name_table);
    }
    
    
    /**
     * 
     */
    public void setConsultation(String[] values)  throws SQLException{
        crud.setTable(name_table, values);
    }
    
    
    /**
     * @param  String, String, String, int
     * @return void
     * crud function delete a ligne in a table of our DB
     */
    public void updateConsultation(String[] values, int id_row)  throws SQLException{
        crud.updateTable(name_table, values, id_row);
    }
    
    
    /**
     * @param  String
     * @return void
     * crud function delete a ligne in a table of our DB
     */
    public void deleteConsultation(int id)  throws SQLException{
        crud.deleteTable(id, name_table);
        this.deleteTableWithDependencyConsultation(id);
    }  
    
    
    /**
     * @param  String
     * @return void
     * crud function delete a ligne in a table of our DB
     */
    public void deleteTableWithDependencyConsultation(int id)  throws SQLException{
        crud.deleteTableWithDependency(id, name_table, "soin");
        crud.deleteTableWithDependency(id, name_table, "ordonnance");
        crud.deleteTableWithDependency(id, name_table, "examen");
    }
}
