// Class representing a Word
package LanguageBricks;

import java.util.ArrayList;
import java.util.List;

class Word {

    private List<Letter> letters;

    public Word(String word) {
        letters = new ArrayList<>();
        // Filter out invalid characters (symbols and standalone numbers)
        String cleanedWord = word
            .replaceAll("^[^\\p{L}\\d]+|[^\\p{L}\\d]+$", "")
            .replaceAll("[^\\p{L}\\d]", "");
        for (char c : cleanedWord.toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    public String getWord() {
        StringBuilder builder = new StringBuilder();
        for (Letter letter : letters) {
            builder.append(letter.getValue());
        }
        return builder.toString();
    }

    public int countOccurrences(char targetChar) {
        int count = 0;
        for (Letter letter : letters) {
            if (Character.toLowerCase(letter.getValue()) == targetChar) {
                count++;
            }
        }
        return count;
    }
}
