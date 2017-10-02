/**
 * A product of mecha
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
