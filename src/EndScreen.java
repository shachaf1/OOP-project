import biuoop.DrawSurface;
import java.awt.Color;
/**
 * DirectHit.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class EndScreen implements  Animation {
    private Integer score;
    private boolean hasWon;
    /**
     * Constructor.
     * @param score - score of the game
     * @param hasWon - true if won, false if lost
     */
    public EndScreen(int score, boolean hasWon) {
        this.hasWon = hasWon;
        this.score = score;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        if (hasWon) {
            d.setColor(Color.cyan);
            d.fillRectangle(0, 0, 800, 600);
            d.setColor(Color.black);
            d.drawText(160, 320, "You Win! Your score is " + score.toString(), 40);
        } else {
            d.setColor(Color.red);
            d.fillRectangle(0, 0, 800, 600);
            d.setColor(Color.black);
            d.drawText(160, 320, "Game Over. Your score is " + score.toString(), 40);
        }
    }
    @Override
    public boolean shouldStop() {
        return false;
    }

}
