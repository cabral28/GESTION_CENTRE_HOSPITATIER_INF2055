/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionduncentredesante.backend;

import gestionduncentredesante.database.Interfaces.CRUDInterface;
import gestionduncentredesante.database.ReturnCRUDInterface;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gino
 */
public class Soin{
    ReturnCRUDInterface retourne = new ReturnCRUDInterface();
    CRUDInterface crud = retourne.returnInterface();
    private String name_table = "soin";
    private int id_soin;
    private String nom_soin;
    private String dose_soin;
    private int consultation_id;
    private String[] values = {};
    
    
    /**
     * 
     */
    public Soin(int id, String nom, String dose, int consul_id){
        this.id_soin = id;
        this.nom_soin = nom;
        this.dose_soin = dose;
        this.consultation_id = consul_id;
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
        this.id_soin = id;
    }
    
    
    /**
     * 
     */
    public int getId() throws SQLException{
        return this.id_soin;
    }
    
    
    /**
     * 
     */
    public void setSoin(String[] values) throws SQLException { 
        crud.setTable(this.name_table, values);
    }
    
    
    /**
     * 
     */
    public ArrayList getSoinConsultation(int id_relation) throws SQLException{ 
        return crud.getTableDependToAnotherTable(id_relation, this.name_table, "consultation");
    }
    
    /**
     * 
     */
    public void storeSoin(String[] values) throws SQLException{
        crud.setTable(this.name_table, values);
    }
    
    
    /**
     * 
     */
    public void updateSoin(String[] values, int id_relation) throws SQLException{
        crud.updateTableDependsToAnotherTable(this.name_table, "consultation", values, id_relation);
    }
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void deleteSoin(int id_relation)  throws SQLException{
        crud.deleteTableDependsToAnotherTable(id_relation, this.name_table, "consultation");
    }
}
