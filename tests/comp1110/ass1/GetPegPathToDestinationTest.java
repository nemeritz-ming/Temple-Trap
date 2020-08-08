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
public class GetPegPathToDestinationTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    private void test(Objective objective, int start, char dest, boolean viaA, String expected) {
        TempleTrap game = new TempleTrap(objective);
        String out = game.getPegPathToDestination(game.board[start], dest, viaA);
        assertTrue("Expected " + ((expected == null) ? "null" : "'" + expected + "'") +
                        " for boardState " + game.getObjective().getInitialState() +
                        ", start position " + start +
                        ", and end position " + dest +
                        ", via exit " + (viaA ? "A" : "B") +
                        ", but got " + ((out == null) ? "null" : "'" + out + "'") + ".",
                (out == null && expected == null) || (out != null && out.equals(expected))
        );
    }


    @Test
    public void testPathOneToFinish() {
        // trivially false
        test(OBJECTIVES[0], 8, 'F', true, null);
        test(OBJECTIVES[1], 2, 'F', true, null);
        test(OBJECTIVES[6], 6, 'F', false, null);
        // trivially true
        test(OBJECTIVES[0], 0, 'F', true, "W");
        test(OBJECTIVES[12], 0, 'F', true, "W");
        test(OBJECTIVES[6], 0, 'F', false, "W");

        // false because of levels
        test(OBJECTIVES[5], 0, 'F', false, null);
    }


    @Test
    public void testPathOneToTile() {
        // trivially false
        test(OBJECTIVES[33], 1, '0', false, null);
        test(OBJECTIVES[54], 4, '5', true, "E");

        // trivially true
        test(OBJECTIVES[51], 8, '7', true, "W");
        test(OBJECTIVES[34], 7, '4', false, "N");
        test(OBJECTIVES[20], 3, '6', false, "S");

        // false because of levels
        test(OBJECTIVES[53], 6, '3', true, null);
    }

    @Test
    public void testPathMultiToFinish() {
        // trivially false
        test(OBJECTIVES[2], 1, 'F', false, null);
        test(OBJECTIVES[0], 7, 'F', false, null);

        // trivially true
        test(OBJECTIVES[0], 2, 'F', false, "WWW");
        test(OBJECTIVES[17], 1, 'F', true, "WW");
        test(OBJECTIVES[10], 3, 'F', false, "ENWW");

        // false because of levels
        test(OBJECTIVES[13], 6, 'F', true, null);
    }

    @Test
    public void testPathMultiToTile() {
        // trivially true
        test(OBJECTIVES[46], 8, '0', true, "WNNW");
        test(OBJECTIVES[28], 8, '1', true, "WWNEENW");
        test(OBJECTIVES[24], 0, '7', false, "SES");
        test(OBJECTIVES[20], 3, '6', true, "NESSW");


        // trivially false
        test(OBJECTIVES[21], 7, '6', true, null);
        test(OBJECTIVES[22], 6, '1', false, null);

        // false because of levels
        test(OBJECTIVES[6], 6, '0', true, null);
        test(OBJECTIVES[35], 6, '0', false, null);

    }


}

