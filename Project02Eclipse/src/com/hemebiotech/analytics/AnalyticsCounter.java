package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalyticsCounter {

	private final ISymptomReader reader;
	private final ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return reader.GetSymptoms();
	}


	public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCount = symptoms.stream()
				.collect(Collectors.groupingBy(symptom -> symptom, Collectors.summingInt(e -> 1)));

        return symptomCount;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sortedSymptoms = symptoms.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

		return sortedSymptoms;
	}


	public void writeSymptoms(Map<String, Integer>symptoms) throws IOException {
		writer.writeSymptoms(symptoms);
	}

}
