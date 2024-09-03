package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MessageDecoder {

    public static String decode(String messageFile) {
      
        // Read the contents of the file

        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(messageFile))) {
            
            String line;
            
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

        // Sort lines based on the numeric value
        Collections.sort(lines, Comparator.comparingInt(line -> Integer.parseInt(line.split("\\s+")[0])));

        // Create a new pyramid structure with sorted words
        List<String> decodedWords = new ArrayList<>();
        int currentIndex = 0;

        for (int i = 1; currentIndex < lines.size(); i++) {
            String[] tokens = lines.get(currentIndex).split("\\s+");

            // Ensure there are words in the line
            if (tokens.length > 0) {
                int wordsToAdd = Math.min(i, tokens.length); // Ensure not to exceed the number of words in the line
                for (int j = 1; j <= wordsToAdd && j < tokens.length; j++) {
                    decodedWords.add(tokens[j]);
                }
            }

            currentIndex += i; // Move to the next line
        }

        // Join the words to form the decoded message
        String decodedString = String.join(" ", decodedWords);

        return decodedString;
    }

    public static void main(String[] args) {
        String messageFile = "C:\\Users\\tapia\\Documents\\GitHub\\Java-Projects\\test\\src\\test\\coding_qual_input.txt";
        String decodedMessage = decode(messageFile);
        System.out.println(decodedMessage.toLowerCase());
    }
}
