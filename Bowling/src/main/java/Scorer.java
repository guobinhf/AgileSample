/**
 * Created by togb on 2017/5/14.
 */
public class Scorer {
    private int ball;
    private int[] itsThrows = new int[21]; //最大投掷数
    private int itsCurrentThrow = 0;
    public void addThrow(int pins){
        itsThrows[itsCurrentThrow++] = pins;
    }
    public int scoreForFrame(int thrFrame) {
        ball = 0;
        int score = 0;
        for (int currentFrame = 0; currentFrame < thrFrame; currentFrame++) {
            if(strike()){
                score += 10 + netTwoBallsForStrike();
                ball++;
            }else if (spare()){
                score += 10 + nextBallForSpare();
                ball += 2;
            }else{
                score += towBallsInFrame();
                ball +=2;
            }

        }
        return score;
    }

    private int netTwoBallsForStrike() {
        return itsThrows[ball +1] + itsThrows[ball+2];
    }

    private boolean strike() {
        return  itsThrows[ball] ==10;
    }
    private int towBallsInFrame() {
        return itsThrows[ball] + itsThrows[ball+1];
    }

    private int nextBallForSpare() {
        return itsThrows[ball +2];
    }

    private boolean spare() {
        return (itsThrows[ball] + itsThrows[ball+1]) ==10;
    }
}
