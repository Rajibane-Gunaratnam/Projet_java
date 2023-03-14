package Perso;

import java.awt.Image;

import javax.swing.ImageIcon;

import Jeu.test;
import Objet.Objet;

public class Personnage {
	private int largeur, hauteur;
	private int x, y;
	private boolean marche;
	private boolean versladroite;
	private int compteur;
	
	public Personnage(int x, int y, int largeur, int hauteur) {
		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.marche = false;
		this.compteur = 0;
		this.versladroite = true;
	}

	public int getLargeur() {return largeur;}
	
	public int getHauteur() {return hauteur;}
	
	public int getX() {return x;}
	
	public int getY() {return y;}
	
	public boolean isMarche() {return marche;}
	
	public boolean isVersladroite() {return versladroite;}
	
	public int getCompteur() {return compteur;}
	
	public void setLargeur(int largeur) {this.largeur = largeur;}

	public void setHauteur(int hauteur) {this.hauteur = hauteur;}

	public void setX(int x) {this.x = x;}

	public void setY(int y) {this.y = y;}

	public void setMarche(boolean marche) {this.marche = marche;}

	public void setVersladroite(boolean versladroite) {this.versladroite = versladroite;}

	public void setCompteur(int compteur) {this.compteur = compteur;}
	
	
	public Image marche(String nom, int frequence) {
		String str;
		ImageIcon ico;
		Image img;
		
		if (this.marche == false || test.map.getPos() <= 0 || test.map.getPos() > 4430 ) {
			if (this.versladroite == true) {
				str = "/image/" + nom + "ArretDroite.png";
			}else {
				str = "/image/" + nom + "ArretGauche.png";
			}
		}else {
			this.compteur++;
			if(this.compteur/frequence == 0) {
				if(this.versladroite == true) {
					str = "/image/" + nom + "ArretDroite.png";
				}else {
					str = "/image/" + nom + "ArretGauche.png";
				}
			}else {
				if(this.versladroite == true) {
					str = "/image/" + nom + "MarcheDroite.png";
				}else {
					str = "/image/" + nom + "MarcheGauche.png";
				}
			}	
			if (this.compteur == 2 * frequence) {
				this.compteur = 0;
			}
		}
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
	protected boolean collisionDevant(Objet objet) {
		if(this.x + this.largeur < objet.getX() || this.x + this.largeur > objet.getX() + 5 || this.y + this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur()) {
			return false;
		}else {
			return true;
		}
	}
	
	protected boolean collisionArriere(Objet objet) {
		if(this.x > objet.getX() + objet.getLargeur() || this.x + this.largeur < objet.getX()+ objet.getLargeur() - 5 || this.y + this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur()) {
			return false;
		}else {
			return true;
		}
	}
	
	protected boolean collisionBas(Objet objet) {
		if(this.x + this.largeur < objet.getX() + 5 || this.x > objet.getX()+ objet.getLargeur() - 5 || this.y  + this.hauteur < objet.getY() || this.y + this.hauteur > objet.getY() + 5) {
			return false;
		}else {
			return true;
		}
	}
	
	protected boolean collisionHaut(Objet objet) {
		if(this.x + this.largeur < objet.getX() + 5 || this.x > objet.getX() + objet.getLargeur() - 5 || this.y < objet.getY() + objet.getHauteur() || this.y > objet.getY() + objet.getHauteur() + 5) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean acote(Objet objet) {
		if(this.x > objet.getX() -10 && this.x < objet.getX() + objet.getLargeur() + 10 || (this.x + this.largeur > objet.getX() - 10 && this.x + this.largeur < objet.getX() + objet.getLargeur()+10)) {
			return true;
		}else {
			return false;
		}
	}
}
