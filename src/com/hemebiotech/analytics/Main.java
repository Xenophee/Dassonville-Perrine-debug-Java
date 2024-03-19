package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Main {


    public static void main(String[] args) {

        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        AnalyticsCounter analytics = new AnalyticsCounter(reader, writer);

        List<String> symptomsList = analytics.getSymptoms();

        Map<String, Integer> symptomsMap = analytics.countSymptoms(symptomsList);
        TreeMap<String, Integer> symptomsSortedMap = analytics.sortSymptoms(symptomsMap);

        analytics.writeSymptoms(symptomsSortedMap);

    }
}
