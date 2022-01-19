/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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

/**
 *
 * @author gino
 */
public class Ordonnance{
    
    ReturnCRUDInterface retourne = new ReturnCRUDInterface();
    CRUDInterface crud = retourne.returnInterface();
    private String name_table = "ordonnance";
    private int id_ordonnance;
    private String nom_ord;
    private String description_ord;
    private int consultation_id;
    private String[] values = {};
    
    
    /**
     * 
     */
    public Ordonnance(int id_ordonnance, String nom_ord, String description_ord, int consultation_id){    
        
        this.id_ordonnance = id_ordonnance;
        this.nom_ord = nom_ord;
        this.description_ord = description_ord;
        this.consultation_id = consultation_id;
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
    public ArrayList getAllOrdonnance() throws SQLException {
        return crud.getAllTable(name_table);
    }
    
        
    /**
     * 
     */
    public ArrayList getOneByIdOrdonnance(int id) throws SQLException{
        return crud.getOneByIdTable(id, name_table);
    }
    
    
    /**
     * 
     */
    public void setOrdonnance(String[] values)  throws SQLException{
        crud.setTable(name_table, values);
    }
    
    
    /**
     * @param  String, String, String, int
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void updateOrdonnance(String[] values, int id_row)  throws SQLException{
        crud.updateTable(name_table, values, id_row);
    }
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void deleteOrdonnance(int id)  throws SQLException{
        crud.deleteTable(id, name_table);
    }
}

