/**
 * Created by togb on 2017/5/14.
 */
public class Game {

    private int itsScore;
    private int[] itsThrows = new int[21]; //最大投掷数
    private int itsCurrentThrow = 0;
    private int itsCurrentFrame = 1;
    private int ball;
    private int firstThrow;
    private int secondThrow;
    private boolean firstThrowInFrame = true;
    public int score() {
        return scoreForFrame(getCurrentFrame() -1);
    }

    //不需要Throw类，Throw没有行为，只是data
    public void add(int pins) {
        itsThrows[itsCurrentThrow++] = pins;
        itsScore += pins;
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if(firstThrowInFrame == true){
            if(pins == 10){
                itsCurrentFrame ++;
            }else{
                firstThrowInFrame = false;
            }
        }else{
            firstThrowInFrame = true;
            itsCurrentFrame++;
        }
        itsCurrentFrame = Math.min(11, itsCurrentFrame);
    }

    public int scoreForFrame(int thrFrame) {
         ball = 0;
        int score = 0;
        for (int currentFrame = 0; currentFrame < thrFrame; currentFrame++) {
             firstThrow = itsThrows[ball];
            if(firstThrow ==10){
                ball++;
                score += 10 + itsThrows[ball] + itsThrows[ball+1];
            }else {
                score += handleSecondThrow();
            }

        }
        return score;
    }

    private int handleSecondThrow() {
        int score =0;
        secondThrow = itsThrows[ball+1];
        int frameScore = firstThrow + secondThrow;
        if (frameScore == 10) {
            ball += 2;
            score += frameScore + itsThrows[ball];
        } else {
            ball += 2;
            score += frameScore;
        }
        return score;
    }

    public int getCurrentFrame() {
        return itsCurrentFrame;
    }
}
