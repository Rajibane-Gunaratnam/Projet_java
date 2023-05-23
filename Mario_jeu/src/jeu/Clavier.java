//**************************Class CLAVIER******************************************************************************
//	- Cette class va permettre de créer le KeyListerner qui va permettre de déplacer le joueur(Mario) dans la plate -
//		forme des niveaux
//
//*********************************************************************************************************************
//**************************IMPORT*************************************************************************************
package jeu;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//*********************************************************************************************************************
public class Clavier implements KeyListener{
//**************************METHODES***********************************************************************************
	// keyPressed = lorsque l'on presse un bouton
	public void keyPressed(KeyEvent e) {
		
		if(FenetreJeu.niveau_1.mario.isVivant() == true) {
			
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				
				if(FenetreJeu.niveau_1.getxPos() == -1) {
					FenetreJeu.niveau_1.setxPos(0);
					FenetreJeu.niveau_1.setxFond1(-50);
					FenetreJeu.niveau_1.setxFond2(750);
				}
				FenetreJeu.niveau_1.mario.setMarche(true);
				FenetreJeu.niveau_1.mario.setVersDroite(true);
				
				FenetreJeu.niveau_1.setDx(1);
				} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					
					if(FenetreJeu.niveau_1.getxPos() == 4431) {
						FenetreJeu.niveau_1.setxPos(4430);
						FenetreJeu.niveau_1.setxFond1(-50);
						FenetreJeu.niveau_1.setxFond2(750);
					}
					
					
						
					FenetreJeu.niveau_1.mario.setMarche(true);
					FenetreJeu.niveau_1.mario.setVersDroite(false);
					FenetreJeu.niveau_1.setDx(-1);
				}
				
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					FenetreJeu.niveau_1.mario.setSaut(true);
				}
			
		}
		
	}
	// keyReleased = lorsque l'on relache un bouton
	public void keyReleased(KeyEvent e) {
		FenetreJeu.niveau_1.setDx(0);
		FenetreJeu.niveau_1.mario.setMarche(false);
		}
	
	public void keyTyped(KeyEvent e) {}

}
