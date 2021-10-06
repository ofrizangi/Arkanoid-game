// ID: 207488305

package game;
import graphics.Point;
import interfaces.Collidable;

/**
 * the of the info of the sprite.sprite.collision - the sprite.sprite.collision object and point.
 *
 * @author ofri zangi
 * @version 1.00 24 April 2021
 */
public class CollisionInfo {

    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * Constructor.
     *
     * @param collisionPoint  the collision point.
     * @param collisionObject the collision object.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}

