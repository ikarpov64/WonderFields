package org.javaacadmey.wonder_field.player;

import org.javaacadmey.wonder_field.Game;
import org.javaacadmey.wonder_field.MagicBox;
import org.javaacadmey.wonder_field.Tableau;
import org.javaacadmey.wonder_field.wheel.Wheel;

import java.util.InputMismatchException;

import static org.javaacadmey.wonder_field.player.AnswerType.*;

public class Player {
    private final String name;
    private final String city;
    private int scores = 0;
    private int correctAttempt = 0;
    private int moneyWin = 0;

    public Player(String name, String city) {
        this.name = name;
        this.city = city;
    }

    private String sayLetter(Tableau tableau) {
        String letter = "";
        boolean letterIsChecked = false;
        while (!letterIsChecked) {
            System.out.println("Введите букву:");
            letter = Game.scanner.nextLine();
            letterIsChecked = Game.checkLetter(letter);
            boolean alreadyOpen = tableau.containsLetters(letter);
            if (alreadyOpen) {
                letterIsChecked = false;
                System.out.println("Такая буква уже открыта, назовите другую букву!");
                continue;
            }
            if (letterIsChecked) {
                System.out.printf("Игрок %s: буква - %s\n", this.name, letter);
            } else {
                System.out.println("Ошибка! это не русская буква, введите русскую букву.");
            }
        }
        return letter;
    }

    private String sayWord() {
        System.out.println("Введите слово:");
        String word = Game.scanner.nextLine();
        System.out.printf("Игрок %s: слово - %s\n", this.name, word);
        return word;
    }

    public PlayerAnswer move(Tableau tableau) {
        System.out.println("Если хотите букву нажмите 'б' и enter, если хотите слово нажмите 'c' и enter.");
        PlayerAnswer playerAnswer = new PlayerAnswer();
        String answer;
        String answerType;
        while (true) {
            answerType = Game.scanner.nextLine();
            if (answerType.equalsIgnoreCase(ANSWER_TYPE.getLetter())) {
                answer = sayLetter(tableau);
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

    public int chooseMagicBox(MagicBox magicBox) {
        System.out.println("Выберите шкатулку. Введите 1 или 2 и нажмите enter.");
        int playerChoose;
        int money = 0;
        while (true) {
            try {
                playerChoose = Game.scanner.nextInt();
                if (playerChoose > 0 && playerChoose <= magicBox.getBoxQty()) {
                    money = magicBox.choosingBox(playerChoose);
                    break;
                } else {
                    System.out.println("Такой шкатулки нет.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Пожалуйста, введите число.");
                Game.scanner.nextInt();
            }
        }
        return money;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public void setCorrectAttempt(int correctAttempt) {
        this.correctAttempt = correctAttempt;
    }

    public int getCorrectAttempt() {
        return correctAttempt;
    }

    public void setMoneyWin(int moneyWin) {
        this.moneyWin = moneyWin;
    }

    public int getMoneyWin() {
        return moneyWin;
    }
}
