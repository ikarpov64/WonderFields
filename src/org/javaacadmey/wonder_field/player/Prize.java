package org.javaacadmey.wonder_field.player;

public class Prize {
    private int prizeValue;
    private String prizeName;

    public Prize(int prizeValue, String prizeName) {
        this.prizeValue = prizeValue;
        this.prizeName = prizeName;
    }

    public int getPrizeValue() {
        return prizeValue;
    }

    public String getPrizeName() {
        return prizeName;
    }
}
