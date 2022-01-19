package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Extern.ButtonEditPerso;
import Extern.ButtonRenderer;
import Model.connection;

public class Panneau extends JPanel {
	
	DefaultTableModel P;
	/*********************************************/
	JButton Retour=new JButton("Retour");
	JButton Ajouter=new JButton("Ajouter");
	JButton Modifier=new JButton("Modifier");
	JButton Supprimer=new JButton("Supprimer");
	
	JPanel PanneauBouton=new JPanel();
	
	/*Tableau a double entree pour definir nos donnees*/
	Object[][] data= {};
    /***Entete du tableau dans la 	GUI***/
	String title[] = {"MatriculeMed","Matricule", "Nom", "Prenom","Age","Specialite","Actions"};
	
	/*****Le model de tableau et le tableau sur lequel on vas inserer et mettre a jour nos donnes***/
	DefaultTableModel tableau = new DefaultTableModel(data,title);
	JTable TableDonnees=new JTable(tableau);
	
	/************************************************************************************************/
	public Panneau(DefaultTableModel Patient) {
		this.P=Patient;
	}
	
	ButtonEditPerso ButtEdit;
	
	public Panneau() {
		/*****Reglage du tableau pour permettre qu'il affiche les boutons***/
		ButtEdit=new ButtonEditPerso(new JCheckBox(), tableau);
		this.TableDonnees.getColumn("Actions").setCellRenderer(new ButtonRenderer());
		this.TableDonnees.getColumn("Actions").setCellEditor(ButtEdit);
		
		/*******************************************************************/
		PanneauBouton.setBackground(Color.yellow);
		this.setLayout(new BorderLayout(10,0));
		TableDonnees.setRowHeight(20);
		
		/*******Ajout d'un ecouteur et de l'action a executé si y'a interaction*/
		Ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DialogueAddMedecin Da=new DialogueAddMedecin(null, "Ajouter Un Patient",tableau);
			}
		});	
		
		/*****Ajout des boutons aux panel bouton*****/
		PanneauBouton.add(Ajouter);
	    /**********Ajout du panel bouton et de la table au panel main************/
		add(PanneauBouton,BorderLayout.NORTH);
		add(new JScrollPane(TableDonnees),BorderLayout.CENTER);
		
	}
}
