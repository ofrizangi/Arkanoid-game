//ID: 207488305

package listeners;

import game.Counter;
import interfaces.HitListener;
import sprites.Block;
import sprites.Ball;

/**
 * A listener for changing the score when there was a hit event.
 *
 * @author ofri zangi
 * @version 1.00 23 May 2021
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * Constructor.
     *
     * @param scoreCounter the current score
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * Changing the score when a hit occurs.
     *
     * @param beingHit the block that was hit.
     * @param hitter   the ball that hit the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}
