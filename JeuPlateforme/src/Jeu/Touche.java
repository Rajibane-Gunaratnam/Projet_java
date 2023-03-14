package Jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Touche implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(test.map.getPos() == -1) {
				test.map.setPos(0);
				test.map.setxFont1(-50);
				test.map.setxFond2(750);
			}
			test.map.mario.setMarche(true);
			test.map.mario.setVersladroite(true);
			test.map.setDx(1);
		}
		else if(e.getKeyCode()== KeyEvent.VK_LEFT) {
			if(test.map.getPos() == 4431) {
				test.map.setPos(4430);
				test.map.setxFont1(-50);
				test.map.setxFond2(750);
			}
			test.map.mario.setMarche(true);
			test.map.mario.setVersladroite(false);
			test.map.setDx(-1);
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			test.map.mario.setSaut(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		test.map.mario.setMarche(false);
		test.map.setDx(0);
	}
	

	@Override
	public void keyTyped(KeyEvent e) {}

}
