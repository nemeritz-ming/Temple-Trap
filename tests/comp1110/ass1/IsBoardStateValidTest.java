package comp1110.ass1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertTrue;

/*
 * IMPORTANT: THIS CODE MUST NOT BE MODIFIED.
 *
 * You may write your own tests, but they need to be in separate files.
 */
public class IsBoardStateValidTest {

    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    private void test(String boardString, boolean expected) {
        boolean out = TempleTrap.isBoardStateValid(boardString);
        assertTrue("Expected " + expected + " for boardString " + boardString +
                ", but got " + out + ".", out == expected);
    }

    private final static String[] BAD_TILE = {
            "E2S6W3N8N1S1S7S57", // overlapping tiles
            "E5W0N1S3S6E7W3W43",
            "N6S0N1S7N6E8N3S47",
            "E8S0N1E9W4E5W2S66", // tile off board
            "E8S0N1E9W4E5W2S656", // malformed string extra chars, "S656"
            "E8S0N1E3W4E5W8S66", // duplicate locations
            "E8S0N1E3W8E5W2S66",
            "E8S0N1E3W3E5W2S66",
            "N7S6X3E5S1N2S8S48", //invalid orientation
            "N0N1N2N3N4N5N6Z73",
    };

    private final static String[] BAD_PEG = {
            "N4S3E5W1E2W7S0W6", //no peg
            "E1N7N2N0E5N8W6E3",
            "N1N6N2N4N5S7S3W01", // peg on invalid tile
            "N0N5E4W7E2N8N6E15",
            "E5N3W4W1N0S6E2W84",
            "N0W8E7S3W2S6S1N59" // peg off board
    };

    private void testTrivialTrue() {
        test("N0N1N2N3N4N5N6N73", true);
    }


    private void testTrivialFalse() {
        test("Z9N1N2N3N4N5N6N79", false);
    }

    @Test
    public void testValid() {
        testTrivialFalse();
        for (Objective o : Objective.getOBJECTIVES()) {
            test(o.getInitialState(), true);
        }
    }

    @Test
    public void testInvalidPeg() {
        testTrivialTrue();
        for (String s : BAD_PEG) {
            test(s, false);
        }
    }

    @Test
    public void testInvalidTile() {
        testTrivialTrue();
        for (String s : BAD_TILE) {
            test(s, false);
        }
    }


}

