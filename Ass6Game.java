//ID: 207488305

import game.GameFlow;
import gamelevels.DirectHit;
import gamelevels.FinalFour;
import gamelevels.Green3;
import gamelevels.WideEasy;
import interfaces.LevelInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * a class that is activating the game.
 *
 * @author ofri zangi
 * @version 1.00 12 June 2021
 */
public class Ass6Game {

    /**
     * Main function.
     *
     * @param args a list that contains all the levels we want to run.
     */
    public static void main(String[] args) {

        List<LevelInformation> levels = new ArrayList<>();
        DirectHit directHit = new DirectHit();
        WideEasy wideEasy = new WideEasy();
        Green3 green3 = new Green3();
        FinalFour finalFour = new FinalFour();

        for (String level : args) {
            try {
                int numLevel = Integer.parseInt(level);
                if (numLevel == 1) {
                    levels.add(directHit);
                } else if (numLevel == 2) {
                    levels.add(wideEasy);
                } else if (numLevel == 3) {
                    levels.add(green3);
                } else if (numLevel == 4) {
                    levels.add(finalFour);
                }
            } catch (Exception e) {
                continue;
            }
        }
        if (levels.isEmpty()) {
            levels.add(directHit);
            levels.add(wideEasy);
            levels.add(green3);
            levels.add(finalFour);
        }
        GameFlow gameFlow = new GameFlow();
        gameFlow.runLevels(levels);

    }
}
