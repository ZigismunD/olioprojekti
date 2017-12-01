package olioprojekti;

import java.io.File;

import lejos.hardware.Sound;

public class Aani extends Thread {
	private boolean running = true;
	private int efekti;
	
	private File musiikki = new File("polkka2.wav");
	private File auto = new File("autostart.wav");
	
	public Aani() {
		this.efekti = 0;
	}

	
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
	
	public void running() {
		this.running = false;
	}

	public void kaynnista() {
		Sound.playSample(auto);
	}
	public void kappale() {
		Sound.playSample(musiikki);
	}
	
	public void efekti(int aani) {
		this.efekti = aani;
	}
}
