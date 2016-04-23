import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BowlingGameTest {
    @Test
    public void newGameScoreIsZero() throws Exception {
        BowlingGame game = new BowlingGame();
        assertEquals(0, game.score());
    }

    @Test
    public void singleRoundScoreIsEight() throws Exception {
        BowlingGame game = new BowlingGame();

        BowlingRound round = new BowlingRound();
        round.roll(3);
        round.roll(5);

        game.newRound( round );

        assertEquals(8, game.score());
    }
}
