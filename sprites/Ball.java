//ID: 207488305

package sprites;

import biuoop.DrawSurface;
import graphics.Line;
import graphics.Point;
import velocity.Velocity;
import collections.GameEnvironment;
import interfaces.Sprite;
import game.GameLevel;
import game.CollisionInfo;
import interfaces.Collidable;
import java.awt.Color;

/**
 * one ball, with a center point a radios and a color.
 *
 * @author ofri zangi
 * @version 1.00 26 April 2021
 */
public class Ball implements Sprite {
    private graphics.Point center;
    private int r;
    private java.awt.Color color;
    private Velocity v;
    private GameEnvironment environment;

    /**
     * Constructor.
     *
     * @param center the center of the ball
     * @param r      the size of the ball
     * @param color  the color of the ball.
     */
    public Ball(graphics.Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.v = new Velocity(0, 0);
        this.environment = new GameEnvironment();
    }

    /**
     * Constructor.
     *
     * @param y     the y coordinate of the center of the ball.
     * @param x     the x coordinate of the center of the ball
     * @param r     the size of the ball.
     * @param color the color of the ball.
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new graphics.Point(x, y);
        this.r = r;
        this.color = color;
        this.v = new Velocity(0, 0);
        this.environment = new GameEnvironment();
    }

    /**
     * @return the x coordinate of the center of the ball.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * @return the y coordinate of the center of the ball.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * @return the size of the ball.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * @return the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }


    /**
     * @return the game environment of the ball.
     */
    public GameEnvironment getGameEnvironment() {
        return this.environment;
    }

    /**
     * Setting the game environment of the ball.
     *
     * @param g the game environment we want to set.
     */
    public void setGameEnvironment(GameEnvironment g) {
        this.environment = g;
    }

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param s the surface the ball is drawn on.
     */
    public void drawOn(DrawSurface s) {
        s.setColor(Color.BLACK);
        s.drawCircle(this.getX(), this.getY(), r);
        s.setColor(this.color);
        s.fillCircle(this.getX(), this.getY(), r);
    }

    /**
     * Setting the velocity of the ball.
     *
     * @param v1 the velocity we want the ball to have.
     */
    public void setVelocity(Velocity v1) {
        this.v = v1;
    }

    /**
     * Setting the velocity of the ball.
     *
     * @param dx part of the velocity we want the ball to have.
     * @param dy part of the velocity we want the ball to have.
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * @return the velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * Letting know the function moveOneStep that time has passed.
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * Adding the ball to the game.
     *
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Checking if the ball hits a block in his next step, if he is we will change the velocity and move him,
     * otherwise we will just move him.
     */
    public void moveOneStep() {
        Line trajectory = new Line(this.center, this.v.applyToPoint(this.center));
        CollisionInfo collision = this.environment.getClosestCollision(trajectory);
        // if there is a collision
        if (collision != null) {
            this.v = collision.collisionObject().hit(this, collision.collisionPoint(), this.getVelocity());
            Point p1 = this.center;
            this.center = this.v.applyToPoint(this.center);
            // if the ball got in to another block we get him out.
            getBallOut(p1);
        } else {
            this.center = this.v.applyToPoint(this.center);
        }
    }

    /**
     * If the ball gets in the block, we want to get him out.
     *
     * @param p1 te previous place of the ball.
     */
    private void getBallOut(Point p1) {
        for (Collidable c : this.environment.getCollidables()) {
            if (ifBallInBlock(c, this.center)) {
                this.center = p1;
            }
        }
    }

    /**
     * Checking if the ball is in the collidable.
     *
     * @param c        the collidable object we want to check.
     * @param newPoint the new place of the ball.
     * @return true if the ball is in' false otherwise.
     */
    private boolean ifBallInBlock(Collidable c, graphics.Point newPoint) {
        Point upperPointOfRec = c.getCollisionRectangle().getUpperLeft();
        // checking if the ball is inside the block.
        if (newPoint.getX() < upperPointOfRec.getX() + c.getCollisionRectangle().getWidth()
                && newPoint.getX() > upperPointOfRec.getX()) {
            if (newPoint.getY() < upperPointOfRec.getY()
                    && newPoint.getY() > upperPointOfRec.getY() - c.getCollisionRectangle().getHeight()) {
                return true;
            }
        }
        return false;
    }


    /**
     * removing the ball from the game.
     *
     * @param game the game we want to remove the ball from.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}
