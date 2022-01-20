/*
 * To change crud license header, choose License Headers in Project Properties.
 * To change crud template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncentresante.database.CRUD;
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
public class Examen {
    
    CRUD crud = new CRUD();
    private String name_table = "examen";
    
        
    /**
     * 
     */
    public ArrayList getAllExamen() throws SQLException{
        
        return crud.getAllTable(name_table);
    }
    
        
    /**
     * 
     */
    public ArrayList getOneByIdExamen(int id) throws SQLException{
        return crud.getOneByIdTable(id, name_table);
    }
    
    
    /**
     * 
     */
    public void setExamen(String[] values)  throws SQLException{
        crud.setTable(name_table, values);
    }
    
    
    /**
     * @param  String, String, String, int
     * @return void
     * crud function delete a ligne in a table of our DB
     */
    public void updateExamen(String[] values, int id_row)  throws SQLException{
        crud.updateTable(name_table, values, id_row);
    }
    
    
    /**
     * @param  String
     * @return void
     * crud function delete a ligne in a table of our DB
     */
    public void deleteExamen(int id)  throws SQLException{
        crud.deleteTable(id, name_table);
    }
}
