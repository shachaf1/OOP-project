/**
 * HitNotifier.
 * @author Shacahf yosef
 * ID: 206962763
 */
public interface HitNotifier {
    // Add hl as a listener to hit events.
    /**
     * @param hl - the new HitListener to add
     */
    void addHitListener(HitListener hl);
    // Remove hl from the list of listeners to hit events.
    /**
     * @param hl - the HitListener to remove
     */
    void removeHitListener(HitListener hl);
}