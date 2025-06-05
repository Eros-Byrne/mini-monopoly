package com.cm6123.monopoly.s6bankruptcy;

import com.cm6123.monopoly.game.GameEngine;
import cm6123.game.Player;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for game-level logic including early termination and winner selection.
 */
public class GameTests {

    /**
     * Ensure the game ends early when only one player is not bankrupt.
     */
    @Test
    public void testGameEndsEarlyWhenOnePlayerLeft() {
        GameEngine engine = new GameEngine(10, 2, 100);
        List<Player> players = engine.getPlayers();

        Player p1 = players.get(0);
        Player p2 = players.get(1);

        p1.setBankrupt(true);

        engine.playGame();

        Player winner = engine.getWinner();
        assertNotNull(winner, "There should be a winner.");
        assertFalse(winner.isBankrupt(), "Winner should not be bankrupt.");
        assertEquals(p2.getName(), winner.getName(), "Remaining player should be the winner.");
    }

    /**
     * Ensure the player with the highest money wins.
     */
    @Test
    public void testWinnerIsPlayerWithMostMoney() {
        GameEngine engine = new GameEngine(10, 3, 1);
        List<Player> players = engine.getPlayers();

        Player p1 = players.get(0);
        Player p2 = players.get(1);
        Player p3 = players.get(2);

        p1.addMoney(500);
        p2.addMoney(300);
        p3.setBankrupt(true);

        engine.playGame();

        Player winner = engine.getWinner();
        assertNotNull(winner, "There should be a winner.");
        assertEquals(p1.getName(), winner.getName(), "Player with the most money should be the winner.");
    }
}
