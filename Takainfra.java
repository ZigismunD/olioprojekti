package olioprojekti;

import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.filter.MeanFilter;

/**
 * Takainfra class allows the use of EV3IRSensor in
 * the back of the vehicle that observes
 * obstacles and commands that are given via remote controller.
 * @author zigi
 *
 */
public class Takainfra extends Thread {
	private EV3IRSensor irSensor;
	private int komento;
	private float etaisyys = (float) 50.0;
	private boolean running = true;
	
	/**
	 * Constructor for the class
	 * @param sensori EV3IrSensor
	 */
	public Takainfra(EV3IRSensor sensori) {
		this.irSensor = sensori;
	}
	
	/**
	 * This method only observes possible obstacles and updates the distance to etaisyys variable
	 */
	public void run() {
		while (running) {
			this.komento = irSensor.getRemoteCommand(0);
			etaisyys = irDistance();
		}
		
	}
	
	/**
	 * Alters the state of boolean 'running' to false.
	 */
	public void running() {
		this.running = false;
	}
	
	/**
	 * Returns the remote controller command
	 * @return Integer the command given via remote controller
	 */
	public int getKomento() {
		return this.komento;
	}
	
	/**
	 * Returns the distance from EV3IRSensor
	 * @return float the distance to obstacle
	 */
	public float getEtaisyys() {
		return this.etaisyys;
	}
	
	/**
	 * Checks the distance to possible obstacles and returns the average value
	 * @return float[] distance to obstacle as average from 25 previous measurements
	 */
	public float irDistance() {
		SampleProvider distance = irSensor.getDistanceMode();
		SampleProvider average = new MeanFilter(distance, 25);
		float[] sample = new float[average.sampleSize()];
		average.fetchSample(sample, 0);
		return sample[0];
	}
	

}
