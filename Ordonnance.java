
public class Ordonnance {
	

	public int id_or;
	public String nom_or;
	public String description;
	
	
	public Ordonnance(int id_or, String nom_or,String description) {
		
		// TODO Auto-generated constructor stub
		this.id_or=id_or;
		this.nom_or=nom_or;
		this.description=description;
	}
	
	
	public int getId_or() {
		return id_or;
	}
}