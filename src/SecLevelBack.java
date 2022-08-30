import biuoop.DrawSurface;
import java.awt.Color;
/**
 * SecLevelBack.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class SecLevelBack implements Sprite {
    private Rectangle rectangle;

    private static Color[] colors = {Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.CYAN, Color.MAGENTA,
            Color.ORANGE, Color.PINK};
    /**
     * Constructor.
     * @param rectangle - the rectangle of the block.
     */
    public SecLevelBack(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(),
                (int) rectangle.getHeight());
        d.setColor(Color.orange);
        d.fillCircle(100, 150, 40);
        for (int i = 0; i < 30; i++) {
            d.drawLine(100, 150, 0 + (40 * i), 250);
        }

    }

    @Override
    public void timePassed() {
    }
}
