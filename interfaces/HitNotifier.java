// ID: 207488305

package interfaces;

/**
 * A HitNotifier interface to notify the listeners of a hit event.
 *
 * @author ofri zangi
 * @version 1.00 23 May 2021
 */
public interface HitNotifier {

    /**
     * Add a listener to hit events.
     *
     * @param hl the listener we want to add.
     */
    void addHitListener(HitListener hl);

    /**
     * Remove a listener from the list of listeners to hit events.
     *
     * @param hl the listener we want to remove.
     */
    void removeHitListener(HitListener hl);
}
