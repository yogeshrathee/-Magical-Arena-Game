package org.example.services;

import java.util.Random;

/**
 * The Dice class represents a dice with a fixed number of sides used in the game.
 */
public class Dice {
    private static final int SIDES = 6;
    private Random random;

    /**
     * Constructs a Dice object with a random number generator.
     */
    public Dice() {
        this.random = new Random();
    }

    /**
     * Rolls the dice and returns a random number between 1 and the number of sides.
     *
     * @return the result of the dice roll
     */
    public int roll() {
        return random.nextInt(SIDES) + 1;
    }
}
