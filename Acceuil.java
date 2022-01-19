package Vue;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Extern.DataManager;
import Model.connection;

public class Acceuil extends JPanel {
	
	private String UserNameSession;
	private String Mat;
	//connection avec laa bd
	Connection myconnect=connection.getConection();
	
	JPanel panelHaut=new JPanel();//Pour le panneau de base de Welcome
	JPanel panelCenter=new JPanel();//Pour le panneau du centre qui vas conternir les elements du formulaire de connection
	JButton LabelText=new JButton("Welcome !!!");//le text welcome
	JButton Connecter=new JButton("Se connecter");
	/*Panneau a activer et desactivee*/
	JPanel Main,Second;
	
	
	public Acceuil(JPanel p) {
		 Main=p;
		this.setLayout(new BorderLayout());
		this.setBackground(Color.yellow);
		
		/*Zone de Welcome */
		Font f=new Font("verdana", Font.BOLD, 50);
		LabelText.setBackground(Color.white);
		LabelText.setFont(f);
		LabelText.setEnabled(false);
		
		panelHaut.setBackground(Color.white);
		panelHaut.setLayout(new BorderLayout());
		panelHaut.add(LabelText,BorderLayout.CENTER);
		panelHaut.setPreferredSize(new Dimension(panelHaut.getWidth(),180));
		/*Fin ici*/
		
		/**/
		panelCenter.setBackground(Color.yellow);
		panelCenter.setLayout(new BorderLayout());
		panelCenter.setPreferredSize(new Dimension(50, 50));
		
		/***Style et grosseur du texte***/
		Font Fof=new Font("verdana", Font.ITALIC, 20);
		
		
		/*Bouton de connection */
		Connecter.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				connecter();
			}
		});
		
		/*Config du bouton*/
        Connecter.setPreferredSize(new Dimension(150,50));
        Connecter.setBackground(Color.white);
        Connecter.setFont(Fof);
        /**************/
		add(Connecter,BorderLayout.SOUTH);
		add(panelHaut,BorderLayout.NORTH);
		
		Main.setVisible(false);
	}
	
	
	public void connecter() {
		
		//Boites de dialogue pour le Mots de passe et le matricule
		JOptionPane opMatricule=new JOptionPane();
		JOptionPane opMdp=new JOptionPane();
		
		/*Matricule */
		String Matricule=opMatricule.showInputDialog(null, "Matricule !","Connexion",JOptionPane.QUESTION_MESSAGE);
		setVisible(true);
		
		/*Mot de passe*/
		String mdp=opMdp.showInputDialog(null, "Mot de passe!","Connexion",JOptionPane.QUESTION_MESSAGE);
		Mat=Matricule;
		setVisible(true);
		
		/**recherche ds la bd**/
		String Query="SELECT Nom FROM medecin";
				Query+=" WHERE MatriculeMed='"+Matricule;
				Query+="' AND mdp='"+mdp+"'";		
		try {
		  Statement pStm=myconnect.createStatement();
		  ResultSet result= pStm.executeQuery(Query);
		/*Start*/
		 while(result.next()) {
			 System.out.println("Bienvenu "+result.getString("Nom"));
			 UserNameSession=result.getString("Nom");
			 Main.setVisible(true);
			 opMatricule.showMessageDialog(null,"Welcome "+UserNameSession,"Confirmation",JOptionPane.INFORMATION_MESSAGE);
			 DataManager dm=new DataManager();
			 dm.writeData(Matricule);
			// System.out.println(""+val);
			 break;
		}
		/**end**/ 
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public String GetUserSeesionName() {
		return this.UserNameSession;
	}
	public String GetMat() {
		return this.Mat;
	}

}
