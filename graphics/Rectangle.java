package graphics;
//ID: 207488305

import java.util.ArrayList;

/**
 * a rectangle build from an upper point, a width and a height.
 *
 * @author ofri zangi
 * @version 1.00 24 April 2021
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Constructor.
     * Creating a new rectangle with location and width/height.
     *
     * @param upperLeft a location point
     * @param width     the width of the rectangle
     * @param height    the height of the rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * Returning a (possibly empty) List of intersection points with a specified line.
     *
     * @param line the line we check if the rectangle intersect with.
     * @return an array of points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        Point upperRight = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
        Point bottomLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() - this.height);
        Point bottomRight = new Point(upperRight.getX(), this.upperLeft.getY() - this.height);
        // creating the lines of the rectangle
        Line l1 = new Line(this.upperLeft, upperRight);
        Line l2 = new Line(this.upperLeft, bottomLeft);
        Line l3 = new Line(bottomLeft, bottomRight);
        Line l4 = new Line(bottomRight, upperRight);
        java.util.List<Point> points = new ArrayList<>();
        // for each line, we check if it intersect with the our param line, and add the intersection point to the list.
        if (line.intersectionWith(l1) != null) {
            points.add(line.intersectionWith(l1));
        }
        if (line.intersectionWith(l2) != null) {
            points.add(line.intersectionWith(l2));
        }
        if (line.intersectionWith(l3) != null) {
            points.add(line.intersectionWith(l3));
        }
        if (line.intersectionWith(l4) != null) {
            points.add(line.intersectionWith(l4));
        }
        return points;
    }

    /**
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}
