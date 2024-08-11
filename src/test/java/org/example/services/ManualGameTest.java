package org.example.services;

import org.example.models.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the ManualGame class.
 * This class contains unit tests to verify the functionality of the ManualGame class.
 */
class ManualGameTest {
    private Player playerA;
    private Player playerB;
    private ManualGame manualGame;

    /**
     * Sets up the test environment before each test.
     * Initializes two Player objects.
     */
    @BeforeEach
    void setUp() {
        playerA = new Player("Player A", 50, 5, 10);
        playerB = new Player("Player B", 100, 10, 5);
    }

    /**
     * Tests the attack method with valid user input for attack and defense rolls.
     * Verifies that the defender's health is reduced correctly.
     */
    @Test
    void testManualAttackWithValidInput() {
        String input = "5\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        manualGame = new ManualGame(playerA, playerB, scanner);

        manualGame.attack(playerA, playerB);
        assertEquals(70, playerB.getHealth()); // Player B health should be reduced by 30
    }

    /**
     * Tests the attack method with random user input for attack and defense rolls.
     * Verifies that the defender's health is reduced or equals initial health.
     */
    @Test
    void testManualAttackWithRandomInput() {
        String input = "0\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        manualGame = new ManualGame(playerA, playerB, scanner);

        manualGame.attack(playerA, playerB);
        assertTrue(playerB.getHealth() <= 100); // Player B health should be reduced or equals
    }

    /**
     * Tests the getValidRoll method with invalid user input.
     * Verifies that the method prompts again until a valid input is provided.
     */
    @Test
    void testGetValidRollWithInvalidInput() {
        String input = "10\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        manualGame = new ManualGame(playerA, playerB, scanner);

        int roll = manualGame.getValidRoll("Enter roll:");
        assertEquals(3, roll); // Should prompt again and accept valid roll 3
    }

    /**
     * Tests that the attack method does not reduce health if the defense is stronger.
     * Verifies that the defender's health remains the same if the attack is not strong enough.
     */
    @Test
    void testAttackNoDamageIfDefenseIsStronger() {
        playerA = new Player("Player A", 50, 20, 1); // High defense
        playerB = new Player("Player B", 50, 1, 1);  // Low attack
        String input = "1\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        manualGame = new ManualGame(playerA, playerB, scanner);

        manualGame.attack(playerB, playerA);
        assertEquals(50, playerA.getHealth());
    }

    /**
     * Tests that the game correctly ends when one player's health reaches zero.
     * Verifies that the game does not continue indefinitely.
     */
    @Test
    void testGameEndsWhenPlayerHealthIsZero() {
        playerA = new Player("Player A", 10, 1, 2);
        playerB = new Player("Player B", 10, 1, 2);
        String input = "6\n1\n6\n1\n6\n1\n"; // Simulate input for attack rolls
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        manualGame = new ManualGame(playerA, playerB, scanner);

        manualGame.start();

        // Ensure that the game stops when one player reaches zero health
        assertFalse(playerA.isAlive() && playerB.isAlive(), "Both players are still alive, game should have ended.");
    }
}
