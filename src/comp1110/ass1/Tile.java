package comp1110.ass1;

import java.lang.invoke.SwitchPoint;

/**
 * This class represents a movable tile in the TempleTrap game.   The
 * class encodes which sort of tile it is (tileName), its orientation,
 * its position on the board, and whether it currently holds the peg
 * (AKA the 'adventurer').
 *
 * This class contains four tasks of varying difficulty that you need
 * to complete.
 */
public class Tile {

    private final TileName tileName;      // The TileName ('PLUS', 'SQUARE' ...) (this never changes)
    private final Direction orientation;  // The tile's orientation (this does not change after the board has been initialised)
    public int position;                  // The current position of the tile on the board.

    private static Tile[] list = new Tile[TileName.values().length];

    /**
     * Static method to return the tile with give tild ID
     * @param id A tile ID corresponding to the tileName ordinal
     * @return The corresponding tile
     */
    public static Tile getTileFromID(int id) {
        assert id >= 0 && id <= TileName.values().length;
        return list[id];
    }

    /**
     * Constructor for a Tile
     *
     * @param type The TileType of the new tile
     * @param placement the String placement of the tile eg: "N0"
     */
    public Tile(TileName type, String placement) {
        this.tileName = type;
        this.orientation = placementToOrientation(placement);
        this.position = placementToPosition(placement);
        list[tileName.ordinal()] = this;
    }

    /**
     * Given a two-character tile placement string, decode the tile's position.
     *
     * You will need to read the description of the encoding in README.md.
     *
     * Hint: you will probably want to use the charAt() method on the placemen
     * string.
     *
     * @param placement A string representing the placement of a tile on the game board
     * @return An int corresponding to the tile's position on the board.
     */
    public static int placementToPosition(String placement) {
        return Integer.parseInt(placement.substring(1,2));
    }// FIXME Task 1 (P)

    /**
     * Given a two-character tile placement string, decode the tile's orientation.
     *
     * You will need to read the description of the encoding in README.md
     *
     * @param placement A string representing the placement of a tile on the game board
     * @return A value of type `Direction` corresponding to the tile's orientation on board
     */
    public static Direction placementToOrientation(String placement) {
        return Direction.fromChar(placement.charAt(0));
    }
    // FIXME Task 2.c (P)

    /**
     * Determine whether a given tile is adjacent to this tile instance,
     * and if so, the direction in which it is adjacent.
     *
     * For example: Tile tile1 is in position 0, tile other is in position 1.
     * other is adjacent to tile 1 in the Direction East, so the method would
     * return EAST.
     *
     * @param other the other tile
     * @return The direction of adjacency if the tiles are adjacent, or null if
     * they are not adjacent.
     */
    public Direction adjacencyDirection(Tile other) {
        if(other.position - 1 == this.position && other.position % 3 >=1) {return Direction.EAST;}
        else if(other.position + 1 == this.position && other.position % 3 <= 1) {return Direction.WEST;}
        else if(other.position - 3 == this.position) {return Direction.SOUTH;}
        else if(other.position + 3 == this.position) {return Direction.NORTH;}
        else{return null;}
    }// FIXME Task 7 (CR)

    /**
     * Determine whether a peg can move between this tile and another (other).
     *
     * Conditions for this to be true:
     * - The tiles must be adjacent.
     * - The tiles must have compatible tile types:
     *   - The tiles must both have exits that are on the abutting side.
     *   - The tiles must be at the same level on their abutting sides (both high or both low).
     *
     * NOTE: This test does not consider whether a peg can end its movement on these
     * tiles, only whether it can move between them (i.e. whether this pair of tiles can
     * form part of a path for a peg to transit along).
     *
     * @param other The other tile being considered.
     * @return true if a peg can legally transit from this tile to the other.
     */
    public boolean canTransit(Tile other) {
        if (adjacencyDirection(other) == null) {return false;}
        Direction dir = adjacencyDirection(other);
        Direction otherdirA = other.getTileType().exitAFaces(other.orientation);
        Direction otherdirB = other.getTileType().exitBFaces(other.orientation);
        Direction thisdirA = this.getTileType().exitAFaces(this.orientation);
        Direction thisdirB = this.getTileType().exitBFaces(this.orientation);
        String thisType = this.getTileType().name();
        String otherType = other.getTileType().name();
        if (otherdirA != dir.getOpposite() && otherdirB != dir.getOpposite()){return false;}
        if (otherType.equals("STAIRCASE") && thisType.equals("STAIRCASE") &&
                (otherdirA == thisdirA.getOpposite() || otherdirB == thisdirB.getOpposite()))
        {return true;}
        if (((otherType.equals("STAIRCASE") && thisType.equals("GREEN_CORNER")) || (otherType.equals("STAIRCASE") && thisType.equals("STRAIGHT"))) &&
                (otherdirA == thisdirA.getOpposite() || otherdirA == thisdirB.getOpposite()))
        {return true;}
        if ((otherType.equals("STAIRCASE") && thisType.equals("BROWN_CORNER")) &&
                (otherdirB == thisdirA.getOpposite() || otherdirB == thisdirB.getOpposite()))
        {return true;}
        if (((otherType.equals("GREEN_CORNER") && thisType.equals("STAIRCASE")) || (otherType.equals("STRAIGHT") && thisType.equals("STAIRCASE"))) &&
                (otherdirA == thisdirA.getOpposite() || otherdirB == thisdirA.getOpposite()))
        {return true;}
        if (((otherType.equals("GREEN_CORNER") || otherType.equals("STRAIGHT")) && (thisType.equals("GREEN_CORNER") || thisType.equals("STRAIGHT"))) &&
                (otherdirA == thisdirA.getOpposite() || otherdirB == thisdirA.getOpposite() || otherdirA == thisdirB.getOpposite() || otherdirB == thisdirB.getOpposite()))
        {return true;}
        if ((otherType.equals("BROWN_CORNER") && thisType.equals("BROWN_CORNER")) &&
                (otherdirA == thisdirA.getOpposite() || otherdirB == thisdirA.getOpposite() || otherdirA == thisdirB.getOpposite() || otherdirB == thisdirB.getOpposite()))
        {return true;}
        if ((otherType.equals("BROWN_CORNER") && thisType.equals("STAIRCASE")) &&
                (otherdirA == thisdirB.getOpposite() || otherdirB == thisdirB.getOpposite()))
        {return true;}
        return false;
    }      // FIXME Task 10 (D)

    /** @return the orientation of this tile */
    public Direction getOrientation() { return orientation; }

    /** @return the TileName of this tile */
    public TileName getTileName() { return tileName; }

    /** @return the TileType of this tile */
    public TileType getTileType() { return tileName.getType(); }

    /**
     * Set the position of this tile
     * @param position the new position of this tile.
     */
    public void setPosition(int position) { this.position = position; }

    /** @return the position of this tile */
    public int getPosition() { return position; }

    /** @return true if this tile able to hold the peg */
    public boolean canTakePeg() { return getTileType().canTakePeg(); }

    /**
     * @param viaA if true, we're referring to exiting via A, otherwise via B
     * @return true if the given exit is Green.
     */
    public boolean exitIsGreen(boolean viaA) {
        return viaA ? getTileType().exitAisGreen() : getTileType().exitBisGreen();
    }

    /**
     * @return The direction of exit a faces (in its current orientation).
     */
    public Direction exitAFaces() {
        return getTileType().exitAFaces(orientation);
    }

    /**
     * @return The direction of exit b faces (in its current orientation).
     */
    public Direction exitBFaces() {
        return getTileType().exitBFaces(orientation);
    }

    /**
     * Return a string representation of this tile.
     * @return A string consisting of the tile name's symbol followed by the symbol
     * for the tile's orientation.
     */
    @Override
    public String toString() {
        return tileName+orientation.getSymbol();
    }
}