/**
 * velocity of the ball.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;
    /**
     * Constructor.
     * @param collisionObject - the collisionObject.
     * @param collisionPoint - the collisionPoint.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }
    // the point at which the collision occurs.
    /**
     * @return collisionPoint
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }
    // the collidable object involved in the collision.
    /**
     * @return collisionObject
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}