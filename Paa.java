import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;

public class Paa extends Aani {
	
	public static void main(String[] args) {

		while(true) {
			
	    	int painallus = Button.waitForAnyPress();
	    	LCD.drawString("paina ylos",1, 1);
	    	LCD.drawString("Alas lopettaa", 1, 3);
	    	if (painallus == Button.ID_UP) {
	    	Sound.playSample(musiikki);
	    	}
	    	else if(painallus == Button.ID_DOWN) {
	    		
	    		break;
	    	}
		}
	}
}
