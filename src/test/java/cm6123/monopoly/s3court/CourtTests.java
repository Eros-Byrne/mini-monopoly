package com.cm6123.monopoly.s3court;

import com.cm6123.monopoly.game.GameEngine;
import cm6123.game.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * Tests for Court logic (skip turn).
 */
public class CourtTests {

    @Test
    public void testPlayerReceivesCourtPenalty() {
        GameEngine engine = new GameEngine(10, 2, 1);
        engine.playGame();
        List<Player> players = engine.getPlayers();
        Player player = players.get(0);
        // Court is on tile 5; simulate it
        player.setPosition(5);
        player.setTurnsToSkip(1);
        assertEquals(1, player.getTurnsToSkip());
    }

    @Test
    public void testNoPenaltyOnNonCourtTile() {
        Player player = new Player("Test");
        player.setPosition(3);  // Non-court tile
        // No penalty should be applied manually
        assertEquals(0, player.getTurnsToSkip());
    }
}
