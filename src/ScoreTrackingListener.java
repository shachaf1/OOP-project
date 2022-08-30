/**
 * ScoreTrackingListener.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;
    /**
     * Constructor.
     * @param scoreCounter - the counter of the score.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    /**
     * @param beingHit - the block that being hit.
     * @param hitter - the ball that hit.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
       this.currentScore.increase(5);
    }
}