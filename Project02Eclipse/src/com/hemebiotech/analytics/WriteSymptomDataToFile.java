package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    public String filePathToWrite;

    public WriteSymptomDataToFile(String filePathToWrite) {
        this.filePathToWrite = filePathToWrite;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {

        Files.deleteIfExists(Path.of(filePathToWrite));
        Path newFilePath = Paths.get(filePathToWrite);
        Path fileToWrite = Files.createFile(newFilePath);


        try(BufferedWriter writer = Files.newBufferedWriter(fileToWrite, StandardOpenOption.APPEND)) {


            symptoms.forEach((key, value) -> {

                try {
                    writer.write(key + " : " + value + System.lineSeparator());
                } catch (IOException e) {
                    System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
                }

            });

        } catch (Exception e) {
            System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
        }

        System.out.println("Fichier créé avec succès : " + fileToWrite);

    }
}
