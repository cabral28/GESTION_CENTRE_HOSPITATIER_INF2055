/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionduncentredesante;

import java.sql.SQLException;
import gestionduncentredesante.backend.*;

/**
 *
 * @author gino
 */
public class GestionDunCentreDeSante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        Admin ad = new Admin(2, "gino", "2587", false);
        String[] values = {"jkjvv", "vxwv", "28/11/2021", "F", "infirmier"};
        //ad.storeAdmin(values);
        //ad.connection("koybi", "1234");
        ad.setMedecin("chirigien", 8, "fdf", "dfdf", "13/01/0212", "M");
        Medecin medecin = ad.getMedecin();
        medecin.setCompte(1, "gdfg", "gdgs", false);
        medecin.getCompte().deleteCompte(medecin.getId());
        
        
    }
    
}
