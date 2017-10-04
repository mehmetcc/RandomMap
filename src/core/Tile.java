package core;

/**
 * A product of mehmetcc (Mehmet Can Altuntaş)
 * Generate beautiful worlds that makes sense
 */

public class Tile {
    private TileType type;

    public Tile(TileType t_type) {
        type = t_type;
    }

    public TileType getType() { return type; }

    public boolean setNewType(TileType t_type) {
        type = t_type;

        return true;
    }
}
