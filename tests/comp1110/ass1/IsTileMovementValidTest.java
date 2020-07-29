package comp1110.ass1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static comp1110.ass1.Direction.*;
import static org.junit.Assert.assertTrue;
import static  comp1110.ass1.TileName.*;

/*
 * IMPORTANT: THIS CODE MUST NOT BE MODIFIED.
 *
 * You may write your own tests, but they need to be in separate files.
 */
public class IsTileMovementValidTest {

    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    private void test(Objective objective, TileName tileName, Direction direction, boolean expected) {
        TempleTrap templeTrapGame = new TempleTrap(objective);
        templeTrapGame.initializeBoardState();
        boolean out = templeTrapGame.isTileMovementValid(Tile.getTileFromID(tileName.ordinal()), direction);

        assertTrue("Expected " + expected +
                        " for boardstate " + templeTrapGame.getObjective().getInitialState() +
                        ", and tile " + tileName +
                        ", and direction " + direction +
                        ", but got " + out + ".",
                out == expected);

    }

    public void testSimpleTrue() {
        Objective objective = Objective.OBJECTIVES[0];
        test(objective, SQUARE, EAST, true);

    }

    public void testSimpleFalse() {
        Objective objective = Objective.OBJECTIVES[0];
        test(objective, PLUS, WEST, false);
    }

    @Test
    public void testPeg() {
        Objective objective = Objective.OBJECTIVES[34];
        test(objective, TRIANGLE, SOUTH, true);
        test(objective, DIAMOND, WEST, false);
        objective = Objective.OBJECTIVES[5];
        test(objective, STAR, SOUTH, false);
        test(objective, STAR, WEST, false);
        test(objective, PLUS, NORTH, true);
        test(objective, PLUS, WEST, false);
        test(objective, TRIANGLE, EAST, true);
    }

    @Test
    public void testValid() {
        testSimpleFalse();
        Objective objective = Objective.OBJECTIVES[4];
        test(objective, PLUS, SOUTH, true);
        test(objective, STAR, EAST, true);
        test(objective, TRIANGLE, NORTH, true);
        test(objective, DIAMOND, WEST, true);


    }

    @Test
    public void testInvalid() {
        testSimpleTrue();
        Objective objective = Objective.OBJECTIVES[32];
        TileName[] tiles = {PLUS, EQUALS, SQUARE, CROSS, CIRCLE, STAR};
        Direction[] directions = { NORTH, EAST, SOUTH, WEST};
        for (TileName t : tiles) {
            for (Direction d : directions) {
                test(objective, t, d, false);
            }

        }

    }

}
