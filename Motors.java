package olioprojekti;


import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Motors {
	private RegulatedMotor me;  // Moottori edessä
	private RegulatedMotor mr;	// Moottori oikea takarengas
	private RegulatedMotor mv;	// Moottori vasen takarengas
	private int speed = 200;
	
	
	public Motors() {
	this.me = new EV3MediumRegulatedMotor(MotorPort.B);
	this.mr = new EV3LargeRegulatedMotor(MotorPort.D);
	this.mv = new EV3LargeRegulatedMotor(MotorPort.A);
	this.mr.synchronizeWith(new RegulatedMotor[] { mv });
	this.me.setSpeed(100);
	
	this.mr.setSpeed(speed);
	this.mv.setSpeed(speed);
	}
	public void stopMotors() {
		//this.me.stop(true);
		this.mr.stop(true);
		this.mv.stop(true);
	}
	public void shutdownMotors() {
		this.me.close();
		this.mr.close();
		this.mv.close();
	}
	public void driveMotors() {
		this.mr.backward();
		this.mv.backward();
	}
	public void backupMotors() {
		this.mr.forward();
		this.mv.forward();
	}
	public void turnRight() {
		this.me.rotateTo(-45, true);
		
	}
	public void turnLeft() {
		this.me.rotateTo(45, true);
	}
	public void moreSpeed() {
		int rspeed = this.mr.getSpeed() +30;
		int lspeed = this.mv.getSpeed() +30;
		if (rspeed < this.mr.getMaxSpeed() && lspeed < this.mv.getMaxSpeed()) {
		this.mr.setSpeed(rspeed);
		this.mv.setSpeed(lspeed);
		} else {
		LCD.drawString("Can't go faster", 0, 3);
		}

		
	}
	public void lessSpeed() {
		int rspeed = this.mr.getSpeed() - 30;
		int lspeed = this.mv.getSpeed() - 30;
		if (rspeed < 0 && lspeed < 0) {
		this.mr.setSpeed(0);
		this.mv.setSpeed(0);
		} else {
		this.mr.setSpeed(rspeed);
		this.mv.setSpeed(lspeed);
		}

	}
	
	public void uTurn() {
		while (taka)
		int speed = this.mr.getSpeed();
		int max = (int) this.mr.getMaxSpeed();
		this.mr.setSpeed(max);
		this.mv.setSpeed(max);
		turnRight();
		backupMotors();
		Delay.msDelay(2600);
		stopMotors();
		turnLeft();
		Delay.msDelay(250);
		driveMotors();
		Delay.msDelay(2600);
		straight();
		stopMotors();
		this.mr.setSpeed(speed);
		this.mv.setSpeed(speed);
	}
	
	public void testi() {
		int asteluku = this.me.getTachoCount();
		LCD.drawInt(asteluku, 1, 6);
		Delay.msDelay(4000);
		LCD.clear();
	}
	
	public void straight() {
		this.me.rotateTo(0, true);
	}
}
