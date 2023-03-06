package Jeu;

public class Chrono implements Runnable{
	
	private final int pause = 3;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			test.map.repaint();
			try {
				Thread.sleep(pause);
			} catch (InterruptedException e) {}
		}
	}
	
}
