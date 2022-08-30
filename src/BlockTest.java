import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Sharon Weiss
 */
class BlockTest {

    @Test
    void getCollisionRectangle() {

    }

    @Test
    void hit() {
        GameEnvironment gameEnvironment = new GameEnvironment();
        Point point1 = new Point(6.5, 1.5);
        Ball ball1 = new Ball(point1, 10, Color.CYAN);
        Point point2 = new Point(9, 5);
        Ball ball2 = new Ball(point2, 10, Color.MAGENTA);
        Point point3 = new Point(1.5, 1.5);
        Ball ball3 = new Ball(point3, 10, Color.PINK);
        Point a = new Point(2, 2);
        Rectangle r1 = new Rectangle(a, 6, 4);
        Block b1 = new Block(r1, Color.gray);
        gameEnvironment.addCollidable(b1);
        ball1.setGameEnvironment(gameEnvironment);
        ball2.setGameEnvironment(gameEnvironment);
        ball1.setVelocity(-0.5, 0.5);
        ball2.setVelocity(-1, -1);
        ball3.setVelocity(0.5, 0.5);
        Line l1 = new Line(ball1.getCenter(), new Point(ball1.getCenter().getX() + ball1.getVelocity().getDx(), ball1.getCenter().getY() + ball1.getVelocity().getDy()));
        CollisionInfo collision1 = gameEnvironment.getClosestCollision(l1);
        Line l2 = new Line(ball2.getCenter(), new Point(ball2.getCenter().getX() + ball2.getVelocity().getDx(), ball2.getCenter().getY() + ball2.getVelocity().getDy()));
        CollisionInfo collision2 = gameEnvironment.getClosestCollision(l2);
        Line l3 = new Line(ball3.getCenter(), new Point(ball3.getCenter().getX() + ball3.getVelocity().getDx(), ball3.getCenter().getY() + ball3.getVelocity().getDy()));
        CollisionInfo collision3 = gameEnvironment.getClosestCollision(l3);


    }

    @Test
    void setShape() {

    }
}