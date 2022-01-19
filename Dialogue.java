package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Model.Patient;

public class Dialogue extends JDialog {
	
	/*Classe de base pour les boites de dialogue */
	
	protected DefaultTableModel P;
	protected Patient patient;
	protected Object[] datatemp= {};
	
	/***************Les panneaux*******************/
	protected JPanel PanneauRacine=new JPanel();
	protected JPanel panelBaseInfo=new JPanel();
	protected JPanel PanelInfoPerso=new JPanel();
    protected JPanel PanelInfoDossMedi=new JPanel();
    protected JPanel PanelButton =new JPanel();
    
    /****************************************/
    protected JButton Valider=new JButton("Valider");
    protected JButton Modifier=new JButton("Modifier");
    protected JButton Abandonner=new JButton("Suivre");
    
    /**********************Elements Du Panel info***********************/
    protected JLabel Matricule=new JLabel("");
    protected JTextField MatriculeArea= new JTextField(10);
    
    protected JLabel NoDoss=new JLabel("                   ");
    protected JTextField NoDossArea= new JTextField(10);
    
    protected JLabel Nom=new JLabel("                      ");
    protected JTextField NomArea= new JTextField(10);
    
    protected JLabel Prenoms=new JLabel("         ");
    protected JTextField PrenomsArea= new JTextField(10);
    
    protected JLabel Age=new JLabel("       ");
    protected JTextField AgeArea= new JTextField(10);
   
    protected JLabel Sexe=new JLabel("        ");
    protected JComboBox<String> SexeArea= new JComboBox<String>();
    
    protected JLabel Statu=new JLabel("          ");
    protected JComboBox<String> StatuArea= new JComboBox<String>();
    /**************************************************************************/
    protected JLabel Specialite=new JLabel("                      ");
	protected JTextField SpecialiteArea= new JTextField(10);
	
	protected JLabel Password=new JLabel("         ");
	protected JPasswordField PasswordArea=new JPasswordField(15);
    
    /**********************Elements Du Panel Dossier medical***********************/
    protected JTextArea ResponsablesArea= new JTextArea();
    protected JTextArea RecommandationsArea= new JTextArea();
    protected JTextArea OrdonnanceArea= new JTextArea();
    protected JTextArea ResultatsArea= new JTextArea();
    protected JTextArea AntecedentsArea= new JTextArea();
    
    /*******************************End*********************************/
    
    /***Contructeur de notre classe derivee****/
    public Dialogue() {}

	public Dialogue(JFrame parent, String title,DefaultTableModel Patient) {
	
		/**Constructeur de la Jdialog**/
		super(parent,title);
		P=Patient;	
		/************************/
		PanelInfoPerso.setLayout(new FlowLayout(-1));
		PanneauRacine.setLayout(new BorderLayout());
		
		/***Configuration de la Jdialog Personnalise***/
		this.setVisible(true);
		this.setSize(720, 620);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.red);
		this.setResizable(false);
		
		/**Configuration des panneau**/
		PanelButton.setPreferredSize(new Dimension(720,50));
		
		/*************Bordure*****************/
		PanelInfoPerso.setBorder(BorderFactory.createTitledBorder("Informations Personnelles"));
		PanelInfoDossMedi.setBorder(BorderFactory.createTitledBorder("Informations Du Dossier Medical"));
		
		/************Coleur******************/
		PanelInfoPerso.setBackground(Color.white);
		PanelInfoDossMedi.setBackground(Color.white);
		
		/**************Taille****************/
		PanelInfoPerso.setPreferredSize(new Dimension(710, 150));
		PanelInfoDossMedi.setPreferredSize(new Dimension(710, 400));
		
		/******************************/
		PanneauRacine.setBackground(Color.yellow);
		
		/**************************************************/
		SexeArea.setBackground(Color.white);
		SexeArea.addItem("Masculin");
		SexeArea.addItem("Feninin");
		
		StatuArea.setBackground(Color.white);
		StatuArea.addItem("En Attente");
		StatuArea.addItem("Suivi");
		/*************************************************/
		/**Ajout des composants au panneau info perso**/
		PanelInfoPerso.add(Matricule);
		MatriculeArea.setBorder(BorderFactory.createTitledBorder("Matricule"));
		PanelInfoPerso.add(MatriculeArea);
		
		PanelInfoPerso.add(NoDoss);
		NoDossArea.setBorder(BorderFactory.createTitledBorder("NoDoss"));
		PanelInfoPerso.add(NoDossArea);
		
		PanelInfoPerso.add(Nom);
		NomArea.setBorder(BorderFactory.createTitledBorder("Noms"));
		PanelInfoPerso.add(NomArea);
		
		PanelInfoPerso.add(Prenoms);
		PrenomsArea.setBorder(BorderFactory.createTitledBorder("Prenoms"));
		PanelInfoPerso.add(PrenomsArea);
		
		PanelInfoPerso.add(Age);
		AgeArea.setBorder(BorderFactory.createTitledBorder("Age"));
		PanelInfoPerso.add(AgeArea);
		
		PanelInfoPerso.add(Sexe);
		SexeArea.setBorder(BorderFactory.createTitledBorder("Sexe"));
		PanelInfoPerso.add(SexeArea);
		
		PanelInfoPerso.add(Statu);
		StatuArea.setBorder(BorderFactory.createTitledBorder("Status"));
		PanelInfoPerso.add(StatuArea);
		
		/***********************************/
		/***Ajout des composants du panel dossier medcin****/
		AntecedentsArea.setPreferredSize(new Dimension(135,300));
		AntecedentsArea.setBorder(BorderFactory.createTitledBorder("Antecedents"));
		PanelInfoDossMedi.add(AntecedentsArea);
		
		ResponsablesArea.setPreferredSize(new Dimension(135,300));
		ResponsablesArea.setBorder(BorderFactory.createTitledBorder("Responsables"));
		PanelInfoDossMedi.add(ResponsablesArea);
		
		RecommandationsArea.setPreferredSize(new Dimension(135,300));
		RecommandationsArea.setBorder(BorderFactory.createTitledBorder("Recommandations"));
		PanelInfoDossMedi.add(RecommandationsArea);
		
		OrdonnanceArea.setPreferredSize(new Dimension(135,300));
		OrdonnanceArea.setBorder(BorderFactory.createTitledBorder("Ordonnance"));
		PanelInfoDossMedi.add(OrdonnanceArea);
		
		ResultatsArea.setPreferredSize(new Dimension(135,300));
		ResultatsArea.setBorder(BorderFactory.createTitledBorder("Resultats"));
		PanelInfoDossMedi.add(ResultatsArea);
		/***********************************/
		
		//////////////////Ajout des boutons au panel du bas pour valider ou ignorer les action///////////////
		PanelButton.setBackground(Color.orange);
		Abandonner.setPreferredSize(new Dimension(150,40));
		Valider.setPreferredSize(new Dimension(150,40));
		Modifier.setPreferredSize(new Dimension(150,40));
		PanelButton.add(Modifier);
		PanelButton.add(Abandonner);
		PanelButton.add(Valider);
		/////////////////////////////////////////////////
		/***Ajout au panel racine***/
		panelBaseInfo.add(PanelInfoPerso);
		panelBaseInfo.add(PanelInfoDossMedi);
		
		/**************************************/
		PanneauRacine.add(panelBaseInfo,BorderLayout.CENTER);
		PanneauRacine.add(PanelButton,BorderLayout.SOUTH);
		
		/**Ajout a la boite de dialogue**/
		this.getContentPane().add(PanneauRacine);
	}
	
   
	/***************Methode permettant de recuperer les information Saisies dans la Dialogue******************/
	            /*********************Nous en avons besoin***************************/
	public int getAge() {
		 int Age =Integer.parseInt(AgeArea.getText()); 
		 return Age;
	}
	public String getSexe() {
		return (String)SexeArea.getSelectedItem();
	}
	public String getMatricule() {
		return MatriculeArea.getText();
	}	
	public String getNoDoss() {
		return NoDossArea.getText();
	}
	public String getNom() {
		return NomArea.getText();
	}
	public String getPrenom() {
		return PrenomsArea.getText();
	}
	public String getStatus() {
		return (String)StatuArea.getSelectedItem();
	}
	
	public String getRecommandation() {
		return RecommandationsArea.getText();
	}
	public String getOrdonnance() {
		return OrdonnanceArea.getText();
	}
	public String getResponsatble() {
		return ResponsablesArea.getText();
	}
	public String getResultats() {
		return ResultatsArea.getText();
	}
	public String getAntecedents() {
		return AntecedentsArea.getText();
	}
	
	/***Methode permettant de definir les donnees***/
	public void setAge(int age) {
		 this.AgeArea.setText(""+age);
	}
	public void  setSexe(String Jbox_value) {
		SexeArea.setSelectedItem(Jbox_value);
	}
	public void  setMatricule(String Mat) {
		MatriculeArea.setText(Mat);
	}	
	public void  setNoDoss(String NoDos) {
		NoDossArea.setText(NoDos);
	}
	public void setNom(String nom) {
		NomArea.setText(nom);
	}
	public void  setPrenom(String prenom) {
		PrenomsArea.setText(prenom);
	}
	public void setStatus(String Jbox_Values) {
		StatuArea.setSelectedItem(Jbox_Values);
	}
	
	public void setRecommandation(String Reco) {
		RecommandationsArea.setText(Reco);
	}
	public void setOrdonnance(String Ordo) {
		OrdonnanceArea.setText(Ordo);
	}
	public void setResponsatble(String Resp) {
		ResponsablesArea.setText(Resp);
	}
	public void setResultats(String Result) {
		ResultatsArea.setText(Result);
	}
	public void setAntecedents(String Ante) {
		AntecedentsArea.setText(Ante);
	}
	
	public void setSpecialite(String Special) {
		SpecialiteArea.setText(Special);
	}
	public String getSpecialite() {
		return (String)SpecialiteArea.getText();
	}
	
}
