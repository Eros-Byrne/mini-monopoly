package cm6123;

import com.cm6123.monopoly.dice.Dice;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for Dice class.
 */
public final class DiceChecks {

    /**
     * Test that a single die always rolls within bounds [1–6].
     */
    @Test
    public void diceRollsWithinBounds() {
        Dice dice = new Dice(1);
        for (int i = 0; i < 1000; i++) {
            int roll = dice.getRoll()[0];
            assertTrue(roll >= 1 && roll <= 6, "Roll out of bounds: " + roll);
        }
    }

    /**
     * Ensure all face values from 1 to 6 appear at least once.
     */
    @Test
    public void diceCoversAllFaces() {
        Dice dice = new Dice(1);
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < 2000; i++) {
            seen.add(dice.getRoll()[0]);
        }

        for (int face = 1; face <= 6; face++) {
            assertTrue(seen.contains(face), "Face " + face + " not rolled.");
        }
    }

    /**
     * Test that the total of two preset dice is calculated correctly.
     */
    @Test
    public void testTotalFromTwoDice() {
        Dice dice = new Dice(2);
        dice.setDice(0, 3);
        dice.setDice(1, 4);
        assertEquals(7, dice.getTotal(), "Total should be 7 when rolling 3 and 4.");
    }
}