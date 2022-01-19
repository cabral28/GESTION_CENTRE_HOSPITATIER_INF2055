/*
 * To change CRUD license header, choose License Headers in Project Properties.
 * To change CRUD template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionduncentredesante.backend;

import gestionduncentredesante.backend.help.Compte;
import gestionduncentredesante.database.Interfaces.CRUDInterface;
import gestionduncentredesante.database.ReturnCRUDInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import gestionduncentredesante.database.connexiondatabase.DataBaseConnect;
import java.util.Date;

/**
 *
 * @author gino
 */
public class CompteMedecin extends Compte{
    
    
    ReturnCRUDInterface retourne = new ReturnCRUDInterface();
    CRUDInterface crud = retourne.returnInterface();
    private String name_table = "compte_medecin";
    private String[] name_table_depend = {"patient"};
    private int medecin_id;
    private Patient[] listePatients;
    private Patient[] listePatientsTraite;
    private Patient[] listePatientsNonTraite;
    private String[] values = {};
    
    
    
    /**
     * 
     */
    public CompteMedecin(int medecin_id, int id_compte_medecin, String username, String pwd, boolean connect) {    
        super(id_compte_medecin, username, pwd, connect);
        this.medecin_id = medecin_id;
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
    public int getId(){
        return this.id_compte_medecin;
    }
    

    /**
     * 
     */
    public ArrayList getAllCompte() throws SQLException {
        return crud.getAllTable(name_table);
    }
    
        
    /**
     * 
     */
    public ArrayList getOneByIdCompte(int id) throws SQLException{
        return crud.getOneByIdTable(id, name_table);
    }
    
    
    /**
     * 
     */
    public void setCompte(String[] values)  throws SQLException{
        crud.setTable(name_table, values);
    }
    
    
    /**
     * @param  String, String, String, int
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void updateCompte(String[] values, int id_row)  throws SQLException{
        crud.updateTable(name_table, values, id_row);
    }
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void deleteCompte(int id)  throws SQLException{
        crud.deleteTable(id, name_table);
    }
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public ArrayList getAllCompteDependence(int id)  throws SQLException{
        return crud.getAllTableDependency(id, name_table, "patient");
    }
        
}
