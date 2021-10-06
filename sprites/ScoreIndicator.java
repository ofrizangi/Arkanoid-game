//ID: 207488305

package sprites;

import biuoop.DrawSurface;
import game.Counter;
import game.GameLevel;
import interfaces.Sprite;

/**
 * Indicating the score on a block.
 *
 * @author ofri zangi
 * @version 1.00 23 May 2021
 */
public class ScoreIndicator implements Sprite {

    private Block block;
    private Counter score;

    /**
     * Constructor.
     *
     * @param block a block that the score will be printed on.
     * @param score the score.
     */
    public ScoreIndicator(Block block, Counter score) {
        this.block = block;
        this.score = score;
    }


    /**
     * draw the sprite to the screen.
     *
     * @param d the drawing surface.
     */
    public void drawOn(DrawSurface d) {
        block.drawOn(d);
        d.drawText(350, 15, "Score: " + score.getValue(), 16);
    }

    /**
     * notify the sprite that time has passed.
     */
    public void timePassed() {
        return;
    }

    /**
     * adding the score to the game.
     *
     * @param g the game we want to add the score to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
