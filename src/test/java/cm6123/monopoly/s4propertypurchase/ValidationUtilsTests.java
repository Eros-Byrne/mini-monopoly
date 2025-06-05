package cm6123.monopoly.s4propertypurchase;

import com.cm6123.monopoly.game.ValidationUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for validation utility methods.
 */
public class ValidationUtilsTests {

    /**
     * Check valid board sizes.
     */
    @Test
    public void testValidBoardSize() {
        assertTrue(ValidationUtils.isValidBoardSize(10));
        assertTrue(ValidationUtils.isValidBoardSize(50));
        assertFalse(ValidationUtils.isValidBoardSize(9));
        assertFalse(ValidationUtils.isValidBoardSize(51));
    }

    /**
     * Check Board Size.
     */

    @Test
    public void testBoardSizeExactlyAtMiddle() {
        assertTrue(ValidationUtils.isValidBoardSize(30));
    }

    /**
     * Check property cost validation.
     */
    @Test
    public void testValidPropertyCost() {
        assertTrue(ValidationUtils.isValidPropertyCost(0));
        assertTrue(ValidationUtils.isValidPropertyCost(250));
        assertFalse(ValidationUtils.isValidPropertyCost(-100));
    }

    /**
     * Check board position range validation.
     */
    @Test
    public void testValidBoardPosition() {
        assertTrue(ValidationUtils.isValidBoardPosition(0, 10));
        assertTrue(ValidationUtils.isValidBoardPosition(9, 10));
        assertFalse(ValidationUtils.isValidBoardPosition(10, 10));
        assertFalse(ValidationUtils.isValidBoardPosition(-1, 10));
    }

    /**
     * Test parsing integers from strings.
     */
    @Test
    public void testTryParseInt() {
        assertEquals(123, ValidationUtils.tryParseInt("123"));
        assertNull(ValidationUtils.tryParseInt("abc"));
        assertNull(ValidationUtils.tryParseInt(null));
    }

    /**
     * Test integer range validation.
     */
    @Test
    public void testValidateIntRange() {
        assertTrue(ValidationUtils.validateIntRange(1, 10, 5));
        assertTrue(ValidationUtils.validateIntRange(1, 10, 1));
        assertTrue(ValidationUtils.validateIntRange(1, 10, 10));
        assertFalse(ValidationUtils.validateIntRange(1, 10, 0));
        assertFalse(ValidationUtils.validateIntRange(1, 10, 11));
    }
}
