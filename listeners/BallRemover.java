//ID: 207488305

package listeners;

import sprites.Ball;
import game.GameLevel;
import game.Counter;
import interfaces.HitListener;
import sprites.Block;

/**
 * A listener for removing balls from the game, and keeping count of the balls that remain.
 *
 * @author ofri zangi
 * @version 1.00 23 May 2021
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * Constructor.
     *
     * @param game the game we want to remove the balls from
     * @param remainingBalls the number of remaining balls in the game.
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    /**
     * Balls the hit the "death block" is removed from the game.
     *
     * @param beingHit the death block which the ball hit.
     * @param hitter the ball we want to remove.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }

}
