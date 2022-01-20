/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionduncentredesante.database.help;

import gestionduncentredesante.database.connexiondatabase.DataBaseConnect;
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
import gestionduncentredesante.database.Interfaces.HelpInterface;

/**
 *
 * @author gino
 */
public class Help extends DataBaseConnect implements HelpInterface{
    
    /**
     * 
     */
    public int getNumberOfColumn(String name_table) throws SQLException{
        String query = "SELECT * FROM " + name_table;
        int column_count;
        this.connect();
        try
        {
            Connection con = DriverManager.getConnection(this.url, this.uname, this.pwd);
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            ResultSetMetaData rsmd = result.getMetaData();
            
            //Recuperer le nombre de colonnes 
            column_count = rsmd.getColumnCount();
            
            return column_count;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return column_count=0;
    }
    
    
    /**
     * 
     */
    public String[] getNamesOfColumnInTable(String name_table) throws SQLException{
        String query = "SELECT * FROM " + name_table;
        this.connect();
        try
        {
            Connection con = DriverManager.getConnection(this.url, this.uname, this.pwd);
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            ResultSetMetaData rsmd = result.getMetaData();
            
            //Recuperer le nombre de colonnes 
            int column_count = rsmd.getColumnCount();
            
            String[] column_name = new String[column_count];
            
            //Recuperer les nom de chaque colonne
            for(int i=1; i< column_count; i++){
                column_name[i] = rsmd.getColumnName(i);
            }
            return column_name;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return new String[0];
    }
    
    
    
    /**
     * 
     */
    public String[] getTypeOfColumnInTable(String name_table) throws SQLException{
        String query = "SELECT * FROM " + name_table;
        this.connect();
        try
        {
            Connection con = DriverManager.getConnection(this.url, this.uname, this.pwd);
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            ResultSetMetaData rsmd = result.getMetaData();
            
            int column_count = rsmd.getColumnCount();
            String[] column_type = new String[column_count];
            
            
            int indexTypes[] = new int[column_count];
            
            //recuperer l'indice de la colonne
            for(int i = 1; i < column_count; i++){
                indexTypes[i] = rsmd.getColumnType(i);
            }
            
            //Recuperer les types de chaques colonnes
            for(int i = 1; i < column_count; i++){
                int index = indexTypes[i];
                column_type[i] = JDBCType.valueOf(index).toString();
            }
            return column_type;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return new String[0];
    }
    
    
    /**
     * 
     */
    public String setQuery(String name_table, String[] column_name){
        String queryInsertion ="INSERT INTO " + name_table +" (";
        String value = "(";
        for(int i=2; i< column_name.length-1; i++){
            if(i == column_name.length - 2){
                queryInsertion += column_name[i] + ")";
                value += "?)" ;
            }else{
                queryInsertion += column_name[i] + ", ";
                value += "?, ";
            }
            
        }
        return queryInsertion += " VALUES " + value;
    }
    
    
    /**
     * 
     */
    public String setQueryUpdate(String name_table, String[] column_name){
        String queryInsertion ="UPDATE " + name_table +" SET ";
        for(int i=2; i<= column_name.length-2; i++){
            queryInsertion += column_name[i] + "=?, ";
        }
        return queryInsertion += "update_date=? WHERE id_" + name_table + "= ?";
    }
    
    /**
     * 
     */
    public String setQueryUpdateRelationTable(String name_table, String name_table_relation, String[] column_name){
        String queryInsertion ="UPDATE " + name_table +" SET ";
        for(int i=2; i<= column_name.length-2; i++){
            queryInsertion += column_name[i] + "=?, ";
        }
        return queryInsertion += "update_date=? WHERE id_" + name_table_relation + "= ?";
    }
    
    
    /**
     * 
     */
    public void ExecutQuery(Connection con, int column_count, String[] column_type, String query, String[] values) throws SQLException{
        PreparedStatement preStatement = con.prepareStatement(query);
        for(int i=2; i<= column_count-2; i++){
            if(column_type[i] == "VARCHAR" || column_type[i-2] == "TEXT"){
                preStatement.setString(i-1, values[i-2]);
            } else if(column_type[i] == "INTEGER"){
                preStatement.setInt(i-1, Integer.parseInt(values[i-2]));
            } else if(column_type[i] == "FLOAT"){
                preStatement.setFloat(i-1, Float.parseFloat(values[i-2]));
            }    
        }
        
        int row = preStatement.executeUpdate();
        if(row > 0){
            System.out.println("A row was been inserted ! ");
        }   
    }
    
    
    /**
     * 
     */
    public void ExecutQueryUpdate(Connection con, int column_count, String[] column_type, String query, String[] values, int id_row) throws SQLException{
        PreparedStatement preStatement = con.prepareStatement(query);
        int i=2;
        while(i <= column_count-2){
            if(column_type[i] == "VARCHAR" || column_type[i] == "TEXT"){
                preStatement.setString(i-1, values[i-2]);
            } else if(column_type[i] == "INTEGER"){
                preStatement.setInt(i-1, Integer.parseInt(values[i-2]));
            } else if(column_type[i] == "FLOAT"){
                preStatement.setFloat(i-1, Float.parseFloat(values[i-2]));
            }
            i++;
        }
        
        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());
        preStatement.setTimestamp(i-1, time);
        preStatement.setInt(i, id_row);
            
        int row = preStatement.executeUpdate();
            
        if (row > 0){
            System.out.println("A row was been updated !");       
        }
         
    }
}
