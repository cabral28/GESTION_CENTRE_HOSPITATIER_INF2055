/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncentresante.backend;;

import gestioncentresante.database.CRUD.Crud;
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
public class Patient extends Crud{
    
    private String name_table = "patient";
    private Dossier dos = new Dossier();
    
        
    /**
     * 
     */
    public ArrayList getAllPatient() throws SQLException{
        
        return this.getAllTable(name_table);
    }
    
        
    /**
     * 
     */
    public ArrayList getOneByIdPatient(int id) throws SQLException{
        return this.getOneByIdTable(id, name_table);
    }
    
    
    /**
     * 
     */
    public ArrayList getAllPatientDependency(int id) throws SQLException{
        return this.getAllTableDependency(id, name_table, "dossier");
    }
    
    
    /**
     * 
     */
    public void setPatient(String[] values)  throws SQLException{
        this.setTable(name_table, values);
    }
    
    
    /**
     * @param  String, String, String, int
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void updatePatient(String[] values, int id_row)  throws SQLException{
        this.updateTable(name_table, values, id_row);
    }
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void deletePatient(int id)  throws SQLException{
        this.deleteTable(id, name_table);
        this.deleteTableWithDependencyPatient(id);
    }
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void deleteTableWithDependencyPatient(int id)  throws SQLException{
        this.deleteTableWithDependency(id, name_table, "dossier");
    }
}


