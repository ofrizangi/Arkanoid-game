//ID: 207488305

package game;

import java.awt.Color;
import java.util.List;

import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import collections.GameEnvironment;
import collections.SpriteCollection;
import interfaces.Animation;
import interfaces.LevelInformation;
import interfaces.Sprite;
import listeners.ScoreTrackingListener;
import animationscreens.KeyPressStoppableAnimation;
import animationscreens.PauseScreen;
import sprites.Block;
import interfaces.Collidable;
import sprites.Paddle;
import listeners.BlockRemover;
import listeners.BallRemover;
import graphics.Point;
import graphics.Rectangle;
import sprites.Ball;
import sprites.ScoreIndicator;

/**
 * the game level class, initializing and running it.
 *
 * @author ofri zangi
 * @version 1.00 12 June 2021
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter remainingBlocks;
    private Counter remainingBalls;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;

    private static final int RADIUS = 5;

    /**
     * Constructor.
     *
     * @param levelInformation the information of the level.
     * @param score            of the game
     * @param gui              the board of the game.
     * @param keyboard         a keyboard sensor
     */
    public GameLevel(LevelInformation levelInformation, Counter score, GUI gui, KeyboardSensor keyboard) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.remainingBlocks = new Counter();
        this.remainingBalls = new Counter();
        this.score = score;
        this.gui = gui;
        this.runner = new AnimationRunner(gui, 60);
        this.keyboard = keyboard;
        this.levelInformation = levelInformation;
    }

    /**
     * adding a collidable to the game.
     *
     * @param c the collidable we want to add.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * adding a sprite to the game.
     *
     * @param s the sprite we want to add.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks, Ball and Paddle and add them to the game.
     */
    public void initialize() {
        this.addSprite(levelInformation.getBackground());
        // creating a paddle and adding it to the game
        Paddle p = new Paddle(new Rectangle(new Point(380, 580),
                levelInformation.paddleWidth(), 15), gui.getKeyboardSensor(), levelInformation.paddleSpeed());
        while (p.getRectangle().getUpperLeft().getX() + p.getRectangle().getWidth() > 750) {
            p.getRectangle().getUpperLeft().setX(p.getRectangle().getUpperLeft().getX() - 50);
        }
        p.addToGame(this);
        // creating the big blocks for the corner of the screen.
        Block block = new Block(new Rectangle(new Point(0, 40), 800, 20), Color.GRAY);
        block.addToGame(this);
        block = new Block(new Rectangle(new Point(0, 600), 20, 560), Color.GRAY);
        block.addToGame(this);
        block = new Block(new Rectangle(new Point(780, 600), 20, 560), Color.GRAY);
        block.addToGame(this);
        // creating balls and adding them to the game.
        for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
            Ball ball = new Ball(new Point(420, 520), RADIUS, Color.WHITE);
            ball.setGameEnvironment(this.environment);
            ball.setVelocity(levelInformation.initialBallVelocities().get(i));
            ball.addToGame(this);
            this.remainingBalls.increase(1);
        }
        // creating a death region block for the balls.
        BallRemover ballRemover = new BallRemover(this, this.remainingBalls);
        Block deathRegion = new Block(new Rectangle(new Point(20, 600), 760, 1), Color.WHITE);
        deathRegion.addToGame(this);
        deathRegion.addHitListener(ballRemover);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.score);
        BlockRemover blockRemover = new BlockRemover(this, this.remainingBlocks);
        List<Block> blocks = levelInformation.blocks();
        for (int i = 0; i < blocks.size(); i++) {
            blocks.get(i).addToGame(this);
            this.remainingBlocks.increase(1);
            blocks.get(i).addHitListener(blockRemover);
            blocks.get(i).addHitListener(scoreTrackingListener);
        }
        Block scoreBlock = new Block(new Rectangle(new Point(0, 20), 800, 20), Color.WHITE);
        ScoreIndicator scoreIndicator = new ScoreIndicator(scoreBlock, this.score);
        scoreIndicator.addToGame(this);
    }

    /**
     * @return the animation runner of the game.
     */
    public AnimationRunner gerRunner() {
        return this.runner;
    }

    /**
     * @return true if the animation should stop, else otherwise.
     */
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * @return the number of balls remaining in the game.
     */
    public int getRemainingBalls() {
        return this.remainingBalls.getValue();
    }

    /**
     * doing all the things we need to do in a single frame.
     *
     * @param d the draw surface to do the things on.
     */
    public void doOneFrame(DrawSurface d) {
        // if we lost all the balls we want to stop running.
        if (this.remainingBalls.getValue() == 0) {
            this.running = false;
        }
        // if we destroyed all the blocks we want to finish the level
        if (this.remainingBlocks.getValue() == 0) {
            this.running = false;
            this.score.increase(100);
        }
        // if we press the key - p , we want to pause the game
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                    new PauseScreen()));
        }
        //drawing the level
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        d.drawText(550, 15, "Level Name: " + levelInformation.levelName(), 16);
    }

    /**
     * Run the level -- start the animation loop.
     */
    public void run() {
        // use the runner to run the current animation -- which is one turn of the game.
        this.runner.setFramesPerSecond(2);
        this.runner.run(new CountdownAnimation(2, 3, this.sprites, levelInformation.levelName()));
        this.running = true;
        this.runner.setFramesPerSecond(60);
        this.runner.run(this);
    }

    /**
     * Removing a collidable object from the list.
     *
     * @param c a collidable object to remove from list.
     */
    public void removeCollidable(Collidable c) {
        this.environment.getCollidables().remove(c);
    }

    /**
     * Removing a sprite object from the list.
     *
     * @param s a sprite object to remove from list.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

}
