package com.cm6123.monopoly.s2congestion;

import com.cm6123.monopoly.game.BoardController;
import com.cm6123.monopoly.game.GameBoard;
import cm6123.game.Player;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test congestion penalty logic in the game.
 */
public class CongestionPenaltyTest {

    /**
     * Ensure multiple players on one space are detected.
     */
    @Test
    public void testCongestionCount() {
        BoardController controller = new BoardController(new GameBoard(10), 2);
        List<Player> players = controller.getPlayers();

        players.get(0).setPosition(4);
        players.get(1).setPosition(4);

        int count = controller.countPlayersOnSpace(4);
        assertEquals(2, count);
    }

    /**
     * Ensure congestion penalty is only applied when needed.
     */
    @Test
    public void testPenaltyAppliedForCongestion() {
        BoardController controller = new BoardController(new GameBoard(10), 2);
        List<Player> players = controller.getPlayers();
        Player player = players.get(0);
        Player other = players.get(1);

        player.setPosition(2);
        other.setPosition(2);

        int initial = player.getBalance();
        if (controller.countPlayersOnSpace(2) > 1) {
            player.subtractMoney(50);
        }

        assertEquals(initial - 50, player.getBalance());
    }

    /**
     * Ensure no penalty is applied when player is alone.
     */
    @Test
    public void testNoPenaltyWhenAlone() {
        BoardController controller = new BoardController(new GameBoard(10), 2);
        List<Player> players = controller.getPlayers();
        Player player = players.get(0);
        Player other = players.get(1);

        player.setPosition(6);
        other.setPosition(3);

        int initial = player.getBalance();
        if (controller.countPlayersOnSpace(6) > 1) {
            player.subtractMoney(50);
        }

        assertEquals(initial, player.getBalance());
    }
}
