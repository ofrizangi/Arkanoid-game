//ID: 207488305

package gamelevels;

import graphics.Point;
import graphics.Rectangle;
import interfaces.LevelInformation;
import interfaces.Sprite;
import sprites.Block;
import velocity.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Information about the level Final Four in the game.
 *
 * @author ofri zangi
 * @version 1.00 12 June 2021
 */
public class FinalFour implements LevelInformation {

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
        list.add(new Velocity(-6, -3));
        list.add(new Velocity(4, -3));
        list.add(new Velocity(5, -4));
        return list;
    }

    /**
     * @return the speed of the paddle
     */
    public int paddleSpeed() {
        return 7;
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
        return "Final Four";
    }

    /**
     * @return a sprite with the background of the level
     */
    public Sprite getBackground() {
        return new BackgroundFinalFour();
    }

    /**
     * Making the blocks that make the level, each block contains its size, color and location.
     *
     * @return a list with the balls
     */
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Random rand = new Random();
        // creating 6 lines of blocks.
        double height = 25;
        double width = 51;
        double upperLeftY = 120;
        Color[] colors = {Color.GRAY, Color.RED, Color.YELLOW, Color.GREEN, Color.WHITE, Color.PINK, Color.CYAN};
        for (int i = 0; i < 7; i++) {
            java.awt.Color color = colors[i];
            double upperLeftX = 730;
            blocks.add(new Block(new Rectangle(new Point(20, upperLeftY), 47, height), color));
            for (int j = 0; j < 14; j++) {
                blocks.add(new Block(new Rectangle(new Point(upperLeftX, upperLeftY), width, height), color));
                upperLeftX = upperLeftX - width;
            }
            upperLeftY = upperLeftY + height;
        }
        return blocks;
    }

    /**
     * @return the number of blocks that should be removed.
     */
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
