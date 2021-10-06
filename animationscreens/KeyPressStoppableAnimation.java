//ID: 207488305

package animationscreens;

import biuoop.DrawSurface;
import interfaces.Animation;
import biuoop.KeyboardSensor;

/**
 * Letting the game know we want to the animation when some key is pressed.
 *
 * @author ofri zangi
 * @version 1.00 12 June 2021
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;

    /**
     * Constructor.
     *
     * @param sensor    a keyboard sensor
     * @param key       the key we want to press in order to stop the game.
     * @param animation the animation we want to stop.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.sensor = sensor;
        this.key = key;
        this.isAlreadyPressed = true;
    }

    /**
     * Letting the game know we want to stop showing the screen.
     * If the key is pressed we will return the game true to stop.
     *
     * @return true if we should stop, false otherwise.
     */
    public boolean shouldStop() {
        if (this.sensor.isPressed(key)) {
            if (!this.isAlreadyPressed) {
                return true;
            }
        } else {
            this.isAlreadyPressed = false;
        }
        return false;
    }

    /**
     * Drawing the animation.
     *
     * @param d the draw surface to draw on.
     */
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
    }
}