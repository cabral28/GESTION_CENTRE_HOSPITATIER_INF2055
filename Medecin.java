public class Medecin extends Personne {

	String poste;
	CompteMedecin compte;
	
	//public InterfaceDBCompte dbCompte;
	
	
	
public Medecin(String poste, int id, String nom, String prenom, String date_nais, char sexe){
        
        super(id, nom, prenom, date_nais, sexe);
        this.poste = poste;
    }
	

public void setCompte(){ 
    
}
}
