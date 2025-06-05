package com.cm6123.monopoly.s1navigation;

import com.cm6123.monopoly.app.Application;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Test that the Application starts correctly without crashing.
 */
public class ApplicationTest {

    /**
     * Tests that the application runs without throwing an exception when in test mode.
     */
    @Test
    public void testMainRunsWithoutError() {
        assertDoesNotThrow(() -> Application.main(new String[] {"test"}));
    }
}
