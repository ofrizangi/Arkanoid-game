//ID: 207488305

package gamelevels;

import graphics.Point;
import interfaces.LevelInformation;
import interfaces.Sprite;
import sprites.Block;
import velocity.Velocity;
import graphics.Rectangle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Information about the level Direct Hit in the game.
 *
 * @author ofri zangi
 * @version 1.00 12 June 2021
 */
public class DirectHit implements LevelInformation {


    /**
     * @return the number of the balls in the game.
     */
    public int numberOfBalls() {
        return this.initialBallVelocities().size();
    }

    /**
     * @return a list containing the initial velocity of each ball
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        list.add(new Velocity(0, -3));
        return list;
    }

    /**
     * @return the speed of the paddle
     */
    public int paddleSpeed() {
        return 5;
    }

    /**
     * @return the width of the paddle
     */
    public int paddleWidth() {
        return 80;
    }

    /**
     * @return the level name
     */
    public String levelName() {
        return "Direct Hit";
    }

    /**
     * @return a sprite with the background of the level
     */
    public Sprite getBackground() {
        return new BackgroundDirectHit();
    }

    /**
     * Making the blocks that make the level, each block contains its size, color and location.
     *
     * @return a list with the balls
     */
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(new Rectangle(new Point(400, 170), 30, 30), Color.RED));
        return blocks;
    }

    /**
     * @return the number of blocks that should be removed.
     */
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
