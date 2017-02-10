package exercise11;
/*
 * 
 * Author : Ramesh Kumar
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MonteCarloResampling {
	// Generate number of random samples.
	private static SampleSet sampleValues[]  = new SampleSet[5];
	
	public void randomSampleset(int numberofsamples) {

		double weights = 1 / numberofsamples;
		 ArrayList<Double> samples = new ArrayList<Double>();
		Random randomnumber = new Random();
		for (int i = 0; i < numberofsamples; i++) {

			Poses pose = new Poses();
			Sample sample = new Sample();

			while (true) {
				pose.setX((-200) + randomnumber.nextDouble() * 400);
				pose.setY((-200) + randomnumber.nextDouble() * 400);
				pose.setPhi(randomnumber.nextDouble() * 360);

				if ((pose.getX() + pose.getY()) >= -200 && (pose.getX() + pose.getY() <= 200)) {
					break;
				}
			}
			//System.out.println(
			//		pose.getX() + "         " + pose.getY() + "         " + pose.getPhi() + "       " + weights);			
			sample.setPose(pose);
			sample.setWeight(weights);
			samples.add(pose.getX());
			samples.add(pose.getY());
			samples.add(pose.getPhi());
			samples.add(weights);
			
		}
		System.out.println(samples);

	}
	// Gaussian distribution.
	
	public SampleSet[] gaussianDistribution(int sizeofsample){
 
		// Initialize array 
		for(int i = 0; i<5; i++){
			sampleValues[i] = new SampleSet();
		}
		//Store all poses in separate array list
		
		//Pose 1
		
		ArrayList<Sample> sampleSet1 = new ArrayList<Sample>();
		Sample sample1 = new Sample();
		Poses pose1 = new Poses();
		pose1.setX(-140);
		pose1.setY(20);
		pose1.setPhi(125);
		sample1.setPose(pose1);
		
		sampleSet1.add(sample1);
		
		//Pose 2
		ArrayList<Sample> sampleSet2 = new ArrayList<Sample>();
		Sample sample2 = new Sample();
		Poses pose2 = new Poses();
		pose2.setX(-60);
		pose2.setY(120);
		pose2.setPhi(270);
		sample2.setPose(pose2);
		sampleSet2.add(sample2);

		
		//Pose 3
		ArrayList<Sample> sampleSet3 = new ArrayList<Sample>();
		Sample sample3 = new Sample();
		Poses pose3 = new Poses();
		pose3.setX(20);
		pose3.setY(120);
		pose3.setPhi(0);
		sample3.setPose(pose2);
		sampleSet3.add(sample3);
		
		//Pose 4
		ArrayList<Sample> sampleSet4 = new ArrayList<Sample>();
		Sample sample4 = new Sample();
		Poses pose4 = new Poses();
		pose4.setX(80);
		pose4.setY(0);
		pose4.setPhi(225);
		sample4.setPose(pose1);
		sampleSet4.add(sample4);

		
		//Pose 5
		ArrayList<Sample> sampleSet5 = new ArrayList<Sample>();
		Sample sample5 = new Sample();
		Poses pose5 = new Poses();
		pose5.setX(100);
		pose5.setY(-100);
		pose5.setPhi(125);
		sample5.setPose(pose5);
		sampleSet5.add(sample5);

		
		//Adding all sampleSets i.e. sampleSet1 , sampleSet2 .. in array

		sampleValues[0].setSampleSet(sampleSet1);
		sampleValues[1].setSampleSet(sampleSet2);
		sampleValues[2].setSampleSet(sampleSet3);
		sampleValues[3].setSampleSet(sampleSet4);
		sampleValues[4].setSampleSet(sampleSet5);
		// Given values 
		int sigmax = 20; // variance
		int sigmay = 20;
		int sigmaz = 10;
		
		Random rand = new Random();
		double mean_x;
		double mean_y;
		double mean_phi;
		for(int j = 0; j<5;j++){
			mean_x = sampleValues[j].getSampleSet().get(0).getPose().getX();
			mean_y = sampleValues[j].getSampleSet().get(0).getPose().getY();
			mean_phi = sampleValues[j].getSampleSet().get(0).getPose().getPhi();
			// Apply gaussian distribution to each samplevalues
			for(int i = 0; i<sizeofsample; i++){

			Poses newposes = new Poses();
			Sample newSamples = new Sample();
			while(true){
				// for nextGaussian, we need to multiply variance and add mean
				newposes.setX(rand.nextGaussian()*sigmax + mean_x);
				newposes.setY(rand.nextGaussian()*sigmay+mean_y);
				newposes.setPhi(rand.nextGaussian()*sigmaz + mean_phi);
				// Condition to break the loop
				if ((newposes.getX() + newposes.getY()) >= -200 && (newposes.getX() + newposes.getY() <= 200)) {
					if((newposes.getX() <= 200 && newposes.getX() >= -200) && (newposes.getY() <= 200 && newposes.getY() >= -200) ){
						break;	
					}
					
				}
			}
			//update new pose and weight in sample
			newSamples.setPose(newposes);
			newSamples.setWeight(rand.nextGaussian());
			System.out.println(newposes.getX()+"     " + newposes.getY()+ "   "+ newposes.getPhi()+"   " + newSamples.getWeight());
			// Add gaussian distributed sample
			sampleValues[j].getSampleSet().add(newSamples);
			}
			
		}
		return sampleValues;
		
		
	}
	
	// Generate Real pose
	
		public Sample Realpose(SampleSet sampleSets[], int inputnumber){
			
			int index = (int) (Math.random()* sampleSets[inputnumber].getSampleSet().size()-1);
			return sampleSets[inputnumber].getSampleSet().get(index);
			
		}
		// Calculate Gaussian 
		public double Gauss(double difference, double sigma){
			
			return (1. / Math.sqrt(2 * Math.PI * sigma * sigma)) * 
					(Math.exp((-Math.pow(difference, 2)) / 2 * sigma * sigma));
		}
		
		//Compute weights
		
		public void weights(SampleSet[] sampleSets, Sample Realpose, double sigma){
			double x1, x2, y1,y2, weight, euclidean_distance = 0;
			
			for(int i = 0; i<5; i++){
				for(int j = 1; j<sampleSets[0].getSampleSet().size(); j++){
					
					x1 = Realpose.getPose().getX();
					y1 = Realpose.getPose().getY();
					x2 = sampleSets[i].getSampleSet().get(j).getPose().getX();
					y2 = sampleSets[i].getSampleSet().get(j).getPose().getY();
					//compute euclidean
					euclidean_distance = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
					
					weight = (double)Gauss(euclidean_distance,sigma) / Gauss(0,sigma); //
					sampleSets[i].getSampleSet().get(j).setWeight(weight);
				}
				
			}
		}
			//normalizing weights
				
				public void normalize(SampleSet sampleSets[],int usernumber) {
					// Add all the weights
					double sum = 0;
					for(int i = 0;i<sampleSets[usernumber].getSampleSet().size();i++) {
						sum += sampleSets[usernumber].getSampleSet().get(i).getWeight();
						
					}
					// divide each weight with sum of all weights
					for(int i = 0;i<sampleSets[usernumber].getSampleSet().size();i++) {
						double weight = sampleSets[usernumber].getSampleSet().get(i).getWeight();
						sampleSets[usernumber].getSampleSet().get(i).setWeight((double)weight/sum);
						
					}
			}	
			
			//Save samples in a file.
				
				public static void storeSamplesinFile(ArrayList<Sample> sampleSet) {
					try {
						File file = new File("/home/ramesh/workspace/Exercise06/src/exercise11/samples");
						BufferedWriter out = new BufferedWriter(new FileWriter(file));
						out.flush();
						for(int k=0;k<sampleSet.size();k++) {
							out.write(sampleSet.get(k).toString());
						}
						
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			// plot data in python
				
				private static void dataPlot() {
					try {
						Process p = Runtime.getRuntime().exec(
								"python "  + "/home/ramesh/workspace/Exercise06/src/Dataplot.py");
						p.waitFor();
					} catch (IOException | InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				
			


	public static void main(String[] args) {
		MonteCarloResampling classobject = new MonteCarloResampling();
		classobject.randomSampleset(100);
		SampleSet sampleSets[] = classobject.gaussianDistribution(100);
		
		for(int i=0;i<5;i++){
			storeSamplesinFile(sampleSets[i].getSampleSet());
		}
		int usernumber = (int) (Math.random() * 4);
		Sample realPose = classobject.Realpose(sampleSets,usernumber);
		double sigma = 0.02;
		classobject.weights(sampleSets,realPose,sigma);
		classobject.normalize(sampleSets,usernumber);
		
		double totalWeight[] =  new double[sampleSets[usernumber].getSampleSet().size()];
		double sumOfWeights = 0;
		for(int i = 0;i<sampleSets[usernumber].getSampleSet().size();i++) {
			sumOfWeights += sampleSets[usernumber].getSampleSet().get(i).getWeight();
			totalWeight[i] = sumOfWeights;
		}
		
		//Resampling
		ArrayList<Sample> resampledSet = new ArrayList<Sample>();
		for(int j = 0;j<sampleSets[usernumber].getSampleSet().size();j++) {
			
			if(Math.random() <= totalWeight[j]) {
				resampledSet.add(sampleSets[usernumber].getSampleSet().get(j));
			}
		}
		MonteCarloResampling.storeSamplesinFile(resampledSet);
		dataPlot();
		System.out.println("********************************** Resampling *******************************");
		for(int k=0;k<resampledSet.size();k++){
			System.out.println(resampledSet.get(k));
	}

}
	
	}

