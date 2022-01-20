/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionduncentredesante.backend.help;

import gestionduncentredesante.database.Interfaces.CRUDInterface;
import gestionduncentredesante.database.ReturnCRUDInterface;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gino
 */
public class Compte {
    protected ReturnCRUDInterface retourne = new ReturnCRUDInterface();
    protected CRUDInterface crud = retourne.returnInterface();
    
    protected HashPwd hashpwd= new HashPwd();
    protected int id_compte;
    protected String username;
    protected String pwd;
    protected boolean connect;
    protected String name_table;

    public Compte(int id_compte_medecin, String username, String pwd, boolean connect) {
        this.id_compte = id_compte_medecin;
        this.username = username;
        this.pwd = pwd;
        this.connect = connect;
    }
    
    
    
    /**
     * 
     */
    public boolean connection(String username, String pwd) throws SQLException{
        ArrayList ad = crud.getAllTable(this.name_table);
        if(ad.get(1).toString() == username && ad.get(2).toString() == hashpwd.hashPassword(pwd)){
            System.out.println("Connecté");
            return this.connect = true;
        }
        System.out.println("Pas Connecté");
        return this.connect = false;
    }
    
}
