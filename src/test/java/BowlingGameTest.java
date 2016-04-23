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

        game.newRound(newRound(3, 5));

        assertEquals(8, game.score());
    }

    @Test
    public void multiRoundScoreIsSixteen() throws Exception {
        BowlingGame game = new BowlingGame();

        game.newRound(newRound(3, 5));
        game.newRound(newRound(3, 5));

        assertEquals(16, game.score());
    }

    @Test
    public void multiRoundOneStrikeScoreIsTwentyOne() throws Exception {
        BowlingGame game = new BowlingGame();

        game.newRound(newStrike( ));
        game.newRound(newRound(3, 5));

        assertEquals(26, game.score());
    }

    private BowlingRound newRound(int firstRoll, int secondRoll) {
        BowlingRound round = new BowlingRound();
        round.roll(firstRoll);
        round.roll(secondRoll);
        return round;
    }

    private BowlingRound newStrike() {
        BowlingRound round = new BowlingRound();
        round.roll(10);
        return round;
    }
}
