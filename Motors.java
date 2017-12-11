import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

/**
 * <h1>AutoMotors<h1>
 * Contains the methods used to control motors in the robot.
 * It activates, directs and deactivates three motors.
 * Motors mr and mv control two backwheel motors.
 * Motor me controls the front motor used to turn robots front wheels. 
 * @author omvir
 *
 */
/**
 * this method activates the motoes and sets their initial speed.
 */
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

	/**
	 * This method stops the motors movement.
	 */
	public void stopMotors() {
		this.me.stop();
		this.mr.stop();
		this.mv.stop();
	}

	/**
	 * This method deactivates the motors and closes their connection ports. This is
	 * necessary because the LeJos system is not built to handle left open
	 * connection ports.
	 */
	public void shutdownMotors() {
		this.me.close();
		this.mr.close();
		this.mv.close();
	}

	/**
	 * This method moves the robot forward. The robot will not stop until it is
	 * given the stop command. Due to the configuration of the robot the motors must
	 * spin backwards for it to move forward.
	 */
	public void driveMotors() {
		this.mr.backward();
		this.mv.backward();
	}

	/**
	 * This method moves the robot backward. The robot will not stop until it is
	 * given the stop command.
	 */
	public void backupMotors() {
		this.mr.forward();
		this.mv.forward();
	}

	/**
	 * This turns the robots front wheels right 45 degrees.
	 */
	public void turnRight() {
		this.me.rotate(-45);
	}

	/**
	 * This turns the robots front wheels left 45 degrees.
	 */
	public void turnLeft() {
		this.me.rotate(45);
	}

	/**
	 * This increases the speed of the two back motors and controls the speed of the
	 * robot.
	 */
	public void moreSpeed() {
		this.speed = +100;
		this.mr.setSpeed(speed);
		this.mv.setSpeed(speed);
	}

	/**
	 * This decreases the speed of the two back motors and controls the speed of the
	 * robot.
	 */
	public void lessSpeed() {
		this.speed = -100;
		this.mr.setSpeed(speed);
		this.mv.setSpeed(speed);
	}
}
