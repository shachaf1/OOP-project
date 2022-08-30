import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * KeyPressStoppableAnimation.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private Boolean isAlreadyPressed = true;
    private boolean stop;
    /**
     * Constructor.
     * @param sensor - keybord
     * @param key - the key to stop.
     * @param animation - the animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.key = key;
        this.sensor = sensor;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        //do one frame until key is pressed
        animation.doOneFrame(d);
        if (this.sensor.isPressed(key)) {
            this.stop = true;
        }
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}