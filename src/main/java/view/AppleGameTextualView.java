package view;

import model.AppleInterface;
import model.GameManager;

/**
 * View of the board.
 */
public class AppleGameTextualView {
  private final GameManager gm;

  /**
   * constructor.
   *
   * @param gm of the game.
   */
  public AppleGameTextualView(GameManager gm) {
    this.gm = gm;
  }

  /**
   * visualize the board for the player.
   */
  public void showBoard() {
    AppleInterface[][] board = gm.getBoard();
    StringBuilder sb = new StringBuilder();
    for (AppleInterface[] appleInterfaces : board) {
      for (int j = 0; j < board[0].length; j++) {
        AppleInterface currentApple = appleInterfaces[j];
        if (currentApple == null) {
          sb.append("X");
        } else {
          sb.append(currentApple.getNum());
        }
        sb.append(" ");
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }
}
