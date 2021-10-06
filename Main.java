import game.AnimationRunner;
import interfaces.Animation;
import animationscreens.GameOverScreen;
import animationscreens.PauseScreen;
import animationscreens.KeyPressStoppableAnimation;
import biuoop.GUI;


public class Main {

    public static void main(String[] args) {
        GUI gui = new GUI("game", 600, 800);
        AnimationRunner runner = new AnimationRunner(gui, 60);
        Animation a1 = new GameOverScreen( 80);
        Animation a2 = new PauseScreen(); // also an Animation
        Animation a1k = new KeyPressStoppableAnimation(gui.getKeyboardSensor(), "m", a1);
        Animation a2k = new KeyPressStoppableAnimation(gui.getKeyboardSensor(), "m", a2);
        runner.run(a1k);
        runner.run(a2k);
        gui.close();
    }
}
