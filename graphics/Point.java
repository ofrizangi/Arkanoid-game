//ID: 207488305

package graphics;

/**
 * one dimensional point.
 *
 * @author ofri zangi
 * @version 1.00 30 March 2021
 */
public class Point {
    private double x;
    private double y;

    /**
     * Constructor.
     *
     * @param x the x coordinate of the point.
     * @param y the y coordinate of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Distance.
     *
     * @param other another point.
     * @return the distance between the other point and this point.
     */
    public double distance(Point other) {
        double num1 = Math.abs(this.x - other.x);
        double num2 = Math.abs(this.y - other.y);
        return Math.sqrt(num1 * num1 + num2 * num2);
    }

    /**
     * Checks if the points are equal.
     *
     * @param other another point.
     * @return true is the points are equal, false otherwise
     */
    public boolean equals(Point other) {
        if (other != null) {
            double epsilon = Math.pow(10, -5);
            if ((Math.abs(other.x - this.x) < epsilon) && Math.abs(other.y - this.y) < epsilon) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return the x coordinate of the point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return the y coordinate of the point.
     */
    public double getY() {
        return this.y;
    }

    /**
     * set the x coordinate of the point.
     *
     * @param x1 an x coordinate.
     */
    public void setX(double x1) {
        this.x = x1;
    }

    /**
     * set the y coordinate of the point.
     *
     * @param y1 an y coordinate.
     */
    public void setY(double y1) {
        this.y = y1;
    }

}

