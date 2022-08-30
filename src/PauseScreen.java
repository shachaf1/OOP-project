import biuoop.DrawSurface;
/**
 * PauseScreen.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class PauseScreen implements Animation {
    /**
     * Constructor.
     */
    public PauseScreen() {

    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }
    @Override
    public boolean shouldStop() {
        return true;
    }
}