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
	}
	public void stopMotors() {
		this.me.stop(true);
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
		this.me.rotate(-45);
	}
	public void turnLeft() {
		this.me.rotate(45);
	}
	public void moreSpeed() {
		this.speed += 50;
		this.mr.setSpeed(speed);
		this.mv.setSpeed(speed);
		
	}
	public void lessSpeed() {
		this.speed -= 50;
		this.mr.setSpeed(speed);
		this.mv.setSpeed(speed);
	}
	
	public void uTurn() {
		turnRight();
		backupMotors();
		Delay.msDelay(2500);
		stopMotors();
		turnLeft();
		turnLeft();
		driveMotors();
		Delay.msDelay(2500);
		stopMotors();
	}
	
	public void testi() {
		int asteluku = me.getTachoCount();
		LCD.drawInt(asteluku, 1, 6);
		Delay.msDelay(4000);
		LCD.clear();
	}
	
	public void straight() {
		this.me.rotateTo(0, true);
	}
}
