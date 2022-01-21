package Model;

public class Dossier {

	private String Num_Dossier;
	private String Antecedents;
	private String Recomandations;
	private String Ordonnance;
	private String Resultats;
	private String Responsables;

	public Dossier() {}
	
	public Dossier(String NoDoss,String antecedents,String recomandations,String ordonnance,String responsables,String resultats){
	   this.Num_Dossier=NoDoss;
	   this.Antecedents=antecedents;
	   this.Recomandations=recomandations;
	   this.Ordonnance=ordonnance;
	   this.Responsables=responsables;
	   this.Resultats=resultats;
	}

	public String getResponsables() {
		return Responsables;
	}

	public void setResponsables(String responsables) {
		Responsables = responsables;
	}

	public String getOrdonance() {
		return Ordonnance;
	}

	public void setOrdonance(String ordonance) {
		Ordonnance = ordonance;
	}

	public String getNum_Dossier() {
		return Num_Dossier;
	}

	public void setNum_Dossier(String num_Dossier) {
		Num_Dossier = num_Dossier;
	}

	public String getRecomandations() {
		return Recomandations;
	}

	public void setRecomandations(String recomandations) {
		Recomandations = recomandations;
	}

	public String getResultats() {
		return Resultats;
	}

	public void setResultats(String resultats) {
		Resultats = resultats;
	}
	
	public void Visualiser() {
		System.out.println("Num Dossier "+this.Num_Dossier+"\n"
				           +"Recomandations "+this.Recomandations +"\n"
				           +"Ordonnance "+this.Ordonnance+"\n"
				           +"Responsables "+this.Responsables+"\n");
	}

	public String getAntecedents() {
		return Antecedents;
	}

	public void setAntecedents(String antecedents) {
		Antecedents = antecedents;
	}

	

}
