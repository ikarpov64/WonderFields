package org.javaacadmey.wonder_field;

import java.util.Arrays;
import java.util.Random;

public class MagicBox {
    private final int boxQty = 2;
    private final int[] moneyInBoxes = new int[boxQty];
    private final int money = 10000;

    public MagicBox() {
        Arrays.fill(moneyInBoxes, 0);
        this.moneyInBoxes[getRandomBox()] = this.money;
    }

    private int getRandomBox() {
        return new Random().nextInt(boxQty);
    }

    public int choosingBox(int boxNumber) {
        return moneyInBoxes[boxNumber - 1];
    }

    public int getBoxQty() {
        return boxQty;
    }
}
