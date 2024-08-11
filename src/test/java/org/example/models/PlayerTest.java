package org.example.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Player class.
 * This class contains unit tests to verify the functionality of the Player class.
 */
class PlayerTest {

    /**
     * Tests the initialization of the Player object.
     * Verifies that the player's attributes are set correctly upon initialization.
     */
    @Test
    void testPlayerInitialization() {
        Player player = new Player("Test Player", 100, 10, 20);
        assertEquals("Test Player", player.getName());
        assertEquals(100, player.getHealth());
        assertEquals(10, player.getStrength());
        assertEquals(20, player.getAttack());
    }

    /**
     * Tests the reduceHealth method of the Player class.
     * Verifies that the player's health is reduced correctly and does not go below zero.
     */
    @Test
    void testReduceHealth() {
        Player player = new Player("Test Player", 100, 10, 20);
        player.reduceHealth(30);
        assertEquals(70, player.getHealth());
        player.reduceHealth(70);
        assertEquals(0, player.getHealth());
    }

    /**
     * Tests the reduceHealth method when damage is greater than the player's current health.
     * Verifies that the player's health is reduced to zero and not negative.
     */
    @Test
    void testReduceHealthBeyondZero() {
        Player player = new Player("Test Player", 50, 10, 20);
        player.reduceHealth(60);
        assertEquals(0, player.getHealth());
    }

    /**
     * Tests the isAlive method of the Player class.
     * Verifies that the method returns true when the player's health is above zero and false when it is zero or below.
     */
    @Test
    void testIsAlive() {
        Player player = new Player("Test Player", 50, 10, 20);
        assertTrue(player.isAlive());
        player.reduceHealth(50);
        assertFalse(player.isAlive());
    }

    /**
     * Tests the toString method of the Player class.
     * Verifies that the method returns the player's name.
     */
    @Test
    void testToString() {
        Player player = new Player("Test Player", 50, 10, 20);
        assertEquals("Test Player", player.toString());
    }
}
