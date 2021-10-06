//ID: 207488305

package listeners;

import sprites.Ball;
import game.GameLevel;
import game.Counter;
import interfaces.HitListener;
import sprites.Block;

/**
 * A listener for removing blocks from the game, and keeping count of the blocks that remain.
 *
 * @author ofri zangi
 * @version 1.00 23 May 2021
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * Constructor.
     *
     * @param game            the game we want to remove the blocks from
     * @param remainingBlocks the number of remaining blocks in the game.
     */
    public BlockRemover(GameLevel game, Counter remainingBlocks) {
        this.game = game;
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * Blocks that are hit are removed from the game.
     *
     * @param beingHit that we want to remove.
     * @param hitter   the ball that hit that block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.game);
        beingHit.removeHitListener(this);
        remainingBlocks.decrease(1);
    }
}
