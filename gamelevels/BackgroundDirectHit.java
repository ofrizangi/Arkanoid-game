//ID: 207488305

package gamelevels;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.awt.Color;

/**
 * The background of the level Direct Hit in the game.
 *
 * @author ofri zangi
 * @version 1.00 12 June 2021
 */
public class BackgroundDirectHit implements Sprite {

    /**
     * Drawing the background.
     *
     * @param d the draw surface to draw on.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.BLUE);
        d.drawCircle(415, 155, 120);
        d.drawCircle(415, 155, 90);
        d.drawCircle(415, 155, 60);
        d.drawLine(275, 155, 555, 155);
        d.drawLine(415, -10, 415, 295);
    }

    /**
     * notify the sprite that time has passed.
     */
    public void timePassed() {
        return;
    }

}
