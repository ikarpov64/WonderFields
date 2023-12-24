package org.javaacadmey.wonder_field;

import org.javaacadmey.wonder_field.player.Player;
import org.javaacadmey.wonder_field.player.Prize;

public class Runner {
    public static void main(String[] args) {
//        Game game = new Game();
//        game.init();
//        game.startGame();
        Player player = new Player("Иван", "Вольск");
        player.setScores(8000);
        Prize[] prizes = {new Prize(1000, "Мышка"),
                new Prize(800, "клавиатура")};
        player.choosePrizes(prizes);
    }
}
