import java.util.ArrayList;

public class BowlingRound {
    private ArrayList<Integer> rolls = new ArrayList<Integer>();

    public void roll(int score) {
        rolls.add(score);
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < rolls.size(); i++) {
            score += rolls.get(i);
        }
        return score;
    }

    public boolean isStrike() {
        return rolls.get(0) == 10;
    }

    public boolean isSpare() {
        return (rolls.get(0) + rolls.get(1)) == 10;
    }

    public int getFirstRoll() {
        return rolls.get(0);
    }
}
