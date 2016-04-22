/**
 * Created by alessio on 22/04/16.
 */
public class BowlingGame {
    private int score = 0;

    public int score() {
        return score;
    }

    public void roll(int score) {
        this.score += score;
    }
}
