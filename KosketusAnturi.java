package olioprojekti;

import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.Button;

public class KosketusAnturi {

	private EV3TouchSensor Kytkin;
	float[] sample = new float[Kytkin.sampleSize()];
	
	public KosketusAnturi(EV3TouchSensor ts) {
		this.Kytkin = ts;
	}
	
	public void Lukko() {
		while(true) {
			Button.LEDPattern(2);
			Kytkin.fetchSample(sample, 0);
			if(sample[0] == 1) {
				Button.LEDPattern(1);
				break;
			} else {
				continue;
			}
		}
	}
}
