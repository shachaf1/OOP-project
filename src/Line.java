import java.util.List;
/**
 * line.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class Line {
    private Point start;
    private Point end;
    /**
     * Constructor.
     * @param start can be any point.
     * @param end can be any point.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
    /**
     * Constructor.
     * @param x1 can be any positive number
     * @param y1 can be any positive number
     * @param x2 can be any positive number
     * @param y2 can be any positive number
     */
    public Line(double x1, double y1, double x2, double y2) {
        Point start1 = new Point(x1, y1);
        Point end1 = new Point(x2, y2);
        this.start = start1;
        this.end = end1;
    }
    /**
     * @return the length of line.
     */
    public double length() {
        return this.start.distance(this.end);
    }
    /**
     * @return the middle of the line.
     */
    public Point middle() {
        Point middle = new Point((this.start.getX() + this.end.getX()) / 2, (this.start.getY() + this.end.getY()) / 2);
        return middle;
    }
    /**
     * @return the start of the line.
     */
    public Point start() {
        return this.start;
    }
    /**
     * @return the end of the line.
     */
    public Point end() {
        return this.end;
    }
    /**
     * @return the slope of the line.
     */
    private double slope() {
        return (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
    }
    /**
     * @return the b from the equation y = mx+b of the line.
     */
    private double findB() {
        double m = this.slope();
        //using the equation y = mx + b and give it one point from the line(the start point)
        double b = this.start.getY() - m * this.start.getX();
        return b;
    }
    /**
     * @param other can be any line
     * @return the Intersecting point of two infinite lines.
     */
    public Point findInter(Line other) {
        //if the line is vertical
        if (this.end.getX() == this.start.getX()) {
            if (other.end.getX() == other.start.getX()) {
                return null;
            }
            //find the equation y = mx + b of each line
            double m2 = other.slope();
            double b2 = other.findB();
            double x = this.start.getX();
            //find Intersecting by the equations
            double y = m2 * x + b2;
            Point p1 = new Point(x, y);
            return p1;
        }
        //same if the other is vertical
        if (other.end.getX() == other.start.getX()) {
            double m2 = this.slope();
            double b2 = this.findB();
            double x = other.start.getX();
            double y = m2 * x + b2;
            Point p1 = new Point(x, y);
            return p1;
        }
        //else find the equation y = mx + b of each line
        double m1 = this.slope();
        double b1 = this.findB();
        double m2 = other.slope();
        double b2 = other.findB();
        if (m2 == m1) {
            return null;
        }
        //find Intersecting by the equations
        double x = (b2 - b1) / (m1 - m2);
        double y = m1 * x + b1;
        Point p1 = new Point(x, y);
        return p1;
    }
    /**
     * @param p1 can be any point
     * @return true if point in line or false else.
     */
    private boolean isPointInLine(Point p1) {
        //chekcs if the distance between the point to the middle to the end equals to the length.
        double d1 = this.start.distance(p1) + p1.distance(this.end);
        double d2 = this.length();
        double epsilon = Math.pow(10, -12);
        if ((d1 - d2) < epsilon) {
            return true;
        }
        return false;
    }
    /**
     * @param other can be any line
     * @return true if Intersecting or false else.
     */
    public boolean isIntersecting(Line other) {
        //get the Intersecting point
        Point p1 = this.findInter(other);
        //find the equation y = mx + b of each line
        double m1 = this.slope();
        double b1 = this.findB();
        double m2 = other.slope();
        double b2 = other.findB();
        //if same equation and the lines merge return true and if not merged return false.
        if (m2 == m1 && b1 == b2) {
            if (Math.max(this.start.getX(), this.end.getX()) < Math.min(other.start.getX(), other.end.getX())) {
                return false;
            }
            if (Math.min(this.start.getX(), this.end.getX()) > Math.max(other.start.getX(), other.end.getX())) {
                return false;
            }
            return true;
        }
        //if the point in the lines return true else return false.

        if (this.isPointInLine(p1) && other.isPointInLine(p1)) {
            return true;
        }
        return false;
    }
    /**
     * @param other can be any line
     * @return the Intersecting point of two final lines.
     */
    public Point intersectionWith(Line other) {
        //get the Intersecting point of two infinite lines
        Point p1 = this.findInter(other);
        if (p1 == null) {
            return null;
        }
        //if points in the two lines return the point, else - null.
        if (this.isPointInLine(p1) && other.isPointInLine(p1)) {
            return p1;
        }
        return null;
    }
    /**
     * @param other can be any line
     * @return return true it two lines are the same lines or false else.
     */
    public boolean equals(Line other) {
        //return true if start and end are the same or opposite and false if not.

        if (this.start == other.start && this.end == other.end) {
            return true;
        }
        if (this.end == other.start && this.start == other.end) {
            return true;
        }
        return false;
    }
    // If this line does not intersect with the rectangle, return null.
    // Otherwise, return the closest intersection point to the
    // start of the line.
    /**
     * @param rect can be any Rectangle
     * @return return the closest inter of the Rectangle with the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //put all inter in a list
        List<Point> listOfPoints = rect.intersectionPoints(this);
        //if no inter return null
        if (listOfPoints == null) {
            return null;
        }
        //if 1 return inter
        if (listOfPoints.size() == 1) {
            return listOfPoints.get(0);
        }
        //else return the closest - there could be up to two inter with each Rectangle
        if (this.start.distance(listOfPoints.get(0)) <= this.start.distance(listOfPoints.get(1))) {
            return listOfPoints.get(0);
        }
        return listOfPoints.get(1);
    }
}
