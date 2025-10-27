package model;

/**
 * class that implements BoardInterface.
 */
public class Board implements BoardInterface {
  private final AppleInterface[][] board;
  private final int rows;
  private final int cols;

  /**
   * constructor of the class.
   *
   * @param cols width of the board.
   * @param rows height of the board.
   */
  public Board(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    if (rows < 1 || cols < 1) {
      throw new IllegalArgumentException();
    }
    this.board = new Apple[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        board[i][j] = new Apple();
      }
    }
  }

  /**
   * constructor with no argument.
   */
  public Board() {
    this.rows = 10;
    this.cols = 17;
    this.board = new Apple[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        board[i][j] = new Apple();
      }
    }
  }

  @Override
  public AppleInterface getApple(int row, int col) {
    if (row < 0 || col < 0 || row >= rows || col >= cols) {
      throw new IllegalArgumentException("Index out of bounds");
    }
    return this.board[row][col];
  }

  @Override
  public int getRows() {
    return this.rows;
  }

  @Override
  public int getCols() {
    return this.cols;
  }

  @Override
  public AppleInterface[][] getBoard() {
    AppleInterface[][] copy = new AppleInterface[this.rows][this.cols];
    for (int i = 0; i < this.rows; i++) {
      System.arraycopy(this.board[i], 0, copy[i], 0, this.cols);
    }

    return copy;
  }

  @Override
  public int getTotalNumInPortion(int leftTopRow, int leftTopCol, int rightBottomRow,
                                  int rightBottomCol) throws IllegalArgumentException {
    checkForValidCoordinate(leftTopRow, leftTopCol, rightBottomRow, rightBottomCol);

    int total = 0;
    for (int i = leftTopRow; i <= rightBottomRow; i++) {
      for (int j = leftTopCol; j <= rightBottomCol; j++) {
        if (board[i][j] != null) {
          total += board[i][j].getNum();
        }
      }
    }

    return total;
  }

  @Override
  public void removeApples(int leftTopRow, int leftTopCol, int rightBottomRow, int rightBottomCol) {
    checkForValidCoordinate(leftTopRow, leftTopCol, rightBottomRow, rightBottomCol);

    for (int i = leftTopRow; i <= rightBottomRow; i++) {
      for (int j = leftTopCol; j <= rightBottomCol; j++) {
        board[i][j] = null;
      }
    }
  }

  private void checkForValidCoordinate(int leftTopRow, int leftTopCol, int rightBottomRow,
                                       int rightBottomCol) {
    if (leftTopRow < 0 || leftTopCol < 0 || rightBottomRow >= rows || rightBottomCol >= cols) {
      throw new IllegalArgumentException("out of bounds");
    }
    if (leftTopRow > rightBottomRow || leftTopCol > rightBottomCol) {
      throw new IllegalArgumentException("leftTop should be smaller than rightBottom");
    }
  }
}
