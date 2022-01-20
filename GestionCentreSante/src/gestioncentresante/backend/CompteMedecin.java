/*
 * To change CRUD license header, choose License Headers in Project Properties.
 * To change CRUD template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncentresante.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import gestioncentresante.database.connexiondatabase.DataBaseConnect;
import java.util.Date;
import gestioncentresante.database.CRUD;

/**
 *
 * @author gino
 */
public class CompteMedecin{
    
    
    private CRUD crud = new CRUD();
    private String name_table = "compte_medecin";
    
        
    /**
     * 
     */
    public ArrayList getAllCompte() throws SQLException{
        
        return crud.getAllTable(name_table);
    }
    
        
    /**
     * 
     */
    public ArrayList getOneByIdCompte(int id) throws SQLException{
        return crud.getOneByIdTable(id, name_table);
    }
    
    
    /**
     * 
     */
    public void setCompte(String[] values)  throws SQLException{
        crud.setTable(name_table, values);
    }
    
    
    /**
     * @param  String, String, String, int
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void updateCompte(String[] values, int id_row)  throws SQLException{
        crud.updateTable(name_table, values, id_row);
    }
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void deleteCompte(int id)  throws SQLException{
        crud.deleteTable(id, name_table);
    }
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public ArrayList getAllCompteDependence(int id)  throws SQLException{
        return crud.getAllTableDependency(id, name_table, "patient");
    }
        
}
