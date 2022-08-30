import biuoop.DrawSurface;
import biuoop.Sleeper;
import java.awt.Color;
/**
 * CountdownAnimation.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private biuoop.Sleeper sleeper;
    private java.awt.Color color;
    /**
     * Constructor - black count.
     * @param numOfSeconds - how many seconds
     * @param countFrom - count from which number.
     * @param gameScreen - screen to drwa on.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {

        this.sleeper = new Sleeper();
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        color = Color.black;
    }
    /**
     * Constructor - with color of count.
     * @param numOfSeconds - how many seconds
     * @param countFrom - count from which number.
     * @param gameScreen - screen to drwa on.
     * @param color color of the count animation
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen, Color color) {
        this.sleeper = new Sleeper();
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.color = color;
    }
    /**
     * @param d - drawface to count on.
     */
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.green);
        d.drawText(300, 400, "starts in:" + String.valueOf(this.countFrom), 50);
        sleeper.sleepFor(900);
        this.countFrom = this.countFrom - 1;
    }
    /**
     * @return  if shold stop.
     */
    public boolean shouldStop() {
        return this.countFrom == -1;
    }
}