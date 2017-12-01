package olioprojekti;

import java.io.File;

import lejos.hardware.Sound;

public class Aani {
	
	static File musiikki = new File("polkka2.wav");
	static File auto = new File("autostart.wav");

	public static void kaynnista() {
		Sound.playSample(auto);
	}
	public static void kappale() {
		Sound.playSample(musiikki);
	}
}
