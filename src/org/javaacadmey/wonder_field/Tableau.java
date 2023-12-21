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
        for (String letter : this.lettersOnTableau) {
            System.out.printf("%s ", letter);
        }
        System.out.println();
    }

    public void openLetter(String letter) {
        for (int i = 0; i < this.correctAnswer.length(); i++) {
            if (this.correctAnswer.substring(i, i + 1).equalsIgnoreCase(letter)) {
                this.lettersOnTableau[i] = letter;
            }
        }
        for (String character : this.lettersOnTableau) {
            System.out.printf("%s ", character.toUpperCase());
        }
        System.out.println();
    }

    public void openWord(String word) {
        if (word.toLowerCase().equals(this.correctAnswer)) {
            System.out.println("Верно, это: " + word);
        }
    }

    public boolean containsUnknownLetters() {
        return Arrays.toString(this.lettersOnTableau).contains(UNKNOWN_LETTER);
    }

    private boolean checkLetter(String letter) {
        return Arrays.toString(this.lettersOnTableau).contains(letter);
    }


}
