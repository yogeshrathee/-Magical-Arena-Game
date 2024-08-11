package org.example.services;

import org.example.models.Player;

/**
 * The Game class manages the game logic between two players.
 */
public class Game {
    protected Player playerA;
    protected Player playerB;
    protected Dice dice;

    /**
     * Constructs a Game with two players.
     *
     * @param playerA the first player
     * @param playerB the second player
     */
    public Game(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.dice = new Dice();
    }

    /**
     * Starts the game and continues until one of the players is no longer alive.
     */
    public void start() {
        while (playerA.isAlive() && playerB.isAlive()) {
            if (playerA.getHealth() < playerB.getHealth()) {
                attack(playerA, playerB);
                if (playerB.isAlive()) {
                    attack(playerB, playerA);
                }
            } else {
                attack(playerB, playerA);
                if (playerA.isAlive()) {
                    attack(playerA, playerB);
                }
            }
        }
        displayResult();
    }

    /**
     * Simulates an attack from one player to another.
     *
     * @param attacker the player performing the attack
     * @param defender the player defending against the attack
     */
    public void attack(Player attacker, Player defender) {
        int attackRoll = dice.roll();
        int defenseRoll = dice.roll();
        int attackDamage = attacker.getAttack() * attackRoll;
        int defenseStrength = defender.getStrength() * defenseRoll;
        int damageTaken = Math.max(0, attackDamage - defenseStrength);
        defender.reduceHealth(damageTaken);

        System.out.println(attacker.getName() + " rolls " + attackRoll + ", " + defender.getName() + " rolls " + defenseRoll);
        System.out.println("Attack damage: " + attackDamage + ", Defense strength: " + defenseStrength);
        System.out.println(defender.getName() + " health reduced by " + damageTaken + " to " + defender.getHealth() + "\n");
    }

    /**
     * Displays the result of the game, indicating the winner.
     */
    protected void displayResult() {
        if (playerA.isAlive()) {
            System.out.println(playerA.getName() + " wins!");
        } else {
            System.out.println(playerB.getName() + " wins!");
        }
    }
}
