package org.javaacadmey.wonder_field;

import org.javaacadmey.wonder_field.player.Player;
import org.javaacadmey.wonder_field.player.PlayerAnswer;

public class Runner {
    public static void main(String[] args) {
//        Game game = new Game();
//        game.init();
//        Tableau tableau = new Tableau();
//        tableau.init("Четыре");
//        tableau.openWord("Четыре");
//        tableau.openLetter("е");
//        tableau.openLetter("т");
//        tableau.openLetter("ы");
//        tableau.openLetter("р");
//        tableau.openLetter("ч");
        Player player = new Player("Ivan", "Volsk");
        System.out.println(player.playerTurn());
    }
}
