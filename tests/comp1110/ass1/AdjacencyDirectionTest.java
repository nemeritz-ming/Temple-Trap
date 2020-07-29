package comp1110.ass1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static comp1110.ass1.Direction.*;
import static comp1110.ass1.TileName.*;
import static org.junit.Assert.assertTrue;

/*
 * IMPORTANT: THIS CODE MUST NOT BE MODIFIED.
 *
 * You may write your own tests, but they need to be in separate files.
 */
public class AdjacencyDirectionTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(50000);

    private void test(Tile tile, Tile other, Direction expected) {
        Direction out = tile.adjacencyDirection(other);

        assertTrue("Expected " + expected + " for Tile instance" + tile.toString() +
                ", and other Tile: " + other.toString() +
                ", but got: " + out + ".", out == expected);
    }

    private Direction[] directions = {NORTH, EAST, SOUTH, WEST};

    @Test
    public void testCentreValid() {
        Tile tile = new Tile(PLUS, "N4");
        Tile other = new Tile(SQUARE, "N0");
        int[] positions = {1, 5, 7, 3};
        for (int i = 0; i < positions.length; i++) {
            other.position = positions[i];
            test(tile, other, directions[i]);
        }
    }

    @Test
    public void testEdge() {
        Tile tile = new Tile(STAR, "S3");
        Tile other = new Tile(TRIANGLE, "S2");
        int[] positions = {0, 4, 6};
        for (int i = 0; i < positions.length; i++) {
            other.position = positions[i];
            test(tile, other, directions[i]);
        }
        other.position = 2;
        test(tile, other, null);
    }

    @Test
    public void testInvalid() {
        Tile tile = new Tile(DIAMOND, "E8");
        Tile other = new Tile(CROSS, "W6");
        int[] positions = {0, 1, 2, 3, 4, 6};
        for (int p : positions) {
            other.position = p;
            test(tile, other, null);
        }
    }
}
