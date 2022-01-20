/*
 * To change crud license header, choose License Headers in Project Properties.
 * To change crud template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionduncentredesante.backend;

import gestionduncentredesante.database.crud.CRUD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import gestionduncentredesante.database.connexiondatabase.DataBaseConnect;

/**
 *
 * @author gino
 */
public class Consultation{
    
    private String name_table = "consultation";
    CRUD crud = new CRUD();
    private int id_consultation;
    private String[] name_table_depend = {"soin", "ordonnance", "examen"};
    private String nom_cons;
    private int dossier_id;
    private int traite_cons;
    private Soin soin;
    private Examen examen;
    private Ordonnance ordonnance;
    private String[] values = {}; 
    
    /**
     * 
     */
    public Consultation(int id_consultation, String nom_cons, int dossier_id, int traite_cons){
        this.id_consultation = id_consultation;
        this.nom_cons = nom_cons;
        this.dossier_id = dossier_id;
        this.traite_cons = traite_cons;
        //
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
    public void setValues(String[] vals) { 
        this.values = vals;
    }
    
    /**
     * 
     */
    public int getId() throws SQLException{
        return this.id_consultation;
    }
    
    /**
     * 
     */
    public void setId(int id) throws SQLException{
        this.id_consultation = id;
    }
    
    

    
   /**
     * 
     */
    public void setOrdonnance(int id_ordonnance, String nom_ord, String description_ord) throws SQLException { 
        this.ordonnance = new Ordonnance(id_ordonnance, nom_ord, description_ord, this.id_consultation);
    }
    
    /**
     * 
     */
    public void setSoin(int id, String nom, String dose) throws SQLException { 
        this.soin = new Soin(id, nom, dose, this.id_consultation);
    }
    
    /**
     * 
     */
    public void setExamen(int id_exam, String nom_exam, float taille, float poids, float frequence_cardiaque, String allergie, float taux_glycemie, String groupe_sanguin, String maladie_chronique) throws SQLException { 
        this.examen = new Examen(id_exam,  nom_exam,  taille,  poids,  frequence_cardiaque,  allergie,  taux_glycemie,  groupe_sanguin,  maladie_chronique, this.id_consultation);
    }
    
    
    /**
     * 
     */
    public Ordonnance getOrdonnance(){ 
        return this.ordonnance;
    }
    
    /**
     * 
     */
    public Soin setSoin() { 
        return this.soin;
    }
    
    /**
     * 
     */
    public Examen getExamen() { 
        return this.examen;
    }
    
    
    /**
     * 
     */
    public String[] getConsultationDossier(int id_relation) throws SQLException{
        String[] resultConsultations = new String[4];
        resultConsultations[0] = crud.getTableDependToAnotherTable(id_relation, this.name_table, "dossier").toString();
        resultConsultations[1] += this.ordonnance.getOrdonnanceConsultation(this.id_consultation).toString();
        resultConsultations[2] += this.examen.getExamenConsultation(this.id_consultation);
        resultConsultations[3] += this.soin.getSoinConsultation(this.id_consultation);
        
        return resultConsultations;
    }
    
    /**
     * 
     */
    public void storeConsultation(String[] values, String[] valuesSoin, String[] valuesExam, String[] valuesOrd) throws SQLException{
        crud.setTable(this.name_table, values);
        this.soin.setSoin(valuesSoin);
        this.ordonnance.setOrdonnance(valuesOrd);
        this.examen.setExamen(valuesExam);
    }
    
    
    /**
     * 
     */
    public void updateConsultation(String[] values, int id_relation) throws SQLException{
        crud.updateTable(this.name_table, values, this.id_consultation);
    }
    
    
    /**
     * @param  String
     * @return void
     * this function delete a ligne in a table of our DB
     */
    public void deleteConsultation(int id_relation, int id_table)  throws SQLException{
        crud.deleteTableDependsToAnotherTable(id_relation, this.name_table, "dossier");
        this.soin.deleteSoin(this.id_consultation);
        this.ordonnance.deleteOrdonnance(this.id_consultation);
        this.examen.deleteExamen(this.id_consultation);
    }
}
