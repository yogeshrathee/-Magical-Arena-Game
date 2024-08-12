# Magical Arena Game
Magical Arena is a turn-based strategy game where two players engage in a magical battle. The game is implemented in Java and features a console-based interface.

============================================================================================
# For a comprehensive overview of the project execution, please watch the full walkthrough on YouTube:
[![Project Execution Demo](https://img.youtube.com/vi/l16lrGbRxhg/0.jpg)](https://youtu.be/l16lrGbRxhg?si=I9vz2oYtexIpsKiE)

============================================================================================

## Problem Statement
Design a Magical Arena. Every Player is defined by a “health” attribute, “strength” attribute and an “attack” attribute - all positive integers. The player dies if his health attribute touches 0. 
Any two player can fight a match in the arena. Players attack in turns. Attacking player rolls the attacking dice and the defending player rolls the defending dice. The “attack”  value multiplied by the outcome of the  attacking dice roll is the damage created by the attacker. The defender “strength” value, multiplied by the outcome of the defending dice is the damage defended by the defender. Whatever damage created by attacker which is in excess of the damage defended by the defender will reduce the “health” of the defender. Game ends when any players health reaches 0

* Player with lower health attacks first at the start of a match. 

* Assume two players . Player A 50 health 5 strength 10 attack Player B 100 health 10 stregnth and 5 attack . Attacking die and Defending die are both 6 sided die with values ranging from 1- 6

* Player A attacks and rolls die. Die roll : 5 . Player B defends and rolls die. Die roll 2

  + Attack damage is 5 * 10 = 50 ; Defending strength = 10 * 2 = 20 ; Player B health reduced by 30 to 70

* Player B attacks and rolls die. Die roll : 4. Player A defends and rolls die. Die Roll 3

  + Attack damage is 4 * 5 = 20 ; Defending strength = 5 * 3 = 15 ; Player A health reduced by 5 to 45

* And so on


## Features
* Two game modes: Auto and Manual
* Players can choose their attributes: health, strength, and attack
* Game logic handles attacks, defenses, and health reduction
* Game ends when one player's health reaches zero

## Classes and Packages
* `org.example.models`: Player class represents a player in the game
* `org.example.services`: Game and ManualGame classes manage the game logic
* `org.example`: Main class serves as the entry point for the game

## Testing
* JUnit tests are provided for each class to ensure functionality and correctness
* Test cases cover various scenarios, including:
	+ Player initialization and attribute setting
	+ Attack and defense logic
	+ Game ending conditions
	+ Manual mode input handling

### Test Cases

#### PlayerTest
* `testPlayerInitialization`: Verifies that a player is initialized correctly with given attributes
* `testReduceHealth`: Verifies that a player's health is reduced correctly when attacked
* `testIsAlive`: Verifies that a player's alive status is updated correctly based on health
* `testToString`: Verifies that a player's string representation is correct

#### GameTest
* `testGameInitialization`: Verifies that a game is initialized correctly with two players
* `testStart`: Verifies that the game starts correctly and at least one player is alive
* `testAttack`: Verifies that an attack reduces the defender's health correctly
* `testGameEndsWhenPlayerHealthIsZero`: Verifies that the game ends when one player's health reaches zero

#### ManualGameTest
* `testManualAttackWithValidInput`: Verifies that a manual attack reduces the defender's health correctly with valid input
* `testManualAttackWithRandomInput`: Verifies that a manual attack reduces the defender's health correctly with random input
* `testGetValidRollWithInvalidInput`: Verifies that the `getValidRoll` method prompts again until a valid input is provided
* `testAttackNoDamageIfDefenseIsStronger`: Verifies that an attack does not reduce health if the defense is stronger
* `testGameEndsWhenPlayerHealthIsZero`: Verifies that the game ends when one player's health reaches zero in manual mode

## Requirements
* Java 8 or higher
* JUnit 5 or higher for testing

## Authors
  Yogesh Rathee
  https://www.linkedin.com/in/yogesh-425b20279


