import java.util.ArrayList;

public class Soin {
	public int id_soin;
	public String nom_soin;
	public String dose;
	public int id_consultation;
	
	
	
	public void setSoin(int id_soin, String nom_soin, String dose, int id_consultation) {
		this.id_soin = id_soin;
		this.nom_soin=nom_soin;
		this.dose=dose;
		this.id_consultation=id_consultation;
		
	}
}
