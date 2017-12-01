package olioprojekti;

import java.io.File;

import lejos.hardware.Sound;

public class Aani {
	
	static File musiikki = new File("polkka2.wav");

	public static int playSample(File musiikki){
		return Sound.playSample(musiikki);
	}
	
}
