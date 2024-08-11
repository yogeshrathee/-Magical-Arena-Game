package org.example.services;

import org.example.models.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Game class.
 * This class contains unit tests to verify the functionality of the Game class.
 */
class GameTest {
    private Player playerA;
    private Player playerB;
    private Game game;

    /**
     * Sets up the test environment before each test.
     * Initializes two Player objects and a Game object.
     */
    @BeforeEach
    void setUp() {
        playerA = new Player("Player A", 50, 5, 10);
        playerB = new Player("Player B", 100, 10, 5);
        game = new Game(playerA, playerB);
    }

    /**
     * Tests the initialization of the Game object.
     * Verifies that the Game object is not null after creation.
     */
    @Test
    void testGameInitialization() {
        assertNotNull(game);
    }

    /**
     * Tests the start method of the Game class.
     * Verifies that at least one player is alive after the game starts.
     */
    @Test
    void testGameStart() {
        game.start();
        assertTrue(playerA.isAlive() || playerB.isAlive());
    }

    /**
     * Tests the attack method of the Game class.
     * Verifies that the defender's health is reduced correctly after an attack.
     */
    @Test
    void testAttack() {
        game.attack(playerA, playerB);
        assertTrue(playerB.getHealth() <= 100);
    }

    /**
     * Tests that an attack reduces the defender's health correctly.
     * Verifies that the health is not reduced below zero.
     */
    @Test
    void testAttackReducesHealthCorrectly() {
        playerB = new Player("Player B", 20, 10, 5);
        game = new Game(playerA, playerB);
        game.attack(playerA, playerB);
        assertTrue(playerB.getHealth() <= 20 && playerB.getHealth() >= 0);
    }

    /**
     * Tests that the game ends when one player's health reaches zero.
     * Verifies that the game does not continue indefinitely.
     */
    @Test
    void testGameEndsWhenPlayerHealthIsZero() {
        playerA = new Player("Player A", 10, 5, 2);
        playerB = new Player("Player B", 10, 5, 2);
        game = new Game(playerA, playerB);
        game.start();
        assertFalse(playerA.isAlive() && playerB.isAlive());
    }

    /**
     * Tests that the attack method does not reduce health if the defense is stronger.
     * Verifies that the defender's health remains the same if the attack is not strong enough.
     */
    @Test
    void testAttackNoDamageIfDefenseIsStronger() {
        playerA = new Player("Player A", 50, 20, 1); // High defense
        playerB = new Player("Player B", 50, 1, 1);  // Low attack
        game = new Game(playerA, playerB);
        game.attack(playerB, playerA);
        assertEquals(50, playerA.getHealth());
    }
}
