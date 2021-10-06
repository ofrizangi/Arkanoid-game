//ID: 207488305

package gamelevels;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.awt.Color;

/**
 * The background of the level Final Four in the game.
 *
 * @author ofri zangi
 * @version 1.00 12 June 2021
 */
public class BackgroundFinalFour implements Sprite {

    /**
     * Drawing the background.
     *
     * @param d the draw surface to draw on.
     */
    public void drawOn(DrawSurface d) {
        java.awt.Color color = new Color(51, 153, 255);
        d.setColor(color);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.WHITE);
        for (int i = 0; i < 80; i += 10) {
            d.drawLine(585 + i, 600, 610 + i, 500);
        }
        java.awt.Color colorLightGrey = new Color(204, 204, 204);
        java.awt.Color colorGrey = new Color(189, 178, 178);
        java.awt.Color colorDarkGrey = new Color(160, 150, 150);
        d.setColor(colorLightGrey);
        d.fillCircle(610, 500, 20);
        d.fillCircle(630, 525, 25);
        d.setColor(colorGrey);
        d.fillCircle(640, 505, 25);
        d.setColor(colorDarkGrey);
        d.fillCircle(655, 525, 20);
        d.fillCircle(670, 515, 30);
        d.setColor(Color.WHITE);
        for (int i = 0; i < 80; i += 10) {
            d.drawLine(65 + i, 600, 90 + i, 400);
        }
        d.setColor(colorLightGrey);
        d.fillCircle(90, 400, 20);
        d.fillCircle(110, 425, 25);
        d.setColor(colorGrey);
        d.fillCircle(120, 405, 25);
        d.setColor(colorDarkGrey);
        d.fillCircle(135, 425, 20);
        d.fillCircle(150, 415, 30);
    }

    /**
     * notify the sprite that time has passed.
     */
    public void timePassed() {
        return;
    }

}