package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * The AnalyticsCounter class provides functionality for analyzing and processing symptom data.
 * It reads symptom data, count and sort the data, and writes the results to an output source.
 *
 * @author Perrine
 * @version 1.0
 */
public class AnalyticsCounter {

	private final ISymptomReader reader;
	private final ISymptomWriter writer;


	/**
	 * Constructs an AnalyticsCounter object with the specified reader and writer.
	 *
	 * @param reader The reader used to read symptom data.
	 * @param writer The writer used to write analysis results.
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}


	/**
	 * Retrieves a list of symptoms from the data file using the reader.
	 *
	 * @return A list of symptoms obtained from the data file.
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}


	/**
	 * Counts the occurrences of each symptom in the given list.
	 *
	 * @param symptoms List of symptoms to be counted.
	 * @return A Map where the keys represent the names of the symptoms and the values represent the number of occurrences.
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
        return symptoms.stream()
				.collect(Collectors.groupingBy(symptom -> symptom, Collectors.summingInt(symptom -> 1)));
	}


	/**
	 * Sorts the symptoms Map alphabetically by symptom name.
	 *
	 * @param symptoms A Map of symptoms for keys and their occurrences for values.
	 * @return A TreeMap containing the symptoms sorted alphabetically by name.
	 */
	public TreeMap<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}


	/**
	 * Writes the symptoms TreeMap to an output source using the writer.
	 *
	 * @param symptoms A TreeMap of symptoms and their occurrences to be written.
	 */
	public void writeSymptoms(TreeMap<String, Integer>symptoms) {
		writer.writeSymptoms(symptoms);
	}

}
