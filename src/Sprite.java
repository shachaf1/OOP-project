import biuoop.DrawSurface;
/**
 * Sprite.
 * @author Shacahf yosef
 * ID: 206962763
 */
public interface Sprite {
    // draw the sprite to the screen
    /**
     * @param d - surface
     */
    void drawOn(DrawSurface d);
    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}