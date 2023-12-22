package org.javaacadmey.wonder_field;

import org.javaacadmey.wonder_field.player.Player;
import org.javaacadmey.wonder_field.player.PlayerAnswer;

import java.util.Scanner;

public class Game {
    private final static int NUMBER_OF_PLAYERS = 3;
    private final static int NUMBER_OF_ROUNDS = 4;
    private final static int NUMBER_OF_GROUP_ROUNDS = 3;
    private final static int INDEX_OF_FINAL_ROUND = 3;

    public final static Scanner scanner = new Scanner(System.in);

    private String[] questions = new String[NUMBER_OF_ROUNDS];
    private String[] answers = new String[NUMBER_OF_ROUNDS];
    private Tableau tableau = new Tableau();
    private Yakubovich yakubovich = new Yakubovich();

    private Player[] winners = new Player[NUMBER_OF_GROUP_ROUNDS];

    public void init() {
        System.out.println("Запуск игры 'Поле Чудес' - подготовка к игре. " +
                "Вам нужно ввести вопросы и ответы для игры.");
        completeQuestions();
//        inputtingQuestions();
        System.out.println("Инициализация закончена, игра начнется через 5 секунд.");

        try {
            Thread.sleep(2000); // 5000 миллисекунд = 5 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Прошло 5 секунд.");
        System.out.println("\n".repeat(50));
    }

    public Player[] createPlayers() {
        Player[] players = new Player[NUMBER_OF_GROUP_ROUNDS];

        String string = "Игрок №%s представьтесь: имя,город. Например: Иван,Москва\n";
        for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
            System.out.printf(string, i + 1);
            String aboutPlayer = scanner.nextLine();

            String[] splitString = aboutPlayer.split(",");
            Player player = new Player(splitString[0].trim(),
                    splitString[1].trim());
            players[i] = player;
        }
        return players;
    }

    private void inputtingQuestions() {
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            System.out.printf("Введите вопрос №%s\n", i + 1);
            String question = scanner.nextLine();
            System.out.printf("Введите ответ на вопрос №%s\n", i + 1);
            String answer = scanner.nextLine();
            questions[i] = question;
            answers[i] = answer;
        }
    }
    private static String[] playersName(Player[] players) {
        String[] playersName = new String[NUMBER_OF_PLAYERS];
        for (int i = 0; i < players.length; i++) {
            playersName[i] = players[i].getName();
        }
        return playersName;
    }

    private boolean checkTableau() {
        return !tableau.containsUnknownLetters();
    }

    public boolean playerTurn(String question, Player player) {
        PlayerAnswer answer = player.playerTurn();


        while (!checkTableau()) {
            yakubovich.checkPlayerAnswer(answer, this.answers[1], tableau);

        }
        return true;
    }

    public void playRound(Player[] players, int numberOfRound) {
//        if (numberOfRound == INDEX_OF_FINAL_ROUND) {
//
//        } else {
//
//        }

        do {
            for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
                PlayerAnswer answer = players[i].playerTurn();
                if (!yakubovich.checkPlayerAnswer(answer, answers[numberOfRound], this.tableau)) {
                    break;
                }
                if (checkTableau()) {
                    yakubovich.shoutAboutVictory(players[i].getName(), players[i].getCity(), false);
                }
            }
        }
        while (!checkTableau());

    }

    private void playAllGroupRound() {
        for (int i = 0; i < NUMBER_OF_GROUP_ROUNDS; i++) {
            Player[] players = createPlayers();
            tableau.init(answers[i]);
            yakubovich.invitingPlayers(playersName(players), i);
            yakubovich.askingQuestion(questions[i]);
            tableau.showTableau();

            playRound(players, i);
        }
    }

    private void playFinalRound() {
        tableau.init(answers[INDEX_OF_FINAL_ROUND]);
        yakubovich.invitingPlayers(playersName(winners), INDEX_OF_FINAL_ROUND);
        yakubovich.askingQuestion(questions[INDEX_OF_FINAL_ROUND]);
        tableau.showTableau();

        playRound(winners, INDEX_OF_FINAL_ROUND);
    }

    public void startGame() {
        yakubovich.greetings();
        this.playAllGroupRound();
        this.playFinalRound();
        yakubovich.farewell();
    }

    private void completeQuestions() {
        String q1 = "Вопрос номер один?";
        String q2 = "Вопрос номер два?";
        String q3 = "Вопрос номер три?";
        String q4 = "Вопрос номер четыре?";
        String a1 = "один";
        String a2 = "два";
        String a3 = "три";
        String a4 = "четыре";

        this.questions = new String[] {q1, q2, q3, q4};
        this.answers = new String[] {a1, a2, a3, a4};
    }


}
