import biuoop.DrawSurface;
/**
 * Animation.
 * @author Shacahf yosef
 * ID: 206962763
 */
public interface Animation {
    /**
     * @param d - the surface
     */
    void doOneFrame(DrawSurface d);
    /**
     * @return if should stop.
     */
    boolean shouldStop();
}