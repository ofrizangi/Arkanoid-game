//ID: 207488305

package game;

import biuoop.GUI;
import biuoop.KeyboardSensor;
import interfaces.LevelInformation;
import animationscreens.GameOverScreen;
import animationscreens.KeyPressStoppableAnimation;
import animationscreens.YouWinScreen;

import java.util.List;

/**
 * the game flow class, initializing and running it.
 *
 * @author ofri zangi
 * @version 1.00 12 June 2021
 */
public class GameFlow {
    private static final int BOARD_WIDTH = 800;
    private static final int BOARD_HEIGHT = 600;

    private Counter score;
    private KeyboardSensor keyboard;
    private GUI gui;

    /**
     * Constructor.
     */
    public GameFlow() {
        this.score = new Counter();
        this.gui = new GUI("game", BOARD_WIDTH, BOARD_HEIGHT);
        this.keyboard = gui.getKeyboardSensor();
    }

    /**
     * Running all the levels of the game and creating different screens when necessary.
     *
     * @param levels a list with all the levels.
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {

            //running the levels.
            GameLevel level = new GameLevel(levelInfo, this.score, this.gui, this.keyboard);
            level.initialize();
            level.run();

            // if no balls remains in the game we want to create a game over screen
            if (level.getRemainingBalls() == 0) {
                level.gerRunner().run(new KeyPressStoppableAnimation(this.keyboard,
                        KeyboardSensor.SPACE_KEY, new GameOverScreen(this.score.getValue())));
                this.gui.close();
                break;
            }
        }
        // if we finished all the levels we want to create a game win screen
        if (!levels.isEmpty()) {
            GameLevel level = new GameLevel(levels.get(0), this.score, this.gui, this.keyboard);
            level.gerRunner().run(new KeyPressStoppableAnimation(this.keyboard,
                    KeyboardSensor.SPACE_KEY, new YouWinScreen(this.score.getValue())));
            this.gui.close();
        }
    }
}
