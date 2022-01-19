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
    public ArrayList getAllSoin() throws SQLException{ 
        return crud.getAllTable(name_table);
    }
    
        
    /**
     * 
     */
    public ArrayList getOneByIdSoin(int id) throws SQLException{
        return crud.getOneByIdTable(id, name_table);
    }
    
    
    /**
     * 
     */
    public void setSoin(String[] values)  throws SQLException{
        crud.setTable(name_table, this.values);
    }
    
    
    /**
     * @param  String, String, String, int
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void updateSoin(String[] values, int id_row)  throws SQLException{
        crud.updateTable(name_table, this.values, id_row);
    }
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void deleteSoin(int id)  throws SQLException{
        crud.deleteTable(id, name_table);
    }
}
