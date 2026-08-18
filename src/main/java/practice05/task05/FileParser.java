package practice05.task05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class FileParser {

    public static List<String> parseFile(String file, String text) {
        List<String> wordsFromFile = new ArrayList<>();
        Pattern pattern = Pattern.compile(text);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.lines()
                    .map(e -> {
                        List<String> filteredWords = Arrays.stream(e.split("[\\s.,]+")).filter(pattern.asMatchPredicate()).toList();
                        return filteredWords;
                    })
                    .forEach(wordsFromFile::addAll);
//            String line;
//            while ((line = reader.readLine()) != null) {
//                reader.lines()
//                        .map(e -> Arrays.stream(e.split("[\\s.,]]")).filter(pattern.asMatchPredicate()).toList())
//                        .forEach(wordsFromFile::addAll);
//                wordsFromFile.addAll(Arrays.asList(line.split("[\\s.,]+")));
//            }
        } catch (IOException e) {
            System.out.println("Error reading from a file. File {" + file + "} not found: " + e. getMessage());
        }
        return wordsFromFile;
    }
}
