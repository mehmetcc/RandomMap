package core;

import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 * A product of mehmetcc (Mehmet Can Altuntaş)
 * Generate beautiful worlds that makes sense
 */

public class TileMap {
    // variables
    private Tile[][] map;
    private int mapSize;
    private Random random;

    // constructor(s)
    public TileMap(int size) {
        mapSize = size;
        map = new Tile[mapSize][mapSize];

        random = new Random();

        // initialize everything as void
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = new Tile(TileType.VOID);
            }
        }

        generateMap();
    }

    // methods
    public void generateMap() {
        int numberOfLaketileLeaders  = randomNumberInGivenRange(2, 4);
        int numberOfGrasslandLeaders = randomNumberInGivenRange(2, 6);
        int numberOfGroundLeaders    = randomNumberInGivenRange(2, 6);

        HashMap<Coordinate, TileType> leaderMap = new HashMap<Coordinate, TileType>();

        // establish leader tiles for lakes
        for (int i = 0; i < numberOfLaketileLeaders; i++) {
            int randomX = randomNumberInGivenRange(1, mapSize - 1);
            int randomY = randomNumberInGivenRange(1, mapSize - 1);
            map[randomX][randomY] = new Tile(TileType.LAKETILE);

            Coordinate tmp = new Coordinate(randomX, randomY);
            leaderMap.put(tmp, TileType.LAKETILE);
        }

        // establish leader tiles for ground
        for (int i = 0; i < numberOfGroundLeaders; i++) {
            int randomX = randomNumberInGivenRange(1, mapSize - 1);
            int randomY = randomNumberInGivenRange(1, mapSize - 1);
            map[randomX][randomY] = new Tile(TileType.GROUND);

            Coordinate tmp = new Coordinate(randomX, randomY);
            leaderMap.put(tmp, TileType.GROUND);
        }

        // establish leader tiles for grasslands
        for (int i = 0; i < numberOfGrasslandLeaders; i++) {
            int randomX = randomNumberInGivenRange(1, mapSize - 1);
            int randomY = randomNumberInGivenRange(1, mapSize - 1);
            map[randomX][randomY] = new Tile(TileType.GRASSLAND);

            Coordinate tmp = new Coordinate(randomX, randomY);
            leaderMap.put(tmp, TileType.GRASSLAND);
        }


        // draw the entire map
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                HashMap<Integer, TileType> distances = new HashMap<Integer, TileType>(); // integer is for the distance

                // iterate the leader map and find the closest leader
                for (java.util.Map.Entry<Coordinate, TileType> entry : leaderMap.entrySet()) {
                    int distanceToAdd  = entry.getKey().findDistance(i, j);
                    TileType typeToAdd = entry.getValue();
                    distances.put(distanceToAdd, typeToAdd);
                }

                int key = Collections.min(distances.keySet());
                TileType finalizedTileType = distances.get(key);
                map[i][j].setNewType(finalizedTileType);
            }
        }


    }


    private void generateRoads() {
        // ToDo
    }


    // auxiliaries
    public Tile[][] getMap() { return map; }

    public void printMap() {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if      (map[i][j].getType().equals(TileType.GROUND))    System.out.print(0 + " ");
                else if (map[i][j].getType().equals(TileType.LAKETILE))  System.out.print(1 + " ");
                else if (map[i][j].getType().equals(TileType.GRASSLAND)) System.out.print(2 + " ");
                else if (map[i][j].getType().equals(TileType.BRIDGE))    System.out.print(3 + " ");
                else                                                     System.out.print(4 + " "); // void
            }
            System.out.println();
        }
    }

    private int randomNumberInGivenRange(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

}
