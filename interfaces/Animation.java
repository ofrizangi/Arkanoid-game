//ID: 207488305

package interfaces;

import biuoop.DrawSurface;

/**
 * An interface for all the objects that do an animation screen.
 *
 * @author ofri zangi
 * @version 1.00 12 June 2021
 */
public interface Animation {

    /**
     * doing all the things we need to do in a single frame in the animation.
     *
     * @param d the draw surface to do the things on.
     */
    void doOneFrame(DrawSurface d);

    /**
     * Letting know we want to stop the animation.
     *
     * @return true if the animation should stop, else otherwise.
     */
    boolean shouldStop();
}
