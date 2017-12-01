
package olioprojekti;

import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;

public class KosketusAnturi {

	private EV3TouchSensor Kytkin;
	
	public KosketusAnturi(EV3TouchSensor ts) {
		this.Kytkin = ts;
	}
	
	public void Lukko() {
		LCD.drawString("Auto on lukossa.", 2, 4);
		while(true) {
			float[] sample = new float[Kytkin.sampleSize()];
			Button.LEDPattern(2);
			Kytkin.fetchSample(sample, 0);
			if(sample[0] == 1) {
				LCD.clear();
				LCD.drawString("Auto ei ole lukossa." , 2, 4);
				Button.LEDPattern(1);
				break;
			} else {
				continue;
			}
		}
	}
}