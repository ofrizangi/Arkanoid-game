//ID: 207488305

package graphics;

/**
 * one line build from two decimal points.
 *
 * @author ofri zangi
 * @version 1.00 30 March 2021
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * Constructor by two points.
     *
     * @param start the start of the line (one of the edges).
     * @param end   the end of the line (one of the edges).
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Constructor by four decimal numbers.
     *
     * @param x1 the x coordinate of the start of the line (one of the edges).
     * @param y1 the y coordinate of the start of the line (one of the edges).
     * @param x2 the x coordinate of the end of the line (one of the edges).
     * @param y2 the y coordinate of the end of the line (one of the edges).
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * @return the length of the line.
     */
    public double length() {
        return this.start.distance(end);
    }

    /**
     * @return the middle point of the line.
     */
    public Point middle() {
        double x1 = (this.end.getX() + this.start.getX()) / 2;
        double y1 = (this.end.getY() + this.start.getY()) / 2;
        return new Point(x1, y1);
    }

    /**
     * @return the start point of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * @return the end point of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * Calculate the incline between the edges of the line.
     *
     * @return the incline of the line.
     */
    private double incline() {
        double num1 = this.start.getY() - this.end.getY();
        double num2 = this.start.getX() - this.end.getX();
        // if the line is parallel to the y axle the incline is infinity
        if (num2 == 0) {
            return Double.POSITIVE_INFINITY;
        }
        return num1 / num2;
    }

    /**
     * Checking intersection between tow lines.
     *
     * @param other another line.
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        // if the function returns null the lines don't intersect.
        if (intersectionWith(other) == null) {
            return false;
        }
        return true;
    }

    /**
     * Solving the lines equations in order to find the intersection point.
     *
     * @param other another line.
     * @return the x coordinate we found by solving the lines equations.
     */
    private double solvingLinesEquation(Line other) {
        double m1 = this.incline();
        double m2 = other.incline();
        // if one of the lines incline is infinity, we return the x coordinate of the start point of the line.
        if (m1 == Double.POSITIVE_INFINITY) {
            return this.start.getX();
        }
        if (m2 == Double.POSITIVE_INFINITY) {
            return other.start.getX();
        }
        // subtracting the x coefficient of both equations to the same side (which is the incline).
        double oneSide = m1 - m2;
        // subtracting the constant term of both equations to the same side.
        double secondSide = (-m2 * other.start.getX() + other.start().getY()) - (-m1 * this.start.getX()
                + this.start.getY());
        // dividing the constant term with the x coefficient, which brings the equation solution.
        return secondSide / oneSide;
    }

    /**
     * checking if the intersection point that was found is in the ranges of both the lines.
     *
     * @param other another line.
     * @param x1    the x coordinate of the intersection point.
     * @return true if the coordinate is in the range of the lines, false otherwise.
     */
    private boolean inRangeXCoordinate(double x1, Line other) {
        double min = Math.min(this.start.getX(), this.end.getX());
        double max = Math.max(this.start.getX(), this.end.getX());
        // if the coordinate is in the range of this line
        double epsilon = Math.pow(10, -5);
        if ((x1 > min && x1 < max) || (Math.abs(min - x1) < epsilon || Math.abs(max - x1) < epsilon)) {
            min = Math.min(other.start.getX(), other.end.getX());
            max = Math.max(other.start.getX(), other.end.getX());
            // if the coordinate is in the range of the other line
            if ((x1 > min && x1 < max) || (Math.abs(min - x1) < epsilon || Math.abs(max - x1) < epsilon)) {
                return true;
            }
        }
        return false;
    }

    /**
     * checking if the intersection point that was found is in the ranges of both the lines.
     *
     * @param other another line.
     * @param y1    the x coordinate of the intersection point.
     * @return true if the coordinate is in the range of the lines, false otherwise.
     */
    private boolean inRangeYCoordinate(double y1, Line other) {
        double min = Math.min(this.start.getY(), this.end.getY());
        double max = Math.max(this.start.getY(), this.end.getY());
        // if the coordinate is in the range of this line
        double epsilon = Math.pow(10, -5);
        if ((y1 > min && y1 < max) || (Math.abs(min - y1) < epsilon || Math.abs(max - y1) < epsilon)) {
            min = Math.min(other.start.getY(), other.end.getY());
            max = Math.max(other.start.getY(), other.end.getY());
            // if the coordinate is in the range of the other line
            if ((y1 > min && y1 < max) || (Math.abs(min - y1) < epsilon || Math.abs(max - y1) < epsilon)) {
                return true;
            }
        }
        return false;
    }

    /**
     * checking if the both the points are not on the lines, if they aren't we return true and otherwise false.
     *
     * @param other another line.
     * @param p1    a point
     * @param p2    a point
     * @return true if the point are not on the line anf false otherwise.
     */
    private boolean ifPointsNotOnLines(Line other, Point p1, Point p2) {
        if (this.incline() != Double.POSITIVE_INFINITY) {
            if (!inRangeXCoordinate(p1.getX(), other) && !inRangeXCoordinate(p2.getX(), other)) {
                return true;
            }
        } else {
            if (!inRangeYCoordinate(p1.getY(), other) && !inRangeYCoordinate(p2.getY(), other)) {
                return true;
            }
        }
        return false;
    }

    /**
     * checking if the parallel meet at only one point. If they meet we return the point, if they don't meet
     * or if they meet at more than one point we return null.
     *
     * @param other another line.
     * @return the point if the lines meet only in this point, otherwise returns null.
     */
    private Point meetOnceWhenParallel(Line other) {
        if (this.start.equals(other.start)) {
            if (ifPointsNotOnLines(other, other.end, this.end)) {
                return this.start;
            }
        }
        if (this.start.equals(other.end)) {
            if (ifPointsNotOnLines(other, other.start, this.end)) {
                return this.start;
            }
        }
        if (this.end.equals(other.end)) {
            if (ifPointsNotOnLines(other, other.start, this.start)) {
                return this.end;
            }
        }
        if (this.end.equals(other.start)) {
            if (ifPointsNotOnLines(other, other.end, this.start)) {
                return this.end;
            }
        }
        return null;
    }

    /**
     * finding the intersection point between two lines.
     *
     * @param other another line.
     * @return the intersection point if the lines intersect, and null otherwise.
     */
    public Point intersectionWith(Line other) {
        // if the inclines of both lines are equal the lines are parallel or unified.
        if (this.incline() == other.incline()) {
            // if it's not the same line
            if (!((this.start.equals(other.start) && this.end.equals(other.end))
                    || (this.start.equals(other.end) && this.end.equals(other.start)))) {
                return meetOnceWhenParallel(other);
            } else {
                return null;
            }
        }
        // the x coordinate of the lines intersection
        double x1 = this.solvingLinesEquation(other);
        // if the x coordinate is in this range.
        if (inRangeXCoordinate(x1, other)) {
            double y1;
            // finding the y coordinate by one of the lines equations (that it's incline isn't infinity).
            if (this.incline() != Double.POSITIVE_INFINITY) {
                y1 = this.incline() * x1 - this.incline() * this.start.getX() + this.start.getY();
            } else {
                y1 = other.incline() * x1 - other.incline() * other.start.getX() + other.start.getY();
            }
            if (!inRangeYCoordinate(y1, other)) {
                return null;
            }
            return new Point(x1, y1);
        }
        return null;

    }

    /**
     * checking if two lines are equal.
     *
     * @param other another line.
     * @return true if the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        // if both of the points are equal the line is equal
        if ((this.start.equals(other.start) && this.end.equals(other.end))
                || (this.start.equals(other.end) && this.end.equals(other.start))) {
            return true;
        }
        return false;
    }

    /**
     * Comparing between two points and returning the closer point to this line.
     *
     * @param p1 first point.
     * @param p2 second point.
     * @return the point that is closer to the line.
     */
    public Point comparePointsAndReturnCloser(Point p1, Point p2) {
        double m1, m2;
        // if the incline of the line is infinity
        if (this.incline() == Double.POSITIVE_INFINITY) {
            m1 = Math.abs(this.start.getY() - p1.getY());
            m2 = Math.abs(this.start.getY() - p2.getY());
        } else {
            m1 = Math.abs(this.start.getX() - p1.getX());
            m2 = Math.abs(this.start.getX() - p2.getX());
        }
        if (m1 < m2) {
            return p1;
        }
        return p2;
    }

    /**
     * Returning the closest intersection point to the line.
     *
     * @param rect the rectangle that we want to check his intersection points with the line.
     * @return the closest intersection point to the start of the line. Otherwise, if this line does not intersect
     * with the rectangle, return null.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        // getting the array op intersection points
        java.util.List<Point> points = rect.intersectionPoints(new Line(this.start, this.end));
        if (points.isEmpty()) {
            return null;
        }
        Point minPoint = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            Point currentPoint = points.get(i);
            // returning the closer point between both of them.
            minPoint = comparePointsAndReturnCloser(minPoint, currentPoint);
        }
        return minPoint;
    }
}
