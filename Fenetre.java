package Vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import Extern.DataManager;
import Model.connection;

public class Fenetre extends JFrame{
    
	PanneauPatient panelPatient=new PanneauPatient();
	PanneauPersonnels panelPersonnels=new PanneauPersonnels();
	EnAttente panneauattente=new EnAttente();
	
	
	CardLayout cl = new CardLayout();
	JPanel content = new JPanel();

	
	/**********************Appel du controleur***************************/
	//ControlleurBouton Controleur=new ControlleurBouton(A, p, Per);
	/**Panel du menu principale et panneau des boutons**/
	JPanel MenuPrincipal = new JPanel();
	JPanel PanneauDuMenu=new JPanel();
    /*End*/
	
	/****Les boutons du menu*****/
	JButton Patient=new JButton("Patients");
	JButton Personnels=new JButton("Personnels");
	JButton EnAttente=new JButton("En Attente");
	JButton MesPatients=new JButton("Mes Patients");
	JButton Historigue=new JButton("Historique");
	JButton Transferer=new JButton("Transferer");
	JButton Aide=new JButton("Aide");
	JButton Apropos=new JButton("Apropos");
	JButton Fermer=new JButton("Fermer");
	JButton UserName=new JButton();
	
	/**Text du menu**/
	JLabel TextMenu=new JLabel("Menu Principal");
	
	/**La barre de menu et ses composants**/
	JMenuBar menuBar = new JMenuBar();
	private JMenu test1 = new JMenu("Fichier");
	private JMenu test2 = new JMenu("Edition");
	
	Acceuil panelAcceuil=new Acceuil(PanneauDuMenu);
	PanelMesPatients myPatient=new PanelMesPatients();
	
	public Fenetre(){myPatient.SetMat(panelAcceuil.GetMat());
        /*******************************/
		Font Fof=new Font("verdana", Font.BOLD, 20);//Police 
		/**Proprietees de la fenetre**/
		this.setLayout(new BorderLayout());
		this.setTitle("Gestion d'hopital");
		this.setSize(getWidth(), getHeight());
		this.setVisible(true);
		this.setMinimumSize(new Dimension(800,620));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		/**/
		TextMenu.setFont(Fof);
		/**Ajout Des Elements A la barre de Menu**/
		menuBar.add(test1);
		menuBar.add(test2);
		
		/**Couleur du menu**/
		menuBar.setBackground(Color.white);
		
		/**Ajout A la fenetre**/
		this.setJMenuBar(menuBar);
		
		/**Type de gestionnaire**/
		MenuPrincipal.setLayout(new BorderLayout());
		
		/***Definition de la taille des boutons pour qu'ils s'ajustent bien dans le panneau***/
		Patient.setPreferredSize(new Dimension(195,70));
		Personnels.setPreferredSize(new Dimension(195,70));
		EnAttente.setPreferredSize(new Dimension(195,70));
		MesPatients.setPreferredSize(new Dimension(195,70));
		//Historigue.setPreferredSize(new Dimension(195,70));
		Transferer.setPreferredSize(new Dimension(195,70));
		Aide.setPreferredSize(new Dimension(195,70));
		Apropos.setPreferredSize(new Dimension(195,70));
		Fermer.setPreferredSize(new Dimension(195,70));
		/********couleur des boutons*******/
		Patient.setBackground(Color.white);
		Personnels.setBackground(Color.white);
		EnAttente.setBackground(Color.white);
		MesPatients.setBackground(Color.white);
	//	Historigue.setBackground(Color.white);
		Transferer.setBackground(Color.white);
		Aide.setBackground(Color.white);
		Apropos.setBackground(Color.white);
		Fermer.setBackground(Color.white);
		/***Ajout des boutons au panneau des boutons**/
		PanneauDuMenu.add(TextMenu);
		PanneauDuMenu.add(Patient);
		PanneauDuMenu.add(Personnels);
		PanneauDuMenu.add(EnAttente);
		PanneauDuMenu.add(MesPatients);
	//	PanneauDuMenu.add(Historigue);
		PanneauDuMenu.add(Aide);
		PanneauDuMenu.add(Apropos);
		PanneauDuMenu.add(Fermer);
		
		/**********************************************************************************/
		
		
		
		/***Ajout du panneau de bouton au panneau principal pour une bonne mise en forme***/
		MenuPrincipal.add(PanneauDuMenu,BorderLayout.CENTER);
		
		/**Taille du panneu du menu principal**/
		MenuPrincipal.setPreferredSize(new Dimension(200,200));
		
		/**Ajout de l'ensemble a la fenetre**/
		//getContentPane().add(A,BorderLayout.CENTER);
		//getContentPane().add(p,BorderLayout.CENTER);
		content.add(panelAcceuil);
		content.add(panelPatient);
		content.add(panelPersonnels);
		content.add(panneauattente);
		content.add(myPatient);
		
        content.setLayout(cl);
        getContentPane().add(content, BorderLayout.CENTER);
		getContentPane().add(MenuPrincipal,BorderLayout.WEST);
		
		/***Ajout des ecouteurs pour declancher les evenements lors du clic sur un bouton****/
		Patient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelAcceuil.setVisible(false); 
				panelPatient.setVisible(true);
				panelPersonnels.setVisible(false);
				panneauattente.setVisible(false);
				myPatient.setVisible(false);
				
				Patient.setBackground(Color.orange);
				Personnels.setBackground(Color.white);
				EnAttente.setBackground(Color.white);
				MesPatients.setBackground(Color.white);
			}
		});
		
		Personnels.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelAcceuil.setVisible(false); 
				panelPatient.setVisible(false);
				panelPersonnels.setVisible(true);	
				panneauattente.setVisible(false);
				myPatient.setVisible(false);
				
				Patient.setBackground(Color.white);
				Personnels.setBackground(Color.orange);
				EnAttente.setBackground(Color.white);
				MesPatients.setBackground(Color.white);
			}
		});
		EnAttente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelPatient.setVisible(false);
				panelAcceuil.setVisible(false); 
				panelPersonnels.setVisible(false);	
				panneauattente.setVisible(true);
				myPatient.setVisible(false);
				
				Patient.setBackground(Color.white);
				Personnels.setBackground(Color.white);
				EnAttente.setBackground(Color.orange);
				MesPatients.setBackground(Color.white);
			}
		});
		
		MesPatients.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				panelPatient.setVisible(false);
				panelAcceuil.setVisible(false); 
				panelPersonnels.setVisible(false);	
				panneauattente.setVisible(false);
				myPatient.setVisible(true);
				
				Patient.setBackground(Color.white);
				Personnels.setBackground(Color.white);
				EnAttente.setBackground(Color.white);
				MesPatients.setBackground(Color.orange);
			}
		});
	 
		
		/*** Fermer le logiciel ****/
		Fermer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

	}



}
