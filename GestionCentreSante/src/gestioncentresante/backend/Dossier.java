/*
 * To change crud license header, choose License Headers in Project Properties.
 * To change crud template file, choose Tools | Templates
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
import gestioncentresante.database.connexiondatabase.DataBaseConnect;
import gestioncentresante.database.Consultation;

/**
 *
 * @author gino
 */
public class Dossier {
    
    CRUD crud = new CRUD();
    private String name_table = "dossier";
    
        
    /**
     * 
     */
    public ArrayList getAllDossier() throws SQLException{
        
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
        crud.deleteTableWithDependencyDossier(id);
    }
    
    
    /**
     * @param  String
     * @return void
     * crud function delete a ligne in a table of our DB
     */
    public void deleteTableWithDependencyDossier(int id)  throws SQLException{
        crud.deleteTableWithDependency(id, name_table, "consultation");
        crud.deleteDossier(id);
    }
}
