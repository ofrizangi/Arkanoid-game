//ID: 207488305

package game;

import interfaces.Animation;
import collections.SpriteCollection;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Counting down until the game level starts.
 *
 * @author ofri zangi
 * @version 1.00 12 June 2021
 */
public class CountdownAnimation implements Animation {

    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private String levelName;

    /**
     * Constructor.
     *
     * @param numOfSeconds the number of seconds we want to count.
     * @param countFrom    the number we want to start counting from.
     * @param gameScreen   the game screen we want to do the counting on.
     * @param levelName    the name of the level we want to do the countdown for.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen, String levelName) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.levelName = levelName;
    }

    /**
     * Drawing the countdown screen.
     *
     * @param d the draw surface to draw on.
     */
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.YELLOW);
        d.drawText(390, 380, "" + this.countFrom, 130);
        d.setColor(Color.BLACK);
        d.drawText(550, 15, "Level Name: " + levelName, 16);
        this.countFrom--;
    }

    /**
     * Letting the game know we want to stop showing the screen.
     * If we got to end of the count we should stop showing the animation.
     *
     * @return true if we should stop, false otherwise.
     */
    public boolean shouldStop() {
        if (this.countFrom == 0) {
            return true;
        }
        return false;
    }

}
