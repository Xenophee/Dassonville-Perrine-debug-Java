package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;


/**
 * Writes symptom data to a file.
 * This implementation write symptom data, represented as a TreeMap where the keys
 * are symptom names and the values are the occurrences of each symptom, to a specified file path.
 *
 * @author Perrine
 * @version 1.0
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    public String filePathToWrite;

    /**
     * Constructs a WriteSymptomDataToFile object with the specified file path.
     *
     * @param filePathToWrite The full or partial path to the file where symptom data will be written.
     */
    public WriteSymptomDataToFile(String filePathToWrite) {
        this.filePathToWrite = filePathToWrite;
    }


    /**
     * Writes the provided symptom data to the specified file path.
     *
     * @param symptoms A TreeMap containing symptom data, where keys represent symptom names and values represent occurrences.
     */
    @Override
    public void writeSymptoms(TreeMap<String, Integer> symptoms) {

        try {
            Files.deleteIfExists(Path.of(filePathToWrite));
            Path newFilePath = Paths.get(filePathToWrite);
            Path fileToWrite = Files.createFile(newFilePath);

            try(BufferedWriter writer = Files.newBufferedWriter(fileToWrite)) {

                symptoms.forEach((key, value) -> {

                    try {
                        writer.write(key + " : " + value + System.lineSeparator());
                    } catch (IOException e) {
                        System.err.println("Erreur lors de l'écriture du fichier : " + e.getMessage());
                    }

                });

            }

            System.out.println("Fichier créé avec succès : " + fileToWrite);

        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
        }

    }

}
