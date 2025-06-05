package com.cm6123.monopoly.game;

/**
 * Utility class for input and game state validation.
 */
public final class ValidationUtils {

    /**
     * Private constructor to prevent instantiation.
     */
    private ValidationUtils() {
        // Utility class
    }

    /**
     * Checks whether a board size is valid.
     *
     * @param size the board size to check
     * @return true if between 10 and 50 inclusive
     */
    public static boolean isValidBoardSize(final int size) {
        return size >= 10 && size <= 50;
    }

    /**
     * Checks if a property cost is valid (non-negative).
     *
     * @param cost the cost to check
     * @return true if the cost is zero or positive
     */
    public static boolean isValidPropertyCost(final int cost) {
        return cost >= 0;
    }

    /**
     * Validates that a board position is within range.
     *
     * @param position the position to check
     * @param boardSize the total size of the board
     * @return true if 0 <= position < boardSize
     */
    public static boolean isValidBoardPosition(final int position, final int boardSize) {
        return position >= 0 && position < boardSize;
    }

    /**
     * Attempts to parse an integer from a string.
     *
     * @param value the input string
     * @return the parsed Integer or null if invalid
     */
    public static Integer tryParseInt(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Validates that a number is within a specific inclusive range.
     *
     * @param min minimum value
     * @param max maximum value
     * @param value value to check
     * @return true if min <= value <= max
     */
    public static boolean validateIntRange(final int min, final int max, final int value) {
        return value >= min && value <= max;
    }
}
