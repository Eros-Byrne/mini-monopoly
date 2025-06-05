package com.cm6123.monopoly.s3court;

import cm6123.game.Player;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for skipping and decrementing turns in the Player class.
 */
public class TurnTests {

    @Test
    public void testDecrementSkipTurn() {
        Player player = new Player("Test", Color.MAGENTA);
        player.setTurnsToSkip(2);
        player.decrementSkipTurns();
        assertEquals(1, player.getTurnsToSkip());
    }

    @Test
    public void testNoNegativeTurns() {
        Player player = new Player("Test", Color.CYAN);
        player.setTurnsToSkip(0);
        player.decrementSkipTurns();
        assertEquals(0, player.getTurnsToSkip());
    }
}
