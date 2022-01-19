/*
 * To change crud license header, choose License Headers in Project Properties.
 * To change crud template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionduncentredesante.backend;
import gestionduncentredesante.database.Interfaces.CRUDInterface;
import gestionduncentredesante.database.ReturnCRUDInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import gestionduncentredesante.database.connexiondatabase.DataBaseConnect;

/**
 *
 * @author gino
 */
public class Examen {
    
    ReturnCRUDInterface retourne = new ReturnCRUDInterface();
    CRUDInterface crud = retourne.returnInterface();
    private String name_table = "examen";
    private int id_exam;
    private String nom_exam;
    private float taille;
    private float poids;
    private float frequence_cardiaque;
    private String allergie;
    private float taux_glycemie;
    private String groupe_sanguin;
    private String maladie_chronique;
    private int consultation_id;
    private String[] values = {};
    
    
    /**
     * 
     */
    public Examen(int id_exam, String nom_exam, float taille, float poids, float frequence_cardiaque, String allergie, float taux_glycemie, String groupe_sanguin, String maladie_chronique, int consultation_id){    
        
        this.id_exam = id_exam;
        this.nom_exam = nom_exam;
        this.taille = taille;
        this.poids = poids;
        this.frequence_cardiaque = frequence_cardiaque;
        this.allergie = allergie;
        this.taux_glycemie = taux_glycemie;
        this.groupe_sanguin = groupe_sanguin;
        this.maladie_chronique = maladie_chronique;
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
    public ArrayList getAllExamen() throws SQLException {
        return crud.getAllTable(name_table);
    }
    
        
    /**
     * 
     */
    public ArrayList getOneByIdExamen(int id) throws SQLException{
        return crud.getOneByIdTable(id, name_table);
    }
    
    
    /**
     * 
     */
    public void setExamen(String[] values)  throws SQLException{
        crud.setTable(name_table, values);
    }
    
    
    /**
     * @param  String, String, String, int
     * @return void
     * crud function delete a ligne in a table of our DB
     */
    public void updateExamen(String[] values, int id_row)  throws SQLException{
        crud.updateTable(name_table, values, id_row);
    }
    
    
    /**
     * @param  String
     * @return void
     * crud function delete a ligne in a table of our DB
     */
    public void deleteExamen(int id)  throws SQLException{
        crud.deleteTable(id, name_table);
    }
}
