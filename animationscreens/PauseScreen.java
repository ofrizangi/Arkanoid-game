//ID: 207488305

package animationscreens;

import biuoop.DrawSurface;
import interfaces.Animation;

/**
 * A pause screen that appears when we want to stop the game.
 *
 * @author ofri zangi
 * @version 1.00 12 June 2021
 */
public class PauseScreen implements Animation {
    private boolean stop;

    /**
     * Constructor.
     */
    public PauseScreen() {
        this.stop = false;
    }

    /**
     * Drawing the pause screen.
     *
     * @param d the draw surface to draw on.
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
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
