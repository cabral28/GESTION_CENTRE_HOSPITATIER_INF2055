package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
	
	/*
	 * Cette classe permet une connection unique ,a chaque fois on aura plus besoin d'etablir 
	 * une connection avec la Bd ce qui ralentira probablement le programme
	 * 
	*/
	
	public String url="jdbc:mysql://localhost:3306/Hopital";
	public String user="root";
	public String passwd="0123456789Aa";
	
	private static Connection connect;
	
	private connection(){
		try {
			connect = DriverManager.getConnection(url,user,passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	//Retoune un objet de connection a la BD 
	public static Connection StartConnection(){
		if(connect == null){
			new connection();
			System.out.println("CONNEXION SQL ok! ");
			System.out.println("Connexion etablie...");
	    }else {
	    	System.out.println("connexion exite déjà  ");
	    }
	   return connect;
	}
	
	
	/******/
	public static  Connection getConection() {
		return connect;
	}
	
	//Arret de la  connection a la BD 
		public static void  EndConnection(){
			System.out.println("DECONNEXION  en cours ! ");
		   connect=null;
		   System.out.println("Stop de la uCONNEXION SQL! ");
		}

}
