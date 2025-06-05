package com.cm6123.monopoly.game;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the game board consisting of looped spaces.
 */
public final class GameBoard {

    /** The number of spaces on the board. */
    private final int size;

    /** Map of property spaces indexed by their position on the board. */
    private final Map<Integer, Property> properties;

    /**
     * Constructs a new game board of a given size.
     *
     * @param boardSize the number of spaces (between 10 and 50 inclusive)
     * @throws IllegalArgumentException if boardSize is outside valid range
     */
    public GameBoard(final int boardSize) {
        if (boardSize < 10 || boardSize > 50) {
            throw new IllegalArgumentException("Board size must be 10 to 50.");
        }
        this.size = boardSize;
        this.properties = new HashMap<>();
    }

    /**
     * Gets the board size.
     *
     * @return the number of spaces on the board
     */
    public int getSize() {
        return size;
    }

    /**
     * Calculates the new position after moving a number of steps.
     *
     * @param currentPosition the current position on the board
     * @param steps           the number of steps to move forward
     * @return the new position, wrapped around the board if needed
     */
    public int getNewPosition(final int currentPosition, final int steps) {
        return (currentPosition + steps) % size;
    }

    /**
     * Adds a property to the board at a given position.
     *
     * @param position  the board index
     * @param property  the property to add
     */
    public void addProperty(final int position, final Property property) {
        if (position < 0 || position >= size) {
            throw new IllegalArgumentException("Position is out of board range.");
        }
        properties.put(position, property);
    }

    /**
     * Retrieves a property from a given position.
     *
     * @param position the board index
     * @return the property at that position or null
     */
    public Property getProperty(final int position) {
        return properties.get(position);
    }

    /**
     * Gets all the properties on the board.
     *
     * @return map of all properties
     */
    public Map<Integer, Property> getAllProperties() {
        return properties;
    }
}
