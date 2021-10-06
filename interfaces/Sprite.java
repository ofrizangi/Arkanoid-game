package interfaces;
//ID: 207488305

import biuoop.DrawSurface;

/**
 * A interface for all the objects drawn on screen.
 *
 * @author ofri zangi
 * @version 1.00 24 April 2021
 */
public interface Sprite {

    /**
     * draw the sprite to the screen.
     *
     * @param d the drawing surface.
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}
