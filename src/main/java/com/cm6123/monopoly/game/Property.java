package com.cm6123.monopoly.game;

import cm6123.game.Player;

/**
 * Represents a property on the board that can be purchased by players.
 */
public final class Property {

    /** The name of the property. */
    private final String name;

    /** The position of the property on the board. */
    private final int position;

    /** The cost to purchase the property. */
    private final int cost;

    /** The player who owns this property, or null if unowned. */
    private Player owner;

    /**
     * Constructs a new property with the given name, position, and cost.
     *
     * @param propertyName the name of the property
     * @param boardPosition the board position of the property
     * @param purchaseCost the cost to purchase the property
     */
    public Property(final String propertyName, final int boardPosition, final int purchaseCost) {
        this.name = propertyName;
        this.position = boardPosition;
        this.cost = purchaseCost;
        this.owner = null;
    }

    /**
     * Overloaded constructor for test cases that omits position.
     *
     * @param propertyName the name of the property
     * @param purchaseCost the cost to purchase the property
     */
    public Property(final String propertyName, final int purchaseCost) {
        this(propertyName, 0, purchaseCost);
    }

    /**
     * Gets the name of the property.
     *
     * @return the property name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the board position of the property.
     *
     * @return the board index
     */
    public int getPosition() {
        return position;
    }

    /**
     * Gets the cost to purchase the property.
     *
     * @return the cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * Gets the player who owns this property.
     *
     * @return the owner, or null if unowned
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * Sets the owner of this property.
     *
     * @param newOwner the player who purchased it
     */
    public void setOwner(final Player newOwner) {
        this.owner = newOwner;
    }

    /**
     * Checks whether the property is owned by a player.
     *
     * @return true if owned, false otherwise
     */
    public boolean isOwned() {
        return owner != null;
    }
}
