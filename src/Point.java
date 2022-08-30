/**
 * point.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class Point {
    private double x;
    private double y;
    /**
     * Constructor.
     * @param x can be any positive number
     * @param y can be any positive number
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * @param other can be any point
     * @return the distance between 2 points.
     */
    public double distance(Point other) {
        //the Quadratic formula.
        double p1 = Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2);
        return Math.sqrt(p1);
    }
    /**
     * @param other can be any point
     * @return the distance between 2 points.
     */
    public boolean equals(Point other) {
        if (this.x == other.x && this.y == other.y) {
            return true;
        }
        return false;
    }
    /**
     * @return the X of point.
     */
    public double getX() {
        return this.x;
    }
    /**
     * @return the Y of point.
     */
    public double getY() {
        return this.y;
    }


}
