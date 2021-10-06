//ID: 207488305

package animationscreens;

import biuoop.DrawSurface;
import interfaces.Animation;

/**
 * A win screen that appears when someone wins the game.
 *
 * @author ofri zangi
 * @version 1.00 12 June 2021
 */
public class YouWinScreen implements Animation {
    private int score;
    private boolean stop;

    /**
     * Constructor.
     *
     * @param score the score we got from playing the game.
     */
    public YouWinScreen(int score) {
        this.stop = false;
        this.score = score;
    }

    /**
     * Drawing the win screen.
     *
     * @param d the draw surface to draw on.
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "You Win!", 64);
        d.drawText(280, d.getHeight() / 2, " Your score is" + " " + score, 31);

    }

    /**
     * Letting the game know we want to stop showing the screen. Here we will never return we should stop.
     *
     * @return true if we should stop, false otherwise.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
