package org.example.snakeLadder;

import java.util.Random;

public class Dice {
    private final Random random = new Random();
    private DiceType diceType;

    public Dice(DiceType diceType) {
        this.diceType = diceType;
    }

    public int roll(){
        if(DiceType.NORMAL.equals(diceType)){
            return random.nextInt(6) +1;
        } else {
            int randomNumber = random.nextInt(3); //
            return (randomNumber * 2) + 1;
        }
    }
}
