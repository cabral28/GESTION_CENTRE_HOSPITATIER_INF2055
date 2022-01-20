/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionduncentredesante.database;

import gestionduncentredesante.database.crud.CRUD;

/**
 *
 * @author gino
 */
public class ReturnCRUDInterface {
    
    public CRUD returnInterface(){
        return new CRUD();
    }
}
