//ID: 207488305

package game;

import biuoop.DrawSurface;
import biuoop.GUI;
import interfaces.Animation;

/**
 * Running the animation.
 *
 * @author ofri zangi
 * @version 1.00 12 June 2021
 */
public class AnimationRunner {

    private GUI gui;
    private int framesPerSecond;

    /**
     * Constructor.
     *
     * @param gui             the board we want to run the animation on.
     * @param framesPerSecond how much time we want to show each frame.
     */
    public AnimationRunner(GUI gui, int framesPerSecond) {
        this.gui = gui;
        this.framesPerSecond = framesPerSecond;
    }

    /**
     * Setting the number of frames per second.
     *
     * @param framesPerSecond1 how much frames we want to show in a second.
     */
    public void setFramesPerSecond(int framesPerSecond1) {
        this.framesPerSecond = framesPerSecond1;
    }

    /**
     * Running the animation.
     *
     * @param animation the animation we want to run.
     */
    public void run(Animation animation) {
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {

            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);

            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }


}
