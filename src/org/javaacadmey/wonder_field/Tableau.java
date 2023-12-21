package org.javaacadmey.wonder_field;

import java.util.Arrays;
import java.util.Locale;

public class Tableau {
    private String correctAnswer;
    private String[] letters;

    public Tableau(String correctAnswer) {
        this.correctAnswer = correctAnswer.toLowerCase();
        this.letters = new String[this.correctAnswer.length()];
        Arrays.fill(this.letters, "_");
        for (String letter : this.letters) {
            System.out.printf("%s ", letter);
        }
        System.out.println();
    }

    public void openLetter(String letter) {
        for (int i = 0; i < this.correctAnswer.length(); i++) {
            if (this.correctAnswer.substring(i, i + 1).equalsIgnoreCase(letter)) {
                this.letters[i] = letter;
            }
        }
        for (String character : this.letters) {
            System.out.printf("%s ", character);
        }
        System.out.println();
    }

    public void openWord(String word) {
        if (word.toLowerCase().equals(this.correctAnswer)) {
            System.out.println("Верно, это: " + word);
        }
    }

    private boolean containsLetter(char letter) {
        return false;
    }

    private boolean checkAttributes(char attribute) {
        return true;
    }

    private boolean checkAttributes(String attribute) {
        return true;
    }
}
