package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

public  class Patient extends Personne {
	
	Connection MyConnect=connection.getConection();
	
	private String Matricule;
	private String Status;
	private Dossier dossier;
	
	public Patient() {
		//dossier=new Dossier();
	}

	public Patient(String nom, String prenom, String sexe, int age,String matricule,String Status,Dossier dos) {
		super(nom, prenom, sexe, age);
		this.setMatricule(matricule);
		this.Status=Status;
		dossier=dos;
	}
		
	public void setStatus(String status) {
		this.Status=status;
	}
	
	public String getStatus() {
		return Status;
	}

	public String getMatricule() {
		return Matricule;
	}

	public void setMatricule(String matricule) {
		Matricule = matricule;
	}
	
	public Dossier Getdosseir() {
		return this.dossier;
	}
	
	public void setDossier(String Recomandations,String Responsable,String Antecedents,String Ordonnance,String Resultats) {
		dossier.setAntecedents(Antecedents);
		dossier.setRecomandations(Recomandations);
		dossier.setResultats(Resultats);
		dossier.setOrdonance(Ordonnance);
		dossier.setResponsables(Responsable);
	}

	@Override
	public void Ajouter() {
		/**Ajout dans la table patient**/
		String Query="INSERT INTO Patient(Matricule,NumDoss,nom,prenom,age,Statu) VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement prepareQuery=MyConnect.prepareStatement(Query);
			prepareQuery.setString(1, ""+this.getMatricule());
			prepareQuery.setString(2, ""+this.Getdosseir().getNum_Dossier());
			prepareQuery.setString(3, ""+this.getNom());
			prepareQuery.setString(4, ""+this.getPrenom());
			prepareQuery.setString(5, ""+this.getAge());
			prepareQuery.setString(6, ""+this.getStatus());
			prepareQuery.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/**Fin ici**/
		
		/**Ajout dans la table Dossier**/
		String QueryDoss="INSERT INTO Dossier(NumDoss,Antecedent,Recomandations,Ordonnance,Responsables,Resultats) VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement prepareQuery=MyConnect.prepareStatement(QueryDoss);
			prepareQuery.setString(1, ""+this.Getdosseir().getNum_Dossier());
			prepareQuery.setString(2, ""+this.Getdosseir().getAntecedents());
			prepareQuery.setString(3, ""+this.Getdosseir().getRecomandations());
			prepareQuery.setString(4, ""+this.Getdosseir().getOrdonance());
			prepareQuery.setString(5, ""+this.Getdosseir().getResponsables());
			prepareQuery.setString(6, ""+this.Getdosseir().getResultats());
			prepareQuery.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/**Fin ici**/
	}

	@Override
	public void Modifier() {
		
		/**Mise a jour du patient**/
		
		String Query="UPDATE Patient SET";
		Query+=" Nom=?";
		Query+=", Prenom=?";
		Query+=", Age=?";
		Query+=", Statu=?";
		Query+=", NumDoss=?";
		Query+=" WHERE Matricule=?";
		
		try {
			PreparedStatement prepareQuery=MyConnect.prepareStatement(Query);
			prepareQuery.setString(1, ""+this.getNom());
			prepareQuery.setString(2, ""+this.getPrenom());
			prepareQuery.setString(3, ""+this.getAge());
			prepareQuery.setString(4, ""+this.getStatus());
			prepareQuery.setString(5, ""+this.Getdosseir().getNum_Dossier());
			prepareQuery.setString(6, ""+this.getMatricule());
			prepareQuery.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/**Fin ici**/
		
		/**Mettre a jour la table Dossier**/
		String QueryDoss="UPDATE Dossier SET";
		QueryDoss+=" Antecedent=?";
		QueryDoss+=", Recomandations=?";
		QueryDoss+=", Ordonnance=?";
		QueryDoss+=", Responsables=?";
		QueryDoss+=", Resultats=?";
		QueryDoss+=" WHERE NumDoss=?";
		
		try {
			PreparedStatement prepareQuery=MyConnect.prepareStatement(QueryDoss);
			prepareQuery.setString(1, ""+this.Getdosseir().getAntecedents());
			prepareQuery.setString(2, ""+this.Getdosseir().getRecomandations());
			prepareQuery.setString(3, ""+this.Getdosseir().getOrdonance());
			prepareQuery.setString(4, ""+this.Getdosseir().getResponsables());
			prepareQuery.setString(5, ""+this.Getdosseir().getResultats());
			prepareQuery.setString(6, ""+this.Getdosseir().getNum_Dossier());
			prepareQuery.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/**Fin ici**/
	}

	@Override
	public void Supprimer() {
		
		
	}

	@Override
	public void Rechercher() {
		// TODO Auto-generated method stub
		
	}
	

}


