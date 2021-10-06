// ID: 207488305

package interfaces;
import sprites.Ball;
import sprites.Block;

/**
 * A HitListener interface for all the listeners we want to notify about a hit event.
 *
 * @author ofri zangi
 * @version 1.00 23 May 2021
 */
public interface HitListener {

    /**
     * This method is called whenever the beingHit object is hit.
     *
     * @param beingHit the block that was hit.
     * @param hitter the ball that hit the block.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
