package exercise11;
/*
 * 
 * Author : Ramesh Kumar
 */
import java.util.ArrayList;

public class SampleSet {

	private ArrayList<Sample> sampleSet;
	
	//Constructor
	public SampleSet() {
		
		sampleSet = new ArrayList<Sample>();
	}

	public ArrayList<Sample> getSampleSet() {
		return sampleSet;
	}

	public void setSampleSet(ArrayList<Sample> sampleSet) {
		this.sampleSet = sampleSet;
	}
	
	
}
