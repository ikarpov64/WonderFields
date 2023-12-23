package org.javaacadmey.wonder_field.player;

import org.javaacadmey.wonder_field.Game;

import static org.javaacadmey.wonder_field.player.AnswerType.*;

public class Player {
    private final String name;
    private final String city;

    public Player(String name, String city) {
        this.name = name;
        this.city = city;
    }

    private String sayLetter() {
        System.out.println("Введите букву:");
        String letter = Game.scanner.nextLine();
        if (Game.checkLetter(letter)) {
            System.out.printf("Игрок %s: буква - %s\n", this.name, letter);
        } else {
            System.out.println("Ошибка! это не русская буква, введите русскую букву.");
            sayLetter();
        }
        return letter;
    }

    private String sayWord() {
        System.out.println("Введите слово:");
        String word = Game.scanner.nextLine();
        System.out.printf("Игрок %s: слово - %s\n", this.name, word);
        return word;
    }

    public PlayerAnswer turn() {
        System.out.printf("Ход игрока %s, %s.\n", this.name, this.city);
        System.out.println("Если хотите букву нажмите 'б' и enter, если хотите слово нажмите 'c' и enter.");

        PlayerAnswer playerAnswer = new PlayerAnswer();
        String answer;
        String answerType;
        while (true) {
            answerType = Game.scanner.nextLine();
            if (answerType.equalsIgnoreCase(ANSWER_TYPE.getLetter())) {
                answer = sayLetter();
                break;
            } else if (answerType.equalsIgnoreCase(ANSWER_TYPE.getWord())) {
                answer = sayWord();
                break;
            } else {
                System.out.println("Некорректное значение, введите 'б' или 'с'");
            }
        }

        playerAnswer.setAnswer(answer);
        playerAnswer.setAnswerType(answerType);
        return playerAnswer;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
