/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncentresante.backend;

import gestioncentresante.database.CRUD;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gino
 */
public class Soin extends Crud {
    private String name_table = "soin";
    
        
    /**
     * 
     */
    public ArrayList getAllSoin() throws SQLException{ 
        return this.getAllTable(name_table);
    }
    
        
    /**
     * 
     */
    public ArrayList getOneByIdSoin(int id) throws SQLException{
        return this.getOneByIdTable(id, name_table);
    }
    
    
    /**
     * 
     */
    public void setSoin(String[] values)  throws SQLException{
        this.setTable(name_table, values);
    }
    
    
    /**
     * @param  String, String, String, int
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void updateSoin(String[] values, int id_row)  throws SQLException{
        this.updateTable(name_table, values, id_row);
    }
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void deleteSoin(int id)  throws SQLException{
        this.deleteTable(id, name_table);
    }
}
