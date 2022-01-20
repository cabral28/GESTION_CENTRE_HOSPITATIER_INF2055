/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncentresante.backend;

import gestioncentresante.database.CRUD;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author gino
 */
public class Admin extends DataBaseConnect{

    private CRUD crud = new CRUD();
    private String name_table = "admin";
    
        
    /**
     * 
     */
    public void setAmin(String[] values) throws SQLException{ 
        crud.setTable(name_table, values);
    }
    
}
