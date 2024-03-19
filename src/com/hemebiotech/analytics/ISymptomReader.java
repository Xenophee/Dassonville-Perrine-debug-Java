package com.hemebiotech.analytics;

import java.util.List;

/**
 * The ISymptomReader interface represents a component responsible for reading symptom data from a data source.
 * Implementing classes must provide an implementation for :
 *
 * <ul>
 *  	<li>{@link #getSymptoms()}</li>
 * </ul>
 *
 * The returned list may contain duplicates and is not guaranteed to be ordered.
 * If no data is available, the method should return an empty list.
 *
 * @see ReadSymptomDataFromFile
 *
 * @author Perrine
 * @version 1.0
 */
public interface ISymptomReader {

	/**
	 * Retrieves a list of symptom names from a data source.
	 * If no data is available, an empty list is returned.
	 *
	 * @return A list containing the names of all symptoms obtained from the data source. Duplicates are possible.
	 */
	List<String> getSymptoms ();
}
