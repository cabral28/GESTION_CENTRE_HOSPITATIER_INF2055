
public class CompteMedecin {
	public String id_compte;
	public String username;
	public Patient patient;
	public String pwd;
	//public InterfaceDBPatient dbPatient;
	public Dossier[] liste_dos[];
	public Dossier[] liste_dos_traiter[];
	public Dossier[] liste_dos_a_faire[];
	public Patient[] liste_pat[];
	public Patient[] liste_pat_traiter[];
	public Patient[] liste_pat_a_traiter[];
	
	
	
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setListe_dos(Dossier[][] liste_dos_Dossier) {
		this.liste_dos = liste_dos;
	}
	
	public void setListe_dos_traiter(Dossier[][] liste_dos_traiter) {
		this.liste_dos_traiter = liste_dos_traiter;
	}
	
	public void setListe_dos_a_faire(Dossier[][] liste_dos_a_faire) {
		this.liste_dos_a_faire = liste_dos_a_faire;
	}
	public void setListe_pat(Patient[][] liste_pat) {
		this.liste_pat = liste_pat;
	}
	
	public void setListe_pat_traiter(Patient[][] liste_pat_traiter) {
		this.liste_pat_traiter = liste_pat_traiter;
	}
	
	public void setListe_pat_a_traiter(Patient[][] liste_pat_a_traiter) {
		this.liste_pat_a_traiter = liste_pat_a_traiter;
	}

}
