
public class Patient extends Personne {
	public String nom_pere;
	public String nom_mere;
	public Dossier dossier;
	
	//public InterfaceDBConsultation db_Dos;
	
	
	public Patient(int id, String nom, String prenom, String date_nais, char sexe) {
		super(id, nom, prenom, date_nais, sexe);
		// TODO Auto-generated constructor stub
	}

}
