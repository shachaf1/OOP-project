import biuoop.DrawSurface;
import java.awt.Color;
/**
 * ThirdBack.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class ThirdBack implements Sprite {
    private Rectangle rectangle;

    private static Color[] colors = {Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.CYAN, Color.MAGENTA,
            Color.ORANGE, Color.PINK};
    /**
     * Constructor.
     * @param rectangle - the rectangle of the block.
     */
    public ThirdBack(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.green.darker());
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(),
                (int) rectangle.getHeight());
        d.setColor(Color.darkGray);
        d.fillRectangle(70, 430, 130, 200);
        d.setColor(Color.white);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                d.fillRectangle(85 + (i * 30), 440 + (j * 45), 15, 30);

            }
        }
        d.setColor(Color.gray);
        d.fillRectangle(135, 150, 10, 280);
        d.setColor(Color.pink);
        d.fillCircle(140, 150, 15);
        d.setColor(Color.RED);
        d.fillCircle(140, 150, 10);
        d.setColor(Color.white);
        d.fillCircle(140, 150, 5);

    }

    @Override
    public void timePassed() {
    }
}
