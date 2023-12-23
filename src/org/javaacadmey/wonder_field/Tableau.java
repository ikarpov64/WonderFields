package org.javaacadmey.wonder_field;

import java.util.Arrays;

public class Tableau {
    private static final String UNKNOWN_LETTER = "_";
    private String correctAnswer;
    private String[] lettersOnTableau;

    public void init(String correctAnswer) {
        this.correctAnswer = correctAnswer.toLowerCase();
        this.lettersOnTableau = new String[this.correctAnswer.length()];
        Arrays.fill(this.lettersOnTableau, UNKNOWN_LETTER);
    }

    public void showTableau() {
        for (String character : this.lettersOnTableau) {
            System.out.printf("%s ", character.toUpperCase());
        }
        System.out.println();
    }

    public void openLetter(String letter) {
        for (int i = 0; i < this.correctAnswer.length(); i++) {
            if (this.correctAnswer.substring(i, i + 1).equalsIgnoreCase(letter)) {
                this.lettersOnTableau[i] = letter;
            }
        }
    }

    public void openWord(String word) {
        if (word.toLowerCase().equals(this.correctAnswer)) {
            for (int i = 0; i < word.length(); i++) {
                openLetter(word.substring(i, i + 1));
            }
        }
    }

    public boolean containsUnknownLetters() {
        return Arrays.toString(this.lettersOnTableau).contains(UNKNOWN_LETTER);
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
