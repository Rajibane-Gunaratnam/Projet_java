package Objet;

import javax.swing.ImageIcon;

public class TuyauR extends Objet{
	
	public TuyauR(int x, int y) {
		super(x, y, 43, 65);
		super.icoObjet = new ImageIcon(getClass().getResource("/image/tuyauRouge.png"));
		super.imgObjet = this.icoObjet.getImage();
	}

	
	
}
