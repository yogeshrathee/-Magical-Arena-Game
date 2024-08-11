package org.example.models;

/**
 * The Player class represents a player in the Magical Arena game.
 * It contains information about the player's name, health, strength, and attack.
 */
public class Player {
    private String name;
    private int health;
    private int strength;
    private int attack;

    /**
     * Constructs a Player with the specified name, health, strength, and attack values.
     *
     * @param name the name of the player
     * @param health the health points of the player
     * @param strength the strength attribute of the player
     * @param attack the attack attribute of the player
     */
    public Player(String name, int health, int strength, int attack) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    /**
     * Returns the name of the player.
     *
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the health points of the player.
     *
     * @return the health points of the player
     */
    public int getHealth() {
        return health;
    }

    /**
     * Returns the strength attribute of the player.
     *
     * @return the strength attribute of the player
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Returns the attack attribute of the player.
     *
     * @return the attack attribute of the player
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Reduces the health of the player by the specified damage amount.
     *
     * @param damage the amount of damage to reduce the health by
     */
    public void reduceHealth(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    /**
     * Checks if the player is still alive.
     *
     * @return true if the player's health is greater than zero, false otherwise
     */
    public boolean isAlive() {
        return this.health > 0;
    }

    /**
     * Returns the name of the player as a string representation.
     *
     * @return the name of the player
     */
    @Override
    public String toString() {
        return this.name;
    }
}
