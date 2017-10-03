package core;

/**
 * A product of mehmetcc (Mehmet Can Altuntaş)
 * Generate beautiful worlds that makes sense
 */

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    /**
     * Calculates the distance between the given coordinate and the object itself
     * @param xLoc x coordinate
     * @param yLoc y coordinate
     * @return the distance
     */
    public int findDistance(int xLoc, int yLoc) {
        int distance;

        int xDistance = Math.abs(x - xLoc);
        int yDistance = Math.abs(y - yLoc);
        double tmp    = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
        distance      = (int)tmp;

        return distance;
    }

    /**
     * Finds the coordinate where to straight lines first intersect between the object itself and the given coordinate
     * @param xLoc
     * @param yLoc
     * @return
     */
    public Coordinate findCrossing(int xLoc, int yLoc) {
        int xCoord = Math.abs(x - xLoc);
        int yCoord = Math.max(y, yLoc);

        return new Coordinate(xCoord, yCoord);
    }

    public String toString() {
        return "X: " + x + " Y: " + y;
    }
}
