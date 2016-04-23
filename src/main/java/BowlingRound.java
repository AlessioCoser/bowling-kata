import java.util.ArrayList;

/**
 * Created by alessio on 23/04/16.
 */
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
}
