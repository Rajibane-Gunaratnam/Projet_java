//**************************Class MAIN********************************************************************************
//	- Cette class va permettre de créer la fenetre qui va acceuillir les panels qui seront le MenuPrincipale et le 
//		MenuNiveaux.
//
//*********************************************************************************************************************
//**************************IMPORT*************************************************************************************
package jeu;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//*********************************************************************************************************************
public class Main extends JFrame implements ActionListener {
//**************************DECLARATIONS DE VARIABLES******************************************************************
		private JPanel mainPanel;
	    private JPanel MenuPrincipal;
	    private JPanel MenuNiveau;
	    private JButton BoutonRetour;
	    private JButton BoutonJouer;
	    private JButton BoutonNiveau1;
	    public static FenetreJeu fenetrejeu;
//**************************CONSTRUCTEUR*******************************************************************************
	    public Main() {
	    	
	    	super();
	    	
	        // Création des panneaux et des boutons
	        mainPanel = new JPanel();
	        MenuPrincipal = new JPanel();
	        MenuNiveau = new JPanel();
	        
	        BoutonRetour = new JButton("retour");
	        BoutonJouer = new JButton("Jouer");
	        BoutonNiveau1 = new JButton("1");
	        
	        // Ajout des boutons aux panneaux et configuration des listeners
	        //MenuPrincipal.setLayout(new BorderLayout());
	        
	        BoutonJouer.setFont(new Font("Century", Font.BOLD, 26));
	        
	        MenuPrincipal.add(BoutonJouer);	  
	        BoutonJouer.addActionListener(this);
	        

	        MenuNiveau.add(BoutonRetour);
	        BoutonRetour.addActionListener(this);
	        MenuNiveau.add(BoutonNiveau1);
	        
	        
	        BoutonNiveau1.addActionListener(this);
	        
	        
	        // Configuration du panneau principal
	        mainPanel.setLayout(new CardLayout());
	        mainPanel.add(MenuPrincipal, "MenuPrincipal");
	        mainPanel.add(MenuNiveau, "MenuNiveau");

	        // Configuration de la fenêtre principale
	        setContentPane(mainPanel);
	        setTitle("Mario");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(700, 360);
	        setLocationRelativeTo(null);
	        setVisible(true);
	        
	    }
//**************************METHODES***********************************************************************************    
	    public void actionPerformed(ActionEvent e) {
	        // Si le bouton 1 est cliqué, activez le panneau 1
	        if (e.getSource() == BoutonRetour) {
	            CardLayout Card = (CardLayout) (mainPanel.getLayout());
	            Card.show(mainPanel, "MenuPrincipal");
	        }
	        // Si le bouton 2 est cliqué, activez le panneau 2
	        else if (e.getSource() == BoutonJouer) {
	            CardLayout Card = (CardLayout) (mainPanel.getLayout());
	            Card.show(mainPanel, "MenuNiveau");
	        }
	        
	        else if (e.getSource() == BoutonNiveau1) {
	        	fenetrejeu = new FenetreJeu();
	        	fenetrejeu.setVisible(true);
	        	dispose();
	        	
	        }
	    }
//**************************METHODE MAIN*******************************************************************************	    
	    public static void main(String[] args) {
	        // Création de l'instance de l'application
	        Main Jeu = new Main();
	    }
	    
}
