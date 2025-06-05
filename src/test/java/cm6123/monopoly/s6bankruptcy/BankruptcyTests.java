package com.cm6123.monopoly.s6bankruptcy;

import cm6123.game.Player;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for checking bankruptcy logic in Player class.
 */
public class BankruptcyTests {

    @Test
    public void testPlayerBecomesBankruptWhenBalanceNegative() {
        Player player = new Player("TestName",Color.RED);
        player.removeMoney(1100); // Exceeds starting balance of 1000
        assertTrue(player.isBankrupt(), "Player should be bankrupt if balance is below 0.");
    }

    @Test
    public void testPlayerNotBankruptWhenBalancePositive() {
        Player player = new Player("TestName",Color.BLUE);
        player.removeMoney(300);
        assertFalse(player.isBankrupt(), "Player should not be bankrupt if balance is positive.");
    }

    @Test
    public void testManualBankruptSet() {
        Player player = new Player("TestName",Color.GREEN);
        player.setBankrupt(true);
        assertTrue(player.isBankrupt(), "Player should be manually marked as bankrupt.");
    }
}
