//ID: 207488305

package sprites;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Collidable;
import interfaces.Sprite;
import graphics.Rectangle;
import graphics.Point;
import game.GameLevel;
import velocity.Velocity;

import java.awt.Color;

/**
 * A paddle build from a rectangle and a sensor.
 *
 * @author ofri zangi
 * @version 1.00 24 April 2021
 */
public class Paddle implements Sprite, Collidable {
    private static final int END_OF_BOARD_WIDTH = 780;
    private static final int START_OF_BOARD_WIDTH = 20;

    private Rectangle r;
    private KeyboardSensor keyboard;
    private int speed;

    /**
     * Constructor.
     *
     * @param r        the rectangle the paddle is build from
     * @param keyboard in order to make paddle move.
     * @param speed    the speed of the paddle
     */
    public Paddle(Rectangle r, biuoop.KeyboardSensor keyboard, int speed) {
        this.r = r;
        this.keyboard = keyboard;
        this.speed = speed;
    }

    /**
     * @return the paddle rectangle
     */
    public Rectangle getRectangle() {
        return this.r;
    }

    /**
     * moving the paddle left only in the range of the screen.
     */
    public void moveLeft() {
        if (this.r.getUpperLeft().getX() > START_OF_BOARD_WIDTH) {
            this.r.getUpperLeft().setX(this.r.getUpperLeft().getX() - this.speed);
        }
    }

    /**
     * moving the paddle right only in the range of the screen.
     */
    public void moveRight() {
        if (this.r.getUpperLeft().getX() + this.r.getWidth() < END_OF_BOARD_WIDTH) {
            this.r.getUpperLeft().setX(this.r.getUpperLeft().getX() + this.speed);
        }
    }

    /**
     * notify the keyboard to move the paddle.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * drawing the paddle on the screen.
     *
     * @param d the draw surface we want to draw the paddle on.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.GRAY);
        d.fillRectangle((int) this.r.getUpperLeft().getX(), (int) (this.r.getUpperLeft().getY() - this.r.getHeight()),
                (int) this.r.getWidth(), (int) this.r.getHeight());
    }

    /**
     * @return the rectangle the paddle is build of.
     */
    public Rectangle getCollisionRectangle() {
        return this.r;
    }

    /**
     * Change the velocity of the object hitting the ball when the collision happens.
     *
     * @param collisionPoint  the collision point with the object
     * @param currentVelocity the velocity of the object that collided with tha paddle.
     * @param hitter          the ball that hits the object..
     * @return the new velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if (collisionPoint.getY() < 570) {
            // separating the object to 5 parts.
            double region = (this.r.getWidth() / 5);
            double epsilon = Math.pow(10, -5);
            // calculating the speed by using pitagoras sentence.
            double speed1 = (int) Math.sqrt(Math.pow(currentVelocity.getDx(), 2)
                    + Math.pow(currentVelocity.getDy(), 2));
            if (Math.abs(collisionPoint.getY() - this.r.getUpperLeft().getY()) < epsilon
                    || Math.abs(collisionPoint.getY()
                    - (this.r.getUpperLeft().getY() - this.r.getHeight())) < epsilon) {
                // if we are in the first region
                if (collisionPoint.getX() <= region + this.r.getUpperLeft().getX()) {
                    return Velocity.fromAngleAndSpeed(300, speed1);
                    // if we are in the second region
                } else if (collisionPoint.getX() <= 2 * region + this.r.getUpperLeft().getX()) {
                    return Velocity.fromAngleAndSpeed(330, speed1);
                    // if we are in the third region
                } else if (collisionPoint.getX() <= 3 * region + this.r.getUpperLeft().getX()) {
                    return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
                    // if we are in the fourth region
                } else if (collisionPoint.getX() <= 4 * region + this.r.getUpperLeft().getX()) {
                    return Velocity.fromAngleAndSpeed(30, speed1);
                    // if we are in the fifth region
                } else {
                    return Velocity.fromAngleAndSpeed(60, speed1);
                }
            }
            //if the ball hits a vertical edge of the block
            if (Math.abs(collisionPoint.getX() - this.r.getUpperLeft().getX()) < epsilon
                    || Math.abs(collisionPoint.getX() - (this.r.getUpperLeft().getX() + this.r.getWidth())) < epsilon) {
                return new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
            }
        }
        return currentVelocity;
    }

    /**
     * Add this paddle to the game.
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}
