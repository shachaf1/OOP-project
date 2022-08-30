import biuoop.KeyboardSensor;
import java.util.List;
/**
 * GameFlow.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class GameFlow {
    private AnimationRunner ar;
    private KeyboardSensor ks;
    private Counter scoreCounter;
    private boolean hasWon = true;
    /**
     * Constructor.
     * @param ar - the animation runner.
     * @param ks - keyboard
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.ar = ar;
        this.ks = ks;
        this.scoreCounter = new Counter();

    }
    /**
     * @param levels - list of levels to run.
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.ar, this.ks, this.scoreCounter);
            level.initialize();
            level.run();
            if (level.getBallsVal() == 0) {
                hasWon = false;
                break;
            }
        }
        this.ar.run(new KeyPressStoppableAnimation(ks, KeyboardSensor.SPACE_KEY,
                new EndScreen(scoreCounter.getValue(), hasWon)));
        this.ar.getGui().close();
        return;
    }
}