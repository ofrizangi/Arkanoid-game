//ID: 207488305

package gamelevels;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.awt.Color;

/**
 * The background of the level Green 3 in the game.
 *
 * @author ofri zangi
 * @version 1.00 12 June 2021
 */
public class BackgroundGreen3 implements Sprite {

    /**
     * Drawing the background.
     *
     * @param d the draw surface to draw on.
     */
    public void drawOn(DrawSurface d) {
        java.awt.Color color = new Color(40, 102, 40);
        d.setColor(color);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.BLACK);
        d.fillRectangle(60, 440, 110, 180);
        d.setColor(Color.WHITE);
        int startX = 70;
        int startY = 450;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                d.fillRectangle(startX, startY, 10, 28);
                startX += 20;
            }
            startX = 70;
            startY += 33;
        }
        Color color1 = new Color(51, 51, 51);
        d.setColor(color1);
        d.fillRectangle(100, 390, 30, 50);
        Color colorGrey = new Color(102, 102, 102);
        d.setColor(colorGrey);
        d.fillRectangle(110, 200, 10, 190);
        Color colorYellow = new Color(236, 164, 111);
        d.setColor(colorYellow);
        d.fillCircle(115, 205, 14);
        Color colorRed = new Color(222, 76, 76);
        d.setColor(colorRed);
        d.fillCircle(115, 205, 9);
        d.setColor(Color.YELLOW);
        d.fillCircle(115, 205, 4);
    }

    /**
     * notify the sprite that time has passed.
     */
    public void timePassed() {
        return;
    }

}