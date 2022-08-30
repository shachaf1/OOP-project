import biuoop.DrawSurface;
import biuoop.GUI;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import biuoop.KeyboardSensor;
/**
 * Game.
 * @author Shacahf yosef
 * ID: 206962763
 */
public class GameLevel implements Animation {
    private AnimationRunner runner;
    private GUI gui;
    private boolean running;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private biuoop.Sleeper sleeper;
    private Counter blocksCounter;
    private BlockRemover blockRemover;
    private Counter ballsCounter;
    private BallRemover ballRemover;
    private Counter scoreCounter;
    private ScoreTrackingListener scoreTrackingListener;
    private biuoop.KeyboardSensor keyboard;
    private LevelInformation levelInformation;
    /**
     * Constructor.
     * @param level - the level to start
     * @param ar - the animation runner.
     * @param ks - keyboard
     * @param scoreCounter - the score.
     */
    public GameLevel(LevelInformation level, AnimationRunner ar, KeyboardSensor ks, Counter scoreCounter) {
        this.levelInformation = level;
        this.blocksCounter = new Counter();
        this.blockRemover = new BlockRemover(this, this.blocksCounter);
        this.ballsCounter = new Counter();
        this.ballRemover = new BallRemover(this, this.ballsCounter);
        this.scoreCounter = scoreCounter;
        this.scoreTrackingListener = new ScoreTrackingListener(this.scoreCounter);
        this.runner = ar;
        this.keyboard = ks;
        this.gui = ar.getGui();
        this.sleeper = ar.getSleeper();
        this.running = true;
    }
    /**
     * @param c - the new collidable to add
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }
    /**
     * @param s - the new sprite to add
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }
    /**
     * add all borders to Collidable and Sprite.
     */
    public void addBorders() {
        Rectangle upScore = new Rectangle(new Point(0, 0), 800, 30);
        ScoreIndicator scoreBlock = new ScoreIndicator(upScore, Color.lightGray, scoreCounter,
                this.levelInformation.levelName());
        Rectangle upR = new Rectangle(new Point(0, 30), 800, 20);
        Block upB = new Block(upR, Color.gray);
        Rectangle leftR = new Rectangle(new Point(0, 51), 20, 600);
        Block leftB = new Block(leftR, Color.gray);
        Rectangle rightR = new Rectangle(new Point(780, 51), 20, 600);
        Block rightB = new Block(rightR, Color.gray);
        Rectangle downR = new Rectangle(new Point(0, 601), 850, 20);
        Block downB = new Block(downR, Color.gray);
        this.addSprite(scoreBlock);
        this.addSprite(upB);
        this.addCollidable(upB);
        this.addSprite(leftB);
        this.addCollidable(leftB);
        this.addSprite(rightB);
        this.addCollidable(rightB);
        this.addSprite(downB);
        this.addCollidable(downB);
        downB.addHitListener(this.ballRemover);
    }
    /**
     * @param n - number of blocks to add
     * @param color - color of blocks
     * @param p1 - point of first block
     * add line of blocks.
     */
    public void addBlocks(int n, java.awt.Color color, Point p1) {
        ArrayList arr = new ArrayList<Block>(5);
        Block b;
        for (int i = 1; i < n; i++) {
            Rectangle r = new Rectangle(new Point(p1.getX() - (i * 51), p1.getY()), 50, 20);
            b = new Block(r, color);
            this.addSprite(b);
            this.addCollidable(b);
            b.addHitListener(this.blockRemover);
            this.blocksCounter.increase(1);
            b.addHitListener(scoreTrackingListener);
        }
    }
    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle) and add them to the game.
     */
    public void initialize() {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        Sprite back = this.levelInformation.getBackground();
        this.addSprite(back);
        this.addBorders();
        List<Block> blocks = levelInformation.blocks();
        for (Block block : blocks) {
            this.addSprite(block);
            this.addCollidable(block);

            block.addHitListener(this.blockRemover);
            this.blocksCounter.increase(1);
            block.addHitListener(scoreTrackingListener);
        }
        List<Velocity> velocities = this.levelInformation.initialBallVelocities();
        for (Velocity velocity : velocities) {
            Ball ball = new Ball(new Point(400, 530), 7, Color.white);
            this.addSprite(ball);
            ball.setGameEnvironment(this.environment);
            ball.setVelocity(velocity);
            this.ballsCounter.increase(1);
        }
        Paddle paddle = new Paddle(this.levelInformation.paddleWidth(),
                this.levelInformation.paddleSpeed(), this.gui, Color.red);
        paddle.addToGame(this);
    }
    /**
     * run the game -- start the animation loop.
     */
    public void run() {
        //initialize();
        this.runner.run(new CountdownAnimation(1, 3, this.sprites)); // countdown before turn starts.

        this.running = true;
        while (!this.shouldStop()) {
            // use our runner to run the current animation -- which is one turn of
            // the game.
            this.runner.run(this);
        }
    }
    /**
     * un the game -- start the animation loop.
     * @param c - collidable to remove
     */
    public void removeCollidable(Collidable c) {
        this.environment.remCollidable(c);
    }
    /**
     * un the game -- start the animation loop.
     * @param s - sprite to remove
     */
    public void removeSprite(Sprite s) {
        this.sprites.remSprite(s);
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        long startTime = System.currentTimeMillis(); // timing
        d.setColor(Color.blue);
        d.fillRectangle(0, 0, 800, 600);
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        // timing
        long usedTime = System.currentTimeMillis() - startTime;
        long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
        if (milliSecondLeftToSleep > 0) {
            sleeper.sleepFor(milliSecondLeftToSleep);
        }
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, new PauseScreen()));
        }
        if (this.blocksCounter.getValue() == 0) {
            this.scoreCounter.increase(100);

            //gui.close();
            this.running = false;
        }
        //System.out.println(this.ballsCounter.getValue());
        if (this.ballsCounter.getValue() == 0) {

            //gui.close();
            this.running = false;
        }
    }
    @Override
    public boolean shouldStop() {
        return !this.running;
    }
    /**
     * @return  balls left
     */
    public int getBallsVal() {
        return this.ballsCounter.getValue();
    }
    /**
     * @return  blocks left
     */
    public int getBlocksVal() {
        return this.blocksCounter.getValue();
    }
}