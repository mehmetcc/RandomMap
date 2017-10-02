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

    public int findDistance(int xLoc, int yLoc) {
        int distance;

        int xDistance = Math.abs(x - xLoc);
        int yDistance = Math.abs(y - yLoc);
        double tmp    = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
        distance      = (int)tmp;

        return distance;
    }
}
