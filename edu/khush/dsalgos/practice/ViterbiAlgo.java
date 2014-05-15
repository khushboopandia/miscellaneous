package edu.khush.dsalgos.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class ViterbiAlgo {

	float[][] emissionProbs = new float[1224][5];
	float[][] transitionProb = new float[3][3];
	float[] startProb = new float[3];

	String[] states = { "pos", "neu", "neg" };

	
	
	
	public static void main(String args[]) {

		try {

			ViterbiAlgo viterbiAlgo = new ViterbiAlgo();
			viterbiAlgo.readStartAndTransitionProbabilites();
			viterbiAlgo.readEmissionProbabilties();
			viterbiAlgo.tagObservationSequences();

		} catch (IOException e) {

			System.out.println("IO Exception");
			e.printStackTrace();
		}
	}

	
	
	
	public void readStartAndTransitionProbabilites() throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(
				"/Users/khushboopandia/CS5740/Project3/Scripts/transProb.txt"));

		String line = null;
		int lineNo = 1;
		int index = 0;
		while ((line = reader.readLine()) != null) {
			String[] probValues = line.split(" ");

			if (lineNo == 1) {
				for (int i = 0; i < states.length; i++)
					startProb[i] = Float.parseFloat(probValues[i]);
				lineNo++;
			} else {
				for (int j = 0; j < states.length; j++) {
					transitionProb[index][j] = 0.33f;
					// Float.parseFloat(probValues[j]);
				}
				index++;

			}
		}

	}

	
	
	
	public void readEmissionProbabilties() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(
				"/Users/khushboopandia/CS5740/Project3/Scripts/emissionprob"));
		String line = "";
		int index = 0;
		while ((line = reader.readLine()) != null) {
			String[] probValues = line.split(" ");
			for (int j = 0; j < 1224; j++) {
				emissionProbs[j][index] = Float.parseFloat(probValues[j]);
			}
			index++;
		}

	}

	
	
	
	public void tagObservationSequences() throws IOException {

		String[] obsSeq = null;
		int id = 0;
		HashMap<String, String> stateMap = new HashMap<String, String>();
		stateMap.put("pos", "1");
		stateMap.put("neu", "0");
		stateMap.put("neg", "-1");

		// Write the prediction file
		BufferedWriter writer = new BufferedWriter(new FileWriter(
				"/Users/khushboopandia/CS5740/Project3/Scripts/pred.txt"));
		writer.write("Id,answer");
		writer.newLine();

		BufferedReader reader = new BufferedReader(new FileReader(
				"/Users/khushboopandia/CS5740/Project3/Scripts/seqfile"));
		String line = "";
		while ((line = reader.readLine()) != null) {
			obsSeq = line.split(" ");
			obsSeq = Arrays.copyOfRange(obsSeq, 1, obsSeq.length - 1);
			String[] result = fwdViterbi(obsSeq);

			for (int i = 0; i < result.length; i++) {
				writer.write(id + "," + stateMap.get(result[i]));
				writer.newLine();
				id++;
			}
		}

		writer.close();

	}

	
	
	
	public String[] fwdViterbi(String[] observations) {

		// Create a table of rows=no of states and cols=no of obs
		Node[][] viterbiTable = new Node[states.length][observations.length];

		// Fill out the first col of the viterbi table
		for (int i = 0; i < states.length; i++) {
			double logEp = -10000.0;
			if (emissionProbs[Integer.parseInt(observations[0])][i] != 0.0)
				logEp = Math.log(emissionProbs[Integer
						.parseInt(observations[0])][i]);
			double prob = Math.log(startProb[i]) + logEp;
			viterbiTable[i][0] = new Node(prob, -1);

		}

		// Fill out the remianing cols of the viterbi table
		for (int i = 1; i < observations.length; i++) {
			int prevCol = i - 1;
			for (int j = 0; j < states.length; j++) {

				double maxProb = -10000.0f;
				int prevState = -1;
				double prob = -1.0;
				for (int k = 0; k < states.length; k++) {

					// Get emission prob
					double logEp = -10000.0;
					if (emissionProbs[Integer.parseInt(observations[i])][j] != 0.0)
						logEp = Math.log(emissionProbs[Integer
								.parseInt(observations[i])][j]);

					// Get transition prob
					double logTp = -10000.0;
					if (transitionProb[k][j] != 0.0)
						logTp = Math.log(transitionProb[k][j]);

					prob = logEp + logTp + viterbiTable[k][i - 1].prob;
					if (prob >= maxProb) {

						maxProb = prob;
						prevState = k;
					}

				}

				viterbiTable[j][i] = new Node(maxProb, prevState);

			}

		}

		// Print the viterbi table (debugging purpose)
		/*
		 * for (int i=0;i<states.length;i++) { for (int
		 * j=0;j<observations.length;j++) {
		 * System.out.print(" ("+viterbiTable[i]
		 * [j].state+","+viterbiTable[i][j].prob+") "); }
		 * 
		 * System.out.println(); }
		 */
		
		
		

		// Get the tagged seq from the viterbi table
		int index = observations.length - 1;
		String result[] = new String[observations.length];
		double maxProb = -10000.0;
		int maxPrevStateNode = -1;
		int maxStateNode = -1;
		for (int i = 0; i < states.length; i++) {
			if (viterbiTable[i][index].prob >= maxProb) {
				maxProb = viterbiTable[i][index].prob;
				maxPrevStateNode = viterbiTable[i][index].state;
				maxStateNode = viterbiTable[i][index].state;
				;
			}

		}
		result[index] = states[maxStateNode];
		index--;
		while (index >= 0) {
			Node n = viterbiTable[maxPrevStateNode][index];
			maxStateNode = maxPrevStateNode;
			maxPrevStateNode = n.state;
			result[index] = states[maxStateNode];
			index--;
		}


		return result;

	}

	
	
	private static class Node {
		public double prob;
		public int state;

		public Node(double prob, int state) {
			this.prob = prob;
			this.state = state;
		}
	}

}
