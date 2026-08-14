package practice05.task05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileParser {

    public static List<String> parseFile(String file) {
        System.out.println("Parsing file...");
        List<String> wordsFromFile = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordsFromFile.addAll(Arrays.asList(line.split(" ")));
            }
        } catch (IOException e) {
            System.out.println("Error reading from a file. File {" + file + "} not found: " + e. getMessage());
        }
        return wordsFromFile;
    }
}
