/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionduncentredesante.backend;

import gestionduncentredesante.database.Interfaces.CRUDInterface;
import gestionduncentredesante.database.ReturnCRUDInterface;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import gestionduncentredesante.database.connexiondatabase.DataBaseConnect;
import gestionduncentredesante.backend.help.Compte;
import gestionduncentredesante.backend.help.HashPwd;

/**
 *
 * @author gino
 */
public class Admin extends Compte{

    private Medecin medecin;
    private String[] values = {};
    
    
    /**
     * 
     */
    public Admin(int id_compte, String username, String pwd, boolean connect){ 
        super(id_compte, username, pwd, connect);
        this.name_table = "admin";
    }

    /**
     * 
     */
    public void storeAdmin(String[] values) throws SQLException { 
        crud.setTable(this.name_table, values);
    }
    
    /**
     * 
     */
    public void setMedecin(String poste, int id, String nom, String prenom, String date_Naissance, String sexe) { 
        this.medecin = new Medecin(poste, id, nom, prenom, date_Naissance, sexe);
    }
    
    /**
     * 
     */
    public Medecin getMedecin() { 
        return this.medecin;
    }
    
    
    /**
     * 
     */
    public void updateAdmin(String[] values) throws SQLException{
        crud.updateTable(this.name_table, values, this.id_compte);
    }
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void deleteAdmin()  throws SQLException{
        crud.deleteTable(this.id_compte, this.name_table);
    }
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void deleteMedecin(int id_medecin)  throws SQLException{
        this.medecin.deleteMedecin(id_medecin);
    }
}
