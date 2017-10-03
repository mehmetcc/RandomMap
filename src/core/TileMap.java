package core;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
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
    private HashMap<String, Coordinate> leaderCoordinates; // a map that holds the values of the start and the end of the map

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
        int numberOfLaketileLeaders  = randomNumberInGivenRange(1, 3);
        int numberOfGrasslandLeaders = randomNumberInGivenRange(2, 6);
        int numberOfGroundLeaders    = randomNumberInGivenRange(2, 6);

        HashMap<Coordinate, TileType> leaderMap = new HashMap<>();

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
                HashMap<Integer, TileType> distances = new HashMap<>(); // integer is for the distance

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


    private HashMap<String, Coordinate> generateRoads() {
        int roadStartX = 0;
        int roadStartY = 0;

        int roadEndX = 0;
        int roadEndY = 0;

        HashMap<Integer, Coordinate> leaders = new HashMap<>();

        // generate 4 different leader points

        // starting point
        roadStartX = randomNumberInGivenRange(2, mapSize / 8);
        roadStartY = randomNumberInGivenRange(2, mapSize - 2);
        leaders.put(1, new Coordinate(roadStartX, roadStartY));

        // second point
        leaders.put(2, new Coordinate(randomNumberInGivenRange(mapSize / 8 + 1, mapSize / 4),
                                      randomNumberInGivenRange(2, mapSize - 2)));

        // third point
        leaders.put(2, new Coordinate(randomNumberInGivenRange(mapSize / 4 + 1, mapSize / 2),
                randomNumberInGivenRange(2, mapSize - 2)));

        // final point
        roadEndX = randomNumberInGivenRange(2, mapSize - 1);
        roadEndY = randomNumberInGivenRange(2, mapSize - 2);
        leaders.put(1, new Coordinate(roadEndX, roadEndY));


        // ToDo draw maps



        // return a hashmap holding the start end the end points
        HashMap<String, Coordinate> tmp = new HashMap<>();
        tmp.put("Start", new Coordinate(roadStartX, roadStartY));
        tmp.put("End", new Coordinate(roadEndX, roadEndY));

        return tmp;
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
                else if (map[i][j].getType().equals(TileType.ROAD))      System.out.print(4 + " ");
                else                                                     System.out.print(5 + " "); // void
            }
            System.out.println();
        }
    }

    private int randomNumberInGivenRange(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

}
