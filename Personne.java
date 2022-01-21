package Model;

public abstract class Personne {

	private String Nom,Prenom,Sexe;
	private int Age;
	
	//Constructeur de l'objet personne sans parametre
	public Personne() {}
	
	//Constructeur de l'objet personne avec parametres
	public Personne(String nom,String prenom,String sexe,int age) {
		this.Nom=nom;
		this.Prenom=prenom;
		this.Sexe=sexe;
		this.Age=age;
	}
	
	/*****************************/
	public abstract void Ajouter();
    public abstract void Modifier() ;
	public abstract void Supprimer();
	public abstract void Rechercher() ;
	
	//Connaitre le nom,prenom,sexe,age
	public void SetNom(String nom) {this.Nom=nom;}
	public void SetPrenom(String prenom) {this.Prenom=prenom;}
	public void SetSexe(String sexe) {this.Sexe=sexe;}
	public void SetAge(int age) { this.Age=age;}

	// definir le nom,prenom,sexe,age
	public String getNom() {return this.Nom;}
	public String getPrenom() {return this.Prenom;}
	public String getSexe() {return this.Sexe;}
	public int getAge() {return this.Age;}
	

}
