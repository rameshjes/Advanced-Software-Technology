package exercise11;
/*
 * 
 * Author : Ramesh Kumar
 */
public class Sample {

	private Poses poseofsample;
	private double weight;
	
	
	public Poses getPose() {
		return poseofsample;
	}
	// constructor of Pose and weight
	public Sample(Poses poseofsample, double weight) {
		super();
		this.poseofsample = poseofsample;
		this.weight = weight;
	}
	
	// Pose only
	public Sample(Poses poseofsample) {
		super();
		this.poseofsample = poseofsample;
	}

	public Sample() {
		// TODO Auto-generated constructor stub
	}
	public void setPose(Poses pose) {
		this.poseofsample = pose;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
