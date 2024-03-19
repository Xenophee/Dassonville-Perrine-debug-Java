package com.hemebiotech.analytics;

import java.util.TreeMap;

/**
 * The ISymptomWriter interface represents a writer for writing symptom data to an output source.
 * Implementing classes must provide an implementation for :
 *
 * <ul>
 *     <li>{@link #writeSymptoms(TreeMap)}</li>
 * </ul>
 *
 * If the symptom data is null, the created file will simply be empty.
 *
 * @see WriteSymptomDataToFile
 *
 * @author Perrine
 * @version 1.0
 */
public interface ISymptomWriter {

    /**
     * Writes the provided symptom data to an output source.
     * The symptom data is provided as a TreeMap where the keys represent the names of the symptoms
     * and the values represent the occurrences of each symptom.
     *
     * @param symptoms A TreeMap containing the symptom data to be written.
     */
    void writeSymptoms(TreeMap<String, Integer> symptoms);
}
