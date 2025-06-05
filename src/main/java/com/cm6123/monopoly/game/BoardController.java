package com.cm6123.monopoly.game;

import com.cm6123.monopoly.dice.Dice;
import cm6123.game.Player;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Controls the board and player logic for each round.
 */
public final class BoardController {

    /** The list of players in the game. */
    private final List<Player> players;

    /** The game board being used. */
    private final GameBoard board;

    /** The dice object used to roll for movement. */
    private final Dice dice;

    /** List of properties on the board. */
    private final List<Property> properties;

    /** Index of the player whose turn it currently is. */
    private int currentPlayerIndex;

    /**
     * Constructs a BoardController with a board and number of players.
     *
     * @param gameBoard  the board
     * @param numPlayers number of players
     */
    public BoardController(final GameBoard gameBoard, final int numPlayers) {
        this.board = gameBoard;
        this.dice = new Dice(2);
        this.players = new ArrayList<>();
        this.properties = new ArrayList<>();
        this.currentPlayerIndex = 0;

        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player("Player " + (i + 1), new Color((int) (Math.random() * 0x1000000))));
        }

        // Add default properties at every even position starting from 2
        for (int pos = 2; pos < board.getSize(); pos += 2) {
            properties.add(new Property("Property " + pos, pos, 300));
        }
    }

    /**
     * Gets the current player.
     *
     * @return the player whose turn it is
     */
    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    /**
     * Gets the list of players.
     *
     * @return the list of all players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Advances to the next player's turn.
     */
    public void nextTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    /**
     * Gets the dice object used for rolling.
     *
     * @return the dice
     */
    public Dice getDice() {
        return dice;
    }

    /**
     * Gets the game board.
     *
     * @return the game board
     */
    public GameBoard getBoard() {
        return board;
    }

    /**
     * Gets the list of all properties.
     *
     * @return list of board properties
     */
    public List<Property> getProperties() {
        return properties;
    }

    /**
     * Counts how many players are currently on the given board position.
     *
     * @param position the position to check
     * @return the number of players on that position
     */
    public int countPlayersOnSpace(final int position) {
        int count = 0;
        for (Player player : players) {
            if (player.getPosition() == position && !player.isBankrupt()) {
                count++;
            }
        }
        return count;
    }
}
