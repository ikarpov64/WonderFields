package org.javaacadmey.wonder_field;

import java.util.Scanner;

public class Game {
    private final static int NUMBER_OF_PLAYERS = 3;
    private final static int NUMBER_OF_ROUNDS = 4;
    private final static int NUMBER_OF_GROUP_ROUNDS = 3;
    private final static int INDEX_OF_FINAL_ROUND = 3;

    public final static Scanner scanner = new Scanner(System.in);

    private String[] questions = new String[NUMBER_OF_ROUNDS];
    private String[] answers = new String[NUMBER_OF_ROUNDS];

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
