package Jeu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Map extends JPanel {
	
	private ImageIcon icofond;
	private Image fond;
	private Image fond2;
	private ImageIcon icoPerso;
	private Image perso;
	private ImageIcon icoDepart;
	private Image depart;
	private ImageIcon icoKingdom;
	private Image kingdom;
	private int xFont1;
	private int dx;
	private int Pos;
	private int xFond2;
	
	
	public Map() {
		super();
		this.xFont1 = -50;
		this.xFond2 = 750;
		this.dx = 0;
		this.Pos = -1;
		icofond = new ImageIcon(getClass().getResource("/image/fondEcran.png"));
		icoPerso = new ImageIcon(getClass().getResource("/image/marioMarcheDroite.png"));
		icoDepart = new ImageIcon(getClass().getResource("/image/depart.png"));
		icoKingdom = new ImageIcon(getClass().getResource("/image/chateau1.png"));
		this.fond = this.icofond.getImage();
		this.fond2 = this.icofond.getImage();
		this.perso = this.icoPerso.getImage();
		this.depart = this.icoDepart.getImage();
		this.kingdom = this.icoKingdom.getImage();
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Touche());
		
		Thread temps = new Thread(new Chrono());
		temps.start();
	}
	public int getDx() {
		return dx;
	}
	
	public int getPos() {
		return Pos;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}
	
	public void setPos(int pos) {
		this.Pos = pos;
	}
		
	public void setxFont1(int xFont1) {
		this.xFont1 = xFont1;
	}
	
	public void setxFond2(int xFond2) {
		this.xFond2 = xFond2;
	}
	
	public void deplacementFond() {
		if(this.Pos >= 0) {
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
		this.deplacementFond();
		g1.drawImage(this.fond, this.xFont1, 0, null);
		g1.drawImage(this.fond2, this.xFond2, 0, null);
		g1.drawImage(this.perso, 300, 245, null);
		g1.drawImage(this.kingdom, 10 - this.Pos, 95, null);
		g1.drawImage(this.depart, 220 - this.Pos, 234, null);
	}
}
