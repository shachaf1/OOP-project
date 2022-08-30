import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * DirectHit.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class DirectHit implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return this.initialBallVelocities().size();
    }
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        Velocity v = new Velocity(0, -4);
        list.add(v);
        return  list;
    }
    @Override
    public int paddleSpeed() {
        return 5;
    }
    @Override
    public int paddleWidth() {
        return 60;
    }
    @Override
    public String levelName() {
        return "DirectHit";
    }
    @Override
    public Sprite getBackground() {
        Rectangle rec = new Rectangle(new Point(0, 0), 800, 600);
        Sprite back = new FirstLevelBack(rec);
        return back;
    }
    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        Block v = new Block(new Rectangle(new Point(390, 190), 20, 20), Color.red);
        list.add(v);
        return  list;
    }
    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
