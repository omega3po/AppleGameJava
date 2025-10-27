package model;

/**
 * Interface of Board.
 */
public interface BoardInterface {

  /**
   * return the 2d array of the board.
   *
   * @return the 2d array of the board.
   */
  AppleInterface[][] getBoard();

  /**
   * get the number of rows of the board.
   *
   * @return the number of rows of the board.
   */
  int getRows();

  /**
   * get the number of cols of the board.
   *
   * @return the number of cols of the board.
   */
  int getCols();

  /**
   * return the apple of the provided position.
   *
   * @param row is row.
   * @param col is col.
   * @return the apple of the provided position.
   */
  AppleInterface getApple(int row, int col);

  /**
   * get the total number in the rectangular portion.
   *
   * @param leftTopRow     row coordinate of left top of the rectangular portion.
   * @param leftTopCol     col coordinate of left top of the rectangular portion.
   * @param rightBottomRow row coordinate of right bottom of the rectangular portion.
   * @param rightBottomCol col coordinate of right bottom of the rectangular portion.
   * @return the total number in that rectangular portion from the board.
   * @throws IllegalArgumentException if it is out of bounds or
   *                                  leftTop coordinate > rightBottom coordinate.
   */
  int getTotalNumInPortion(int leftTopRow, int leftTopCol, int rightBottomRow, int rightBottomCol);

  /**
   * remove the apples in that rectangular portion.
   *
   * @param leftTopRow     row coordinate of left top of the rectangular portion.
   * @param leftTopCol     col coordinate of left top of the rectangular portion.
   * @param rightBottomRow row coordinate of right bottom of the rectangular portion.
   * @param rightBottomCol col coordinate of right bottom of the rectangular portion.
   * @throws IllegalArgumentException if it is out of bounds or
   *                                  leftTop coordinate > rightBottom coordinate.
   */
  void removeApples(int leftTopRow, int leftTopCol, int rightBottomRow, int rightBottomCol);
}
