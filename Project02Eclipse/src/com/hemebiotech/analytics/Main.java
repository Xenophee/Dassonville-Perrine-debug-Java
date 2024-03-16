package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        AnalyticsCounter analytics = new AnalyticsCounter(reader, writer);

        List<String> symptomsList =  analytics.getSymptoms();
        Map<String, Integer> symptomsMap =  analytics.countSymptoms(symptomsList);
        Map<String, Integer> symptomsSortedMap = analytics.sortSymptoms(symptomsMap);

        try {
            analytics.writeSymptoms(symptomsSortedMap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
