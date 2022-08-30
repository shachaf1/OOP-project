import biuoop.DrawSurface;
import java.util.ArrayList;
/**
 * SpriteCollection.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class SpriteCollection {
    private ArrayList<Sprite> listSprites;
    /**
     * Constructor.
     */
    public SpriteCollection() {
        this.listSprites = new ArrayList<Sprite>(500);
    }
    /**
     * @param s - sprite to add.
     */
    public void addSprite(Sprite s) {
        this.listSprites.add(s);
    }
    /**
     * @param s - sprite to remove.
     */
    public void remSprite(Sprite s) {
        this.listSprites.remove(s);
    }
    /**
     *call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < this.listSprites.size(); i++) {
            this.listSprites.get(i).timePassed();
        }
    }
    /**
     *call drawOn() on all sprites.
     * @param d - surface.
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < this.listSprites.size(); i++) {
            this.listSprites.get(i).drawOn(d);
        }
    }
}