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
        Consultation con = new Consultation();
        con.deleteConsultation(1);
    }
    
}
