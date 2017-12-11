package olioprojekti;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.utility.Delay;
/**
 * 
 * @author Skynet
 *
 */
public class Dippa {

	public static void main(String[] args) {
		Logiikka logiikka = new Logiikka();
		logiikka.run();	
	}
}
