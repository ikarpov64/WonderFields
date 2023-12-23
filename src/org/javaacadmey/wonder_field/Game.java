package org.javaacadmey.wonder_field;

import org.javaacadmey.wonder_field.player.Player;
import org.javaacadmey.wonder_field.player.PlayerAnswer;
import org.javaacadmey.wonder_field.wheel.Wheel;

import java.util.Scanner;

public class Game {
    private final static int NUMBER_OF_PLAYERS = 3;
    private final static int NUMBER_OF_ROUNDS = 4;
    private final static int NUMBER_OF_GROUP_ROUNDS = 3;
    public final static int INDEX_OF_FINAL_ROUND = 3;
    public final static Scanner scanner = new Scanner(System.in);
    private String[] questions = new String[NUMBER_OF_ROUNDS];
    private String[] answers = new String[NUMBER_OF_ROUNDS];
    private final Tableau tableau = new Tableau();
    private final Yakubovich yakubovich = new Yakubovich();
    private final Player[] winners = new Player[NUMBER_OF_GROUP_ROUNDS];
    private final Wheel wheel = new Wheel();

    public void init() {
        System.out.println("Запуск игры 'Поле Чудес' - подготовка к игре. " +
                "Вам нужно ввести вопросы и ответы для игры.");
        completeQuestions();
//        inputtingQuestions();
        System.out.println("Инициализация закончена, игра начнется через 5 секунд.");

        try {
            Thread.sleep(2000); // 5000 миллисекунд = 5 секунд
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n".repeat(50));
    }

    public void startGame() {
        yakubovich.greetings();
        this.playAllGroupRound();
        this.playFinalRound();
        yakubovich.farewell();
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

    private void playRound(Player[] players, int numberOfRound) {
        boolean isFinalRound = numberOfRound == INDEX_OF_FINAL_ROUND;

        while (tableauNotOpen()) {
            for (Player player : players) {
                boolean playerWin = playersMove(player);
                if (playerWin) {
                    yakubovich.shoutAboutVictory(player.getName(), player.getCity(),
                            player.getScores(), isFinalRound);
                    if (!isFinalRound) {
                        winners[numberOfRound] = player;
                    }
                    break;
                }
            }
        }
    }

    private boolean playersMove(Player player) {
        boolean noMistake = true;

        while (noMistake && tableauNotOpen()) {
            System.out.printf("Игрок %s, %s крутит барабан.\n", player.getName(), player.getCity());
            int playerScore = player.getScores();
            int newScore = wheel.rotateWheel(playerScore, yakubovich);

            if (playerScore == newScore) {
                noMistake = false;
                System.out.printf("Игрок %s из города %s пропускает ход.\n",
                        player.getName(), player.getCity());
                break;
            }
            PlayerAnswer answer = player.move();

            if (!this.yakubovich.checkPlayerAnswer(answer, this.tableau.getCorrectAnswer(), this.tableau)) {
                noMistake = false;
            } else {
                this.tableau.showTableau();
                player.setScores(newScore);
                System.out.println("У игрока: " + player.getScores());
            }
        }
        return noMistake;
    }

    public Player[] createPlayers() {
        Player[] players = new Player[NUMBER_OF_GROUP_ROUNDS];
        String string = "Игрок №%s представьтесь: имя,город. Например: Иван,Москва\n";
        for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
            System.out.printf(string, i + 1);
            players[i] = createPlayer();
        }
        return players;
    }

    private Player createPlayer() {
        boolean playerChecked = false;
        String playerInfo = scanner.nextLine();
        while (!playerChecked) {
            playerChecked = checkPlayerInfo(playerInfo);
            if (!playerChecked) {
                System.out.println("Некорректный ввод. Пожалуйста, введите имя и город через запятую.");
                playerInfo = scanner.nextLine();
            }
        }
        String[] splitPlayerInfo = playerInfo.split(",");
        return new Player(splitPlayerInfo[0].trim(), splitPlayerInfo[1].trim());
    }

    private boolean checkPlayerInfo(String playerInfo) {
        boolean playerChecked = false;
        if (playerInfo.contains(",")) {
            String[] parts = playerInfo.split(",");
            if (parts.length == 2 && !parts[0].trim().isEmpty() && !parts[1].trim().isEmpty()) {
                playerChecked = true;
            }
        }
        return playerChecked;
    }

    public static boolean checkLetter(String letter) {
        boolean validLetter = false;
        if (letter.trim().length() == 1) {
            if (isRussianAlphabetLetter(letter.trim().charAt(0))) {
                validLetter = true;
            }
        }
        return validLetter;
    }

    private static boolean isRussianAlphabetLetter(char symbol) {
        return Character.UnicodeBlock.CYRILLIC.equals(Character.UnicodeBlock.of(symbol));
    }

    private void inputtingQuestions() {
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            System.out.printf("Введите вопрос №%s\n", i + 1);
            String question = scanner.nextLine();
            System.out.printf("Введите ответ на вопрос №%s\n", i + 1);
            String answer = scanner.nextLine();
            this.questions[i] = question;
            this.answers[i] = answer;
        }
    }

    private static String[] playersName(Player[] players) {
        String[] playersName = new String[NUMBER_OF_PLAYERS];
        for (int i = 0; i < players.length; i++) {
            playersName[i] = players[i].getName();
        }
        return playersName;
    }

    private boolean tableauNotOpen() {
        return this.tableau.containsUnknownLetters();
    }

    private void completeQuestions() {
        String q1 = "Вопрос номер один?";
        String q2 = "Вопрос номер два?";
        String q3 = "Вопрос номер три?";
        String q4 = "Вопрос номер четыре?";
//        String a1 = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        String a1 = "один";
        String a2 = "два";
        String a3 = "три";
        String a4 = "четыре";

        this.questions = new String[] {q1, q2, q3, q4};
        this.answers = new String[] {a1, a2, a3, a4};
    }
}
