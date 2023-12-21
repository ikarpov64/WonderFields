package org.javaacadmey.wonder_field.player;

import org.javaacadmey.wonder_field.Game;

public class Player {
    private String name;
    private String city;

    public Player(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String sayLetter() {
        String letter = Game.scanner.nextLine();
        System.out.println(this.name + ": " + letter);
        return letter;
    }

    public String sayWord() {
        String word = Game.scanner.nextLine();
        System.out.println(this.name + ": " + word);
        return word;
    }

    public PlayerAnswer playerTurn() {
        System.out.printf("Ход игрока %s, %s.\n", this.name, this.city);
        System.out.println("Если хотите букву нажмите 'б' и enter, если хотите слово нажмите 'c' и enter.");

        PlayerAnswer playerAnswer = new PlayerAnswer();
        String answer = "";
        String answerType = "";
        while (true) {
            answerType = Game.scanner.nextLine();
            if (answerType.equalsIgnoreCase("б")) {
                answer = sayLetter();
                break;
            } else if (answerType.equalsIgnoreCase("с")) {
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
}
