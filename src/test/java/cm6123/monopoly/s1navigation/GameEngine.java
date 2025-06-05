package com.cm6123.monopoly.game;

import cm6123.game.Player;
import com.cm6123.monopoly.dice.Dice;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Runs rounds of the Mini Monopoly game.
 */
public final class GameEngine {

    /** The game board used to track positions. */
    private final GameBoard board;

    /** The list of players in the game. */
    private final List<Player> players;

    /** The dice used for player movement. */
    private final Dice dice;

    /** The total number of rounds the game should run. */
    private final int totalRounds;

    /** The winner of the game, if determined. */
    private Player winner;

    /** Random number generator for player colors. */
    private final Random random = new Random();

    /**
     * Constructs a new GameEngine with board size, number of players and rounds.
     *
     * @param boardSize  the number of spaces on the board
     * @param numPlayers the number of players
     * @param rounds     the number of rounds
     */
    public GameEngine(final int boardSize, final int numPlayers, final int rounds) {
        this.board = new GameBoard(boardSize);
        this.dice = new Dice(2);
        this.totalRounds = rounds;
        this.players = new ArrayList<>();

        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player("Player " + i, new Color(random.nextInt(0xFFFFFF))));
        }
    }

    /**
     * Plays the game for the specified number of rounds.
     */
    public void playGame() {
        for (int round = 1; round <= totalRounds; round++) {
            System.out.println("\n--- Round " + round + " ---");

            for (Player player : players) {
                if (player.isBankrupt()) {
                    System.out.println(player.getName() + " is bankrupt and skips their turn.");
                    continue;
                }

                if (player.getTurnsToSkip() > 0) {
                    System.out.println(player.getName() + " is skipping turn due to court.");
                    player.decrementSkipTurns();
                    continue;
                }

                System.out.println(player.getName() + " is taking their turn.");
                dice.roll();
                int roll = dice.getTotal();
                int oldPosition = player.getPosition();
                int newPosition = board.getNewPosition(oldPosition, roll);
                player.setPosition(newPosition);

                System.out.println(player.getName() + " rolled " + roll + " and moved to position " + newPosition);

                // Passed Home
                if (newPosition < oldPosition) {
                    System.out.println("Passed Home! Collecting \u00A3200.");
                    player.addMoney(200);
                }

                // Court logic (e.g., land on tile 5)
                if (newPosition == 5) {
                    System.out.println(player.getName() + " landed on Court and must skip next turn.");
                    player.setTurnsToSkip(1);
                }

                // Congestion penalty
                long othersOnSameSpace = players.stream()
                        .filter(p -> !p.equals(player) && p.getPosition() == newPosition && !p.isBankrupt())
                        .count();
                if (othersOnSameSpace > 0) {
                    System.out.println("Too many players here! " + player.getName() + " pays \u00A350 congestion fee.");
                    player.removeMoney(50);
                }

                if (player.getBalance() < 0) {
                    player.setBankrupt(true);
                    System.out.println(player.getName() + " has gone bankrupt!");
                }
            }

            if (players.stream().filter(p -> !p.isBankrupt()).count() == 1) {
                System.out.println("Only one player left. Ending early.");
                break;
            }
        }

        this.winner = determineWinner();
    }

    /**
     * Determines and returns the winner.
     *
     * @return the winner Player or null
     */
    public Player getWinner() {
        return winner;
    }

    /**
     * Returns the list of players.
     *
     * @return players list
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Gets the final winner.
     *
     * @return the winner with the highest balance
     */
    private Player determineWinner() {
        return players.stream()
                .filter(p -> !p.isBankrupt())
                .max(Comparator.comparingInt(Player::getBalance))
                .orElse(null);
    }
}
