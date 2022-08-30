import java.awt.*;
import java.util.List;

public class consTest {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(new Point(20, 20), 20, 20);
        Block b1 = new Block(r1, Color.gray);
        Rectangle r2 = new Rectangle(new Point(40, 40), 20, 20);
        Block b2 = new Block(r2, Color.gray);
        Rectangle r3 = new Rectangle(new Point(1500, 150), 20, 20);
        Block b3 = new Block(r3, Color.gray);
        Line line = new Line(100,100,0,0);
        GameEnvironment gameEnvironment = new GameEnvironment();
        gameEnvironment.addCollidable(b1);
        gameEnvironment.addCollidable(b2);
        gameEnvironment.addCollidable(b3);
        gameEnvironment.addCollidable(b3);
        List<Point> listOfPoints = r3.intersectionPoints(line);
        if(listOfPoints == null) {
            System.out.println("1");
        }
        Point p1;
        p1 = gameEnvironment.getClosestCollision(line).collisionPoint();
    }
}
