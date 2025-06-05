package com.cm6123.monopoly.s1navigation;

import cm6123.game.Welcome;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the Welcome class.
 */
public final class WelcomeChecks {

    /**
     * Test that welcome message contains the word "Welcome".
     */
    @Test
    public void testWelcomeMessageContainsWelcome() {
        Welcome welcome = new Welcome();
        String message = welcome.getWelcomeMessage();
        assertTrue(message.contains("Welcome"), "Welcome message should contain 'Welcome'.");
    }
}