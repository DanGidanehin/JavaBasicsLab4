// Class representing a Text
package LanguageBricks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Text {

    private List<Sentence> sentences;

    public Text(String inputText) {
        sentences = new ArrayList<>();
        // Split text into sentences
        String[] sentenceArray = inputText.split("(?<=[.!?])\\s+");
        for (String sentence : sentenceArray) {
            sentences.add(new Sentence(sentence));
        }
    }

    public String process(char targetChar) {
        // Map to group words by occurrences of the target character
        Map<Integer, List<String>> groupedWords = new TreeMap<>(
            Collections.reverseOrder()
        );

        for (Sentence sentence : sentences) {
            for (Word word : sentence.getWords()) {
                int count = word.countOccurrences(targetChar);
                if (!word.getWord().isEmpty()) { // Ignore empty words after cleaning
                    groupedWords
                        .computeIfAbsent(count, ArrayList::new)
                        .add(word.getWord());
                }
            }
        }

        // Build the result
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, List<String>> entry : groupedWords.entrySet()) {
            result
                .append(entry.getKey())
                .append(": ")
                .append(String.join(", ", entry.getValue()))
                .append(";\n");
        }
        return result.toString().trim();
    }
}
