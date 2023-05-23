package Personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import objets.Objet;

public class Tortue extends Personnage implements Runnable{
//*************************DECLARATION DES VARIABLES*******************************************************************
		private Image imgTortue;
		private ImageIcon icoTortue;
		
		private final int PAUSE = 15;
		private int dxTortue;
		
		
//**************************CONSTRUCTEUR********************************************************************************
		
		public Tortue (int x, int y) {
			
			super(x, y, 43, 50) ;
			super.setVersDroite (true) ;
			super.setMarche(true);
			this.dxTortue = 1;
			
			this.icoTortue = new ImageIcon (getClass().getResource("/images/TortueArretGauche.png")) ;
			this.imgTortue = this.icoTortue.getImage();
			
			Thread chronoChamp = new Thread(this);
			chronoChamp.start();		
		}

		
//*************************GETTERS*************************************************************************************
		public Image getImgTortue() {return imgTortue;}
		
		
		
//*************************METHODES************************************************************************************

		
	    public void bouge(){ // D�placement du champignon
	    	if(super.isVersDroite() == true){this.dxTortue = 1;}
	    	else{this.dxTortue = -1;}
	        super.setX(super.getX() + this.dxTortue);	
	    }
	    
	    
		public void contact(Objet objet) {			
			if(super.contactAvant(objet) == true && this.isVersDroite() == true){					
	            super.setVersDroite(false);
		    	this.dxTortue = -1; 
		    }else if(super.contactArriere(objet) == true && this.isVersDroite() == false){
		    	super.setVersDroite(true);
		    	this.dxTortue = 1;     
		    }	
		}
		
		
		 public void contact(Personnage personnage) {		
			    if(super.contactAvant(personnage) == true && this.isVersDroite() == true){					
		            super.setVersDroite(false);
		    	    this.dxTortue = -1; 
		        }else if(super.contactArriere(personnage) == true && this.isVersDroite() == false){
		    	    super.setVersDroite(true);
		    	    this.dxTortue = 1;     
		        }	
		    }
		
		public void run() {
			try{Thread.sleep(20);} // on attend 20 ms avant d'appeler bouge pour que tous les objets soient compl�tement cr��s
			catch (InterruptedException e){}				
			while(true){ // boucle infinie		
				if(this.vivant == true) {
					 this.bouge();
					 try{Thread.sleep(PAUSE);}
					 catch (InterruptedException e){}
				}
			}	
			
		}
		
		
	    public Image meurt(){		
	    	String str;	
			ImageIcon ico;
			Image img;
			
			this.dxTortue = 0;
	        str = "/images/tortueFermee.png";	
	        ico = new ImageIcon(getClass().getResource(str));
	        img = ico.getImage();
			return img;
		}
		
}
