/**
 * HitListener.
 * @author Shacahf yosef
 * ID: 206962763
 */
public interface HitListener {
    // This method is called whenever the beingHit object is hit.
    // The hitter parameter is the Ball that's doing the hitting.
    /**
     * @param beingHit - the block that being hit.
     * @param hitter - the ball that hit.
     */
    void hitEvent(Block beingHit, Ball hitter);
}