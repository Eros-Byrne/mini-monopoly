package com.cm6123.monopoly.dice;

import java.util.Arrays;

/**
 * Represents a configurable number of six-sided dice.
 */
public final class Dice {

  /**
   * Number of sides on each die.
   */
  private static final int DICE_SIDES = 6;

  /**
   * Array representing the rolled values.
   */
  private final int[] dice;

  /**
   * Create a dice roller with the specified number of dice.
   *
   * @param diceAmount number of dice
   */
  public Dice(final int diceAmount) {
    this.dice = new int[diceAmount];
    roll();
  }

  /**
   * Roll all dice and return the values.
   *
   * @return array of dice values
   */
  public int[] getRoll() {
    roll();
    return dice.clone();
  }

  /**
   * Get the value of a single die.
   *
   * @param index which die (0-based)
   * @return value of the die
   */
  public int getSingleDice(final int index) {
    return dice[index];
  }

  /**
   * Return the sum of all dice.
   *
   * @return sum of dice values
   */
  public int getTotal() {
    return Arrays.stream(dice).sum();
  }

  /**
   * Roll all dice (update internal values).
   */
  public void roll() {
    for (int i = 0; i < dice.length; i++) {
      dice[i] = (int) (Math.random() * DICE_SIDES) + 1;
    }
  }

  /**
   * Manually set a die value (used for testing).
   *
   * @param index die index (0-based)
   * @param value value to set
   */
  public void setDice(final int index, final int value) {
    this.dice[index] = value;
  }
}
