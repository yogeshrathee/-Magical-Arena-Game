package org.example.services;

import org.example.models.Player;

import java.util.Scanner;

/**
 * The ManualGame class extends the Game class to include manual input for attacks and defenses.
 */
public class ManualGame extends Game {
    private Scanner scanner;

    /**
     * Constructs a ManualGame with two players and a scanner for user input.
     *
     * @param playerA the first player
     * @param playerB the second player
     * @param scanner the scanner for user input
     */
    public ManualGame(Player playerA, Player playerB, Scanner scanner) {
        super(playerA, playerB);
        this.scanner = scanner;
    }

    /**
     * Simulates a manual attack from one player to another.
     *
     * @param attacker the player performing the attack
     * @param defender the player defending against the attack
     */
    @Override
    public void attack(Player attacker, Player defender) {
        int attackRoll = getValidRoll(attacker.getName() + "'s turn to attack. Enter attack roll (1-6) or 0 for random:");
        int defenseRoll = getValidRoll(defender.getName() + "'s turn to defend. Enter defense roll (1-6) or 0 for random:");

        if (attackRoll == 0) {
            attackRoll = dice.roll();
        }

        if (defenseRoll == 0) {
            defenseRoll = dice.roll();
        }

        int attackDamage = attacker.getAttack() * attackRoll;
        int defenseStrength = defender.getStrength() * defenseRoll;
        int damageTaken = Math.max(0, attackDamage - defenseStrength);
        defender.reduceHealth(damageTaken);

        System.out.println(attacker.getName() + " rolls " + attackRoll + ", " + defender.getName() + " rolls " + defenseRoll);
        System.out.println("Attack damage: " + attackDamage + ", Defense strength: " + defenseStrength);
        System.out.println(defender.getName() + " health reduced by " + damageTaken + " to " + defender.getHealth() + "\n");
    }

    /**
     * Prompts the user to enter a valid roll.
     *
     * @param prompt the prompt message for the user
     * @return the valid roll entered by the user
     */
    public int getValidRoll(String prompt) {
        int roll;
        while (true) {
            System.out.print(prompt);
            roll = scanner.nextInt();
            if ((roll >= 1 && roll <= 6) || roll == 0) {
                break;
            } else {
                System.out.println("Invalid roll. Please enter a number between 1 and 6, or 0 for a random roll.");
            }
        }
        return roll;
    }
}
