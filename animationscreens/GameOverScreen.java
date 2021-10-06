//ID: 207488305

package animationscreens;

import biuoop.DrawSurface;
import interfaces.Animation;

/**
 * A game over screen that appears when we lose the game.
 *
 * @author ofri zangi
 * @version 1.00 12 June 2021
 */
public class GameOverScreen implements Animation {
    private int score;
    private boolean stop;

    /**
     * Constructor.
     *
     * @param score the score we got from playing the game.
     */
    public GameOverScreen(int score) {
        this.stop = false;
        this.score = score;
    }

    /**
     * Drawing the game over screen.
     *
     * @param d the draw surface to draw on.
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "Game Over. Your score is" + " " + score, 32);
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
