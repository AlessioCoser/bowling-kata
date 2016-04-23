import java.util.ArrayList;

public class BowlingGame {
    private ArrayList<BowlingRound> rounds = new ArrayList<BowlingRound>();

    public int score() {
        int score = 0;
        if(hasRounds()) {

            score += rounds.get(0).getScore();

            for (int i = 1; i < rounds.size(); i++) {
                BowlingRound currentRound = rounds.get(i);
                BowlingRound previousRound = rounds.get(i - 1);

                if (previousRound.isStrike()) {
                    score += currentRound.getScore();
                }

                score += currentRound.getScore();
            }
        }
        return score;
    }

    private boolean hasRounds() {
        return rounds.size() > 0;
    }

    public void newRound(BowlingRound round) {
        rounds.add(round);
    }
}
