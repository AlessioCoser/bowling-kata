import java.util.ArrayList;

public class BowlingGame {
    private ArrayList<BowlingRound> rounds = new ArrayList<BowlingRound>();

    public int score() {
        int score = 0;
        for (BowlingRound round : rounds) {
            score += round.getScore() + beforeSpareBonus( round ) + beforeStrikeBonus( round );
        }
        return score;
    }

    private int beforeStrikeBonus(BowlingRound round) {
        int score = 0;
        if(round.previousRound().isStrike()){
            score += round.getScore();
        }

        if((round.previousRound().isStrike()) && (round.previousRound().previousRound().isStrike())) {
            score += round.getFirstRoll();
        }
        return score;
    }

    private int beforeSpareBonus(BowlingRound round) {
        if(round.previousRound().isSpare()){
            return round.getFirstRoll();
        }
        return 0;
    }

    private boolean hasRounds() {
        return rounds.size() > 0;
    }

    public void newRound(BowlingRound round) {
        if(hasRounds()) {
            BowlingRound lastRound = rounds.get(rounds.size() - 1);
            round.setPreviousRound(lastRound);
        }
        rounds.add(round);
    }
}
