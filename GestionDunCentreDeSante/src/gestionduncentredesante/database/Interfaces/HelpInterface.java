/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionduncentredesante.database.Interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author gino
 */
public interface HelpInterface {
     /**
     * 
     */
    public abstract int getNumberOfColumn(String name_table) throws SQLException;
    
    
    /**
     * 
     */
    public abstract String[] getNamesOfColumnInTable(String name_table) throws SQLException;
    
    
    
    
    /**
     * 
     */
    public abstract String[] getTypeOfColumnInTable(String name_table) throws SQLException;
    
    
    /**
     * 
     */
    public abstract String setQuery(String name_table, String[] column_name);
    
    
    /**
     * 
     */
    public abstract String setQueryUpdate(String name_table, String[] column_name);
    
    
    /**
     * 
     */
    public String setQueryUpdateRelationTable(String name_table, String name_table_relation, String[] column_name);
}
