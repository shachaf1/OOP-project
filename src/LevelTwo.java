import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * LevelTwo.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class LevelTwo implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return this.initialBallVelocities().size();
    }
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            Velocity v = Velocity.fromAngleAndSpeed(-75 + 15 * i, 5);
            list.add(v);
        }
        return  list;
    }
    @Override
    public int paddleSpeed() {
        return 5;
    }
    @Override
    public int paddleWidth() {
        return 400;
    }
    @Override
    public String levelName() {
        return "Wide easy";
    }
    @Override
    public Sprite getBackground() {
        Rectangle rec = new Rectangle(new Point(0, 0), 800, 600);
        Sprite back = new SecLevelBack(rec);
        return back;
    }
    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            Rectangle r = new Rectangle(new Point(22 + (54 * i), 250), 52, 20);
            Block b = new Block(r, Color.red);
            list.add(b);
        }
        return  list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }

}
