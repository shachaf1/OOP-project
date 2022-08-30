/**
 * BallRemover.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;
    /**
     * Constructor.
     * @param gameLevel - the game.
     * @param removedBalls - sum of balls left
     */
    public BallRemover(GameLevel gameLevel, Counter removedBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = removedBalls;
    }
    // Blocks that are hit should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.gameLevel.removeSprite(hitter);
        this.remainingBalls.decrease(1);
    }
}