import java.util.ArrayList;

public class BowlingGame {
    private ArrayList<BowlingRound> rounds = new ArrayList<BowlingRound>();

    public int score() {
        int score = 0;
        for (int i = 0; i < rounds.size(); i++) {
            BowlingRound currentRound = rounds.get(i);
            if (i > 0) {
                BowlingRound previousRound = rounds.get(i - 1);

                if (previousRound.isStrike()) {
                    score += currentRound.getFirstRoll();
                }
            }

            score += currentRound.getScore();
        }
        return score;
    }

    public void newRound(BowlingRound round) {
        rounds.add(round);
    }
}
