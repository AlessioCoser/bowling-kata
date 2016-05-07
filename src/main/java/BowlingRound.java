import java.util.ArrayList;

public class BowlingRound {
    private ArrayList<Integer> rolls = new ArrayList<Integer>();
    private BowlingRound previousRound;

    public void roll(int score) {
        rolls.add(score);
    }

    public int getScore() {
        int score = 0;
        for (int roll : rolls)
            score += roll;

        return score;
    }

    public boolean isStrike() {
        return rolls.get(0) == 10;
    }

    public boolean isSpare() {
        return ((rolls.size() > 1) && (rolls.get(0) + rolls.get(1)) == 10);
    }

    public int getFirstRoll() {
        return rolls.get(0);
    }

    public BowlingRound previousRound() {
        if(previousRound != null)
            return previousRound;
        else
            return new NullBowlingRound();
    }

    public void setPreviousRound(BowlingRound previousRound) {
        this.previousRound = previousRound;
    }
}
