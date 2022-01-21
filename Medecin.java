package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Medecin extends Personne {
	Connection MyConnect=connection.getConection();
	private String Matricule_Medecin,Specialite,mdp;
	
 	public Medecin() {}

	public Medecin(String Matricule,String nom, String prenom, String sexe, int age,String speci,String Mdp) {
		super(nom, prenom, sexe, age);
		Matricule_Medecin=Matricule;
		Specialite=speci;
		mdp=Mdp;
	}
	
	public void setMesPatient(Patient patient) {
		//Requete sql pour ajouter un patient a sa liste
	}
	
	public void getMesPatient() {
		//Requete sql pour ajouter un patient

	}

	public String getMatricule_Medecin() {
		return Matricule_Medecin;
	}


	public void setMatricule_Medecin(String matricule_Medecin) {
		Matricule_Medecin = matricule_Medecin;
	}

	public String getSpecialite() {
		return Specialite;
	}

	public void setSpecialite(String specialite) {
		Specialite = specialite;
	}

	public String getMdp() {
		return this.mdp;
	}
	@Override
	public void Ajouter() {
		/**Ajout dans la table patient**/
		String Query="INSERT INTO medecin(MatriculeMed,nom,prenom,age,specialite,mdp) VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement prepareQuery=MyConnect.prepareStatement(Query);
			prepareQuery.setString(1, ""+this.getMatricule_Medecin());
			prepareQuery.setString(2, ""+this.getNom());
			prepareQuery.setString(3, ""+this.getPrenom());
			prepareQuery.setString(4, ""+this.getAge());
			prepareQuery.setString(5, ""+this.getSpecialite());
			prepareQuery.setString(6, ""+this.getMdp());
			prepareQuery.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/**Fin ici**/
	}

	@Override
	public void Modifier() {
    /**Mise a jour du medecin**/
		
		String Query="UPDATE medecin SET";
		Query+=" Nom=?";
		Query+=", Prenom=?";
		Query+=", Age=?";
		Query+=", specialite=?";
		Query+=" WHERE MatriculeMed=?";
		
		try {
			PreparedStatement prepareQuery=MyConnect.prepareStatement(Query);
			prepareQuery.setString(1, ""+this.getNom());
			prepareQuery.setString(2, ""+this.getPrenom());
			prepareQuery.setString(3, ""+this.getAge());
			prepareQuery.setString(4, ""+this.getSpecialite());
			prepareQuery.setString(5, ""+this.getMatricule_Medecin());
			prepareQuery.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Supprimer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Rechercher() {
		// TODO Auto-generated method stub
		
	}

}
