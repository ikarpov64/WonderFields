package org.javaacadmey.wonder_field.player;

public enum AnswerType {
    ANSWER_TYPE("c", "б");

    private final String word;
    private final String letter;

    AnswerType(String word, String letter) {
        this.word = word;
        this.letter = letter;
    }

    public String getWord() {
        return word;
    }

    public String getLetter() {
        return letter;
    }
}
