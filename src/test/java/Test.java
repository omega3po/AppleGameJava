import controller.AppleGameController;
import controller.ControllerInterface;
import java.io.InputStreamReader;
import model.AppleGameManager;
import model.GameManager;
import view.AppleGameTextualView;

/**
 * Test class.
 */
public class Test {
  /**
   * main class for testing.
   *
   * @param args arguments.
   */
  public static void main(String[] args) {
    GameManager gm = new AppleGameManager();
    AppleGameTextualView view = new AppleGameTextualView(gm);
    ControllerInterface c = new AppleGameController(gm, view, new InputStreamReader(System.in));
    c.playGame();
  }
}
