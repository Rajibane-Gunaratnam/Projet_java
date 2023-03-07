package Jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Touche implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(test.map.getPos() == -1) {
				test.map.setPos(0);
				test.map.setxFont1(-50);
				test.map.setxFond2(750);
			}
			test.map.setDx(1);
		}
		else if(e.getKeyCode()== KeyEvent.VK_LEFT) {
			test.map.setDx(-1);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {test.map.setDx(0);}
	

}
