/**
 * velocity of the ball.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class Velocity {
    private double dx;
    private double dy;
    /**
     * Constructor.
     * @param dx can be any positive number.
     * @param dy can be any positive number.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    /**
     * @return dx
     */
    public double getDx() {
        return dx;
    }
    /**
     * @return dy
     */
    public double getDy() {
        return dy;
    }
    /**
     * @param p - a point
     * @return point + velocity
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }
    /**
     * @param angle - angle of movement
     * @param speed - speed of movement
     * @return point + velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        angle = angle - 90;
        double dx = Math.cos(Math.toRadians(angle));
        double dy = Math.sin(Math.toRadians(angle));
        return new Velocity(speed * dx, speed * dy);
    }
    /**
     * @return speed of ball
     */
    public double getSpeed() {
        return (Math.abs(this.getDx()) + Math.abs(this.getDy()));
    }
}
