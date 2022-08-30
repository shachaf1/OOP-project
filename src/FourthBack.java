import biuoop.DrawSurface;
import java.awt.Color;
/**
 * FourthBack.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class FourthBack implements Sprite {
    private Rectangle rectangle;

    private static Color[] colors = {Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.CYAN, Color.MAGENTA,
            Color.ORANGE, Color.PINK};
    /**
     * Constructor.
     * @param rectangle - the rectangle of the block.
     */
    public FourthBack(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.cyan);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(),
                (int) rectangle.getHeight());
        d.setColor(Color.white);
        for (int i = 0; i < 10; i++) {
            d.drawLine(120 + (i * 12), 420, 140 + (i * 12), 600);
        }
        for (int i = 0; i < 10; i++) {
            d.drawLine(600 + (i * 12), 520, 580 + (i * 12), 600);
        }





        d.setColor(Color.gray.brighter());
        d.fillCircle(140, 400, 20);
        d.fillCircle(145, 415, 20);
        d.fillCircle(135, 430, 20);
        d.setColor(Color.lightGray);
        d.fillCircle(120, 420, 20);
        d.fillCircle(170, 400, 20);
        d.fillCircle(175, 420, 20);
        d.fillCircle(165, 435, 20);
        d.setColor(Color.gray.brighter());
        d.fillCircle(160, 420, 20);
        d.fillCircle(205, 400, 20);
        d.fillCircle(210, 420, 20);
        d.fillCircle(195, 435, 20);

        d.setColor(Color.gray.brighter());
        d.fillCircle(640, 500, 20);
        d.fillCircle(645, 515, 20);
        d.fillCircle(635, 530, 20);
        d.setColor(Color.lightGray);
        d.fillCircle(620, 520, 20);
        d.fillCircle(670, 500, 20);
        d.fillCircle(675, 520, 20);
        d.fillCircle(665, 535, 20);
        d.setColor(Color.gray.brighter());
        d.fillCircle(660, 520, 20);
        d.fillCircle(605, 500, 20);
        d.fillCircle(610, 520, 20);
        d.fillCircle(695, 535, 20);
    }

    @Override
    public void timePassed() {
    }
}
