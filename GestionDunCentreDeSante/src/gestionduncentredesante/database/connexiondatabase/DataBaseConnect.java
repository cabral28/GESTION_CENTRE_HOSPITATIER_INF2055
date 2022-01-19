/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionduncentredesante.database.connexiondatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author gino
 */
public class DataBaseConnect {
    protected String url = "jdbc:mysql://localhost:3306/gestion_centre_sante";
    protected String uname = "root";
    protected String pwd = "";
    
    public void connect() throws SQLException{
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
