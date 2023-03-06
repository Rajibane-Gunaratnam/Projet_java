package Jeu;

import javax.swing.JFrame;

public class test {

	public static Map map;

	public static void main(String[] args) {
		
		
		JFrame fenetre = new JFrame("TesT MARIO");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(700,360);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);
		
		map = new Map();
		
		fenetre.setContentPane(map);
		fenetre.setVisible(true);
	}

}
