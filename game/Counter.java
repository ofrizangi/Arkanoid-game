//ID: 207488305

package game;

/**
 * A counter.
 *
 * @author ofri zangi
 * @version 1.00 23 May 2021
 */
public class Counter {

    private int counter;

    /**
     * Constructor. initializing the counter.
     */
    public Counter() {
        this.counter = 0;
    }

    /**
     * add number to current count.
     *
     * @param number the number we want to add.
     */
    public void increase(int number) {
        this.counter = this.counter + number;
    }


    /**
     * subtract number from current count.
     *
     * @param number the number we want to subtract.
     */
    public void decrease(int number) {
        this.counter = this.counter - number;
    }

    /**
     * @return the current count.
     */
    public int getValue() {
        return this.counter;
    }
}
