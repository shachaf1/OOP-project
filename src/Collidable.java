/**
 * velocity of the ball.
 * @author Shacahf yosef
 * ID: 206962763
 */
public interface Collidable {
    // Return the "collision shape" of the object.
    /**
     * @return rectangle of the collidable.
     */
    Rectangle getCollisionRectangle();

    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).
    /**
     * @param collisionPoint - the point where the ball hits
     * @param currentVelocity - velocity of the ball
     * @param hitter - ball that hit.
     * @return new velocity of the ball.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}