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
    public void multiRoundOneStrikeScoreIsTwentySix() throws Exception {
        BowlingGame game = new BowlingGame();

        game.newRound(newStrike( ));
        game.newRound(newRound(3, 5));

        assertEquals(26, game.score());
    }

    @Test
    public void multiRoundOneSpareScoreIsTwentyOne() throws Exception {
        BowlingGame game = new BowlingGame();

        game.newRound(newSpare( ));
        game.newRound(newRound(3, 5));

        assertEquals(21, game.score());
    }

    @Test
    public void twoConsecutiveStrikeScoreFiftyOne() throws Exception {
        BowlingGame game = new BowlingGame();

        game.newRound(newStrike());
        game.newRound(newStrike());
        game.newRound(newRound(3, 6));

        assertEquals(51, game.score());
    }

    @Test
    public void allSparesScoreOneThousandForty() throws Exception {
        BowlingGame game = new BowlingGame();

        game.newRound(newSpare());
        game.newRound(newSpare());
        game.newRound(newSpare());
        game.newRound(newSpare());
        game.newRound(newSpare());
        game.newRound(newSpare());
        game.newRound(newSpare());
        game.newRound(newSpare());
        game.newRound(newSpare());
        game.newRound(newSpare());
        game.newBonusRound(newRound(4, 0));
        assertEquals(140, game.score());
    }

    private BowlingRound newRound(int firstRoll, int secondRoll) {
        BowlingRound round = new BowlingRound();
        round.roll(firstRoll);
        round.roll(secondRoll);
        return round;
    }

    private BowlingRound newBonusRound(int firstRoll, int secondRoll) {
        BowlingRound round = new BowlingBonusRound();
        round.roll(firstRoll);
        round.roll(secondRoll);
        return round;
    }

    private BowlingRound newStrike() {
        BowlingRound round = new BowlingRound();
        round.roll(10);
        return round;
    }

    private BowlingRound newSpare() {
        BowlingRound round = new BowlingRound();
        round.roll(4);
        round.roll(6);
        return round;
    }
}
