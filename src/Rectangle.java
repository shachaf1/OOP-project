import java.util.LinkedList;
import java.util.List;
/**
 * rectangle.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    /**
     * Constructor.
     * @param upperLeft - the upperLeft point of rectangle.
     * @param width the width of rectangle.
     * @param height the height of rectangle..
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }
    /**
     * @param upperLeft1 - the upperLeft point of rectangle.
     */
    public void setUpperLeft(Point upperLeft1) {
        this.upperLeft = upperLeft1;
    }
    /**
     * @param line - any line.
     * @return a (possibly empty) List of intersection points with the specified line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        //get each line of rectangle
        Line up = new Line(this.upperLeft, new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY()));
        Line left = new Line(this.upperLeft, new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height));
        Line down = new Line(new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height),
                new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height));
        Line right = new Line(new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY()),
                new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height));
        //get inters with each line
        List<Point> listOfPoints = new LinkedList<>();
        if (line.intersectionWith(up) != null) {
            listOfPoints.add(line.intersectionWith(up));
        }
        if (line.intersectionWith(right) != null && line.intersectionWith(right) != line.intersectionWith(up)) {
            listOfPoints.add(line.intersectionWith(right));
        }
        if (line.intersectionWith(down) != null && line.intersectionWith(down) != line.intersectionWith(right)) {
            listOfPoints.add(line.intersectionWith(down));
        }
        if (line.intersectionWith(left) != null && line.intersectionWith(left) != line.intersectionWith(down)
                && line.intersectionWith(left) != line.intersectionWith(up)) {
            listOfPoints.add(line.intersectionWith(left));
        }
        if (listOfPoints.size() != 0) {
            return listOfPoints;
        }
        return null;
    }
    /**
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }
    /**
     * @return the upperleft of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}