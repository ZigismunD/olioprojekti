package olioprojekti;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.utility.Delay;
/**
* <h1>Logiikka</h1>
*This contains the operating logic of the robot.
*It starts the threads listening for commands and sensor input.
*It also translates that info into orders for the engines.
*
* @author Sami Sikilä
*/
public class Logiikka {
	
	public Logiikka(){
		
	}
	/**
	* Run method that activates the robots sensors and threads
	*/
	public void run() {
		
		LCD.drawString("1", 1, 1);
		EV3IRSensor takaSensori = new EV3IRSensor(SensorPort.S4);
		LCD.clear();
		LCD.drawString("2", 1, 1);
		
		EV3IRSensor etuSensori = new EV3IRSensor(SensorPort.S3);
		LCD.clear();
		LCD.drawString("3", 1, 1);
		
		EV3TouchSensor touchSensori = new EV3TouchSensor(SensorPort.S1);
		LCD.clear();
		LCD.drawString("4", 1, 1);
		
		EtuInfra etuThread = new EtuInfra(etuSensori);
		LCD.clear();
		LCD.drawString("5", 1, 1);
		
		Takainfra takaThread = new Takainfra(takaSensori);
		LCD.clear();
		LCD.drawString("6", 1, 1);
		
		Motors motors = new Motors();
		LCD.clear();
		LCD.drawString("7", 1, 1);
		
		Aani aanet = new Aani();
		LCD.clear();
		LCD.drawString("8", 1, 1);
		
		etuThread.start();
		takaThread.start();
		aanet.start();
		
		
		
		
		KosketusAnturi kosketusAnturi = new KosketusAnturi(touchSensori);
		/**
		*This part prevents the robots movement until the touch sensor is activated.
		*/
		kosketusAnturi.lukko();
		aanet.efekti(1);
		motors.straight();
		LCD.clear();
		Delay.msDelay(500);
		
		/**
		* This loop handles listening for and relaying commands to motors.
		*/
		while (!Button.ESCAPE.isDown()) {
			int kasky = takaThread.getKomento();
			
			if (etuThread.getEtaisyys() < 20) {
				motors.stopMotors();
				motors.straight();
				motors.uTurn();
			}
			
			if (takaThread.getEtaisyys() < 20) {
				motors.stopMotors();
			}
			
			switch (kasky) {
			case 1:
				motors.turnLeft();
				break;
			case 2:
				motors.driveMotors();
				aanet.efekti(2);
				break;
			case 3:
				motors.turnRight();
				break;
			case 4:
				motors.backupMotors();
				break;
			case 5:
				motors.stopMotors();
				break;
			case 6:
				motors.moreSpeed();
				break;
			case 7:
				motors.lessSpeed();
				break;
			case 8: 
				motors.lessSpeed();
				break;
			case 9:
				motors.straight();
				break;
			}
		}
		/**
		*This part deactivates all sensors and motors.
		*/
		aanet.running();
		etuThread.running();
		takaThread.running();
		Delay.msDelay(500);
		etuSensori.close();
		takaSensori.close();
		motors.shutdownMotors();
		touchSensori.close();

	}
	}


