/**
 * Created by alessio on 24/04/16.
 */
public class NullBowlingRound extends BowlingRound {
    public int getScore() {
        return 0;
    }
    public boolean isStrike() {
        return false;
    }
    public boolean isSpare() {
        return false;
    }
    public int getFirstRoll() {
        return 0;
    }

    public BowlingRound previousRound() {
        return new NullBowlingRound();
    }
}
