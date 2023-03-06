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
			test.map.setDx(1);
		}
		else if(e.getKeyCode()== KeyEvent.VK_LEFT) {
			test.map.setDx(-1);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {test.map.setDx(0);}
	

}
