import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {
    @Test
    public void newGameScoreIsZero() throws Exception {
        BowlingGame game = new BowlingGame();
        assertEquals(0, game.score());
    }

    @Test
    public void singleRollScoreIsOne() throws Exception {
        BowlingGame game = new BowlingGame();
        game.roll(1);
        assertEquals(1, game.score());
    }
}
