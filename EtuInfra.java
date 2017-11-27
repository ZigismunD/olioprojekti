package olioprojekti;

import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.filter.MeanFilter;

/**
 * EtuInfra allows the use of EV3IRSensor in front of the vehicle that observes 
 * obstacles that come in it's way
 * @author zigi
 *
 */
public class EtuInfra extends Thread {
	private EV3IRSensor irSensor;
	private float etaisyys;
	private boolean running = true;
	
	/**
	 * Constructor for the class EtuInfra
	 * @param sensor EV3IRSensor
	 */
	public EtuInfra(EV3IRSensor sensor) {
		this.irSensor = sensor;
	}
	
	/**
	 * This method only observes possible obstacles and updates the distance to etaisyys variable
	 */
	public void run() {
		while (running) {
			this.etaisyys = irDistance();
		}
		
		this.irSensor.close();
	}
	
	
	/**
	 * Alters the state of running variable to false thus ending this thread
	 */
	public void running() {
		this.running = false;
	}
	
	/**
	 * Returns the distance to observed obstacle
	 * @return float distance to obstacle
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
