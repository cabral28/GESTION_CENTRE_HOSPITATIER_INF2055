/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionduncentredesante.database.crud;

import gestionduncentredesante.database.connexiondatabase.DataBaseConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.JDBCType;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import gestionduncentredesante.database.help.Help;
import gestionduncentredesante.database.Interfaces.CRUDInterface;

/**
 *
 * @author gino
 */
public class CRUD extends DataBaseConnect implements CRUDInterface{
    
    public Help help = new Help();
    
    
    /**
     * 
     */
    public int getLastIdTable(String name_table) throws SQLException{
        int id = 0;
        this.connect();
        String query = "SELECT MAX(id_" + name_table + ") FROM " + name_table;
        ArrayList list = new ArrayList();
        try
        {
            Connection con = DriverManager.getConnection(this.url, this.uname, this.pwd);
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while(result.next()) {
                id = result.getInt(1);
            }
            statement.close();
            con.close();
            return id;
        } catch(SQLException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return id;
    }
    
    
    /**
     * 
     */
    public ArrayList getAllTable(String name_table) throws SQLException{
        this.connect();
        String query = "SELECT * FROM " + name_table;
        ArrayList list = new ArrayList();
        try
        {
            Connection con = DriverManager.getConnection(this.url, this.uname, this.pwd);
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            //Determination du nombre de colonnes de la table
            ResultSetMetaData rsmd = result.getMetaData();
            int column_count = rsmd.getColumnCount();
            
            
            while(result.next()){
                String UniversityData = "";
                for(int i=1 ; i <= column_count; i++){
                     UniversityData += result.getString(i) + ":";
                }
                list.add(UniversityData);
            }
            
            statement.close();
            con.close();
            return list;
        } catch(SQLException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    /**
     * 
     */
    public ArrayList getAllTableDependency(int id_dependency, String name_table, String name_table_dependency) throws SQLException{
        this.connect();
        String query = "SELECT * FROM " + name_table_dependency + " WHERE " + name_table + "_id= ?";
        ArrayList list = new ArrayList();
        try
        {
            Connection con = DriverManager.getConnection(this.url, this.uname, this.pwd);
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id_dependency);
            ResultSet result = statement.executeQuery(query);
            
            
            //Determination du nombre de colonnes de la table
            ResultSetMetaData rsmd = result.getMetaData();
            int column_count = rsmd.getColumnCount();
            
            
            String UniversityData = "";
            while(result.next()){
                for(int i=1 ; i <= column_count; i++){
                     UniversityData += result.getString(i) + ":";
                }
                list.add(UniversityData);
            }
            
            ArrayList liste = this.getAllTable(name_table);
            int size = liste.size();
            for(int i=1 ; i <= size; i++){
                list.add(liste.get(i).toString());
            }
            
            statement.close();
            con.close();
            return list;
        } catch(SQLException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
        
    }
    
    
    /**
     * 
     */
    public ArrayList getOneByIdTable(int id, String name_table) throws SQLException{
        
        
        this.connect();
        String query = "SELECT * FROM " + name_table + " WHERE id_" + name_table + "=?";
        System.out.println(query);
        ArrayList list = new ArrayList();
        try
        {
            Connection con = DriverManager.getConnection(this.url, this.uname, this.pwd);
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            
            ResultSetMetaData rsmd = result.getMetaData();
            int column_count = rsmd.getColumnCount();
         
            while(result.next()){
                String UniversityData = "";
                for(int i=1 ; i <= column_count; i++){
                     UniversityData += result.getString(i) + ":";
                }
                list.add(UniversityData);
            }
            
            statement.close();
            con.close();
            return list;
        } catch(SQLException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    
    
    /**
     * 
     */
    public ArrayList getTableDependToAnotherTable(int id_table_relation, String name_table, String name_table_relation) throws SQLException{
        
        
        this.connect();
        String query = "SELECT * FROM " + name_table + " WHERE id_" + name_table_relation + "=?";
        System.out.println(query);
        ArrayList list = new ArrayList();
        try
        {
            Connection con = DriverManager.getConnection(this.url, this.uname, this.pwd);
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id_table_relation);
            ResultSet result = statement.executeQuery();
            
            ResultSetMetaData rsmd = result.getMetaData();
            int column_count = rsmd.getColumnCount();
         
            while(result.next()){
                String UniversityData = "";
                for(int i=1 ; i <= column_count; i++){
                     UniversityData += result.getString(i) + ":";
                }
                list.add(UniversityData);
            }
            
            statement.close();
            con.close();
            return list;
        } catch(SQLException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void deleteTable(int id, String name_table)  throws SQLException{
        String query = "DELETE FROM " + name_table + " WHERE id_" + name_table+ "= ?";
        this.connect();
        try
        {
            Connection con = DriverManager.getConnection(this.url, this.uname, this.pwd);
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id);
            
            int row = statement.executeUpdate();
            
            if (row > 0){
                System.out.println("A row was been deleted !");       
            }
            
            statement.close();
            con.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    /**
     * @param  String, String, String, int
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void setTable(String name_table, String[] values) throws SQLException{
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
            
            
            //Recuperer les noms de chaque colonnes
            String[] column_name = help.getNamesOfColumnInTable(name_table);
            
            //Recuperer les types de chaque colonnes
            String[] column_type = help.getTypeOfColumnInTable(name_table);
            
            //Creer la requette d'insertion
            String queryInsertion = help.setQuery(name_table, column_name);
            
            //Executer la requette
            help.ExecutQuery(con, column_count, column_type, queryInsertion, values);

            statement.close();
            con.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    /**
     * @param  String, String, String, int
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void updateTable(String name_table, String[] values, int id_row) throws SQLException{
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
            
            //Recuperer les types de chaque colonnes
            String[] column_name = help.getNamesOfColumnInTable(name_table);
            
            //Recuperer les types de chaque colonnes
            String[] column_type = help.getTypeOfColumnInTable(name_table);
            
            //Creer la requette d'insertion
            String queryInsertion = help.setQueryUpdate(name_table, column_name);
            
            //Executer la requette
            help.ExecutQueryUpdate(con, column_count, column_type, queryInsertion, values, id_row);

            statement.close();
            con.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    /**
     * @param  String, String, String, int
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void updateTableDependsToAnotherTable(String name_table, String name_table_relation, String[] values, int id_relation) throws SQLException{
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
            
            //Recuperer les types de chaque colonnes
            String[] column_name = help.getNamesOfColumnInTable(name_table);
            
            //Recuperer les types de chaque colonnes
            String[] column_type = help.getTypeOfColumnInTable(name_table);
            
            //Creer la requette d'insertion
            String queryInsertion = help.setQueryUpdateRelationTable(name_table, name_table_relation, column_name);
            
            //Executer la requette
            help.ExecutQueryUpdate(con, column_count, column_type, queryInsertion, values, id_relation);

            statement.close();
            con.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void deleteTableDependsToAnotherTable(int id_dependency, String name_table, String name_table_dependency)  throws SQLException{
        String query = "DELETE FROM " + name_table + " WHERE " + name_table_dependency + "_id= ?";
        this.connect();
        try
        {
            Connection con = DriverManager.getConnection(this.url, this.uname, this.pwd);
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id_dependency);
            
            int row = statement.executeUpdate();
            
            if (row > 0){
                System.out.println("A row was been deleted !");       
            }
            this.deleteTable(id_dependency, name_table_dependency);
            statement.close();
            con.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
