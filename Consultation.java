
public class Consultation {
	
	public int id_consultation;
	Ordonnance ordonnance;
	Soin soin;
	Examen examen;
	public boolean traiter;
	//public InterfaceDBOrdonnance dbOrd;
	//public InterfaceDBSoin dbSoin;
	//public InterfaceDBEam dbExam;
	
	
	public void setOrdonnance(Ordonnance ordonnance) {
		this.ordonnance = ordonnance;
	}
	
	public void setSoin(Soin soin) {
		this.soin = soin;
	}
	
	public void setExamen(Examen examen) {
		this.examen = examen;
	}
	
	public void setTraiter(boolean traiter) {
		this.traiter = traiter;
	}
}
