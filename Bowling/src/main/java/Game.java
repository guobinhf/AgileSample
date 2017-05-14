/**
 * Created by togb on 2017/5/14.
 */
public class Game {

    private int itsScore;
    private int[] itsThrows = new int[21]; //最大投掷数
    private int itsCurrentThrow = 0;

    public int getScore() {
        return itsScore;
    }

    //不需要Throw类，Throw没有行为，只是data
    public void add(int pins) {
        itsThrows[itsCurrentThrow++] = pins;
        itsScore += pins;
    }

    public int scoreForFrame(int thrFrame) {
        int ball = 0;
        int score = 0;
        for (int currentFrame = 0; currentFrame < thrFrame; currentFrame++) {
            score += itsThrows[ball++] + itsThrows[ball++]; 
        }
        return score;
    }
}
