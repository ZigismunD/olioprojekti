import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class Motors {
	private RegulatedMotor me;
	private RegulatedMotor mr;
	private RegulatedMotor mv;
	private int speed = 200;
	public Motors() {
	this.me = new EV3MediumRegulatedMotor(MotorPort.B);
	this.mr = new EV3LargeRegulatedMotor(MotorPort.D);
	this.mv = new EV3LargeRegulatedMotor(MotorPort.A);
	this.mr.synchronizeWith(new RegulatedMotor[] { mv });
	this.me.setSpeed(100);
	}
	public void stopMotors() {
		this.me.stop();
		this.mr.stop();
		this.mv.stop();
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
		this.speed =+ 100;
		this.mr.setSpeed(speed);
		this.mv.setSpeed(speed);
		
	}
	public void lessSpeed() {
		this.speed =- 100;
		this.mr.setSpeed(speed);
		this.mv.setSpeed(speed);
	}
}
