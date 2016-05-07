import java.util.ArrayList;

public class BowlingGame {
    private ArrayList<BowlingRound> rounds = new ArrayList<BowlingRound>();
    private BowlingRound bonusRound = new BowlingRound();

    public void newRound(BowlingRound round) {
        rounds.add(setPreviousRound(round));
    }

    public void newBonusRound(BowlingRound round) {
        bonusRound = setPreviousRound(round);
    }

    public int score() {
        int score = 0;
        for (BowlingRound round : rounds)
            score += round.getScore() + addBonuses(round);

        score += bonusRound.getScore() + doubleStrikeBonus(bonusRound);
        return score;
    }

    private int addBonuses(BowlingRound round) {
        return spareBonus( round ) + strikeBonus( round ) + doubleStrikeBonus( round );
    }

    private int spareBonus(BowlingRound round) {
        if(round.previousRound().isSpare())
            return round.getFirstRoll();

        return 0;
    }

    private int strikeBonus(BowlingRound round) {
        if(round.previousRound().isStrike())
            return round.getScore();

        return 0;
    }

    private int doubleStrikeBonus(BowlingRound round) {
        if((round.previousRound().isStrike()) && round.previousRound().previousRound().isStrike())
            return round.getFirstRoll();

        return 0;
    }

    private boolean hasRounds() {
        return rounds.size() > 0;
    }

    private BowlingRound setPreviousRound(BowlingRound round) {
        if(hasRounds()) {
            BowlingRound lastRound = rounds.get(rounds.size() - 1);
            round.setPreviousRound(lastRound);
        }
        return round;
    }
}
