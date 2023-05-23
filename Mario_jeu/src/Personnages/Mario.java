package Personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import jeu.FenetreJeu;
import objets.Objet;
import objets.Piece;

public class Mario extends Personnage {
//*************************DECLARATION DES VARIABLES*******************************************************************
	private Image imgMario;
	private ImageIcon icoMario;
	private boolean saut;	//vrai si mario saute
	private int compteurSaut;	//gérer la durée et hauteur du saut 
	private int compteurMort;

//**************************CONSTRUCTEUR********************************************************************************	
	public Mario(int x, int y) {
		
		super(x, y, 28, 50);
		this.icoMario = new ImageIcon(getClass().getResource("/images/marioArretDroite.png"));
		this.imgMario = this.icoMario.getImage();
		
		this.saut = false;
		this.compteurSaut = 0;
		this.compteurMort = 0;
	}

//**************************GETTERS*************************************************************************************
	
	public boolean isSaut() {return saut;}

	public Image getImgMario() {return imgMario;}
//*************************SETTERS*************************************************************************************	
	
	public void setSaut(boolean saut) {this.saut = saut;}
//*************************METHODES************************************************************************************	
	
	@Override
	public Image marche(String nom, int frequence) {
		String str;	
		ImageIcon ico;
		Image img;
			
		if (this.marche == false || FenetreJeu.niveau_1.getxPos() <= 0 || FenetreJeu.niveau_1.getxPos() > 4430) {
			if(this.versDroite == true){str = "/images/" + nom + "ArretDroite.png";}
			else{str = "/images/" + nom + "ArretGauche.png";}				
		}else{
		    this.compteur++;
		    if (this.compteur / frequence == 0) { // quotient de la division euclidienne de compteur par frequence
		    	if(this.versDroite == true){str = "/images/" + nom + "ArretDroite.png";}
		    	else{str = "/images/" + nom + "ArretGauche.png";}					
		    }else{
		    	if(this.versDroite == true){str = "/images/" + nom + "MarcheDroite.png";}
		    	else{str = "/images/" + nom + "MarcheGauche.png";}	
		    }		    
		    if (this.compteur == 2 * frequence) {this.compteur = 0;}
		}
		// Affichage de l'image du personnage
        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
		return img;
	}
	
	
	public Image saute() {
		
		ImageIcon ico;
		Image img;
		String str;
		
		this.compteurSaut ++;
		// Montée du Saut
		if(this.compteurSaut <= 40) {
			if(this.getY() > FenetreJeu.niveau_1.getHauteurPlafond()) {this.setY(this.getY() - 4);}
			else {this.compteurSaut = 41;}
			if(this.isVersDroite() ==  true) {str = "/images/marioSautDroite.png";}
			else {str = "/images/marioSautGauche.png";}
		
		//Retombée du saut	
		} else if (this.getY() + this.getHauteur() < FenetreJeu.niveau_1.getySol()) {this.setY(this.getY() + 1);
			if (this.isVersDroite() == true) {str = "/images/marioSautDroite.png";}
			else {str = "/images/marioSautGauche.png";}
		
		//Saut terminé	
		} else {
			if(this.isVersDroite() == true) {str = "/images/marioArretDroite.png";}
			else {str = "/images/marioArretGauche.png";}
			this.saut= false;
			this.compteurSaut = 0;
		}
		
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
	
	public void contact(Objet objet) {		
		if((super.contactAvant(objet) == true && this.isVersDroite() == true) || (super.contactArriere(objet) == true && this.isVersDroite() == false)){
			FenetreJeu.niveau_1.setDx(0);
		    this.setMarche(false);
		}
        if(super.contactDessous(objet) == true && this.saut == true){
        	FenetreJeu.niveau_1.setySol(objet.getY());			
		}else if(super.contactDessous(objet) == false){
			FenetreJeu.niveau_1.setySol(293); // altitude du sol initial
			if(this.saut == false){this.setY(243);}
		}
        if(super.contactDessus(objet) == true){
			FenetreJeu.niveau_1.setHauteurPlafond(objet.getY() + objet.getHauteur()); // le plafond devient le dessous de l'objet
		}else if(super.contactDessus(objet) == false && this.saut == false){
			FenetreJeu.niveau_1.setHauteurPlafond(0);
		}      
	}
	
	public boolean contactPiece(Piece piece){		
		if(this.contactArriere(piece) == true || this.contactAvant(piece) == true || this.contactDessous(piece) == true || this.contactDessus(piece) == true){
			return true;			
		}else{return false;}
	}
	
	
    public void contact(Personnage personnage) {		
		if((super.contactAvant(personnage) == true) || (super.contactArriere(personnage) == true)){
			this.setMarche(false);
		    this.setVivant(false);
		}else if(super.contactDessous(personnage) == true){
			personnage.setMarche(false);
			personnage.setVivant(false);
		}
    }		
	
	
	public Image meurt(){		
		String str;
    	ImageIcon ico;
		Image img;	
		
        str = "/images/boom - Copie.png";
        this.compteurMort++; 
        if(this.compteurMort > 100){
        	str = "/images/marioMeurt - Copie.png";
        	this.setY(this.getY() - 1);
        }
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img; 
	} 
    
    
    
}
