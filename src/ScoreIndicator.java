import biuoop.DrawSurface;
import java.awt.Color;
/**
 * score indicator.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class ScoreIndicator implements Sprite {
    private Rectangle rectangle;
    private java.awt.Color color;
    private static Color[] colors = {Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.CYAN, Color.MAGENTA,
            Color.ORANGE, Color.PINK};
    private Counter score;
    private String levelName;
    /**
     * Constructor.
     * @param rectangle - the rectangle of the block.
     * @param color color of the blcok.
     * @param score score of game.
     * @param levelName name of the level.
     */
    public ScoreIndicator(Rectangle rectangle, java.awt.Color color, Counter score, String levelName) {
        this.rectangle = rectangle;
        this.color = color;
        this.score = score;
        this.levelName = levelName;
    }
    /**
     * @param surface - the surface
     */
    public void drawOn(DrawSurface surface) {
        //the score indicator will look like a block but with score counter in the middle
        surface.setColor(this.color);
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(),
                (int) rectangle.getHeight());
        Integer scoreInteger = this.score.getValue();
        surface.setColor(Color.black);
        surface.drawText(350, 20, "Score: " + scoreInteger.toString(), 16);
        surface.drawText(550, 20, "Level Name: " + levelName, 16);
    }
    @Override
    public void timePassed() {
    }
}
