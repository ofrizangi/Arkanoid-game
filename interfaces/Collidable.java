//ID: 207488305
package interfaces;

import graphics.Rectangle;
import graphics.Point;
import velocity.Velocity;
import sprites.Ball;

/**
 * A collidable interface for all the objects we wnt to collide in.
 *
 * @author ofri zangi
 * @version 1.00 24 April 2021
 */
public interface Collidable {

    /**
     * @return the collision shape of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it.
     *
     * @param collisionPoint  the collision point with the object.
     * @param currentVelocity the velocity of the object that hit with him.
     * @param hitter          the ball that hits the object.
     * @return the new velocity expected after the hit.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}

