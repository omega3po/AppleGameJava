package controller;

import java.util.Scanner;
import model.GameManager;
import view.AppleGameTextualView;

/**
 * controller that implements ControllerInterface.
 */
public class AppleGameController implements ControllerInterface {
  private final GameManager model;
  private final AppleGameTextualView view;
  private final Scanner scan;

  /**
   * Constructor.
   *
   * @param model    model of the game.
   * @param view     view of the game.
   * @param readable input source of the game.
   */
  public AppleGameController(GameManager model, AppleGameTextualView view, Readable readable) {
    if (model == null || view == null || readable == null) {
      throw new IllegalArgumentException("Model, View, and Readable cannot be null.");
    }
    this.model = model;
    this.view = view;
    this.scan = new Scanner(readable);
  }

  @Override
  public void playGame() {
    boolean gameRunning = true;
    while (gameRunning) {
      view.showBoard();
      System.out.println("Enter your move (r1 c1 r2 c2) or 'q' to quit:");
      String inputLine = scan.nextLine().trim();
      if (inputLine.equalsIgnoreCase("q") || inputLine.equalsIgnoreCase("quit")) {
        gameRunning = false;
        continue;
      }
      try {
        String[] inputs = inputLine.split("\\s+");
        if (inputs.length != 4) {
          throw new IllegalArgumentException("Input must consist of exactly four numbers.");
        }
        int r1 = Integer.parseInt(inputs[0]);
        int c1 = Integer.parseInt(inputs[1]);
        int r2 = Integer.parseInt(inputs[2]);
        int c3 = Integer.parseInt(inputs[3]);
        model.makeMove(r1, c1, r2, c3);

      } catch (NumberFormatException e) {
        System.out.println("\n[ERROR] Invalid input. Please enter numbers only.");
        System.out.println("------------------------------------------\n");
      } catch (IllegalArgumentException e) {
        System.out.println("\n[ERROR] Invalid move: " + e.getMessage());
        System.out.println("------------------------------------------\n");
      }
    }

    // Game loop has ended
    System.out.println("Game over. Final Score: " + model.getScore());
  }
}
