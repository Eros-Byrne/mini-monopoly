package cm6123.game;

import java.awt.Color;

/**
 * Represents a player in the Mini Monopoly game.
 */
public final class Player {

    /** The unique name for the player. */
    private final String name;

    /** The color representing the player. */
    private Color playerColor;

    /** The current balance of the player. */
    private int balance;

    /** The current board position of the player. */
    private int position;

    /** Whether the player is bankrupt. */
    private boolean isBankrupt;

    /** The number of turns to skip. */
    private int turnsToSkip;

    /**
     * Create a player with a default name and color.
     *
     * @param color the player color
     */
    public Player(final String name, final Color color) {
        this.name = name;
        this.playerColor = color;
        this.balance = 1000;
        this.position = 0;
        this.isBankrupt = false;
        this.turnsToSkip = 0;
    }

    /**
     * Create a player with a specific name (no color).
     *
     * @param name the name of the player
     */
    public Player(final String name) {
        this.name = name;
        this.balance = 1000;
        this.position = 0;
        this.isBankrupt = false;
        this.turnsToSkip = 0;
        this.playerColor = null;
    }

    /**
     * Gets the player's name.
     *
     * @return player name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the player's current position on the board.
     *
     * @return board position
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets the player's current position.
     *
     * @param newPosition new board position
     */
    public void setPosition(final int newPosition) {
        this.position = newPosition;
    }

    /**
     * Gets the player's balance.
     *
     * @return player balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Adds money to the player's balance.
     *
     * @param amount money to add
     */
    public void addMoney(final int amount) {
        this.balance += amount;
    }

    /**
     * Removes money and checks for bankruptcy.
     *
     * @param amount the amount to remove
     */
    public void subtractMoney(final int amount) {
        this.balance -= amount;
        if (this.balance < 0) {
            this.isBankrupt = true;
        }
    }

    /**
     * Pays rent to another player.
     *
     * @param owner  the player to receive the rent
     * @param amount the rent amount
     */
    public void payRent(final Player owner, final int amount) {
        if (!this.equals(owner)) {
            this.subtractMoney(amount);
            owner.addMoney(amount);
        }
    }

    /**
     * Checks whether the player is bankrupt.
     *
     * @return true if bankrupt
     */
    public boolean isBankrupt() {
        return isBankrupt;
    }

    /**
     * Manually set a player to bankrupt.
     *
     * @param bankrupt true to declare bankrupt
     */
    public void setBankrupt(final boolean bankrupt) {
        this.isBankrupt = bankrupt;
    }

    /**
     * Gets the number of turns to skip.
     *
     * @return number of turns
     */
    public int getTurnsToSkip() {
        return turnsToSkip;
    }

    /**
     * Sets the number of turns to skip.
     *
     * @param turns number of turns to skip
     */
    public void setTurnsToSkip(final int turns) {
        this.turnsToSkip = turns;
    }

    /**
     * Skip a number of turns.
     *
     * @param turns the number of turns to skip
     */
    public void skipTurns(final int turns) {
        this.turnsToSkip = turns;
    }

    /**
     * Decrements the skip turn counter.
     */
    public void decrementSkipTurns() {
        if (turnsToSkip > 0) {
            turnsToSkip--;
        }
    }

    /**
     * Gets the player color (maybe null).
     *
     * @return color of the player
     */
    public Color getPlayerColor() {
        return playerColor;
    }

    /**
     * Removes money and checks for bankruptcy.
     *
     * @param amount amount to remove
     */
    public void removeMoney(final int amount) {
        subtractMoney(amount);
    }

    /**
     * Sets the player's color.
     *
     * @param color new color
     */
    public void setPlayerColor(final Color color) {
        this.playerColor = color;
    }
}
