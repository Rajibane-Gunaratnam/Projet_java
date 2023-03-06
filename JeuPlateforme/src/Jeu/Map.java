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
	private ImageIcon icoPerso;
	private Image perso;
	private int xFont1;
	private int dx;
	
	public Map() {
		super();
		this.xFont1 = -50;
		this.dx = 0;
		icofond = new ImageIcon(getClass().getResource("/image/fondEcran.png"));
		icoPerso = new ImageIcon(getClass().getResource("/image/marioMarcheDroite.png"));
		this.fond = this.icofond.getImage();
		this.perso = this.icoPerso.getImage();
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Touche());
		
		Thread temps = new Thread(new Chrono());
		temps.start();
	}
	public int getDx() {
		return dx;
	}
	
	public void setDx(int dx) {
		this.dx = dx;
	}
	
	public void deplacementFond() {
		this.xFont1 = this.xFont1 - this.dx;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics g1 = (Graphics2D) g;
		this.deplacementFond();
		g1.drawImage(this.fond, this.xFont1, 0, null);
		g1.drawImage(this.perso, 300, 245, null);
		
	}
}
