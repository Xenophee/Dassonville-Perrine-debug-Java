package com.hemebiotech.analytics;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Reads symptom data from a file and provides a list of symptoms.
 * This implementation reads symptom strings from the specified file, with one symptom per line.
 *
 * @author Perrine
 * @version 1.0
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private final String filePathToRead;

	/**
	 * Constructs a ReadSymptomDataFromFile object with the specified file path.
	 *
	 * @param filepath A full or partial path to the file containing symptom strings, one per line.
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filePathToRead = filepath;
	}


	/**
	 * Retrieves a list of symptom from the specified file.
	 *
	 * @return A list containing the symptom strings read from the file.
	 *         If an error occurs during the reading process, null is returned.
	 */
	@Override
	public List<String> getSymptoms() {

        Path newFilePath = Paths.get(filePathToRead);

        List<String> readFile = null;

        try (BufferedReader reader = Files.newBufferedReader(newFilePath)) {
			readFile = reader.lines().toList();
        } catch (IOException e) {
			System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

		return readFile;
    }

}
