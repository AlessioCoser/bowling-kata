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

    @Test
    public void multiRoundScoreIsSixteen() throws Exception {
        BowlingGame game = new BowlingGame();

        BowlingRound round = new BowlingRound();
        round.roll(5);
        round.roll(3);

        game.newRound( round );

        round = new BowlingRound();
        round.roll(3);
        round.roll(5);

        game.newRound( round );

        assertEquals(16, game.score());
    }

    @Test
    public void multiRoundOneStrikeScoreIsTwentyOne() throws Exception {
        BowlingGame game = new BowlingGame();

        BowlingRound round = new BowlingRound();
        round.roll(10);

        game.newRound( round );

        round = new BowlingRound();
        round.roll(3);
        round.roll(5);

        game.newRound( round );

        assertEquals(21, game.score());
    }
}
