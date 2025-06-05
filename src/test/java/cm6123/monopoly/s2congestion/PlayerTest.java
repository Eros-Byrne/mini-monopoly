package com.cm6123.monopoly.s2congestion;

import cm6123.game.Player;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Player class covering money, turns, and bankruptcy.
 */
public class PlayerTest {

    @Test
    public void testAddAndSubtractMoney() {
        Player player = new Player("Test", Color.RED);
        int initial = player.getBalance();

        player.addMoney(100);
        assertEquals(initial + 100, player.getBalance());

        player.subtractMoney(50);
        assertEquals(initial + 50, player.getBalance());
    }

    @Test
    public void testSkipTurnLogic() {
        Player player = new Player("Test", Color.BLUE);
        player.skipTurns(2);
        assertEquals(2, player.getTurnsToSkip());

        player.decrementSkipTurns();
        assertEquals(1, player.getTurnsToSkip());
    }

    @Test
    public void testManualBankruptcy() {
        Player player = new Player("Test", Color.GREEN);
        assertFalse(player.isBankrupt());
        player.setBankrupt(true);
        assertTrue(player.isBankrupt());
    }
}
