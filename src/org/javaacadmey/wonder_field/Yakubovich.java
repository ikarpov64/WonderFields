package org.javaacadmey.wonder_field;

import org.javaacadmey.wonder_field.player.Player;
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

    }

    public void askingQuestion(String question) {
        System.out.printf("%s: Внимание вопрос!\n%s", name, question);
    }

    public void shoutAboutVictory(String playerName, String city, boolean isFinalRound) {
        if (isFinalRound) {
            String finalRound = "%s: И перед нами победитель Капитал шоу поле чудес! Это %s из города %s";
            System.out.printf(finalRound, name, playerName, city);
        } else {
            String round = "%s: Молодец! %s из %s проходит в финал!";
            System.out.printf(round, name, playerName, city);
        }
    }

    public void checkPlayerAnswer(PlayerAnswer playerAnswer, String answer, Tableau tableau) {
        if (answer.length() == 1) {
            tableau.openLetter(answer);
        } else {
            tableau.openWord(answer);
        }
    }
}
