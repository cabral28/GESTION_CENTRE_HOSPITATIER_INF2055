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

    private String[] name_table_depend = {"medecin"};
    private Medecin[] listeMedecin;
    private Medecin medecin;
    private String[] values = {};
    
    
    /**
     * 
     */
    public Admin(int id_compte_medecin, String username, String pwd, boolean connect){ 
        super(id_compte_medecin, username, pwd, connect);
        this.name_table = "admin";
    }

    /**
     * 
     */
    public void setAdmin(String[] values) throws SQLException { 
        crud.setTable(this.name_table, values);
    }
    
    
    /**
     * 
     */
    public void setValues(String[] vals) { 
        this.values = vals;
    }
    
    
    /**
     * 
     */
    public void setMedecin(String poste, int id, String nom, String prenom, String date_Naissance, String sexe) throws SQLException{ 
        this.medecin = new Medecin(poste, id, nom, prenom, date_Naissance, sexe);
    }
    
    
    /**
     * 
     */
    public ArrayList getAllMedecin() throws SQLException{ 
        return crud.getAllTable(this.name_table_depend[0]);
    }
    
    /**
     * 
     */
    public void storeMedecin() throws SQLException{ 
        crud.setTable(this.name_table_depend[0], this.medecin.getValues());
    }
    
    
    /**
     * 
     */
    public void updateMedecin() throws SQLException{ 
        crud.updateTable(this.name_table_depend[0], this.medecin.getValues(), this.medecin.getId());
    }
    
    
    /**
     * 
     */
    public void storeAdmin() throws SQLException{ 
        crud.setTable(this.name_table, this.values);
    }
}
