import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * Block.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private java.awt.Color color;
    private static Color[] colors = {Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.CYAN, Color.MAGENTA,
            Color.ORANGE, Color.PINK};
    private List<HitListener> hitListeners;
    private List<ScoreTrackingListener> scoreTrackingListeners;
    /**
     * Constructor.
     * @param rectangle - the rectangle of the block.
     * @param color color of the blcok.
     */
    public Block(Rectangle rectangle, java.awt.Color color) {
        this.rectangle = rectangle;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        //check in which direction the ball passed and change to the opposite way
        if (Math.round(collisionPoint.getY()) == Math.round(this.rectangle.getUpperLeft().getY())) {
            dy = -currentVelocity.getDy();
        }

        if (Math.round(collisionPoint.getY()) == Math.round(this.rectangle.getUpperLeft().getY()
                + this.rectangle.getHeight())) {
            dy = -currentVelocity.getDy();
        }
        if (Math.round(collisionPoint.getX()) == Math.round(this.rectangle.getUpperLeft().getX())) {
            dx = -currentVelocity.getDx();
        }
        if (Math.round(collisionPoint.getX()) == Math.round(this.rectangle.getUpperLeft().getX()
                + this.rectangle.getWidth())) {
            dx = -currentVelocity.getDx();
        }
        this.notifyHit(hitter);

        return new Velocity(dx, dy);

    }
    /**
     * @param surface - the surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(),
                (int) rectangle.getHeight());
        surface.setColor(Color.black);
        surface.drawRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(),
                (int) rectangle.getHeight());
    }
    @Override
    public void timePassed() {
    }
    /**
     * removeFromGame.
     * @param gameLevel - remove block from this game
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
        gameLevel.removeCollidable(this);
    }
    /**
     * notifyHit.
     * @param hitter - when hitted
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
