import biuoop.GUI;
import biuoop.Sleeper;
import java.util.ArrayList;
import java.util.List;
/**
 * Ass6Game.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class Ass6Game {
    /**
     * @param args - levels
     */
    public static void main(String[] args) {
        System.out.println(args.length);
        List<LevelInformation> levels = new ArrayList<>();
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "1":
                        levels.add(new DirectHit());
                        break;
                    case "2":
                        levels.add(new LevelTwo());
                        break;
                    case "3":
                        levels.add(new LevelThree());
                        break;
                    case "4":
                        levels.add(new LevelFour());
                        break;
                    default:    //
                }
            }
        } else {
            levels.add(new DirectHit());
            levels.add(new LevelTwo());
            levels.add(new LevelThree());
            levels.add(new LevelFour());
        }
        Sleeper sleeper = new biuoop.Sleeper();
        GUI gui = new GUI("title", 800, 600);
        AnimationRunner runner = new AnimationRunner(gui, sleeper);
        biuoop.KeyboardSensor keyboard = gui.getKeyboardSensor();
        GameFlow gameFlow = new GameFlow(runner, keyboard);
        gameFlow.runLevels(levels);
    }
}
