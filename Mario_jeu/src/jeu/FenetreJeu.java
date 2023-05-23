//**************************Class FENETREJEU***************************************************************************
//	- Cette class va permettre de créer la fenetre qui va acceuillir le panel ou il y aura les niveaux.
//
//*********************************************************************************************************************
//**************************IMPORT*************************************************************************************
package jeu;
import javax.swing.JFrame;
//*********************************************************************************************************************
public class FenetreJeu extends JFrame {
//**************************DECLARATION DES VARIABLES******************************************************************	
	public static Niveau_1 niveau_1;
//**************************CONSTRUCTEUR*******************************************************************************
	public FenetreJeu () {
		super();
		this.setTitle("Mario : les aventures d'anojh et santha");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 360);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		
		//Instanciation de l'objet niveau_1
		niveau_1 = new Niveau_1();
		
		this.setContentPane(niveau_1);
		this.setVisible(true);
		
		
	}
}
