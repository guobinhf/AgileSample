/**
 * Created by togb on 2017/5/14.
 */
public class Game {

    private int itsScore;
    private int[] itsThrows = new int[21]; //最大投掷数
    private int itsCurrentThrow = 0;
    private int itsCurrentFrame = 1;
    private int ball;
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
            if(strike()){
                ball++;
                score += 10 + netTwoBalls();
            }else {
                score += handleSecondThrow();
            }

        }
        return score;
    }

    private int netTwoBalls() {
        return itsThrows[ball] + itsThrows[ball+1];
    }

    private boolean strike() {
        return  itsThrows[ball] ==10;
    }

    private int handleSecondThrow() {
        int score =0;
        if (spare()) {
            ball += 2; //ball的方式不一样？先不调整
            score += 10 + nextBall();
        } else {
            score += towBallsInFrame();
            ball += 2;
        }
        return score;
    }

    private int towBallsInFrame() {
        return itsThrows[ball] + itsThrows[ball+1];
    }

    private int nextBall() {
        return itsThrows[ball];
    }

    private boolean spare() {
        return (itsThrows[ball] + itsThrows[ball+1]) ==10;
    }

    public int getCurrentFrame() {
        return itsCurrentFrame;
    }
}
