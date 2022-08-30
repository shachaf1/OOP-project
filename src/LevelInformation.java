import java.util.List;
/**
 * LevelInformation.
 * @author Shacahf yosef
 * ID: 206962763
 */
public interface LevelInformation {
    /**
     * @return  num of balls
     */
    int numberOfBalls();
    /**
     * @return  list of velocities of the balls
     */
    List<Velocity> initialBallVelocities();
    /**
     * @return  paddle speed
     */
    int paddleSpeed();
    /**
     * @return  paddle width
     */
    int paddleWidth();
    /**
     * @return the level name will be displayed at the top of the screen.
     */
    String levelName();
    /**
     * @return a sprite with the background of the level
     */
    Sprite getBackground();
    /**
     * @return a list of all the blocs
     */
    List<Block> blocks();
    /**
     * @return number of blocs
     */
    int numberOfBlocksToRemove();
}