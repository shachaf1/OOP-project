/**
 * BlockRemover.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;
    /**
     * Constructor.
     * @param gameLevel - the game.
     * @param removedBlocks - sum of blocks left
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }
    // Blocks that are hit should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.
    /**
     * @param beingHit - the block that being hit.
     * @param hitter - the ball that hit.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.gameLevel.removeSprite(beingHit);
        this.gameLevel.removeCollidable(beingHit);

        this.remainingBlocks.decrease(1);
    }
}