import java.util.ArrayList;

public class BowlingGame {
    private ArrayList<BowlingRound> rounds = new ArrayList<BowlingRound>();

    public int score() {
        int score = 0;
        for (BowlingRound round : rounds)
            score += round.getScore() + addBonuses(round);

        return score;
    }

    private int addBonuses(BowlingRound round) {
        return beforeSpareBonus( round ) + beforeStrikeBonus( round ) + beforeDoubleStrikeBonus( round );
    }

    private int beforeSpareBonus(BowlingRound round) {
        if(round.previousRound().isSpare())
            return round.getFirstRoll();

        return 0;
    }

    private int beforeStrikeBonus(BowlingRound round) {
        if(round.previousRound().isStrike())
            return round.getScore();

        return 0;
    }

    private int beforeDoubleStrikeBonus(BowlingRound round) {
        if((round.previousRound().isStrike()) && round.previousRound().previousRound().isStrike())
            return round.getFirstRoll();

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

    public void newBonusRound(BowlingRound round) {
        rounds.add(round);
    }
}
