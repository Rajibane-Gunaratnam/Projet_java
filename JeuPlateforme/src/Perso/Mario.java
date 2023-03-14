package Perso;

import java.awt.Image;

import javax.swing.ImageIcon;

import Jeu.test;
import Objet.Objet;
import Objet.Piece;

public class Mario extends Personnage{
	
	
	private Image imgMario;
	private ImageIcon icoMario;
	private boolean saut;
	private int cptsaut;
	
	public Mario(int x, int y) {
		super(x, y, 28, 50);
		this.icoMario = new ImageIcon(getClass().getResource("/image/marioArretDroite.png"));
		this.imgMario = this.icoMario.getImage();
		this.saut = false;
		this.cptsaut = 0;
		// TODO Auto-generated constructor stub
	}

	public Image getImgMario() {
		return imgMario;
	}

	public boolean isSaut() {
		return saut;
	}

	public void setSaut(boolean saut) {
		this.saut = saut;
	}
	
	public Image sauter() {
		ImageIcon ico;
		Image img;
		String str;
		
		this.cptsaut ++;
		if(this.cptsaut <=35) {
			if(this.getY() > test.map.getPlaf()) {
				this.setY(this.getY()-4);
			}else {
				this.cptsaut = 36;
			}
			if(this.isVersladroite()==true) {
				str = "/image/marioSautDroite.png";
			}else {
				str = "/image/marioSautGauche.png";
			}
		}else if(this.getY() + this.getHauteur() < test.map.getSol()) {
			this.setY(this.getY() + 1);
			if(this.isVersladroite()==true) {
				str = "/image/marioSautDroite.png";
			}else {
				str = "/image/marioSautGauche.png";
			}
		}else {
			if(this.isVersladroite()==true) {
				str = "/image/marioArretDroite.png";
			}else {
				str = "/image/marioArretGauche.png";
			}
			this.saut = false;
			this.cptsaut = 0;
		}
		
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
	
	public void collision(Objet objet) {
		if((super.collisionDevant(objet) == true && this.isVersladroite() == true) || (super.collisionArriere(objet)== true && this.isVersladroite() == false)) {
			test.map.setDx(0);
			this.setMarche(false);
		}
		if(super.collisionBas(objet)==true && this.saut == true) {
			test.map.setSol(objet.getY());
		} else if(super.collisionBas(objet)==false){
			test.map.setSol(293);
			if(this.saut == false) {
				this.setY(243);
			}
		}
		if(super.collisionHaut(objet)==true) {
			test.map.setPlaf(objet.getY()+objet.getHauteur());
		}else if (super.collisionHaut(objet)==false && this.saut == false) {
			test.map.setPlaf(0);
		}
	}
	
	public boolean collisionPiece(Piece piece) {
		if(this.collisionArriere(piece) == true || this.collisionDevant(piece) == true || this.collisionBas(piece) == true || this.collisionHaut(piece) == true) {
			return true;
		}else {
			return false;
		}
	}
}
