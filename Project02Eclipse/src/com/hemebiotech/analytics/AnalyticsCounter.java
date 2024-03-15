package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String[] args) throws Exception {
		// first get input
		String fileName = "Project02Eclipse/symptoms.txt";
		BufferedReader reader = new BufferedReader (new FileReader(fileName));
		String line = reader.readLine();


		while (line != null) {

			if (line.equals("headache")) {
				headacheCount++;
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();
		}


		Map<String, Integer> symptoms = new HashMap<>();
		symptoms.put("headache", headacheCount);
		symptoms.put("rash", rashCount);
		symptoms.put("dialated pupils", pupilCount);

		WriteSymptomDataToFile resultFile = new WriteSymptomDataToFile("result.out");
		resultFile.writeSymptoms(symptoms);

	}
}
