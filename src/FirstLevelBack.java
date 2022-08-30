import biuoop.DrawSurface;
import java.awt.Color;
/**
 * FirstLevelBack.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class FirstLevelBack implements Sprite {
    private Rectangle rectangle;
    private static Color[] colors = {Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.CYAN, Color.MAGENTA,
            Color.ORANGE, Color.PINK};
    /**
     * Constructor.
     * @param rectangle - the rectangle of the block.
     */
    public FirstLevelBack(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(),
                (int) rectangle.getHeight());
        d.setColor(Color.blue);
        d.drawCircle(400, 200, 100);
        d.drawCircle(400, 200, 75);
        d.drawCircle(400, 200, 50);
        d.drawLine(400, 180, 400, 90);
        d.drawLine(400, 220, 400, 320);
        d.drawLine(290, 200, 380, 200);
        d.drawLine(420, 200, 510, 200);
    }
    @Override
    public void timePassed() {
    }
}
