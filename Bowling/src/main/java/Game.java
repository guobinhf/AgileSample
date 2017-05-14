/**
 * Created by togb on 2017/5/14.
 */
public class Game {

    private int itsScore;
    private int[] itsThrows = new int[21]; //最大投掷数
    private int itsCurrentThrow = 0;
    private int itsCurrentFrame = 1;
    private boolean firstThrow = true;
    public int score() {
        return scoreForFrame(getCurrentFrame() -1);
    }

    //不需要Throw类，Throw没有行为，只是data
    public void add(int pins) {
        itsThrows[itsCurrentThrow++] = pins;
        itsScore += pins;
        adjustCurrentFrame();
    }

    private void adjustCurrentFrame() {
        if(firstThrow == true){
            firstThrow = false;
        }else{
            firstThrow = true;
            itsCurrentFrame++;
        }
    }

    public int scoreForFrame(int thrFrame) {
        int ball = 0;
        int score = 0;
        for (int currentFrame = 0; currentFrame < thrFrame; currentFrame++) {
            int firstThrow = itsThrows[ball++];
            int secondThrow = itsThrows[ball++];
            int frameScore = firstThrow + secondThrow;
            if (frameScore == 10) {
                score += frameScore + itsThrows[ball];
            } else {
                score += frameScore;
            }
        }
        return score;
    }

    public int getCurrentFrame() {
        return itsCurrentFrame;
    }
}
