import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * DirectHit.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class LevelFour implements LevelInformation {
    private static Color[] colors = {Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.CYAN, Color.MAGENTA,
            Color.ORANGE, Color.PINK};
    @Override
    public int numberOfBalls() {
        return this.initialBallVelocities().size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Velocity v = Velocity.fromAngleAndSpeed(-60 + (20 * i), 5);
            list.add(v);
        }
        return  list;
    }
    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 150;
    }

    @Override
    public String levelName() {
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        Rectangle rec = new Rectangle(new Point(0, 0), 800, 600);
        Sprite back = new FourthBack(rec);
        return back;
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 16; j++) {
                Rectangle r = new Rectangle(new Point(780 - (j * 50.6), 80 + (26 * i)), 50, 25);
                Block b = new Block(r, colors[i]);
                list.add(b);
            }
        }
        return  list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }

}
