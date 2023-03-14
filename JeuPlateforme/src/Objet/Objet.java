package Objet;

import java.awt.Image;

import javax.swing.ImageIcon;

import Jeu.test;

public class Objet {
	private int largeur, hauteur;
	private int x, y;
	protected ImageIcon icoObjet;
	protected Image imgObjet;
	
	public Objet(int x, int y, int largeur, int hauteur) {
		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public int getX() {
		return x;
	}
	
	public Image getImgObjet() {
		return imgObjet;
	}

	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	
	public void deplacement() {
		if (test.map.getPos() >= 0) {
			this.x = this.x - test.map.getDx();
		}
	}
}
