
public class Dossier {
	
	public Consultation[] liste_cons[];
	public Consultation[] liste_cons_traiter[];
	public Consultation[] liste_cons_a_faire[];
	public boolean dos_traiter;
	public String nom_dossier;
	//InterfaceDBConsultation dbCon;
	
	
	public void cons(Consultation[][] liste_cons) {
		this.liste_cons = liste_cons;
	}
	
	public void setListe_cons(Consultation[][] liste_cons) {
		this.liste_cons = liste_cons;
	}
	
	private void set_examiner() {
		// TODO Auto-generated method stub

	}
	
	public void setListe_cons_traiter(Consultation[][] liste_cons_traiter) {
		this.liste_cons_traiter = liste_cons_traiter;
	}
	
	public void setListe_cons_a_faire(Consultation[][] liste_cons_a_faire) {
		this.liste_cons_a_faire = liste_cons_a_faire;
	}

}
