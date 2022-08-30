import biuoop.DrawSurface;
import biuoop.GUI;
import java.awt.Color;
import java.util.Random;


public class Test {

    private static void drawAnimation() {
        //create new gui whit the Rectangle.
        GUI gui = new GUI("title", 800, 800);
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        Rectangle r1 = new Rectangle(new Point(20,20), 55,40);
        Block b1 = new Block(r1, Color.gray);

        Rectangle r2 = new Rectangle(new Point(0,0), 800,5);
        Block b2 = new Block(r2, Color.gray);
        Rectangle r3 = new Rectangle(new Point(0,0), 5,800);
        Block b3 = new Block(r3, Color.gray);
        Rectangle r4 = new Rectangle(new Point(795,0), 5,800);
        Block b4 = new Block(r4, Color.gray);
        Rectangle r5 = new Rectangle(new Point(0,795), 800,5);
        Block b5 = new Block(r5, Color.gray);
        Rectangle r6 = new Rectangle(new Point(300,360), 60,50);
        Block b6 = new Block(r6, Color.gray);
        GameEnvironment g = new GameEnvironment();
        g.addCollidable(b1);
        g.addCollidable(b2);
        g.addCollidable(b3);
        g.addCollidable(b4);
        g.addCollidable(b5);
        g.addCollidable(b6);
        Ball ball1 = new Ball(new Point( 300, 300),10,Color.blue);
        ball1.setGameEnvironment(g);
        ball1.setVelocity(-11,-10);

        while (true) {
            DrawSurface surface = gui.getDrawSurface();
            b1.drawOn(surface);
            b2.drawOn(surface);
            b3.drawOn(surface);
            b4.drawOn(surface);
            b5.drawOn(surface);
            b6.drawOn(surface);
            ball1.moveOneStep();

            ball1.drawOn(surface);
            gui.show(surface);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
    public static void main(String[] args) {
        drawAnimation();
    }

}
