import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
/**
 * AnimationRunner.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;
    /**
     * Constructor.
     * @param gui - the gui to draw on.
     * @param sleeper the sleeper of the game.
     */
    public  AnimationRunner(GUI gui, biuoop.Sleeper sleeper) {
        this.gui = gui;
        this.framesPerSecond = 60;
        this.sleeper = sleeper;
    }
    /**
     * @return  the gui of the game.
     */
    public GUI getGui() {
        return this.gui;
    }
    /**
     * @return  the gui of the game.
     */
    public Sleeper getSleeper() {
        return this.sleeper;
    }
    /**
     * @param   animation - get an animation to run.
     */
    public void run(Animation animation) {
        //get the miliseconds per frame to be 60 frames per sec.
        int millisecondsPerFrame = (1000 / framesPerSecond);
        //run until should stop
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = this.gui.getDrawSurface();
            animation.doOneFrame(d);
            this.gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}