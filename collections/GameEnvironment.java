//ID: 207488305

package collections;

import java.util.ArrayList;
import java.util.List;

import interfaces.Collidable;
import game.CollisionInfo;
import graphics.Line;
import graphics.Point;

/**
 * the game environment that contains a list of all the collidable objects.
 *
 * @author ofri zangi
 * @version 1.00 24 April 2021
 */
public class GameEnvironment {

    private ArrayList<Collidable> collidables;

    /**
     * Constructor.
     * Creating a list of collidables.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }

    /**
     * @return the list of all collidables.
     */
    public ArrayList<Collidable> getCollidables() {
        return this.collidables;
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c the collidable we want to add.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * returning the information about the closest collision that is going to occur.
     *
     * @param trajectory the route the object will do.
     * @return if the ia a collision point return the information about the closest collision, otherwise
     * return null.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<Collidable> collidables1 = new ArrayList<>(this.collidables);
        if (collidables1.isEmpty()) {
            return null;
        }
        Point min = trajectory.closestIntersectionToStartOfLine(collidables1.get(0).getCollisionRectangle());
        Collidable collisionObject = collidables1.get(0);
        // going over all the collidable objects.
        for (int i = 1; i < collidables1.size(); i++) {
            Point p1 = trajectory.closestIntersectionToStartOfLine(collidables1.get(i).getCollisionRectangle());
            if (min == null) {
                if (p1 != null) {
                    min = p1;
                    collisionObject = collidables1.get(i);
                }
            } else {
                if (p1 != null) {
                    // checking which point is closer
                    if (trajectory.comparePointsAndReturnCloser(p1, min) != min) {
                        min = p1;
                        collisionObject = collidables1.get(i);
                    }
                }
            }
        }
        // if there is no collision pont returning null
        if (min == null) {
            return null;
        }
        // returning the collision point information.
        return new CollisionInfo(min, collisionObject);
    }
}
