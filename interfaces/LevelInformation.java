//ID: 207488305

package interfaces;

import velocity.Velocity;
import sprites.Block;
import java.util.List;

/**
 * An interface of all the information about a level in the game.
 *
 * @author ofri zangi
 * @version 1.00 12 June 2021
 */
public interface LevelInformation {

    /**
     * @return the number of the balls in the game.
     */
    int numberOfBalls();

    /**
     * @return a list containing the initial velocity of each ball
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return the speed of the paddle
     */
    int paddleSpeed();

    /**
     * @return the width of the paddle
     */
    int paddleWidth();

    /**
     * @return the level name
     */
    String levelName();

    /**
     * @return a sprite with the background of the level
     */
    Sprite getBackground();

    /**
     * Making the blocks that make the level, each block contains its size, color and location.
     *
     * @return a list with the balls
     */
    List<Block> blocks();

    /**
     * @return the number of blocks that should be removed.
     */
    int numberOfBlocksToRemove();
}
