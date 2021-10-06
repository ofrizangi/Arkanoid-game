//ID: 207488305

package velocity;
import graphics.Point;

/**
 * velocity.Velocity specifies the change in position on the 'x' and the 'y' axes.
 *
 * @author ofri zangi
 * @version 1.00 31 March 2021
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * Constructor.
     *
     * @param dx the change in position on the 'x' axe
     * @param dy the change in position on the 'y' axe
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     *
     * @param p the point we want to move.
     * @return the new point.
     */
    public Point applyToPoint(Point p) {
        double x = p.getX() + this.dx;
        double y = p.getY() + this.dy;
        return new Point(x, y);
    }


    /**
     * Setting the change in position on the 'x' axe.
     *
     * @param dx1 the new change in the position on the 'x' axe.
     */
    public void setDx(double dx1) {
        this.dx = dx1;
    }

    /**
     * Setting the change in position on the 'y' axe.
     *
     * @param dy1 the new change in the position on the 'y' axe.
     */
    public void setDy(double dy1) {
        this.dy = dy1;
    }

    /**
     * @return the change in the position on the 'x' axe.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * @return the change in the position on the 'y' axe.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * Chang the speed and angle to fit velocity.
     *
     * @param angle the angle we wnt to use for velocity
     * @param speed the speed we wnt to use for velocity
     * @return the change in the position on the 'y' axe.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double radians = Math.toRadians(angle);
        double dx = speed * Math.sin(radians);
        double dy = -(speed * Math.cos(radians));
        return new Velocity(dx, dy);
    }
}
