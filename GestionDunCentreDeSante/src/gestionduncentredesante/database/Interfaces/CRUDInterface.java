package gestionduncentredesante.database.Interfaces;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gino
 */
public interface CRUDInterface {
     
    /**
     * 
     */
    public abstract ArrayList getAllTable(String name_table)  throws SQLException;
    
    
    /**
     * 
     */
    public int getLastIdTable(String name_table) throws SQLException;
    
    
    /**
     * 
     */
    public abstract ArrayList getAllTableDependency(int id_dependency, String name_table, String name_table_dependency)  throws SQLException;
    
    
    /**
     * 
     */
    public abstract ArrayList getOneByIdTable(int id, String name_table)  throws SQLException;
    
    /**
     * 
     */
    public ArrayList getTableDependToAnotherTable(int id_table_relation, String name_table, String name_table_relation) throws SQLException;
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public abstract void deleteTable(int id, String name_table) throws SQLException;

    
    /**
     * @param  String, String, String, int
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public abstract void setTable(String name_table, String[] values)  throws SQLException;
    
    
    /**
     * @param  String, String, String, int
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public abstract void updateTable(String name_table, String[] values, int id_row)  throws SQLException;
    
    
    /**
     * @param  String, String, String, int
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void updateTableDependsToAnotherTable(String name_table, String name_table_relation, String[] values, int id_relation) throws SQLException;
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public abstract void deleteTableDependsToAnotherTable(int id_dependency, String name_table, String name_table_dependency)  throws SQLException;
}
