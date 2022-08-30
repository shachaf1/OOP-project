import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(new Point(20, 20), 50, 40);
        Line line = new Line(100,100,0,0);
        //  System.out.println(rectangle.intersectionPoints(line));
        Point p = line.closestIntersectionToStartOfLine(rectangle);
        System.out.println(p.getX());
        System.out.println(p.getY());
    }

}