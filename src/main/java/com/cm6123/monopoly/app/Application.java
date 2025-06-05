package com.cm6123.monopoly.app;

import com.cm6123.monopoly.game.GameEngine;
import com.cm6123.monopoly.game.ValidationUtils;
import cm6123.game.Player;
import cm6123.game.Welcome;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Application entry point for Mini Monopoly.
 */
public final class Application {

    /**
     * Logger for the Application class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    /**
     * Scanner for user input.
     */
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Private constructor to prevent instantiation.
     */
    private Application() {
        // Not used
    }

    /**
     * Main entry point. Prompts for input and starts game.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        LOGGER.info("Application started with args: {}", String.join(",", args));

        // Add early exit for test mode to prevent Scanner blocking
        if (args.length > 0 && "test".equals(args[0])) {
            LOGGER.info("Running in test mode. Skipping gameplay.");
            return;
        }

        Welcome welcome = new Welcome();
        System.out.println(welcome.getWelcomeMessage());

        int numPlayers = promptForInt("Enter number of players (2-10): ", 2, 10);
        int boardSize = promptForInt("Enter board size (10-50): ", 10, 50);
        int rounds = promptForInt("Enter number of rounds (1-50): ", 1, 50);

        GameEngine game = new GameEngine(boardSize, numPlayers, rounds);

        System.out.println("\nGame starting with " + numPlayers + " players on a "
                + boardSize + "-space board for " + rounds + " rounds.\n");

        game.playGame();

        Player winner = game.getWinner();
        System.out.println("Game over!");

        if (winner != null && !winner.isBankrupt()) {
            System.out.println("Winner: " + winner.getName() + " with \u00A3" + winner.getBalance());
        } else {
            System.out.println("No winner could be determined.");
        }

        LOGGER.info("Application closing");
    }

    /**
     * Prompt user for a valid int within bounds.
     *
     * @param message prompt message
     * @param min     minimum allowed value
     * @param max     maximum allowed value
     * @return valid int entered by user
     */
    private static int promptForInt(final String message, final int min, final int max) {
        while (true) {
            System.out.print(message);
            String input = SCANNER.nextLine();
            Integer parsed = ValidationUtils.tryParseInt(input);
            if (parsed != null && ValidationUtils.validateIntRange(min, max, parsed)) {
                return parsed;
            }
            System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
        }
    }
}
