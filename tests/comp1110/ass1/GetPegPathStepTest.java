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
public class GetPegPathStepTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    private void test(Objective objective, int start, boolean viaA, String expected) {
      TempleTrap game = new TempleTrap(objective);
      String out = game.getPegPathStep(game.board[start], viaA);
      assertTrue("Expected " + ((expected == null) ? "null" : "'"+expected.toString()+"'") +
                       " for boardState " + game.getObjective().getInitialState() +
                       ", and start position " + start +
                       ", via exit "+(viaA ? "A" : "B")+
                        ", but got " +((out == null) ? "null" : "'"+out.toString()+"'") + ".",
              (out == null && expected == null) || (out != null && out.equals(expected))
        );
    }

    @Test
    public void testPathMulti() {
      test(OBJECTIVES[4], 3, true, "NEES5");
      test(OBJECTIVES[4], 5, true, "NWWS3");
    }

    @Test
    public void testPathOne() {
      // trivially false
      test(OBJECTIVES[0], 8, true, null);
      test(OBJECTIVES[1], 2, true, null);
      test(OBJECTIVES[6], 6, false, null);
      // trivially true
      test(OBJECTIVES[0], 8, false, "W7");
      test(OBJECTIVES[2], 1, false, "S4");
      test(OBJECTIVES[6], 7, true, "N4");
      // path that could go further, but must stop at first step
      test(OBJECTIVES[0], 1, false, "E2");
    }

    @Test
    public void testStairs() {
      // false from custom Objectives
      test(new Objective("N8W3N0E5N2E6W4W14", 1), 4, true, null);
      test(new Objective("S3S0N6N1W4W5W8E75", 1), 5, false, null);
      test(new Objective("S7E8N5W3W0S6S1N41", 1), 1, true, null);
      // true from Objectives
      test(OBJECTIVES[28], 8, true, "WWNE4");
      test(OBJECTIVES[46], 8, true, "WNNW0");
      test(OBJECTIVES[50], 8, true, "WW6");
      // test going between downstairs and upstairs with no stairs
      test(OBJECTIVES[40], 3, false, null);
      test(OBJECTIVES[6], 6, true, null);
    }

    @Test
    public void testNullSpace() {
      // false from Objectives
      test(OBJECTIVES[48], 6, true, null);
      test(OBJECTIVES[44], 7, true, null);
      test(OBJECTIVES[42], 4, false, null);
      // next to the empty space, but moves via the exit that does not lead to the empty space
      test(OBJECTIVES[41], 0, true, "E1");
      test(OBJECTIVES[27], 5, false, "W4");
      test(OBJECTIVES[19], 7, false, "E8");
      // test moving several spaces towards the empty space
      test(new Objective("S7W3S6E5N2E1S8N08", 1), 8, true, null);
    }

    @Test
    public void testOutOfBoard() {
        // false from Objectives
        test(Objective.OBJECTIVES[59], 5, false, null);
        test(Objective.OBJECTIVES[50], 8, false, null);
        test(Objective.OBJECTIVES[49], 3, true, null);
        // next to the edge of the board, but moves via the exit away from the edge
        test(Objective.OBJECTIVES[55], 5, true, "WN1");
        test(Objective.OBJECTIVES[43], 3, true, "S6");
        test(Objective.OBJECTIVES[38], 6, false, "E7");
        // test scenario where peg hits wall after multiple moves
        test(Objective.OBJECTIVES[47], 7, true, null);
    }

}
