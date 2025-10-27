package model;

/**
 * class that implements GameManager interface.
 */
public class AppleGameManager implements GameManager {
  private final BoardInterface board;
  private int score;

  /**
   * constructor of the game manager.
   */
  public AppleGameManager() {
    this.board = new Board();
    this.score = 0;
  }

  @Override
  public int getScore() {
    return this.score;
  }

  @Override
  public void makeMove(int r1, int c1, int r2, int c2) throws IllegalArgumentException {
    if (board.getTotalNumInPortion(r1, c1, r2, c2) == 10) {
      board.removeApples(r1, c1, r2, c2);
      score++;
    }
  }

  @Override
  public AppleInterface[][] getBoard() {
    return this.board.getBoard();
  }
}
