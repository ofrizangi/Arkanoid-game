//ID: 207488305

package collections;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * a collection of all sprites.
 *
 * @author ofri zangi
 * @version 1.00 24 April 2021
 */
public class SpriteCollection {
    private ArrayList<Sprite> sprites;

    /**
     * Constructor. creating a new list of sprites.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<>();
    }

    /**
     * adding a sprite to the list.
     *
     * @param s the sprite we want to add.
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * removing a sprite from the list.
     *
     * @param s the sprite we want to remove.
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spriteList = new ArrayList<Sprite>(this.sprites);
        for (Sprite s : spriteList) {
            s.timePassed();
        }
    }

    /**
     * drawing all the sprites on  the screen.
     *
     * @param d the drawing surface.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : this.sprites) {
            s.drawOn(d);
        }
    }
}