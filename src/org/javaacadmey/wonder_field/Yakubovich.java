package org.javaacadmey.wonder_field;

import static org.javaacadmey.wonder_field.player.AnswerType.*;

import org.javaacadmey.wonder_field.player.Player;
import org.javaacadmey.wonder_field.player.PlayerAnswer;

public class Yakubovich {
    private static final String name = "Якубович";

    public void greetings() {
        String greetings = "Здравствуйте, уважаемые дамы и господа! "
                + "Пятница! В эфире капитал-шоу 'Поле чудес'!";
        System.out.printf("%s: %s\n", name, greetings);
    }

    public void farewell() {
        String farewell = "Мы прощаемся с вами ровно на одну неделю! Здоровья вам, до встречи!";
        System.out.printf("%s: %s\n", name, farewell);
    }

    public void invitingPlayers(String[] players, int numberOfRound) {
        if (numberOfRound != Game.INDEX_OF_FINAL_ROUND) {
            String speech = "%s: приглашаю %s тройку игроков: %s\n";
            System.out.printf(speech, name, numberOfRound + 1, stringOfPlayersName(players));
        } else {
            String speech = "%s: приглашаю победителей групповых этапов: %s\n";
            System.out.printf(speech, name, stringOfPlayersName(players));
        }
    }

    public void skippingMoveSectorOnWheelSpeech() {
        System.out.printf("%s: Сектор 'Пропуск хода' на барабане!\n", name);
    }

    public void multiplierSectorOnWheelSpeech() {
        System.out.printf("%s: Сектор 'Умножения очков' на барабане!\n", name);
    }

    public void magicBoxSpeech(Player player, MagicBox magicBox) {
        String speech = "%s: %s поздравляю! Вы правильно угадали 3 буквы, вам положено %s шкатулки.\n";
        System.out.printf(speech, name, player.getName(), magicBox.getBoxQty());
    }

    public void scoreSectorOnWheelSpeech(int score) {
        System.out.printf("%s: На барабане %s очков!\n", name, score);
    }

    public void askingQuestion(String question) {
        System.out.printf("%s: Внимание вопрос!\n'%s'\n", name, question);
    }

    public void shoutAboutVictory(Player player, boolean isFinalRound) {
        if (isFinalRound) {
            String finalRound = "%s: И перед нами победитель капитал-шоу 'Поле чудес'! "
                    + "Со счетом %s очков, и с суммой %s рублей. Это %s из города %s.\n";
            System.out.printf(finalRound, name, player.getScores(),
                    player.getMoneyWin(), player.getName(), player.getCity());
        } else {
            String round = "%s: Молодец! %s из %s проходит в финал!\n";
            System.out.printf(round, name, player.getName(), player.getCity());
        }
    }

    public boolean checkPlayerAnswer(PlayerAnswer playerAnswer, String answer, Tableau tableau) {
        boolean correctAnswer = false;
        if (playerAnswer.getAnswerType().equals(ANSWER_TYPE.getWord())) {
            if (answer.toLowerCase().equals(playerAnswer.getAnswer())) {
                System.out.printf("%s: %s! Абсолютно верно!\n", name, answer);
                tableau.openWord(answer);
                correctAnswer = true;
            } else {
                System.out.printf("%s: Неверно! Следующий игрок!\n", name);
            }
        } else if (playerAnswer.getAnswerType().equals(ANSWER_TYPE.getLetter())) {
            if (answer.contains(playerAnswer.getAnswer())
                    && !tableau.containsLetters(playerAnswer.getAnswer())) {
                String speech = "Есть такая буква, откройте ее!";
                System.out.printf("%s: %s\n", name, speech);
                tableau.openLetter(playerAnswer.getAnswer());
                correctAnswer = true;
            } else {
                String speech = "Нет такой буквы! Следующий игрок, крутите барабан!";
                System.out.printf("%s: %s\n", name, speech);
            }
        } else {
            System.out.println("Некорректный ввод, повторите.");
        }
        System.out.println("__________________________________");
        return correctAnswer;
    }

    public static String stringOfPlayersName(String[] playersName) {
        return String.format("%s, %s, %s", playersName[0], playersName[1], playersName[2]);
    }

    public void magicBoxIsOpenSpeech(String playerName, int money) {
        if (money != 0) {
            System.out.printf("%s: %s поздравляю! Вы выиграли %s рублей.\n",
                    name, playerName, money);
        } else {
            System.out.printf("%s: К сожалению шкатулка пуста! Продолжаем игру.\n", name);
        }
    }
}
