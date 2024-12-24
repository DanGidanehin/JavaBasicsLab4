// Class representing a Sentence
package LanguageBricks;

import java.util.ArrayList;
import java.util.List;

class Sentence {

    private List<Word> words;

    public Sentence(String sentence) {
        words = new ArrayList<>();
        // Split sentence into words, replacing multiple spaces/tabs with a single space
        String[] wordArray = sentence.replaceAll("\\s+", " ").trim().split(" ");
        for (String word : wordArray) {
            if (!word.isBlank()) {
                words.add(new Word(word));
            }
        }
    }

    public List<Word> getWords() {
        return words;
    }
}
