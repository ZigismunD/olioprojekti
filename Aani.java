package olioprojekti;

import java.io.File;



import lejos.hardware.Sound;
/**
 * Aani class allows the program to play sounds.
 * Aani runs in a thread so program can still take commands from remote control.
 * @author Erik Huitti ja Sami Sikkilä
 *
 */
public class Aani extends Thread {
	private boolean running = true;
	private int efekti;
	
	private File musiikki = new File("polkka2.wav");
	private File auto = new File("autostart.wav");
	/**
	 * Consturctor for the class Aani.
	 * Sets variable efekti to 0.
	 */
	public Aani() {
		this.efekti = 0;
	}

	/**
	 * Checks the variable efekti.
	 * if efekti is something else than 0, plays the sound with that number.
	 */
	public void run() {
		while (running) {
			switch (efekti) {
			case 1:
				kaynnista();
				this.efekti = 0;
				break;
			case 2:
				kappale();
				this.efekti = 0;
				break;
			}
		}
	}
	/**
	 * Alters the state of boolean 'running' to false.
	 */
	public void running() {
		this.running = false;
	}
	/**
	 * Plays the sound of car starting.
	 */
	public void kaynnista() {
		Sound.playSample(auto);
	}
	/**
	 * Plays a short version of the song Ievan Polkka.
	 */
	public void kappale() {
		Sound.playSample(musiikki);
	}
	/**
	 * Alters the variable efekti to allow sounds to be played.
	 * @param aani The number of the desired sound effect.
	 */
	public void efekti(int aani) {
		this.efekti = aani;
	}
}
