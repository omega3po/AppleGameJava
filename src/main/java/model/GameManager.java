package model;

/**
 * Interface for AppleGameManager.
 */
public interface GameManager {
  /**
   * return the score of the game.
   *
   * @return the current score.
   */
  int getScore();

  /**
   * make player move.
   *
   * @param r1 row1.
   * @param c1 col1.
   * @param r2 row2.
   * @param c2 col2
   */
  void makeMove(int r1, int c1, int r2, int c2);

  /**
   * Return the board of the game for the view.
   *
   * @return the board of the game for the view.
   */
  BoardInterface getBoard();
}
