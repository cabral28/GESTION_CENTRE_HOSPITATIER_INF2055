/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionduncentredesante.backend.help;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author gino
 */
public class HashPwd {
    
    public String hashPassword(String pwd){
        String generatedPwd = null;
        
        try
        {
            //Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            //Add password bytes to digest
            md.update(pwd.getBytes());
            
            //Get the hash's bytes
            byte[] bytes = md.digest();
            
            //This bytes[] has bytes in decimal format. Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length; i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            
            //Get complete hashed password in hex format
            generatedPwd = sb.toString();
        } catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return generatedPwd;
    }
}
