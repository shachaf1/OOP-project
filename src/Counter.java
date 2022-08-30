/**
 * Counter.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class Counter {
    private int value;
    /**
     * Constructor.
     */
    public Counter() {
        this.value = 0;
    }
    // add number to current count.
    /**
     * @param number - number to increase counter
     */
    public void increase(int number) {
        this.value = this.value + number;
    }
    // subtract number from current count.
    /**
     * @param number - number to decrease counter
     */
    void decrease(int number) {
        this.value = this.value - number;
    }
    // get current count.
    /**
     * @return value of counter
     */
    int getValue() {
        return this.value;
    }
}