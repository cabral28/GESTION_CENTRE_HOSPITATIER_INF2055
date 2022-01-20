/*
 * To change crud license header, choose License Headers in Project Properties.
 * To change crud template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncentresante.backend;

import gestioncentresante.database.CRUD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author gino
 */
public class Consultation{
    
    private String name_table = "consultation";
    CRUD crud = new CRUD();
    
        
    /**
     * 
     */
    public ArrayList getAllConsultation() throws SQLException{
        
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
        crud.deleteTableWithDependencyConsultation(id);
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
