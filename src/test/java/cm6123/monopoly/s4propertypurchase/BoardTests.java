package com.cm6123.monopoly.s4propertypurchase;

import com.cm6123.monopoly.game.GameBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the GameBoard class.
 */
public class BoardTests {

    @Test
    public void testBoardSizeIsValid() {
        GameBoard board = new GameBoard(20);
        assertEquals(20, board.getSize());
    }

    @Test
    public void testBoardSizeThrowsExceptionWhenTooSmall() {
        assertThrows(IllegalArgumentException.class, () -> {
            new GameBoard(5);
        });
    }

    @Test
    public void testBoardSizeThrowsExceptionWhenTooLarge() {
        assertThrows(IllegalArgumentException.class, () -> {
            new GameBoard(100);
        });
    }

    @Test
    public void testGetNewPositionWrapsCorrectly() {
        GameBoard board = new GameBoard(10);
        int newPosition = board.getNewPosition(8, 5);
        assertEquals(3, newPosition);  // 8 + 5 = 13 % 10 = 3
    }

    @Test
    public void testGetNewPositionNoWrapNeeded() {
        GameBoard board = new GameBoard(10);
        int newPosition = board.getNewPosition(2, 4);
        assertEquals(6, newPosition);
    }
}
