//ID: 207488305

package sprites;

import graphics.Rectangle;
import interfaces.Collidable;
import interfaces.HitListener;
import interfaces.HitNotifier;
import interfaces.Sprite;
import biuoop.DrawSurface;
import graphics.Point;
import velocity.Velocity;
import game.GameLevel;

import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

/**
 * A block build from a color and a rectangle.
 *
 * @author ofri zangi
 * @version 1.00 24 April 2021
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private java.awt.Color color;
    private List<HitListener> hitListeners;

    /**
     * Constructor.
     *
     * @param r     the rectangle the block will be build of.
     * @param color the color of the block.
     */
    public Block(Rectangle r, java.awt.Color color) {
        this.rectangle = r;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * Drawing the block on a given surface.
     *
     * @param s the draw surface.
     */
    public void drawOn(DrawSurface s) {
        // filling the block
        s.setColor(this.color);
        s.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) (this.rectangle.getUpperLeft().getY() - this.rectangle.getHeight()),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        s.setColor(Color.BLACK);
        s.drawRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) (this.rectangle.getUpperLeft().getY() - this.rectangle.getHeight()),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        // drawing the outline of the block

    }

    /**
     * @return the rectangle we collided with.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }


    /**
     * changing the velocity of the object that hitted the block.
     *
     * @param collisionPoint  the sprite.sprite.collision point with the block.
     * @param currentVelocity the velocity we want to change.
     * @param hitter          the ball that hit the block.
     * @return the new velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double epsilon = Math.pow(10, -5);
        // if the ball hits both edges of the block both the directions should change.
        if ((Math.abs(collisionPoint.getY() - this.rectangle.getUpperLeft().getY()) < epsilon
                || Math.abs(collisionPoint.getY() - (this.rectangle.getUpperLeft().getY()
                - this.rectangle.getHeight())) < epsilon)
                && (Math.abs(collisionPoint.getX() - this.rectangle.getUpperLeft().getX()) < epsilon
                || Math.abs(collisionPoint.getX() - (this.rectangle.getUpperLeft().getX()
                + this.rectangle.getWidth())) < epsilon)) {
            this.notifyHit(hitter);
            return new Velocity(-currentVelocity.getDx(), -currentVelocity.getDy());
        }
        // if the ball hits a horizontal edge of the block the vertical direction should change.
        if (Math.abs(collisionPoint.getY() - this.rectangle.getUpperLeft().getY()) < epsilon
                || Math.abs(collisionPoint.getY() - (this.rectangle.getUpperLeft().getY()
                - this.rectangle.getHeight())) < epsilon) {
            this.notifyHit(hitter);
            return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        }
        //if the ball hits a vertical edge of the block the horizontal direction should change.
        if (Math.abs(collisionPoint.getX() - this.rectangle.getUpperLeft().getX()) < epsilon
                || Math.abs(collisionPoint.getX() - (this.rectangle.getUpperLeft().getX()
                + this.rectangle.getWidth())) < epsilon) {
            this.notifyHit(hitter);
            return new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
        }
        return currentVelocity;
    }

    /**
     * Notify the block that time has passed.
     */
    public void timePassed() {
        return;
    }

    /**
     * Add the block to the game.
     *
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * Adding a listener to the list.
     *
     * @param hl the listener we want to add.
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * Removing a listener from the list.
     *
     * @param hl the listener we want to remove.
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * Notifying all the different listeners of the block that there was a hit.
     *
     * @param hitter the ball that hitted the block.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * Removing the block from the game.
     *
     * @param game the game we want to remove the block from.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }


}
