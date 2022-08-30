import biuoop.DrawSurface;
import java.awt.Color;
import java.util.List;

/**
 * Ball.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class Ball implements Sprite, HitNotifier {
    private static final double RADIUSFACTOR = 1.8;
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity v;
    private int width;
    private int height;
    private GameEnvironment gameEnvironment;
    private CollisionInfo nextCollision;
    private List<HitListener> hitListeners;
    /**
     * Constructor.
     * @param center - point of the center of the ball.
     * @param r radius of the ball.
     * @param color - color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        if (r < 5) {
            r = 5;
        }
        this.r = r;
        this.color = color;
    }
    /**
     * @param gameEnvironment1 - al the collidables
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment1) {
        this.gameEnvironment = gameEnvironment1;
    }
    /**
     * @param velocity - a velocity of ball
     */
    public void setVelocity(Velocity velocity) {
        this.v = velocity;
    }
    /**
     * @param dx - dx change of ball
     * @param dy - dx change of ball
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }
    /**
     * @return velocity
     */
    public Velocity getVelocity() {
        return this.v;
    }
    /**
     * @return center of ball.
     */
    public Point getCenter() {
        return this.center;
    }
    /**
     * move the ball one step.
     */
    public void moveOneStep() {
        //get the line of the ball by: start - radius, end - radius after 1 move.
        Line line = new Line(this.getCenter(), new Point(this.center.getX() + this.getVelocity().getDx(),
                this.center.getY() + this.getVelocity().getDy()));
        //check next collision by the function
        this.nextCollision = gameEnvironment.getClosestCollision(line);
        //if next collision is null keep moving
        if (this.nextCollision.collisionPoint() == null) {
            this.center = this.v.applyToPoint(this.center);
            return;
        }
        //get collision point and triangle and check in which side of the rectangle the point is and move accordance
        Point collisPoint = this.nextCollision.collisionPoint();
        Rectangle collisionRec = this.nextCollision.collisionObject().getCollisionRectangle();
        //right
        double epsilon = Math.pow(10, -10);
        if (this.v.getDx() > 0
                && this.nextCollision.collisionPoint().getX() - collisionRec.getUpperLeft().getX() < epsilon) {
            if (this.center.getX() + RADIUSFACTOR * this.r >= collisionRec.getUpperLeft().getX()) {
                Velocity newVelocity = this.nextCollision.collisionObject().hit(this, collisPoint, this.v);
                this.setVelocity(newVelocity);
                this.center = newVelocity.applyToPoint(this.center);

                this.nextCollision = null;
                return;
            }
        }
        //left
        if (this.v.getDx() < 0 && this.nextCollision.collisionPoint().getX()
                - (collisionRec.getUpperLeft().getX() + collisionRec.getWidth()) < epsilon) {
            if (this.center.getX() - RADIUSFACTOR * this.r <= collisionRec.getUpperLeft().getX()
                    + collisionRec.getWidth()) {
                Velocity newVelocity = this.nextCollision.collisionObject().hit(this, collisPoint, this.v);
                this.setVelocity(newVelocity);
                this.center = newVelocity.applyToPoint(this.center);

                this.nextCollision = null;
                return;
            }
        }
        //down
        if (this.v.getDy() > 0 && this.nextCollision.collisionPoint().getY()
                - collisionRec.getUpperLeft().getY() < epsilon) {
            if (this.center.getY() + RADIUSFACTOR * this.r >= collisionRec.getUpperLeft().getY()) {
                Velocity newVelocity = this.nextCollision.collisionObject().hit(this, collisPoint, this.v);
                this.setVelocity(newVelocity);
                this.center = newVelocity.applyToPoint(this.center);
                this.nextCollision = null;
                return;
            }
        }
        //up
        if (this.v.getDy() < 0 && this.nextCollision.collisionPoint().getY()
                - (collisionRec.getUpperLeft().getY() + collisionRec.getHeight()) < epsilon) {
            if (this.center.getY() - RADIUSFACTOR * this.r <= collisionRec.getUpperLeft().getY()
                    + collisionRec.getHeight()) {

                Velocity newVelocity = this.nextCollision.collisionObject().hit(this, collisPoint, this.v);
                this.setVelocity(newVelocity);
                this.center = newVelocity.applyToPoint(this.center);

                this.nextCollision = null;
                return;
            }
        }

        this.center = this.getVelocity().applyToPoint(this.center);
    }
    /**
     * Constructor.
     * @param x - x of the point of the center of the ball.
     * @param y - y of the point of the center of the ball.
     * @param r radius of the ball.
     * @param color - color of the ball.
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        if (r < 5) {
            r = 5;
        }
        this.r = r;
        this.color = color;
    }
    /**
     * @return x of center
     */
    public int getX() {
        return (int) this.center.getX();
    }
    /**
     * @return y of center
     */
    public int getY() {
        return (int) this.center.getY();
    }
    /**
     * @return size of ball
     */
    public int getSize() {
        return this.r;
    }
    /**
     * @return color of ball
     */
    public java.awt.Color getColor() {
        return this.color;
    }
    /**
     * @param surface - the surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
        surface.setColor(Color.black);
        surface.drawCircle(this.getX(), this.getY(), this.getSize());
    }
    /**
     * if time passed move once.
     */
    public void timePassed() {
        this.moveOneStep();
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
