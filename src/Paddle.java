import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
/**
 * paddle.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private GUI gui;
    private Rectangle rectangle;
    private java.awt.Color color;
    private int paddleSpeed = 10;
    private static final double SPEED = 5;
    /**
     * Constructor.
     * @param gui - the gui of the game.
     * @param color color of the paddle.
     */
    public Paddle(GUI gui, java.awt.Color color) {
        this.gui = gui;
        this.keyboard = gui.getKeyboardSensor();
        this.rectangle = new Rectangle(new Point(350, 570), 150, 20);
        this.color = color;
    }
    /**
     * Constructor.
     * @param gui - the gui of the game.
     * @param color color of the paddle.
     * @param width width of the paddle.
     * @param speed speed of the paddle.
     */
    public Paddle(int width, int speed, GUI gui, java.awt.Color color) {
        this.gui = gui;
        this.keyboard = gui.getKeyboardSensor();
        this.rectangle = new Rectangle(new Point(400 - (width / 2), 570), width, 20);
        this.color = color;
        this.paddleSpeed = speed;
    }
    /**
     * move left.
     */
    public void moveLeft() {
        if (this.rectangle.getUpperLeft().getX() < 30) {
            return;
        }
        this.rectangle.setUpperLeft(new Point(this.rectangle.getUpperLeft().getX()
                - this.paddleSpeed, this.rectangle.getUpperLeft().getY()));
    }
    /**
     * move right.
     */
    public void moveRight() {
        if (this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth() > 770) {
            return;
        }
        this.rectangle.setUpperLeft(new Point(this.rectangle.getUpperLeft().getX()
                + this.paddleSpeed, this.rectangle.getUpperLeft().getY()));
    }
    /**
     * move according to KeyboardSensor.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }
    /**
     * @param surface - the surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(),
                (int) rectangle.getHeight());
    }
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double speed = currentVelocity.getSpeed();
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        double area1 = this.rectangle.getWidth() / 5 + this.rectangle.getUpperLeft().getX();
        double area2 = this.rectangle.getWidth() * 2 / 5 + this.rectangle.getUpperLeft().getX();
        double area3 = this.rectangle.getWidth() * 3 / 5 + this.rectangle.getUpperLeft().getX();
        double area4 = this.rectangle.getWidth() * 4 / 5 + this.rectangle.getUpperLeft().getX();
        double area5 = this.rectangle.getWidth() + this.rectangle.getUpperLeft().getX();
        Velocity newV = new Velocity(dx, dy);
        if (Math.round(collisionPoint.getY()) == Math.round(this.rectangle.getUpperLeft().getY())) {

            if (collisionPoint.getX() < area1) {
                newV = Velocity.fromAngleAndSpeed(300, SPEED);
                return  newV;
            }
            if (collisionPoint.getX() < area2) {
                newV = Velocity.fromAngleAndSpeed(330, SPEED);
                return  newV;
            }
            if (collisionPoint.getX() < area3) {
                dy = -currentVelocity.getDy();
                return new Velocity(dx, dy);
            }
            if (collisionPoint.getX() < area4) {
                newV = Velocity.fromAngleAndSpeed(30, SPEED);
                return  newV;
            }
            newV = Velocity.fromAngleAndSpeed(60, SPEED);
        }
        if (Math.round(collisionPoint.getY()) == Math.round(this.rectangle.getUpperLeft().getY()
                + this.rectangle.getHeight())) {
            dy = -currentVelocity.getDy();
            return new Velocity(dx, dy);
        }
        if (Math.round(collisionPoint.getX()) == Math.round(this.rectangle.getUpperLeft().getX())) {
            dx = -currentVelocity.getDx();
            return new Velocity(dx, dy);
        }
        if (Math.round(collisionPoint.getX()) == Math.round(this.rectangle.getUpperLeft().getX()
                + this.rectangle.getWidth())) {
            dx = -currentVelocity.getDx();
            return new Velocity(dx, dy);
        }
        return  newV;

    }
    /**
     * @param g can be any game
     */
    // Add this paddle to the game.
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);

    }
}