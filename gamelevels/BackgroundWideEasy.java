//ID: 207488305

package gamelevels;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.awt.Color;

/**
 * The background of the level Wide Easy in the game.
 *
 * @author ofri zangi
 * @version 1.00 12 June 2021
 */
public class BackgroundWideEasy implements Sprite {

    /**
     * Drawing the background.
     *
     * @param d the draw surface to draw on.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 800, 600);
        Color color = new Color(245, 245, 143);
        d.setColor(color);
        // drawing lines
        for (int i = 0; i < 40; i += 5) {
            d.drawLine(i, 230, 100, 140);
        }
        for (int i = 40; i < 70; i += 3) {
            d.drawLine(i, 230, i + 60, 140);
        }
        for (int i = 70; i < 100; i += 3) {
            d.drawLine(i, 230, i + 40, 140);
        }
        for (int i = 100; i < 120; i += 3) {
            d.drawLine(i, 230, i + 20, 140);
        }
        for (int i = 120; i < 150; i += 3) {
            d.drawLine(i, 230, i + 5, 140);
        }
        for (int i = 150; i < 180; i += 3) {
            d.drawLine(i, 140, i + 5, 230);
        }
        for (int i = 170; i < 190; i += 3) {
            d.drawLine(i, 140, i + 20, 230);
        }
        for (int i = 180; i < 200; i += 3) {
            d.drawLine(i, 140, i + 30, 230);
        }
        for (int i = 200; i < 250; i += 3) {
            d.drawLine(195, 140, i + 35, 230);
        }
        for (int i = 250; i < 300; i += 7) {
            d.drawLine(195, 145, i + 40, 230);
        }
        for (int i = 300; i < 350; i += 7) {
            d.drawLine(195, 140, i + 45, 230);
        }
        for (int i = 350; i < 400; i += 7) {
            d.drawLine(193, 140, i + 50, 230);
        }
        for (int i = 400; i < 700; i += 10) {
            d.drawLine(193, 140, i + 55, 230);
        }
        //drawing circles
        d.fillCircle(140, 130, 60);
        Color color2 = new Color(255, 204, 0);
        d.setColor(color2);
        d.fillCircle(140, 130, 50);
        Color color3 = new Color(255, 255, 0);
        d.setColor(color3);
        d.fillCircle(140, 130, 40);
    }
    /**
     * notify the sprite that time has passed.
     */
    public void timePassed() {
        return;
    }
}
