package org.example;

import org.example.models.Player;
import org.example.services.Game;
import org.example.services.ManualGame;

import java.util.Scanner;

/**
 * The Main class serves as the entry point for the Magical Arena game.
 * It initializes the game, allows the user to choose between manual and automatic modes,
 * and starts the game based on the selected mode.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to choose the game mode
        System.out.println("Choose mode: \n\s\s==>> (1) Manual \n\s\s==>> (2) Auto");
        int mode = scanner.nextInt();
        scanner.nextLine();  // consume the newline

        Player playerA;
        Player playerB;

        if (mode == 1) {
            // Manual mode: Get player attributes from user input
            String nameA = "Player A";
            System.out.println(nameA);
            System.out.print("\s\shealth :: ");
            int healthA = scanner.nextInt();
            System.out.print("\s\sstrength :: ");
            int strengthA = scanner.nextInt();
            System.out.print("\s\sattack :: ");
            int attackA = scanner.nextInt();
            playerA = new Player(nameA, healthA, strengthA, attackA);

            System.out.println();

            String nameB = "Player B";
            System.out.println(nameB);
            System.out.print("\s\shealth :: ");
            int healthB = scanner.nextInt();
            System.out.print("\s\sstrength :: ");
            int strengthB = scanner.nextInt();
            System.out.print("\s\sattack :: ");
            int attackB = scanner.nextInt();
            playerB = new Player(nameB, healthB, strengthB, attackB);

            // Start the game in manual mode
            ManualGame manualGame = new ManualGame(playerA, playerB, scanner);
            manualGame.start();
        } else {
            // Auto mode: Use default player attributes
            playerA = new Player("Player A", 50, 5, 10);
            playerB = new Player("Player B", 100, 10, 5);

            // Start the game in auto mode
            Game game = new Game(playerA, playerB);
            game.start();
        }
    }
}
