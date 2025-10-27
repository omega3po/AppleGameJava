package model;

import java.util.Random;

/**
 * Class that implements AppleInterface.
 */
public class Apple implements AppleInterface {
  private final int number;

  /**
   * Constructor with no arguments.
   */
  public Apple() {
    this.number = new Random().nextInt(9) + 1;
  }

  /**
   * Constructor with argument.
   *
   * @param number is the number of this apple to set.
   * @throws IllegalArgumentException if number is number is not between 1 and 9 inclusive.
   */
  public Apple(int number) {
    if (number < 1 || number > 9) {
      throw new IllegalArgumentException("Number should be between 1 and 9 inclusive!");
    }
    this.number = number;
  }

  @Override
  public int getNum() {
    return this.number;
  }
}
