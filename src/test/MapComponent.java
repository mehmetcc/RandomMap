package test;

import core.Tile;
import core.TileMap;
import core.TileType;

import javax.swing.*;
import java.awt.*;

/**
 * A product of mehmetcc (Mehmet Can Altuntaş)
 * Generate beautiful worlds that makes sense
 */

public class MapComponent extends JPanel {

    // constants
    private static final int MAPSIZE   = 32;
    private static final int PIXELSIZE = 16;
    private static final int WIDTH     = MAPSIZE * PIXELSIZE;
    private static final int HEIGHT    = MAPSIZE * PIXELSIZE;

    // variables
    private TileMap  map;
    private Tile[][] arrayMap;

    // constructor(s)
    public MapComponent() {
        map = new TileMap(MAPSIZE);
        arrayMap = map.getMap();


        this.setSize(WIDTH, HEIGHT);
    }

    // methods
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int x = 0; x < MAPSIZE; x++) {
            for (int y = 0; y < MAPSIZE; y++) {
                if      (arrayMap[x][y].getType().equals(TileType.GROUND))    g.setColor(Color.ORANGE);
                else if (arrayMap[x][y].getType().equals(TileType.LAKETILE))  g.setColor(Color.BLUE);
                else if (arrayMap[x][y].getType().equals(TileType.GRASSLAND)) g.setColor(Color.GREEN);

                g.fillRect(x * PIXELSIZE, y * PIXELSIZE, PIXELSIZE, PIXELSIZE);
            }
        }
    }

    public void reset() {
        this.removeAll();
        map.generateMap();
        this.repaint();
        this.revalidate();
    }

    public TileMap getMap() { return map; }
}
