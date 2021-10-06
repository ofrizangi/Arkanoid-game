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
 * Information about the level Wide Easy in the game.
 *
 * @author ofri zangi
 * @version 1.00 12 June 2021
 */
public class WideEasy implements LevelInformation {

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
        for (int i = 0; i < 5; i++) {
            list.add(new Velocity(i + 3, -5 + i));
        }
        for (int i = 0; i > -5; i--) {
            list.add(new Velocity(i - 3, -5 - i));
        }
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
        return 650;
    }

    /**
     * @return the level name
     */
    public String levelName() {
        return "Wide Easy";
    }

    /**
     * @return a sprite with the background of the level
     */
    public Sprite getBackground() {
        return new BackgroundWideEasy();
    }

    /**
     * Making the blocks that make the level, each block contains its size, color and location.
     *
     * @return a list with the balls
     */
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(new Rectangle(new Point(20, 250), 60, 20), Color.RED));
        blocks.add(new Block(new Rectangle(new Point(70, 250), 60, 20), Color.RED));
        blocks.add(new Block(new Rectangle(new Point(120, 250), 60, 20), Color.ORANGE));
        blocks.add(new Block(new Rectangle(new Point(170, 250), 60, 20), Color.ORANGE));
        blocks.add(new Block(new Rectangle(new Point(220, 250), 60, 20), Color.YELLOW));
        blocks.add(new Block(new Rectangle(new Point(270, 250), 60, 20), Color.YELLOW));
        blocks.add(new Block(new Rectangle(new Point(320, 250), 60, 20), Color.GREEN));
        blocks.add(new Block(new Rectangle(new Point(370, 250), 60, 20), Color.GREEN));
        blocks.add(new Block(new Rectangle(new Point(420, 250), 60, 20), Color.GREEN));
        blocks.add(new Block(new Rectangle(new Point(470, 250), 60, 20), Color.BLUE));
        blocks.add(new Block(new Rectangle(new Point(520, 250), 60, 20), Color.BLUE));
        blocks.add(new Block(new Rectangle(new Point(570, 250), 60, 20), Color.PINK));
        blocks.add(new Block(new Rectangle(new Point(620, 250), 60, 20), Color.PINK));
        blocks.add(new Block(new Rectangle(new Point(670, 250), 60, 20), Color.CYAN));
        blocks.add(new Block(new Rectangle(new Point(720, 250), 60, 20), Color.CYAN));
        return blocks;
    }

    /**
     * @return the number of blocks that should be removed.
     */
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
