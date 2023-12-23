package org.javaacadmey.wonder_field.wheel;

import org.javaacadmey.wonder_field.Yakubovich;
import java.util.Random;

public class Wheel {
    private final static int START_SCORE_VALUE = 100;
    private final static int END_SCORE_VALUE = 1200;
    private final static int STEP_SCORE_VALUE = 100;
    private final static int MULTIPLIER_VALUE = 2;
    private final static int NUMBER_OF_SCORE_SECTORS =
            (END_SCORE_VALUE - START_SCORE_VALUE) / STEP_SCORE_VALUE + 1;
    private final static int NUMBER_OF_SECTORS = NUMBER_OF_SCORE_SECTORS + 2;
    private final static int MULTIPLIER_SECTOR_NUMBER = NUMBER_OF_SECTORS;
    private final static int SKIP_SECTOR_NUMBER = NUMBER_OF_SECTORS - 1;

    private final int[] scoreSectors = new int[NUMBER_OF_SCORE_SECTORS];

    public Wheel() {
        for (int i = 0, value = START_SCORE_VALUE;
             i < NUMBER_OF_SCORE_SECTORS;
             i ++, value += STEP_SCORE_VALUE) {
             this.scoreSectors[i] = value;
        }
    }

    private int getSectorNumber() {
        return new Random().nextInt(NUMBER_OF_SECTORS) + 1;
    }

    public int rotateWheel(int scores, Yakubovich yakubovich) {
        int sectorNumber = getSectorNumber();
        if (sectorNumber == SKIP_SECTOR_NUMBER) {
            yakubovich.skippingMoveSectorOnWheelSpeech();
        } else if (sectorNumber == MULTIPLIER_SECTOR_NUMBER) {
            yakubovich.multiplierSectorOnWheelSpeech();
            scores *= MULTIPLIER_VALUE;
        } else {
            yakubovich.scoreSectorOnWheelSpeech(scoreSectors[sectorNumber - 1]);
            scores += scoreSectors[sectorNumber - 1];
        }
        return scores;
    }
}
