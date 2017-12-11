
package olioprojekti;

import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
/**
 * KosketusAnturi uses the EV3Touchsensor to "lock-up" the robot
 * until the touchsensor is pressed, "starting" the robot.
 * @author Topias Renko
 *
 */
public class KosketusAnturi {

	private EV3TouchSensor kytkin;
	/**
	 * Constructor for class KosketusAnturi.
	 * @param ts
	 * Parameter is EV3TouchSensor type.
	 */
	public KosketusAnturi(EV3TouchSensor ts) {
		this.kytkin = ts;
	}
	/**
	 * When called, method lukko stays in a loop until the touch sensor is pressed.
	 * If the car is locked, a red light is shown from the Brick's keypad.
	 * When unlocked, the color changes to green.
	 */
	public void lukko() {
		LCD.drawString("Auto on lukossa.", 2, 4); // This is shown on the Brick's screen until unlocked.
		while(true) {
			float[] sample = new float[kytkin.sampleSize()];
			Button.LEDPattern(2);	// RED
			kytkin.fetchSample(sample, 0);
			if(sample[0] == 1) {
				LCD.clear();
				LCD.drawString("Auto ei ole lukossa." , 2, 4); // This is shown when unlocked.
				Button.LEDPattern(1);	// GREEN
				break;
			} else {
				continue;
			}
		}
	}
}