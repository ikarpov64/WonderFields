package org.javaacadmey.wonder_field;

import static org.javaacadmey.wonder_field.player.AnswerType.*;
import org.javaacadmey.wonder_field.player.PlayerAnswer;

public class Yakubovich {
    private static final String name = "Якубович";

    public void greetings() {
        String greetings = "Здравствуйте, уважаемые дамы и господа! Пятница! В эфире капитал-шоу 'Поле чудес'!";
        System.out.printf("%s: %s\n", name, greetings);
    }

    public void farewell() {
        String farewell = "Мы прощаемся с вами ровно на одну неделю! Здоровья вам, до встречи!";
        System.out.printf("%s: %s\n", name, farewell);
    }

    public void invitingPlayers(String[] players, int numberOfRound) {
        if (numberOfRound != 3) {
            String speech = "%s: приглашаю %s тройку игроков: %s\n";
            System.out.printf(speech, name, numberOfRound + 1, stringOfPlayersName(players));
        } else {
            String speech = "%s: приглашаю победителей групповых этапов: %s\n";
            System.out.printf(speech, name, stringOfPlayersName(players));
        }
    }

    public void askingQuestion(String question) {
        System.out.printf("%s: Внимание вопрос!\n%s\n", name, question);
    }

    public void shoutAboutVictory(String playerName, String city, boolean isFinalRound) {
        if (isFinalRound) {
            String finalRound = "%s: И перед нами победитель капитал-шоу 'Поле чудес'! Это %s из города %s";
            System.out.printf(finalRound, name, playerName, city);
        } else {
            String round = "%s: Молодец! %s из %s проходит в финал!";
            System.out.printf(round, name, playerName, city);
        }
    }

    public boolean checkPlayerAnswer(PlayerAnswer playerAnswer, String answer, Tableau tableau) {
        boolean correctAnswer = false;
        if (playerAnswer.getAnswerType().equals(ANSWER_TYPE.getLetter())) {
            if (playerAnswer.getAnswer().equals(answer)) {
                System.out.printf("%s: %s! Абсолютно верно!", name, answer);
                tableau.openWord(answer);
                System.out.println("__________________________________");
                correctAnswer = true;
            } else {
                System.out.printf("%s: Неверно! Следующий игрок!", name);
            }

        } else if (playerAnswer.getAnswerType().equals(ANSWER_TYPE.getWord())) {
            if (playerAnswer.getAnswer().contains(answer)) {
                String speech = "Есть такая буква, откройте ее!";
                System.out.printf("%s: %s!\n", name, speech);
                tableau.openLetter(answer);
                correctAnswer = true;
            } else {
                String speech = "Нет такой буквы! Следующий игрок, крутите барабан!";
                System.out.printf("%s: %s\n", name, speech);
            }
        } else {
            System.out.println("Что-то пошло не так.");
        }

        System.out.println("__________________________________");
        return correctAnswer;
    }

    public static String stringOfPlayersName(String[] playersName) {
        return String.format("%s, %s, %s", playersName[0], playersName[1], playersName[2]);
    }
}
