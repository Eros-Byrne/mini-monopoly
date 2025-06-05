package com.cm6123.monopoly.s4propertypurchase;

import com.cm6123.monopoly.game.Property;
import cm6123.game.Player;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Property class: ownership and cost.
 */
public class PropertyTests {

    @Test
    public void testInitialOwnership() {
        Property property = new Property("Test", 5, 300);
        assertFalse(property.isOwned());
    }

    @Test
    public void testPropertyPurchase() {
        Player player = new Player("Buyer", Color.BLUE);
        Property property = new Property("Test", 6, 200);

        assertFalse(property.isOwned());
        property.setOwner(player);
        assertEquals(player, property.getOwner());
        assertTrue(property.isOwned());
    }

    @Test
    public void testPropertyDetails() {
        Property property = new Property("Test Prop", 7, 400);
        assertEquals("Test Prop", property.getName());
        assertEquals(7, property.getPosition());
        assertEquals(400, property.getCost());
    }
}
