package comp1110.ass1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static comp1110.ass1.Objective.OBJECTIVES;
import static org.junit.Assert.assertTrue;

/*
 * IMPORTANT: THIS CODE MUST NOT BE MODIFIED.
 *
 * You may write your own tests, but they need to be in separate files.
 */
public class CanMoveTileTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    private void test(Objective objective, char tileID, boolean expected) {
        TempleTrap templeTrapGame = new TempleTrap(objective);
        templeTrapGame.initializeBoardState();
        boolean out = templeTrapGame.canMoveTile(Tile.getTileFromID(tileID - 'a'));

        assertTrue("Expected " + expected +
                        " for boardstate " + templeTrapGame.getObjective().getInitialState() +
                        ", and tile " + tileID +
                        ", but got " + out + ".",
                out == expected);

    }

    private final static char[] CAN_MOVE_TILES = {
            // Objective 14
            'a', 'b', 'e', 'h',
            // Objective 5
            'a', 'd', 'g', 'h',
            // Objective 23
            'b', 'e'
    };

    private final static char[] CANT_MOVE_TILES = {
            // Objective 14
            'c', 'd', 'f', 'g',
            // Objective 5
            'b', 'c', 'e', 'f',
            // Objective 23
            'a', 'd', 'f', 'g', 'h',
    };

    private void testTrivialTrue() {
        Objective trivial = new Objective("N4W8", 1);
        test(trivial, 'a', true);
    }


    private void testTrivialFalse() {
        Objective trivial = new Objective("N0W1S2E3N4W5E6S77", 1);
        test(trivial, 'd', false);
    }

    @Test
    public void testTrue() {
        testTrivialFalse();
        for (int i = 0; i < 4; i++) {
            test(OBJECTIVES[13], CAN_MOVE_TILES[i], true);
            test(OBJECTIVES[4], CAN_MOVE_TILES[i + 4], true);
        }
        for (int i = 0; i < 2; i++) {
            test(OBJECTIVES[22], CAN_MOVE_TILES[i + 8], true);
        }
    }

    @Test
    public void testFalse() {
        testTrivialTrue();
        for (int i = 0; i < 4; i++) {
            test(OBJECTIVES[13], CANT_MOVE_TILES[i], false);
            test(OBJECTIVES[4], CANT_MOVE_TILES[i + 4], false);
        }
        for (int i = 0; i < 5; i++) {
            test(OBJECTIVES[22], CANT_MOVE_TILES[i + 8], false);
        }
    }
}
