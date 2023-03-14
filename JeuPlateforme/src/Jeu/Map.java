package Jeu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Objet.*;
import Perso.*;

@SuppressWarnings("serial")
public class Map extends JPanel {
	
	private ImageIcon icofond;
	private Image fond;
	private Image fond2;
	private ImageIcon icoDepart;
	private Image depart;
	private ImageIcon icoKingdom;
	private Image kingdom;
	
	private int xFont1;
	private int dx;
	private int Pos;
	private int Sol;
	private int plaf;
	private int xFond2;
	
	public Mario mario;
	
	public Piece piece1;
	public Piece piece2;
	public Piece piece3;
	public Piece piece4;
	public Piece piece5;
	public Piece piece6;
	public Piece piece7;
	public Piece piece8;
	public Piece piece9;
	public Piece piece10;
	
	public TuyauR tuyau1;
	public TuyauR tuyau2;
	public TuyauR tuyau3;
	public TuyauR tuyau4;
	public TuyauR tuyau5;
	public TuyauR tuyau6;
	public TuyauR tuyau7;
	public TuyauR tuyau8;
	public Bloc bloc1;
	public Bloc bloc2;
	public Bloc bloc3;
	public Bloc bloc4;
	public Bloc bloc5;
	public Bloc bloc6;
	public Bloc bloc7;
	public Bloc bloc8;
	public Bloc bloc9;
	public Bloc bloc10;
	public Bloc bloc11;
	public Bloc bloc12;
	
	public ImageIcon icodrap;
	public Image drap;
	public ImageIcon icoChateauFin;
	public Image ChateauFin;
	
	private ArrayList<Objet> tabObjets;
	private ArrayList<Piece> tabPieces;
	
	public Map() {
		super();
		this.xFont1 = -50;
		this.xFond2 = 750;
		this.dx = 0;
		this.Pos = -1;
		this.Sol = 293;
		this.plaf = 0;
		
		icofond = new ImageIcon(getClass().getResource("/image/fondEcran.png"));
		icoDepart = new ImageIcon(getClass().getResource("/image/depart.png"));
		icoKingdom = new ImageIcon(getClass().getResource("/image/chateau1.png"));
		icoChateauFin = new ImageIcon(getClass().getResource("/image/chateauFin.png"));
		icodrap = new ImageIcon(getClass().getResource("/image/drapeau.png"));
		this.fond = this.icofond.getImage();
		this.fond2 = this.icofond.getImage();
		this.depart = this.icoDepart.getImage();
		this.kingdom = this.icoKingdom.getImage();
		this.ChateauFin = icoChateauFin.getImage();
		this.drap  = this.icodrap.getImage();
		
		
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Touche());
		
		mario = new Mario(300,245);
		
		piece1 = new Piece(402, 145);
		piece2 = new Piece(1202, 140);
		piece3 = new Piece(1272, 95);
		piece4 = new Piece(1342, 40);
		piece5 = new Piece(1650, 145);
		piece6 = new Piece(2650, 145);
		piece7 = new Piece(3000, 135);
		piece8 = new Piece(3400, 125);
		piece9 = new Piece(4200, 145);
		piece10 = new Piece(4600, 40);
		
		tuyau1 = new TuyauR(600, 230);
		tuyau2 = new TuyauR(1000, 230);
		tuyau3 = new TuyauR(1600, 230);
		tuyau4 = new TuyauR(1900, 230);
		tuyau5 = new TuyauR(2500, 230);
		tuyau6 = new TuyauR(3000, 230);
		tuyau7 = new TuyauR(3500, 230);
		tuyau8 = new TuyauR(4500, 230);
		
		bloc1 = new Bloc(400, 180);
		bloc2 = new Bloc(1200, 180);
		bloc3 = new Bloc(1270, 170);
		bloc4 = new Bloc(1340, 160);
		bloc5 = new Bloc(2000, 180);
		bloc6 = new Bloc(2600, 160);
		bloc7 = new Bloc(2650, 180);
		bloc8 = new Bloc(3500, 160);
		bloc9 = new Bloc(3550, 140);
		bloc10 = new Bloc(4000, 170);
		bloc11 = new Bloc(4200, 200);
		bloc12 = new Bloc(4300, 210);
		
		tabObjets = new ArrayList<Objet>();
		this.tabObjets.add(this.tuyau1);
		this.tabObjets.add(this.tuyau2);
		this.tabObjets.add(this.tuyau3);
		this.tabObjets.add(this.tuyau4);
		this.tabObjets.add(this.tuyau5);
		this.tabObjets.add(this.tuyau6);
		this.tabObjets.add(this.tuyau7);
		this.tabObjets.add(this.tuyau8);
		
		this.tabObjets.add(this.bloc1);
		this.tabObjets.add(this.bloc2);
		this.tabObjets.add(this.bloc3);
		this.tabObjets.add(this.bloc4);
		this.tabObjets.add(this.bloc5);
		this.tabObjets.add(this.bloc6);
		this.tabObjets.add(this.bloc7);
		this.tabObjets.add(this.bloc8);
		this.tabObjets.add(this.bloc9);
		this.tabObjets.add(this.bloc10);
		this.tabObjets.add(this.bloc11);
		this.tabObjets.add(this.bloc12);
		
		tabPieces = new ArrayList<Piece>();
		this.tabPieces.add(this.piece1);
		this.tabPieces.add(this.piece2);
		this.tabPieces.add(this.piece3);
		this.tabPieces.add(this.piece4);
		this.tabPieces.add(this.piece5);
		this.tabPieces.add(this.piece6);
		this.tabPieces.add(this.piece7);
		this.tabPieces.add(this.piece8);
		this.tabPieces.add(this.piece9);
		this.tabPieces.add(this.piece10);
		
		Thread temps = new Thread(new Chrono());
		temps.start();
	}
	public int getDx() {
		return dx;
	}
	
	public int getPos() {
		return Pos;
	}
	
	public int getSol() {
		return Sol;
	}
	
	public int getPlaf() {
		return plaf;
	}
	public void setDx(int dx) {
		this.dx = dx;
	}
	
	public void setPos(int pos) {
		this.Pos = pos;
	}
	
	public void setSol(int sol) {
		Sol = sol;
	}
	
	public void setPlaf(int plaf) {
		this.plaf = plaf;
	}
	
	public void setxFont1(int xFont1) {
		this.xFont1 = xFont1;
	}
	
	public void setxFond2(int xFond2) {
		this.xFond2 = xFond2;
	}
	
	
	public void deplacementFond() {
		if(this.Pos >= 0 && this.Pos <= 4430) {
			this.Pos = this.Pos + this.dx;
			this.xFont1 = this.xFont1 - this.dx;
			this.xFond2 = this.xFond2 - this.dx;
		}
		if(this.xFont1 == -800) {
			this.xFont1 = 800;
		}
		else if(this.xFond2 == -800) {
			this.xFond2 = 800;
		}
		else if(this.xFont1 == 800) {
			this.xFont1 = -800;
		}
		else if(this.xFond2 == 800) {
			this.xFond2 = -800;
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics g1 = (Graphics2D) g;
		
		for(int i =0; i < this.tabObjets.size(); i++) {
			if (this.mario.acote(this.tabObjets.get(i))) {
				this.mario.collision(this.tabObjets.get(i));
			}
		}
		for(int i =0; i < this.tabPieces.size(); i++) {
			if (this.mario.acote(this.tabPieces.get(i))) {
				if(this.mario.collisionPiece(this.tabPieces.get(i))){
					this.tabPieces.remove(i);
				}
			}
		}
		this.deplacementFond();
		
		if (this.Pos >= 0 && this.Pos <=4430) {
			for(int i =0; i < this.tabObjets.size(); i++) {
				this.tabObjets.get(i).deplacement();
			}
			for(int i =0; i < this.tabPieces.size(); i++) {
				this.tabPieces.get(i).deplacement();
			}
		}
		
		g1.drawImage(this.fond, this.xFont1, 0, null);
		g1.drawImage(this.fond2, this.xFond2, 0, null);
		g1.drawImage(this.kingdom, 10 - this.Pos, 95, null);
		g1.drawImage(this.depart, 220 - this.Pos, 234, null);
		
		for (int i = 0; i < this.tabObjets.size(); i++) {
			g1.drawImage(this.tabObjets.get(i).getImgObjet(), this.tabObjets.get(i).getX(), this.tabObjets.get(i).getY(), null);
		}
		for (int i = 0; i < this.tabPieces.size(); i++) {
			g1.drawImage(this.tabPieces.get(i).bouge(), this.tabPieces.get(i).getX(), this.tabPieces.get(i).getY(), null);
		}
		
		g1.drawImage(drap, 4650 - this.Pos, 115, null);
		g1.drawImage(ChateauFin, 5000 - this.Pos, 145, null);
		
		if(this.mario.isSaut()) {
			g1.drawImage(this.mario.sauter(), this.mario.getX(), this.mario.getY(),null);
		}else {
			g1.drawImage(this.mario.marche("mario", 30), this.mario.getX(), this.mario.getY(), null);
		}
	}
}
