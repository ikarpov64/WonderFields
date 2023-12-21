package org.javaacadmey.wonder_field;

public class Runner {
    public static void main(String[] args) {
//        Game game = new Game();
//        game.init();
        Tableau tableau = new Tableau("Четыре");
        tableau.openWord("Четыре");
        tableau.openLetter("е");
        tableau.openLetter("т");
        tableau.openLetter("ы");
        tableau.openLetter("р");
        tableau.openLetter("ч");

    }
}
