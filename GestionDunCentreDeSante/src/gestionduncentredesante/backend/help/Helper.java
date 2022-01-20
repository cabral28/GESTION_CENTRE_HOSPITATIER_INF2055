/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionduncentredesante.backend.help;

import gestionduncentredesante.database.ReturnHelpInterface;
import gestionduncentredesante.database.Interfaces.HelpInterface;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author gino
 */
public class Helper {
    ReturnHelpInterface retourne = new ReturnHelpInterface();
    HelpInterface help = retourne.returnInterface();
    
    
    public void obtenirUneClasse(String name_table) throws SQLException{
        int numbCol = help.getNumberOfColumn(name_table);
        String[] column_type = help.getTypeOfColumnInTable(name_table);
        
        for(int i=0; i < numbCol; i++){
            if(column_type[i] == "VARCHAR" || column_type[i] == "TEXT"){
                
            } else if(column_type[i] == "INTEGER"){
            } else if(column_type[i] == "FLOAT"){
            } 
        }
    }
}
